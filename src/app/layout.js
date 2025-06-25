import './globals.css'

export const metadata = {
    title: 'Restaurante de Tacos',
    description: 'Monte seu pedido de tacos!',
}

export default function RootLayout({ children }) {
    return (
        <html lang="pt-BR">
        <body>{children}</body>
        </html>
    )
}

