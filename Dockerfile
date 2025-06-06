# Estágio de build
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Estágio de runtime
FROM openjdk:17-slim
WORKDIR /app

# Cria um usuário não-root para segurança
RUN useradd -m -u 99404 appuser

# Define as variáveis de ambiente
ENV SPRING_PROFILES_ACTIVE=dev
ENV ORACLE_DB_HOST=oracle.db
ENV ORACLE_DB_PORT=1521
ENV ORACLE_DB_SERVICE=XEPDB1
ENV ORACLE_DB_PORT=1521
ENV ORACLE_DB_USERNAME=
ENV ORACLE_DB_PASSWORD=

# Copia o arquivo JAR do estágio de build
COPY --from=build /app/target/*.jar app.jar

# Define as permissões corretas para o usuário não-root
RUN chown -R appuser:appuser /app

# Muda para o usuário não-root
USER appuser

# Expõe a porta da aplicação
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"] 