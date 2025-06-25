"use client"
import React from "react"
import CardItem from "./CardItem"

export default function ListaItens({
    itens,
    categoria,
    pedido,
    adicionarItem,
    removerItem,
    }) {
    return (
        <section className="max-w-4xl mx-auto p-6 flex-1">
            <h2 className="text-2xl font-bold mb-4 capitalize">{categoria}</h2>
            {itens.map((item) => (
                <CardItem
                    key={item.id}
                    item={item}
                    quantidade={pedido[categoria][item.id] || 0}
                    onAdicionar={() => adicionarItem(categoria, item.id)}
                    onRemover={() => removerItem(categoria, item.id)}
                />
            ))}
        </section>
    )
}
