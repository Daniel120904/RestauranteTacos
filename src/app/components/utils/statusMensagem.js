"use client"
import { useEffect } from "react"

export default function StatusMensagem({ statusMensagem, setStatusMensagem, tempo = 3000 }) {
    useEffect(() => {
        if (statusMensagem) {
            const timer = setTimeout(() => {
                setStatusMensagem("")
            }, tempo)

            return () => clearTimeout(timer)
        }
    }, [statusMensagem, tempo, setStatusMensagem])

    if (!statusMensagem) return null

    return (
        <p className="mt-6 text-center text-sm text-blue-600">
            {statusMensagem}
        </p>
    )
}

