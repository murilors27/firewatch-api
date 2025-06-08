# 🔥 FireWatch - API Java (Spring Boot)

Sistema colaborativo de monitoramento de ocorrências relacionadas a **calor extremo** e **incêndios florestais**, com foco em prevenção e resposta rápida.

---

## 🚀 Sobre a API

Esta API permite:

- Cadastrar e listar localizações afetadas;
- Associar sensores, equipamentos, funcionários e cidades;
- Realizar operações de consulta, atualização e remoção de dados;
- Integrar com banco de dados MySQL utilizando Spring Data JPA;
- Validar dados com Bean Validation;
- Explorar endpoints via Swagger.

---

## 🛠 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL Database
- Bean Validation
- Swagger / OpenAPI
- Lombok

---

## ▶️ Como rodar localmente

**1. Clone o repositório**

```bash
git clone https://github.com/seu-usuario/firewatch-api-java.git
cd firewatch-api-java
```

**2. Configure o banco de dados MySQL**

Configure as variáveis de ambiente necessárias:

```bash
MYSQL_DB_HOST=localhost
MYSQL_DB_PORT=3306
MYSQL_DB_NAME=firewatch
MYSQL_DB_USERNAME=seu_usuario
MYSQL_DB_PASSWORD=sua_senha
```

Ou altere o arquivo `src/main/resources/application.properties` com os dados corretos do seu ambiente:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/firewatch
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

**3. Execute a aplicação com Maven**

```bash
./mvnw spring-boot:run
```

---

## 📖 Documentação Swagger

Acesse a interface gráfica em:  
http://localhost:8080/swagger-ui/index.html

---

## 📌 Principais Endpoints

### Localizações

**GET /localizacoes**  
Lista todas as localizações.

**GET /localizacoes/{id}**  
Busca uma localização por ID.

**POST /localizacoes**  
Cadastra uma nova localização.  
Exemplo de JSON:

```json
{
  "latitude": -23.61,
  "longitude": -46.68,
  "dataOcorrencia": "2024-03-20",
  "idCidade": 1,
  "idFuncionario": 1,
  "idSensor": 1,
  "idEquipamento": 1
}
```

**PUT /localizacoes/{id}**  
Atualiza uma localização existente.  
Exemplo de JSON (mesmo formato do POST).

**DELETE /localizacoes/{id}**  
Remove uma localização por ID.

### Cidades

**GET /cidades**  
Lista todas as cidades.

**GET /cidades/{id}**  
Busca uma cidade por ID.

**POST /cidades**  
Cadastra uma nova cidade.  
Exemplo de JSON:

```json
{
  "nome": "São Paulo",
  "estado": "SP"
}
```

**PUT /cidades/{id}**  
Atualiza uma cidade existente.  
Exemplo de JSON (mesmo formato do POST).

### Funcionários

**GET /funcionarios**  
Lista todos os funcionários.

**GET /funcionarios/{id}**  
Busca um funcionário por ID.

**POST /funcionarios**  
Cadastra um novo funcionário.  
Exemplo de JSON:

```json
{
  "nome": "João Silva"
}
```

**PUT /funcionarios/{id}**  
Atualiza um funcionário existente.  
Exemplo de JSON (mesmo formato do POST).

### Sensores

**GET /sensores**  
Lista todos os sensores.

**GET /sensores/{id}**  
Busca um sensor por ID.

**POST /sensores**  
Cadastra um novo sensor.  
Exemplo de JSON:

```json
{
  "tipo": "Temperatura"
}
```

**PUT /sensores/{id}**  
Atualiza um sensor existente.  
Exemplo de JSON (mesmo formato do POST).

### Equipamentos

**GET /equipamentos**  
Lista todos os equipamentos.

**GET /equipamentos/{id}**  
Busca um equipamento por ID.

**POST /equipamentos**  
Cadastra um novo equipamento.  
Exemplo de JSON:

```json
{
  "nome": "Caminhão de Bombeiros"
}
```

**PUT /equipamentos/{id}**  
Atualiza um equipamento existente.  
Exemplo de JSON (mesmo formato do POST).

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

| Nome                           | RM       | GitHub                                             |
| ------------------------------ | -------- | -------------------------------------------------- |
| Murilo Ribeiro Santos          | RM555109 | [@murilors27](https://github.com/murilors27)       |
| Thiago Garcia Tonato           | RM99404  | [@thiago-tonato](https://github.com/thiago-tonato) |
| Ian Madeira Gonçalves da Silva | RM555502 | [@IanMadeira](https://github.com/IanMadeira)       |

**Curso**: Análise e Desenvolvimento de Sistemas  
**Instituição**: FIAP – Faculdade de Informática e Administração Paulista
