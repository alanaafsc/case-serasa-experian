# case-serasa-experian
Desafio Desenvolvedor Fullstack do Serasa Experian

## Projeto Front-end (React)

### Iniciar o Projeto

O projeto foi executado localmente utilizando o Node.js versão 16.

Para acessar o diretório do projeto:

```shell
cd projeto-blog-pessoal
```

Instale todos os pacotes npm:

```shell
npm install
```

Para executar o projeto:

```shell
npm start
```

Isso iniciará o projeto em modo de desenvolvimento e estará disponível em [http://localhost:3000](http://localhost:3000).

### Testes

Para executar os testes disponíveis no projeto:

```shell
npm test
```

### Construir para Produção

Para construir o aplicativo para produção:

```shell
npm build
```

Este comando compila o aplicativo para produção na pasta build. Ele combina corretamente o React no modo de produção e otimiza a compilação para obter o melhor desempenho. A compilação é minificada e os nomes dos arquivos incluem hashes.

## Projeto Back-end (Quarkus)

### Iniciar o Projeto

Para executar a aplicação em modo de desenvolvimento:

```shell
./mvnw compile quarkus:dev
```

O projeto será iniciado no endereço [http://localhost:8080](http://localhost:8080). Além disso, o Swagger UI estará disponível em [http://localhost:8080/api-docs/](http://localhost:8080/api-docs/), onde você poderá visualizar e testar os endpoints.

### Empacotamento e Execução

A aplicação pode ser empacotada usando:

```shell
./mvnw package
```

Isso produz o arquivo `quarkus-run.jar` no diretório `target/quarkus-app/`. A aplicação pode ser executada usando `java -jar target/quarkus-app/quarkus-run.jar`.

Caso precise executar os testes para verificar a cobertura, execute o comando `test` ou `verify` do Maven como nos exemplos abaixo:

```shell
.\mvnw clean test
```

```shell
.\mvnw clean verify
```

Se os testes executarem com sucesso, o resultado da cobertura estará localizado em `/target/site/jacoco/index.html`.

## Banco de Dados

Para executar o banco de dados, foi utilizado o Docker com o seguinte comando:

```
docker run -d \     
    --name meu-postgres \
    -p 5432:5432 \
    -e POSTGRES_USER=username_blog \
    -e POSTGRES_PASSWORD=password \
    -e POSTGRES_DB=articles \
    postgres:latest
```

Este comando inicia um contêiner do PostgreSQL usando a imagem mais recente disponível. Aqui está o que cada opção faz:

-d: Executa o contêiner em segundo plano (modo detached).
--name meu-postgres: Define o nome do contêiner como "meu-postgres".
-p 5432:5432: Mapeia a porta 5432 do host para a porta 5432 do contêiner, permitindo acessar o PostgreSQL do host.
-e POSTGRES_USER=username_blog: Define o nome de usuário como "username_blog".
-e POSTGRES_PASSWORD=password: Define a senha do usuário como "password".
-e POSTGRES_DB=articles: Cria um banco de dados chamado "articles" ao iniciar o contêiner.
Com este comando, o PostgreSQL será iniciado e estará pronto para ser utilizado.