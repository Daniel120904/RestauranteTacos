"use client"
import { useState, useEffect } from "react"
import axios from "axios"

import BotaoVoltarHome from "@/app/components/utils/botaoVoltarHome"
import StatusMensagem from "@/app/components/utils/statusMensagem"
import HeaderAba from "@/app/components/criarPedido/headerAba"
import ListaItens from "@/app/components/criarPedido/listaItens"
import FooterResumo from "@/app/components/criarPedido/footerResumo"

export default function CriarPedido() {
    const [abaAtiva, setAbaAtiva] = useState("tacos")
    const [tacos, setTacos] = useState([])
    const [bebidas, setBebidas] = useState([])
    const [acompanhamentos, setAcompanhamentos] = useState([])

    const [pedido, setPedido] = useState({
        tacos: {},
        bebidas: {},
        acompanhamentos: {},
    })

    const [nomeCliente, setNomeCliente] = useState("")
    const [statusMensagem, setStatusMensagem] = useState("")

    useEffect(() => {
        axios.get("http://localhost:8080/api/tacos").then((res) => setTacos(res.data))
        axios.get("http://localhost:8080/api/bebidas").then((res) => setBebidas(res.data))
        axios.get("http://localhost:8080/api/acompanhamentos").then((res) => setAcompanhamentos(res.data))
    }, [])

    const adicionarItem = (categoria, id) => {
        setPedido((prev) => ({
            ...prev,
            [categoria]: { ...prev[categoria], [id]: (prev[categoria][id] || 0) + 1 },
        }))
    }

    const removerItem = (categoria, id) => {
        setPedido((prev) => {
            const quantidadeAtual = prev[categoria][id] || 0
            if (quantidadeAtual <= 1) {
                const { [id]: _, ...rest } = prev[categoria]
                return { ...prev, [categoria]: rest }
            }
            return {
                ...prev,
                [categoria]: { ...prev[categoria], [id]: quantidadeAtual - 1 },
            }
        })
    }

    const obterItens = () => {
        switch (abaAtiva) {
            case "tacos":
                return tacos
            case "bebidas":
                return bebidas
            case "acompanhamentos":
                return acompanhamentos
            default:
                return []
        }
    }

    const calcularTotal = () => {
        const calcularCategoria = (categoria, dados) => {
            return Object.entries(pedido[categoria] || {}).reduce((acc, [id, qtd]) => {
                const item = dados.find((i) => i.id === id)
                return acc + (item ? item.preco * qtd : 0)
            }, 0)
        }

        return (
            calcularCategoria("tacos", tacos) +
            calcularCategoria("bebidas", bebidas) +
            calcularCategoria("acompanhamentos", acompanhamentos)
        )
    }

    const finalizarPedido = async () => {
        try {
            const expandirIds = (categoria) => {
                return Object.entries(pedido[categoria] || {}).flatMap(
                    ([id, quantidade]) => Array(quantidade).fill(id)
                )
            }

            const payload = {
                nomeCliente,
                tacosIds: expandirIds("tacos"),
                bebidasIds: expandirIds("bebidas"),
                acompanhamentosIds: expandirIds("acompanhamentos"),
            }

            await axios.post("http://localhost:8080/api/pedidos", payload)

            setStatusMensagem("Pedido realizado com sucesso!")
            setPedido({ tacos: {}, bebidas: {}, acompanhamentos: {} })
            setNomeCliente("")
        } catch (error) {
            console.error("Erro ao finalizar pedido:", error)
            setStatusMensagem("Erro ao finalizar pedido.")
        }
    }

    return (
        <main className="min-h-screen bg-gray-50 flex flex-col">
            <div className="p-6">
                <BotaoVoltarHome />
                <HeaderAba abaAtiva={abaAtiva} setAbaAtiva={setAbaAtiva} />
                <ListaItens
                    itens={obterItens()}
                    categoria={abaAtiva}
                    pedido={pedido}
                    adicionarItem={adicionarItem}
                    removerItem={removerItem}
                />
                <StatusMensagem
                    statusMensagem={statusMensagem}
                    setStatusMensagem={setStatusMensagem}
                />
                <FooterResumo
                    nomeCliente={nomeCliente}
                    setNomeCliente={setNomeCliente}
                    total={calcularTotal()}
                    finalizarPedido={finalizarPedido}
                />
            </div>
        </main>
    )
}
