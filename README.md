# 🔥 FireWatch - API Java (Spring Boot)

Sistema colaborativo de monitoramento de ocorrências relacionadas a **calor extremo** e **incêndios florestais**, com foco em prevenção e resposta rápida.

---

## 🚀 Sobre a API

Esta API permite:

- Cadastrar e listar localizações afetadas;
- Associar sensores, equipamentos, funcionários e cidades;
- Realizar operações de consulta, atualização e remoção de dados;
- Integrar com banco de dados Oracle utilizando Spring Data JPA;
- Validar dados com Bean Validation;
- Explorar endpoints via Swagger.

---

## 🛠 Tecnologias Utilizadas

- Java 17  
- Spring Boot  
- Spring Data JPA  
- Oracle Database  
- Bean Validation  
- Swagger / OpenAPI  
- Lombok  

---

## ▶️ Como rodar localmente

**1. Clone o repositório**

git clone https://github.com/seu-usuario/firewatch-api-java.git  
cd firewatch-api-java

**2. Configure o banco de dados Oracle**

Altere o arquivo `src/main/resources/application.properties` com os dados corretos do seu ambiente:

spring.datasource.url=jdbc:oracle:thin:@//localhost:1521/XEPDB1  
spring.datasource.username=SEU_USUARIO  
spring.datasource.password=SUA_SENHA  
spring.jpa.hibernate.ddl-auto=none  
spring.jpa.show-sql=true  

⚠️ Certifique-se de que o script SQL foi executado com sucesso no Oracle.

**3. Execute a aplicação com Maven**

./mvnw spring-boot:run

---

## 📖 Documentação Swagger

Acesse a interface gráfica em:  
http://localhost:8080/swagger-ui/index.html

---

## 📌 Principais Endpoints

**GET /localizacoes**  
Lista todas as localizações.

**GET /localizacoes/{id}**  
Busca uma localização por ID.

**POST /localizacoes**  
Cadastra uma nova localização.  
Exemplo de JSON:

{
  "latitude": -23.61,  
  "longitude": -46.68,  
  "dataOcorrencia": "2025-06-05",  
  "idCidade": 1,  
  "idFuncionario": 1,  
  "idSensor": 1,  
  "idEquipamento": 1  
}

**PUT /localizacoes/{id}**  
Atualiza uma localização existente.

**DELETE /localizacoes/{id}**  
Remove uma localização por ID.

---

## ❌ Tratamento de Erros

A API retorna mensagens amigáveis em casos de:

- ID inexistente para associações;
- Dados obrigatórios ausentes;
- Campos inválidos ou fora do formato esperado.

---

## ✨ Contribuidores

Este projeto foi desenvolvido por estudantes da FIAP como parte da Global Solution 2025.

---

## 📌 Observações

- Requisitos como JWT e paginação foram dispensados pelo professor nesta entrega.
- A API se conecta exclusivamente a um banco Oracle com procedures e triggers previamente criadas.

---

## 👥 Equipe

| Nome                                | RM       | GitHub                                |
|-------------------------------------|----------|----------------------------------------|
| Murilo Ribeiro Santos               | RM555109 | [@murilors27](https://github.com/murilors27) |
| Thiago Garcia Tonato                | RM99404  | [@thiago-tonato](https://github.com/thiago-tonato) |
| Ian Madeira Gonçalves da Silva      | RM555502 | [@IanMadeira](https://github.com/IanMadeira) |

**Curso**: Análise e Desenvolvimento de Sistemas  
**Instituição**: FIAP – Faculdade de Informática e Administração Paulista

