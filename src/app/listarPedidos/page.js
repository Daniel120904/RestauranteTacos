"use client"
import { useEffect, useState } from "react"
import axios from "axios"

import BotaoVoltarHome from "@/app/components/utils/botaoVoltarHome"
import ListaPedidos from "@/app/components/listarPedidos/listaPedidos"
import StatusMensagem from "@/app/components/utils/statusMensagem"

export default function ListarPedidos() {
    const [pedidos, setPedidos] = useState([])
    const [tiposPagamento, setTiposPagamento] = useState({})
    const [pagamentoSelecionado, setPagamentoSelecionado] = useState({})
    const [statusMensagem, setStatusMensagem] = useState("")

    useEffect(() => {
        axios.get("http://localhost:8080/api/pedidos").then((res) => {
            const pedidosSemPagamento = res.data.filter((p) => p.tipoPagamento === null)
            setPedidos(pedidosSemPagamento)
        })

        axios.get("http://localhost:8080/api/tipo-pagamento").then((res) => {
            const pagamentos = {}
            res.data.forEach((p) => {
                pagamentos[p.id] = p.nome
            })
            setTiposPagamento(pagamentos)
        })
    }, [])

    const finalizarPagamento = async (pedidoId) => {
        try {
            const tipoPagamentoId = pagamentoSelecionado[pedidoId]
            if (!tipoPagamentoId) {
                alert("Selecione um tipo de pagamento antes de finalizar!")
                return
            }

            await axios.post(
                `http://localhost:8080/api/pedidos/${pedidoId}/pagamento`,
                { tipoPagamentoId: tipoPagamentoId }
            )

            setStatusMensagem("Pagamento realizado com sucesso!")
            setPedidos((prev) => prev.filter((p) => p.id !== pedidoId))
        } catch (error) {
            console.error(error)
            setStatusMensagem("Erro ao finalizar pagamento.")
        }
    }

    return (
        <main className="min-h-screen bg-gray-50 p-8 flex flex-col items-center">
            <div className="w-full max-w-3xl">
                <BotaoVoltarHome />
                <h1 className="text-3xl font-bold mb-6">Pedidos em Andamento</h1>
                <StatusMensagem
                    statusMensagem={statusMensagem}
                    setStatusMensagem={setStatusMensagem}
                />
                <ListaPedidos
                    pedidos={pedidos}
                    tiposPagamento={tiposPagamento}
                    pagamentoSelecionado={pagamentoSelecionado}
                    setPagamentoSelecionado={setPagamentoSelecionado}
                    finalizarPagamento={finalizarPagamento}
                />
            </div>
        </main>
    )
}
