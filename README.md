## **📦 Tech Challenge - Gerenciamento de Encomendas**
### 🏢 Sistema de gerenciamento de encomendas para prédios residenciais

![Java](https://img.shields.io/badge/Java-17-blue) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.7-brightgreen) ![Docker](https://img.shields.io/badge/Docker-✔-blue) ![RabbitMQ](https://img.shields.io/badge/RabbitMQ-✔-orange) ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-✔-blue)

---

### **📌 Sobre o projeto**
O **Tech Challenge - Gerenciamento de Encomendas** é um sistema que permite que porteiros de prédios residenciais organizem a entrega de encomendas para os moradores. O sistema permite notificações automáticas via mensageria (**RabbitMQ**) e mantém um registro no banco de dados (**PostgreSQL**).  

### **🚀 Funcionalidades**
✔ Cadastro de moradores  
✔ Registro de encomendas pela portaria  
✔ Notificação automática ao morador sobre a chegada da encomenda  
✔ Confirmação de retirada da encomenda pelo morador  
✔ Persistência de dados no banco PostgreSQL  
✔ Sistema baseado em **Arquitetura Hexagonal** e **Clean Architecture**  
✔ Contêiner Docker para fácil execução  

---

## **🛠 Tecnologias Utilizadas**
- **Java 17**
- **Spring Boot 3.3.7**
- **Spring Data JPA**
- **Spring AMQP (RabbitMQ)**
- **Spring Web**
- **PostgreSQL 15+**
- **Flyway**
- **Docker e Docker Compose**
- **JUnit e Mockito**
- **Lombok**
- **SpringDoc OpenAPI (Swagger)**

---

## **⚙️ Configuração do Ambiente**
### **1️⃣ Pré-requisitos**
Antes de rodar o projeto, você precisa ter instalado:
- [JDK 17](https://adoptium.net/)
- [Docker e Docker Compose](https://www.docker.com/)
- [PostgreSQL](https://www.postgresql.org/download/)
- [RabbitMQ](https://www.rabbitmq.com/download.html)

### **2️⃣ Configuração do Banco de Dados**
O banco de dados pode ser inicializado com **Docker Compose**:
```bash
docker-compose up -d
```
Ou pode ser configurado manualmente no `application.yml`:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/encomendas
    username: seu-usuario
    password: sua-senha
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: validate
    show-sql: true
  flyway:
    enabled: true
```

### **3️⃣ Rodando o projeto**
Clone o repositório:
```bash
git clone https://github.com/seu-usuario/tech-challenge-encomendas.git
cd tech-challenge-encomendas
```
Compile e execute:
```bash
mvn clean install
mvn spring-boot:run
```

### **4️⃣ Acessando a API**
Após rodar o projeto, acesse a documentação:
- Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- API Docs: [http://localhost:8080/api-docs](http://localhost:8080/api-docs)

---

## **📌 Estrutura do Projeto**
```
📂 tech-challenge-encomendas
├── 📂 src/main/java/com/techchallenge/encomendas
│   ├── 📂 domain (Entidades de negócio)
│   ├── 📂 application (Casos de uso)
│   ├── 📂 adapters (Controllers, Repositórios, Mensageria)
│   ├── 📂 config (Configurações do Spring)
│   ├── 📂 tests (Testes unitários e integração)
├── 📄 Dockerfile
├── 📄 docker-compose.yml
├── 📄 README.md
```

---

## **📬 Endpoints Principais**
### **🔹 Moradores**
| Método | Endpoint          | Descrição                 |
|--------|------------------|--------------------------|
| POST   | `/moradores`      | Cadastrar um morador     |
| GET    | `/moradores/{id}` | Buscar morador por ID    |

### **🔹 Encomendas**
| Método | Endpoint          | Descrição                      |
|--------|------------------|--------------------------------|
| POST   | `/encomendas`      | Registrar uma nova encomenda  |
| GET    | `/encomendas/{id}` | Buscar encomenda por ID       |
| PUT    | `/encomendas/{id}/retirada` | Confirmar retirada |

---

## **🛠 Testes**
Para rodar os testes, use:
```bash
mvn test
```

---

## **🛳 Execução com Docker**
Você pode rodar o projeto dentro de um contêiner com:
```bash
docker build -t tech-challenge-encomendas .
docker run -p 8080:8080 tech-challenge-encomendas
```
Ou utilizar **Docker Compose**:
```bash
docker-compose up -d
```

---

## **📌 Contribuição**
Contribuições são bem-vindas!  
Para contribuir:
1. Fork este repositório
2. Crie uma branch (`feature/minha-feature`)
3. Commit suas alterações (`git commit -m 'Adicionando nova feature'`)
4. Envie um Pull Request 🚀

---
