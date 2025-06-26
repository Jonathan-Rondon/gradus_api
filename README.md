# API de Gerenciamento de Alunos

## 📝 Descrição do Projeto

Esta é uma API REST desenvolvida para um trabalho acadêmico, com o objetivo de gerenciar informações de alunos de um campus. A aplicação permite realizar as operações básicas de um sistema de manutenção de dados (CRUD - Create, Read, Update, Delete).

A API foi construída utilizando **Java** com o framework **Spring Boot**. A persistência de dados é feita através do **Spring Data JPA**, e o banco de dados é executado em um container **Docker** para facilitar a configuração do ambiente.

---

## ✅ Funcionalidades

-   [x] **Carga Inicial de Dados:** Um programa separado foi utilizado para ler os dados de alunos e popular o banco de dados.
-   [x] **API REST Completa:**
    -   [x] **Configuração do Banco de Dados:**
        -   Criação do Diagrama de Entidade-Relacionamento (DER).
        -   Configuração do banco de dados com Docker e Docker Compose.
        -   Mapeamento Objeto-Relacional (ORM) com JPA/Hibernate.
    -   [x] **Desenvolvimento dos Endpoints:**
        -   CRUD completo para a entidade `Aluno`.
        -   Validação de dados na entrada (ex: campos obrigatórios).
        -   Implementação de 3 formas de busca personalizada (ex: por nome, curso, etc.).
-   [ ] **Testes:**
    -   [ ] Endpoints testados utilizando a ferramenta Postman (ou Insomnia).

---

## 🛠️ Tecnologias Utilizadas

*   **Linguagem:** Java 17
*   **Framework:** Spring Boot 3
*   **Módulos Principais:**
    *   Spring Web
    *   Spring Data JPA
    *   Spring Validation
*   **Banco de Dados:** PostgreSQL
*   **Containerização:** Docker e Docker Compose
*   **Build Tool:** Maven

---
