"use client"
import React from "react"
import CardPedido from "./CardPedido"

export default function ListaPedidos({
    pedidos,
    tiposPagamento,
    pagamentoSelecionado,
    setPagamentoSelecionado,
    finalizarPagamento,
    }) {
    if (pedidos.length === 0) {
        return <p className="text-gray-500">Nenhum pedido em andamento.</p>
    }

    return (
        <div className="space-y-6">
            {pedidos.map((pedido) => (
                <CardPedido
                    key={pedido.id}
                    pedido={pedido}
                    tiposPagamento={tiposPagamento}
                    pagamentoSelecionado={pagamentoSelecionado}
                    setPagamentoSelecionado={setPagamentoSelecionado}
                    finalizarPagamento={finalizarPagamento}
                />
            ))}
        </div>
    )
}
