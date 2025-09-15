import {
  Chart as ChartJS,
  LineElement,
  CategoryScale,
  LinearScale,
  PointElement,
  Tooltip,
  Legend,
  TimeScale,
} from "chart.js";
import "chartjs-adapter-date-fns";
import { Line } from "react-chartjs-2";
import type { Telemetry } from "../types";

ChartJS.register(
  LineElement,
  CategoryScale,
  LinearScale,
  PointElement,
  Tooltip,
  Legend,
  TimeScale
);

type Props = {
  history: Telemetry[];
};

export default function LiveChart({ history }: Props) {
  const data = {
    labels: history.map((h) => h.ts),
    datasets: [
      {
        label: "Temperatura (°C)",
        data: history.map((h) => h.temperature),
        tension: 0.25,
        pointRadius: 0,
        borderWidth: 2,
      },
      {
        label: "Umidade (%)",
        data: history.map((h) => h.humidity),
        tension: 0.25,
        pointRadius: 0,
        borderWidth: 2,
        yAxisID: "y1",
      },
    ],
  };

  const options = {
    responsive: true,
    maintainAspectRatio: false as const,
    interaction: { mode: "index" as const, intersect: false },
    scales: {
      x: {
        type: "time" as const,
        time: { unit: "minute" as const, tooltipFormat: "dd/MM HH:mm:ss" },
        ticks: { autoSkip: true, maxTicksLimit: 8 },
      },
      y: {
        title: { text: "°C", display: true },
      },
      y1: {
        position: "right" as const,
        grid: { drawOnChartArea: false },
        title: { text: "%", display: true },
      },
    },
    plugins: {
      legend: { position: "bottom" as const },
      tooltip: { enabled: true },
    },
  };

  return (
    <div style={{ height: 320 }}>
      <Line data={data} options={options} />
    </div>
  );
}
