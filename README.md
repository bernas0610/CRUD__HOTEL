# 🏨 CRUD Hotel

API REST para gerenciamento de reservas de hotel, desenvolvida com Spring Boot e MySQL.

## Tecnologias

- Java 25
- Spring Boot 4.0.6
- Spring Data JPA
- MySQL
- Lombok
- Maven

## Funcionalidades

- Cadastrar cliente/reserva
- Listar todos os clientes
- Atualizar dados de uma reserva
- Deletar cliente por e-mail

## Endpoints

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `POST` | `/clientes` | Cadastra um novo cliente |
| `GET` | `/clientes` | Lista todos os clientes |
| `PUT` | `/clientes?id={uuid}` | Atualiza os dados de um cliente |
| `DELETE` | `/clientes?email={email}` | Deleta um cliente pelo e-mail |

## Exemplo de body (POST / PUT)

```json
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "sexo": "Masculino",
  "numnoites": 3,
  "numhospedes": 2,
  "mensagem": "Quarto com vista para o mar"
}
```

> No `PUT`, apenas os campos que você quiser atualizar precisam ser enviados. Os demais serão mantidos com os valores já salvos.

## Configuração

### Pré-requisitos

- Java 25
- MySQL
- Maven

### Variáveis de ambiente

Antes de rodar o projeto, configure a variável de ambiente com a senha do banco:

```bash
export DB_PASSWORD=sua_senha_aqui
```

### Banco de dados

Crie o banco no MySQL:

```sql
CREATE DATABASE hotel;
```

### Rodando o projeto

```bash
./mvnw spring-boot:run
```

A aplicação sobe em `http://localhost:8080`.

## Estrutura do projeto

```
src/
└── main/
    └── java/br/unit/crud_hotel/
        ├── controller/   # Endpoints da API
        ├── domain/       # Entidade Cliente
        ├── dto/          # ClienteDTO (dados recebidos na requisição)
        ├── repository/   # Interface JPA
        └── service/      # Regras de negócio
```
