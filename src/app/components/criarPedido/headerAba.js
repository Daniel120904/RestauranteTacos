"use client"
import React from "react"

export default function HeaderAba({ abaAtiva, setAbaAtiva }) {
    const abas = [
        { id: "tacos", label: "Tacos" },
        { id: "bebidas", label: "Bebidas" },
        { id: "acompanhamentos", label: "Acompanhamentos" },
    ]

    return (
        <header className="bg-red-600 text-white py-4 shadow-md rounded-full">
            <div className="max-w-4xl mx-auto flex justify-around">
                {abas.map((aba) => (
                    <button
                        key={aba.id}
                        className={`${
                            abaAtiva === aba.id ? "font-bold underline" : ""
                        }`}
                        onClick={() => setAbaAtiva(aba.id)}
                    >
                        {aba.label}
                    </button>
                ))}
            </div>
        </header>
    )
}
