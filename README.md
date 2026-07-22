# 💰 Sistema de Gestão Financeira Pessoal

## 📌 Visão Geral

API REST desenvolvida em **Java com Spring Boot** para gerenciamento de usuários e suas **transações financeiras**, permitindo o controle de receitas, despesas, categorias e saldo individual.

O sistema aplica regras de negócio para garantir a **integridade das transações**, a **unicidade dos dados dos usuários** e a **atualização automática do saldo** com base nas movimentações financeiras realizadas.

---
## 🧱 Tecnologias Utilizadas

![Java](https://img.shields.io/badge/Java-17+-orange?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=for-the-badge&logo=springboot&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-3.x-brightgreen?style=for-the-badge&logo=spring&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-ORM596?style=for-the-badge&logo=hibernate&logoColor=white)
![Jakarta Validation](https://img.shields.io/badge/Jakarta%20Validation-3.x-orange?style=for-the-badge)
![Lombok](https://img.shields.io/badge/Lombok-1.18.x-red?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=for-the-badge&logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.x-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
---

## 🧩 **Funcionalidades**
✅ **Usuário**
- Cadastro de usuário com validação de CPF e e-mail únicos;  
- Listagem por ID, CPF ou de todos os usuários;  
- Exceções personalizadas para dados duplicados ou inexistentes.  

✅ **Transação**
- Cadastro de transações (Receita/Despesa);  
- Filtros por tipo, categoria e intervalo de datas;  
- Cálculo automático de saldo com base nas transações;  
- Lançamento de exceções em casos de saldo insuficiente.  

---

## 🏗️ **Arquitetura do Projeto**

O sistema segue a arquitetura em camadas:

### 📚 Camadas explicadas:
- **Controller:** responsável por receber as requisições HTTP e retornar respostas adequadas;  
- **Service:** contém as regras de negócio e a lógica de processamento;  
- **Repository:** camada de persistência, utilizando JPA para acesso ao banco de dados;  
- **Entity:** representa as tabelas do banco de dados (modelos de domínio);  
- **DTO (Data Transfer Object):** responsável pela transferência de dados entre as camadas da aplicação, garantindo segurança e evitando o envio de entidades completas nas requisições e respostas.

---

## ⚙️ **Rotas da API**

### 👤 **Usuário**
| Método | Rota | Descrição |
|:-------:|:---------------------------|:------------------------------------|
| **POST** | `/usuario/novo-usuario` | Cadastra um novo usuário |
| **GET** | `/usuario/listar-cpf/{cpf}` | Busca um usuário pelo CPF |
| **GET** | `/usuario/listar-id/{id}` | Busca um usuário pelo ID |
| **GET** | `/usuario/listar-todos` | Lista todos os usuários cadastrados |

---

### 💳 **Transação**
| Método | Rota | Descrição |
|:-------:|:--------------------------------------------|:----------------------------------------------|
| **POST** | `/transacao/nova-transacao/{cpf}` | Cadastra uma nova transação para o usuário |
| **GET** | `/transacao/usuario-cpf/{cpf}` | Lista todas as transações de um usuário |
| **GET** | `/transacao/tipo/{cpf}/{tipoTransacao}` | Filtra transações por tipo (RECEITA ou DESPESA) |
| **GET** | `/transacao/listar-categoria/{cpf}/{categoria}` | Filtra transações por categoria |
| **GET** | `/transacao/data/{cpf}/{inicio}/{fim}` | Filtra transações por intervalo de datas |
| **GET** | `/transacao//listar-todos` | Lista todas as transações |
| **GET** | `/transacao/saldo/{cpf}` | Retorna o saldo total de um usuário |
