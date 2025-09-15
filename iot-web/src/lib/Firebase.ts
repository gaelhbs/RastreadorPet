import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
import { getDatabase } from "firebase/database";

const firebaseConfig = {
  apiKey: "AIzaSyBDifurmFkWKTemwAGGQwDQMMcId0N8oPI",
  authDomain: "sensor-umidade-iot.firebaseapp.com",
  databaseURL: "https://sensor-umidade-iot-default-rtdb.firebaseio.com",
  projectId: "sensor-umidade-iot",
  storageBucket: "sensor-umidade-iot.firebasestorage.app",
  messagingSenderId: "234814745996",
  appId: "1:234814745996:web:c7e03a8d1957f2af7ffaa9",
  measurementId: "G-0Y26YC78X2"
};

const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);
const db = getDatabase(app);

export { db };