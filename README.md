# API de Gerenciamento de Oficina Mecânica

RESTful API desenvolvida com **Java** e **Spring Boot** para gerenciamento de processos operacionais de uma oficina mecânica. O sistema disponibiliza endpoints para controle de usuários, mecânicos, veículos e ordens de conserto, além de controle de acesso e autenticação via **Spring Security**.

---

## Funcionalidades

- **Autenticação & Autorização:** Gestão de usuários e segurança de rotas com Spring Security.
- **Módulo de Mecânicos:** Cadastro, listagem e atualização de profissionais da oficina.
- **Módulo de Veículos:** Registro e consulta de dados dos veículos atendidos.
- **Módulo de Consertos:** Abertura, acompanhamento e registro de ordens de serviço/consertos mecânicos.

---

## Tecnologias Utilizadas

- **Linguagem:** Java 17+
- **Framework:** Spring Boot
  - *Spring Web* (Criação de APIs REST)
  - *Spring Security* (Controle de acesso e autenticação)
  - *Spring Data JPA* (Persistência de dados)
- **Gerenciador de Dependências:** Maven

---

## Estrutura do Pacote

```text
src/main/java/br/edu/ifsp/prw3/avaliacao3/prw3_2026_1_api/
├── conserto/       # Regras de negócio, entidades e DTOs de consertos
├── controller/     # Endpoints REST e controle de requisições HTTP
├── mecanico/       # Entidades, repositórios e serviços de mecânicos
├── usuario/        # Gestão de credenciais, perfis e autenticação
├── util/           # Classes utilitárias, configs e handlers auxiliares
├── veiculo/        # Entidades e regras associadas a veículos
└── ApiApplication.java
