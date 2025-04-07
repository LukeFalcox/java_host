# Etapa 1: Usar a imagem oficial do OpenJDK para construir o projeto
FROM maven:3.8.6-openjdk-21 AS build

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo pom.xml e baixe as dependências (para otimizar o cache do Docker)
COPY pom.xml .

# Copie o código-fonte do projeto para o contêiner
COPY src ./src

# Compile o projeto
RUN mvn clean package -DskipTests

# Etapa 2: Criar a imagem final com o JDK
FROM openjdk:21-jdk-slim

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo JAR gerado na etapa de construção
COPY --from=build /app/target/*.jar app.jar

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# Exponha a porta onde sua aplicação Spring Boot estará rodando
EXPOSE 8080
