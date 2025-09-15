#include <WiFi.h>
#include <FirebaseESP32.h>
#include <DHT.h>

#define API_KEY "AIzaSyBDifurmFkWKTemwAGGQwDQMMcId0N8oPI"
#define DATABASE_URL "https://sensor-umidade-iot-default-rtdb.firebaseio.com/"

#define USER_EMAIL "test@iot.com"
#define USER_PASSWORD "123456"

#define MOISTURE_SENSOR_PIN 34 // Pin do sensor de umidade do solo

#define DHTPIN 15    
#define DHTTYPE DHT22 

#define DEVICE_ID "esp32-01" 

DHT dht(DHTPIN, DHTTYPE);

FirebaseData fbdo;
FirebaseAuth auth;
FirebaseConfig config;

unsigned long sendDataPrevMillis = 0;

void setup() {
  Serial.begin(9600);
  Serial.println("Inicializando o sensor DHT...");
  dht.begin();

  Serial.print("Conectando-se ao Wi-Fi");
  WiFi.begin("Wokwi-GUEST", "", 6);
  while (WiFi.status() != WL_CONNECTED) {
    delay(100);
    Serial.print(".");
  }
  Serial.println(" Conectado!");

  config.api_key = API_KEY;
  config.database_url = DATABASE_URL;
  
  // Autenticação usando e-mail e senha
  Serial.println("Autenticando no Firebase...");
  auth.user.email = USER_EMAIL;
  auth.user.password = USER_PASSWORD;

  Firebase.begin(&config, &auth);
  Firebase.reconnectWiFi(true);
  
  if (Firebase.ready()) {
    Serial.println("Conectado ao Firebase com sucesso!");
  } else {
    Serial.println("Erro na conexão com o Firebase!");
  }
}

void loop() {
  // Verifica se o Firebase está pronto e se já passou 5 segundos
  if (Firebase.ready() && (millis() - sendDataPrevMillis > 5000 || sendDataPrevMillis == 0)) {
    sendDataPrevMillis = millis();

    Serial.println("Lendo dados do sensor...");
    float hum = dht.readHumidity();
    float temp = dht.readTemperature();

    if (isnan(hum) || isnan(temp)) {
      Serial.println("Falha ao ler do sensor DHT!");
      return;
    }

    Serial.printf("Device: %s | Temperatura: %.2f °C | Umidade: %.2f %%\n", DEVICE_ID, temp, hum);

    // Envia leitura em formato FLAT
    FirebaseJson json;
    json.set("deviceId", DEVICE_ID);
    json.set("temperature", temp);
    json.set("humidity", hum);
    json.set("ts", Firebase.getCurrentTime());

    Serial.println("Enviando dados para o Firebase...");
    if (Firebase.pushJSON(&fbdo, "/readings", &json)) {
      Serial.println("Dados enviados com sucesso!");
    } else {
      Serial.print("Erro ao enviar: ");
      Serial.println(fbdo.errorReason());
    }
  }
}
