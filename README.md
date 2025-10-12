Projeto desenvolvido em **Java + Spring Boot**, com o objetivo de criar uma **API REST** para controle de usuários e suas **transações financeiras** (receitas e despesas), mantendo o **saldo atualizado automaticamente**.

---

## 🚀 **Tecnologias Utilizadas**
- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **Bean Validation**
- **Lombok**
- **MySQL**
- **Maven**

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
