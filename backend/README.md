# 🌮 Restaurante Tacos - Backend

Este é o projeto **backend** do sistema de pedidos do Restaurante Tacos, desenvolvido em **Java com Spring Boot**. Ele fornece uma API REST para que o frontend possa cadastrar pedidos, listar produtos e realizar pagamentos.

---

## 🚀 Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot 3.5**
- **Spring Data MongoDB**
- **MongoDB** – Banco de dados NoSQL
- **Lombok** – Geração de código boilerplate
- **JUnit 5** + **Mockito** – Testes automatizados
- **Maven** – Gerenciador de dependências

---

## 📁 Estrutura de Pastas

```
/src
  /main
    /java
      /com/daniel/restauranteTacos
        /controller     → Endpoints da API
        /service        → Regras de negócio
        /model          → Classes de domínio (Pedido, Taco, Pagamento etc)
        /repository     → Interfaces para acesso ao MongoDB
        /dto            → Objetos de transferência de dados
        /enums          → Tipos como TipoItem
  /test
    /...               → Testes automatizados com JUnit/Mockito
```

---

## ⚙️ Pré-requisitos

- [Java 17+](https://adoptium.net/)
- [Maven](https://maven.apache.org/)
- [MongoDB](https://www.mongodb.com/) (pode ser local ou Atlas)

---

## 🛠️ Como Rodar o Projeto

### 1. Clone o projeto:

```bash
git clone https://github.com/seu-usuario/restaurante-tacos-backend.git
cd restaurante-tacos-backend
```

### 2. Configure o banco de dados (caso precise)

Altere o arquivo `application.properties` ou `application.yml`:

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/restauranteTacos
```

### 3. Rode a aplicação:

Usando Maven:

```bash
./mvnw spring-boot:run
```

Ou pela sua IDE (IntelliJ ou VS Code)

---

## 🧪 Executar os Testes

```bash
./mvnw test
```

Ou diretamente pela IDE com botão de run nos testes.

---

## 🌐 Endpoints Principais

- `GET /api/tacos` – Lista tacos disponíveis  
- `GET /api/bebidas` – Lista bebidas  
- `GET /api/acompanhamentos` – Lista acompanhamentos  
- `POST /api/pedidos` – Cria um novo pedido  
- `POST /api/pedidos/{id}/pagamento` – Associa pagamento ao pedido  
- `GET /api/pedidos` – Lista todos os pedidos

---

## 🛠️ Dependências Principais (pom.xml)

- spring-boot-starter-web  
- spring-boot-starter-data-mongodb  
- spring-boot-starter-test  
- lombok  
- junit-jupiter  
- mockito-core

---

## 🧠 Sobre o Projeto

O sistema gerencia pedidos de tacos, bebidas e acompanhamentos. O backend realiza validações, cálculos de totais, persistência no MongoDB, e simula pagamentos. O frontend (feito em Next.js) consome essa API.

---

## 👨‍💻 Desenvolvedor

**Daniel Adriano**  
Estudante de Análise e Desenvolvimento de Sistemas – FATEC Mogi das Cruzes  
[LinkedIn]([https://www.linkedin.com/](https://www.linkedin.com/in/daniel-adriano-02b66732b/))

