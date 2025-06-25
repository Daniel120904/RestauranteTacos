"use client"
import Funcionalidades from "@/app/components/home/funcionalidades";

export default function Home() {
    return (
        <main className="min-h-screen bg-gray-50 flex flex-col items-center justify-center">
                <h1 className="text-3xl font-bold mb-6">Restaurante de Tacos :)</h1>
                <Funcionalidades />
        </main>
    )
}
