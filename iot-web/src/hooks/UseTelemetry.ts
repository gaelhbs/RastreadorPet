import { useEffect, useState } from "react";
import {
  DataSnapshot,
  limitToLast,
  onValue,
  query,
  ref,
} from "firebase/database";
import { db } from "../lib/Firebase";

type Telemetry = {
  temperature: number;
  humidity: number;
  ts: number;
};

function snapToTelemetry(s: DataSnapshot | null): Telemetry | null {
  if (!s || !s.exists()) return null;
  const val = s.val();
  if (typeof val !== "object" || val === null) return null;
  const t = Number(val.temperature);
  const h = Number(val.humidity);
  const ts = Number(val.ts ?? Date.now());
  if (Number.isNaN(t) || Number.isNaN(h)) return null;
  return { temperature: t, humidity: h, ts };
}

export function useTelemetry(deviceId: string, points = 50) {
  const [latest, setLatest] = useState<Telemetry | null>(null);
  const [history, setHistory] = useState<Telemetry[]>([]);
  const [loading, setLoading] = useState(true);
  const [err, setErr] = useState<string | null>(null);

  useEffect(() => {
    if (!deviceId) return;
    setLoading(true);
    setErr(null);

    const latestRef = ref(db, `/measurements`);
    const unsubLatest = onValue(
      query(latestRef, limitToLast(1)),
      (snap) => {
        let latestData: Telemetry | null = null;
        snap.forEach((child) => {
          latestData = snapToTelemetry(child);
        });
        setLatest(latestData);
      },
      (e) => setErr(e.message)
    );

    const historyRef = ref(db, `/measurements`);
    const q = query(historyRef, limitToLast(points));

    const unsubHist = onValue(
      q,
      (snap) => {
        const arr: Telemetry[] = [];
        snap.forEach((child) => {
          const t = snapToTelemetry(child);
          if (t) arr.push(t);
        });
        arr.sort((a, b) => a.ts - b.ts);
        setHistory(arr);
        setLoading(false);
      },
      (e) => {
        setErr(e.message);
        setLoading(false);
      }
    );

    return () => {
      unsubLatest();
      unsubHist();
    };
  }, [deviceId, points]);

  return { latest, history, loading, error: err };
}
