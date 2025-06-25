"use client"

import BotaoHome from "@/app/components/home/botaoHome";

export default function Funcionalidades(){
    return <div className="w-full max-w-md bg-white rounded-lg shadow p-8 text-center flex flex-col space-y-4">
            <BotaoHome
                href="/criarPedido"
                className="bg-green-600 hover:bg-green-700 text-white py-3 px-6 rounded-lg"
                titulo="Fazer Novo Pedido"
            />
            <BotaoHome
                href="/listarPedidos"
                className="bg-green-600 hover:bg-green-700 text-white py-3 px-6 rounded-lg"
                titulo="Pedidos em Andamento"
            />
    </div>
}
