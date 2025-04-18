## **📦Gerenciamento de Encomendas**
### 🏢 Sistema de gerenciamento de encomendas para prédios residenciais

![Java](https://img.shields.io/badge/Java-17-blue) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0.0-brightgreen) ![Docker](https://img.shields.io/badge/Docker-✔-blue) ![RabbitMQ](https://img.shields.io/badge/RabbitMQ-✔-orange) ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-✔-blue)

---

### **📌 Sobre o projeto**
O **Gerenciamento de Encomendas** é um sistema que permite que porteiros de prédios residenciais organizem a entrega de encomendas para os moradores. O sistema permite notificações automáticas via mensageria (**RabbitMQ**) e mantém um registro no banco de dados (**PostgreSQL**).  

### **🚀 Funcionalidades**
✔ Cadastro de moradores  
✔ Registro de encomendas pela portaria  
✔ Notificação automática ao morador sobre a chegada da encomenda  
✔ Confirmação de retirada da encomenda pelo morador  
✔ Persistência de dados no banco PostgreSQL  
✔ Sistema baseado em **Clean Architecture**  
✔ Contêiner Docker para fácil execução  
✔ Integração com RabbitMQ para comunicação assíncrona

---

## **🛠 Tecnologias Utilizadas**
- **Java 17**
- **Spring Boot 3.0.0**
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
git clone https://github.com/seu-usuario/api-encomendas.git
cd api-encomendas
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
## **📘 Clean Architecture**

O projeto segue o princípio de Arquitetura Limpa, com as seguintes camadas:

Domain: Contém as entidades de negócio (como Morador e Encomenda).

Application: Implementa casos de uso, lógica de negócios e serviços.

Adapters: Camada de interação com o mundo exterior (Controllers, Repositórios).

Infrastructure: Implementações de persistência e mensageria (Banco de dados, RabbitMQ).

## **📌 Estrutura do Projeto**
```
📂 tech-challenge-encomendas
├── 📂 src/main/java/com/techchallenge/encomendas
│   ├── 📂 adapters (Controllers, Repositórios, Mensageria)
│   ├── 📂 application (Casos de uso, DTOs, Mappers e Services)
│   ├── 📂 domain (Entidades de negócio)
│   ├── 📂 infrastructure (Repositórios e Mensageria)
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
| GET   | `/moradores`      | Lista todos moradores   |
| GET    | `/moradores/{id}` | Buscar morador por ID    |
| GET    | `/moradores/?cpf` | Buscar morador por CPF    |
| GET    | `/moradores/?apartamento` | Buscar morador por Apartamento    |

### **🔹 Encomendas**
| Método | Endpoint          | Descrição                      |
|--------|------------------|--------------------------------|
| POST   | `/encomendas`      | Registrar uma nova encomenda  |
| GET    | `/encomendas/{id}` | Buscar encomenda por ID       |
| PUT    | `/encomendas/{id}/retirada` | Confirmar retirada da encomenda |
| PUT    | `/encomendas/{id}/confirmar-notificacao` | Confirmar notificação ao Morador |

---

## **🛠 Modelagem de Dados**
![image](https://github.com/user-attachments/assets/b1bee03b-d16d-45c0-a5a3-d552c1f013c4)
---

## **🛠 Testes**
Para rodar os testes, use:
```bash
mvn test
```

---
## **📘 Docker e Docker Compose**

Ao rodar o projeto com Docker Compose, o sistema irá iniciar dois contêineres:

PostgreSQL: Banco de dados configurado automaticamente com o nome encomendas.

A senha e o usuário são definidos no docker-compose.yml.

O banco é configurado para ser persistido no volume postgres-data.

RabbitMQ: Configurado para fornecer a mensageria de comunicação entre os serviços.

Portas expostas: 5672 para AMQP (mensagens) e 15672 para o painel de administração.

Ambos os serviços são interligados ao contêiner da aplicação principal, permitindo a comunicação entre a API e os bancos de dados e mensageria de forma simplificada.

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
