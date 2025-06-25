# 🌮 Restaurante Tacos - Frontend

Este é o projeto **frontend** do sistema de gerenciamento de pedidos do restaurante fictício **Restaurante Tacos**, desenvolvido com **Next.js**. O sistema permite que o cliente monte seu pedido escolhendo tacos, bebidas e acompanhamentos. Ao final, o pedido é enviado para a API backend e armazenado.

---

## 🚀 Tecnologias Utilizadas

- [Next.js](https://nextjs.org/) – Framework React para aplicações web modernas  
- [React](https://react.dev/) – Biblioteca para construção de interfaces de usuário  
- [Axios](https://axios-http.com/) – Cliente HTTP para comunicação com o backend  
- [Tailwind CSS](https://tailwindcss.com/) – Framework de CSS utilitário  
- [ESLint + Prettier] – Padronização de código  
- [JavaScript (ES6+)] – Linguagem base do projeto  

---

## 📁 Estrutura de Pastas

```
/app
  /components       → Componentes reutilizáveis (Header, Footer, ListaItens etc)
  /criarPedido      → Componentes da tela de criação de pedido
  /listarPedidos    → Componentes da tela de pagamento
  /utils            → Botões, mensagens e funções auxiliares
  /page             → Pagina inicial
```

---

## ⚙️ Pré-requisitos

Antes de começar, você precisa ter instalado na máquina:

- **Node.js** (recomenda-se a versão LTS mais recente)  
  https://nodejs.org/
- **npm** ou **yarn** para gerenciar as dependências  
- **Git** para clonar o projeto (ou baixe o ZIP)

---

## 📥 Como Instalar e Rodar o Projeto

```bash
# 1. Clone o repositório
git clone https://github.com/seu-usuario/restaurante-tacos-frontend.git

# 2. Acesse a pasta do projeto
cd restaurante-tacos-frontend

# 3. Instale as dependências
npm install
# ou
yarn install

# 4. Inicie o servidor de desenvolvimento
npm run dev
# ou
yarn dev

# 5. Acesse no navegador:
http://localhost:3000
```

> Obs: O projeto espera que o backend esteja rodando em `http://localhost:8080`. Você pode ajustar isso dentro dos arquivos onde `axios` é utilizado.

---

## 🌐 Conexão com o Backend

A comunicação com o backend é feita via **Axios**, apontando para rotas como:

- `GET http://localhost:8080/api/tacos`
- `POST http://localhost:8080/api/pedidos`

Se desejar trocar a URL base, você pode criar um arquivo de configuração global para o `axios` com `axios.create()` ou usar variáveis de ambiente (ex: `.env.local`).

---

## 📸 Funcionalidades

- Selecionar tacos, bebidas e acompanhamentos  
- Adicionar ou remover quantidade  
- Inserir nome do cliente  
- Finalizar pedido e exibir mensagem de sucesso  
- Comunicação em tempo real com a API

---

## 👨‍💻 Desenvolvedor

**Daniel Adriano**  
Estudante de Análise e Desenvolvimento de Sistemas – FATEC Mogi das Cruzes  
[LinkedIn]([https://www.linkedin.com/](https://www.linkedin.com/in/daniel-adriano-02b66732b/)) 
