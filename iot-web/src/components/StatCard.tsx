import { type ReactNode } from "react";

type Props = {
  title: string;
  value: string | number;
  footer?: ReactNode;
};

export default function StatCard({ title, value, footer }: Props) {
  return (
    <div style={{
      border: "1px solid #e5e7eb",
      borderRadius: 12,
      padding: 16,
      boxShadow: "0 1px 2px rgba(0,0,0,0.04)"
    }}>
      <div style={{ fontSize: 12, opacity: 0.7 }}>{title}</div>
      <div style={{ fontSize: 28, fontWeight: 700, lineHeight: 1.2 }}>{value}</div>
      {footer && <div style={{ marginTop: 8, fontSize: 12, opacity: 0.8 }}>{footer}</div>}
    </div>
  );
}
