"use client"
import Link from "next/link";

export default function BotaoVoltarHome() {
    return(
        <Link href="/" className="inline-block mb-4 px-4 py-2 bg-blue-600 text-white rounded hover:bg-blue-700">
            ⬅️ Voltar
        </Link>
    )
}