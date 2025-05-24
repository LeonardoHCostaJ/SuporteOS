# SuporteOS-FEF

Sistema de suporte a ordens de serviço desenvolvido com Spring Boot.

## 📋 Descrição

Este projeto é uma API RESTful voltada para a gestão de ordens de serviço (OS), produtos, técnicos e usuários. Ele oferece endpoints para operações CRUD e integrações típicas de sistemas de atendimento e suporte técnico.

## 🚀 Tecnologias

- Java 17+
- Spring Boot
- Maven
- JPA / Hibernate
- Swagger (OpenAPI)
- H2 / PostgreSQL (dependendo do perfil)
- Spring Validation

## 📁 Estrutura

```
src/
├── main/
│   ├── java/com/curso/
│   │   ├── config/            # Configurações do Spring e Swagger
│   │   ├── domains/           # Entidades do sistema (Produto, Técnico, OS)
│   │   ├── domains/dtos/      # Data Transfer Objects
│   │   ├── repositories/      # Interfaces JPA
│   │   ├── resources/         # Controllers REST
│   │   └── services/          # Lógica de negócio
│   └── resources/
│       ├── application.properties  # Configurações do projeto
│       └── static/, templates/     # (se aplicável)
```

## ⚙️ Como executar

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/SuporteOS-FEF.git
cd SuporteOS-FEF
```

2. Compile o projeto:
```bash
./mvnw clean install
```

3. Execute a aplicação:
```bash
./mvnw spring-boot:run
```

4. Acesse:
- API: `http://localhost:8080`
- Swagger UI: `http://localhost:8080/swagger-ui/index.html`

## 🧪 Testes

Você pode executar os testes automatizados com:

```bash
./mvnw test
```

## 🛠️ Autores

Projeto desenvolvido como parte de estudos ou aplicação acadêmica.

--- Leonardo Henrique Costa

> Sinta-se à vontade para contribuir com melhorias ou sugestões!
