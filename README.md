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

O H2 é um banco de dados SQL de código aberto, escrito em Java, que foi utilizado no projeto Quarkus. Ele é conhecido por sua leveza, velocidade e facilidade de uso. Sendo relacional, armazena dados em tabelas relacionadas por chaves estrangeiras. Pode operar em modo de memória, útil para testes e prototipagem rápida, e pode ser incorporado diretamente em aplicativos Java, eliminando a necessidade de um servidor de banco de dados separado. Oferece suporte à maioria das características padrão do SQL e transações ACID (Atomicidade, Consistência, Isolamento e Durabilidade), garantindo a integridade e consistência dos dados. No Quarkus, é comumente utilizado em aplicações de teste e desenvolvimento, devido à sua facilidade de uso e configuração simples.

As configurações do H2 estão localizadas no arquivo application.properties do projeto Quarkus. Ao iniciar, o H2 automaticamente executa um script SQL presente no arquivo import.sql, permitindo uma inicialização rápida com dados pré-existentes ou de teste.