"use client"
import React from "react"

export default function CardPedido({
    pedido,
    tiposPagamento,
    pagamentoSelecionado,
    setPagamentoSelecionado,
    finalizarPagamento,
    }) {
    return (
        <div className="bg-white p-6 rounded-lg shadow flex flex-col space-y-3">
            <h2 className="text-xl font-semibold">
                Cliente: {pedido.nomeCliente}
            </h2>
            <p className="text-gray-600">
                Valor Total: <strong>R$ {pedido.precoTotal.toFixed(2)}</strong>
            </p>

            <div>
                <label className="block mb-1 text-sm font-medium">
                    Selecione o pagamento:
                </label>
                <select
                    className="border rounded px-3 py-2 w-full"
                    value={pagamentoSelecionado[pedido.id] || ""}
                    onChange={(e) =>
                        setPagamentoSelecionado((prev) => ({
                            ...prev,
                            [pedido.id]: e.target.value,
                        }))
                    }
                >
                    <option value="">Selecione...</option>
                    {Object.entries(tiposPagamento).map(([id, nome]) => (
                        <option key={id} value={id}>
                            {nome}
                        </option>
                    ))}
                </select>
            </div>

            <button
                disabled={!pagamentoSelecionado[pedido.id]}
                onClick={() => finalizarPagamento(pedido.id)}
                className={`${
                    pagamentoSelecionado[pedido.id]
                        ? "bg-green-600 hover:bg-green-700"
                        : "bg-gray-400 cursor-not-allowed"
                } text-white py-2 px-4 rounded`}
            >
                Finalizar Pagamento
            </button>
        </div>
    )
}
