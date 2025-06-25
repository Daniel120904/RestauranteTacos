"use client"
import React from "react"

export default function CardItem({ item, quantidade, onAdicionar, onRemover }) {
    return (
        <div className="flex justify-between items-center bg-white shadow-md rounded-lg p-4 mb-4">
            <div>
                <h3 className="text-lg font-semibold">{item.nome || item.descricao}</h3>
                <p className="text-gray-500">R$ {item.preco.toFixed(2)}</p>
            </div>
            <div className="flex items-center space-x-3">
                <button
                    className="bg-red-500 hover:bg-red-600 text-white px-3 py-1 rounded"
                    onClick={onRemover}
                >
                    -
                </button>
                <span className="font-semibold">{quantidade}</span>
                <button
                    className="bg-green-500 hover:bg-green-600 text-white px-3 py-1 rounded"
                    onClick={onAdicionar}
                >
                    +
                </button>
            </div>
        </div>
    )
}
