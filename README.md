# API de Gerenciamento de Alunos

## 📝 Descrição do Projeto

Esta é uma API REST desenvolvida para o trabalho da disciplina, com o objetivo de gerenciar informações de alunos de um campus. A aplicação permite realizar as operações básicas de um sistema de manutenção de dados.

A API foi construída utilizando **Java** com o framework **Spring Boot**. A persistência de dados é feita através do **Spring Data JPA** e o banco de dados é executado em um container **Docker**.

---

## ✅ Funcionalidades Implementadas

Conforme solicitado no escopo do projeto, as seguintes funcionalidades foram implementadas:

### 1ª Aplicação: Carga de Dados
- [x] Um programa separado foi utilizado para ler os dados de alunos e popular o banco de dados.

### 2ª Aplicação: API REST
- [x] **Configuração do Banco de Dados:**
    - [x] Criação do Diagrama de Entidade-Relacionamento.
    - [x] Configuração do banco de dados com Docker.
    - [x] Mapeamento Objeto-Relacional com JPA/Hibernate.
- [x] **Desenvolvimento dos Endpoints da API:**
    - [x] `GET /api/alunos`: Buscar todos os alunos.
    - [x] `POST /api/alunos`: Inserir um novo aluno, com validação de campos obrigatórios.
    - [x] `GET /api/alunos/{id}`: Buscar um aluno por ID.
    - [x] `PUT /api/alunos/{id}`: Editar as informações de um aluno.
    - [x] `DELETE /api/alunos/{id}`: Excluir um aluno.
    - [x] Implementação de 3 formas de busca (Ex: por nome, curso, etc.).
- [] **Testes:**
    - [] Os endpoints foram testados utilizando a ferramenta Postman (ou Insomnia).

---

## 🛠️ Tecnologias Utilizadas

*   **Linguagem:** Java 17
*   **Framework:** Spring Boot 3
*   **Módulos Spring:** Spring Web, Spring Data JPA, Spring Validation
*   **Banco de Dados:** PostgreSQL (ou o banco que você usou)
*   **Ambiente:** Docker e Docker Compose

---

## ⚙️ Como Executar o Projeto

Siga os passos abaixo para executar a aplicação localmente.

### Pré-requisitos
*   Java 17 (ou superior)
*   Maven
*   Docker e Docker Compose

