import { useEffect, useMemo, useState } from "react";
import StatCard from "./components/StatCard";
import LiveChart from "./components/LiveChart";
import { useTelemetry } from "./hooks/UseTelemetry";

export default function App() {
  const [deviceId, setDeviceId] = useState<string>(() => {
    return localStorage.getItem("deviceId") || "esp32-01";
  });
  const [mode, setMode] = useState<"byDevice" | "flat">("flat");
  const { latest, history, stats, loading, error } = useTelemetry(deviceId, 50, mode);

  useEffect(() => {
    localStorage.setItem("deviceId", deviceId);
  }, [deviceId]);

  const tempBadge = useMemo(() => {
    if (!latest) return "—";
    const t = latest.temperature;
    if (t < 18) return "Frio";
    if (t > 30) return "Quente";
    return "Confortável";
  }, [latest]);

  return (
    <div style={{ maxWidth: 980, margin: "0 auto", padding: 24 }}>
      <header style={{ display: "flex", justifyContent: "space-between", alignItems: "center", gap: 16 }}>
        <h1 style={{ fontSize: 24 }}>🌡️ IoT Monitor (ESP32 + Firebase)</h1>
        <div style={{ display: "flex", gap: 8 }}>
          <select
            value={mode}
            onChange={(e) => setMode(e.target.value as any)}
            title="Modo de leitura do banco"
          >
            <option value="byDevice">Estrutura por dispositivo</option>
            <option value="flat">Estrutura flat</option>
          </select>
          <input
            value={deviceId}
            onChange={(e) => setDeviceId(e.target.value.trim())}
            placeholder="deviceId (ex: esp32-01)"
            style={{ padding: "8px 12px", borderRadius: 8, border: "1px solid #e5e7eb" }}
          />
        </div>
      </header>

      <section style={{ marginTop: 16 }}>
        {loading && <p>Carregando…</p>}
        {error && <p style={{ color: "crimson" }}>Erro: {error}</p>}
      </section>

      <section style={{ display: "grid", gridTemplateColumns: "repeat(auto-fit, minmax(210px, 1fr))", gap: 12, marginTop: 12 }}>
        <StatCard
          title="Temperatura atual"
          value={latest ? `${latest.temperature.toFixed(1)} °C` : "—"}
          footer={tempBadge}
        />
        <StatCard
          title="Umidade atual"
          value={latest ? `${latest.humidity.toFixed(1)} %` : "—"}
          footer={latest ? new Date(latest.ts).toLocaleString() : "—"}
        />
        <StatCard
          title="Médias (janela)"
          value={
            stats ? `${stats.avgTemp} °C • ${stats.avgHum} %` : "—"
          }
          footer={
            stats ? `T(min/max): ${stats.minTemp} / ${stats.maxTemp} • U(min/max): ${stats.minHum} / ${stats.maxHum}` : "—"
          }
        />
      </section>

      <section style={{ marginTop: 20 }}>
        <LiveChart history={history} />
      </section>

      <footer style={{ marginTop: 28, opacity: 0.7, fontSize: 12 }}>
        Envie leituras do ESP32 para o caminho escolhido. O gráfico mostra as últimas 50 amostras em tempo real.
      </footer>
    </div>
  );
}
