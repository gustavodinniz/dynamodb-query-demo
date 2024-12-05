# DynamoDB Query Demo

## Contexto

O objetivo deste projeto é demonstrar como realizar consultas **Query** e **Scan** no DynamoDB, utilizando **índices secundários** para 
otimizar o custo e a eficiência das operações. A aplicação oferece exemplos práticos de como integrar essas consultas em um sistema real.

## Como Rodar

### Passo 1: Subir o LocalStack

Este projeto utiliza o LocalStack para simular um ambiente AWS local, permitindo executar o DynamoDB sem custos adicionais. 
Para subir o LocalStack, siga os seguintes passos:

- Navegue até o diretório onde o arquivo `docker-compose.yml` está localizado:

- Execute o comando para subir o LocalStack: `docker-compose up`

O LocalStack estará rodando localmente, simulando o serviço AWS do DynamoDB.

### Passo 2: Inserir um Registro no DynamoDB

O script para criar e inserir um registro no DynamoDB já está configurado. Após subir o LocalStack, o DynamoDB será inicializado 
automaticamente e o registro será inserido.

### Passo 3: Rodar a Aplicação

Agora, basta rodar a aplicação Spring Boot para testar os endpoints da API que interagem com o DynamoDB.

## Testando os Controllers

1. Utilize uma ferramenta como **Postman** ou **cURL** para testar os endpoints da aplicação.
2. API permite inserir e realizar consultas no DynamoDB utilizando os métodos **Query** e **Scan** com os parâmetros configurados.

## Tecnologias Utilizadas

- Spring Boot
- DynamoDB
- LocalStack
- Docker
- Docker Compose


