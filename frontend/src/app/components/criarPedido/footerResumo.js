"use client"
import React from "react"

export default function FooterResumo({
    nomeCliente,
    setNomeCliente,
    total,
    finalizarPedido,
    }) {
    return (
        <footer className="bg-white shadow-md p-4">
            <div className="max-w-4xl mx-auto">
                <div className="flex flex-col space-y-2">
                    <input
                        type="text"
                        className="border rounded px-3 py-2"
                        placeholder="Nome do Cliente"
                        value={nomeCliente}
                        onChange={(e) => setNomeCliente(e.target.value)}
                    />
                    <div className="flex justify-between">
                        <span className="font-semibold">
                            Total: R$ {total.toFixed(2)}
                        </span>
                        <button
                            onClick={finalizarPedido}
                            className="bg-green-600 hover:bg-green-700 text-white px-4 py-2 rounded"
                        >
                            Finalizar Pedido
                        </button>
                    </div>
                </div>
            </div>
        </footer>
    )
}
