# Documentação da API com Swagger

## Descrição

O Swagger ou OpenAPI é um framework que facilita a documentação e o entendimento de APIs REST.  
Ele fornece uma interface amigável e detalhada, permitindo que desenvolvedores e usuários interajam diretamente com os endpoints da API de maneira intuitiva.  
Com o Swagger, os consumidores da API conseguem saber quais parâmetros as operações da API recebem, qual será o retorno esperado, modelo, formato e exemplo.  
A documentação gerada pelo Swagger serve como um guia para entender os recursos disponíveis, como fazer requisições e qual será a resposta de cada uma delas.  
Em suma, o Swagger visa padronizar esse tipo de integração, descrevendo os recursos que uma API deve possuir, como endpoints, dados recebidos, dados retornados, códigos HTTP e métodos de autenticação, entre outros.

## Dependências

No `pom.xml` foram adicionadas duas dependências:

```xml
<dependency>
   <groupId>io.springfox</groupId>
   <artifactId>springfox-swagger2</artifactId>
   <version>2.9.2</version>
</dependency>

<dependency>
   <groupId>io.springfox</groupId>
   <artifactId>springfox-swagger-ui</artifactId>
   <version>2.9.2</version>
</dependency>

Como funciona?
1. Integração com o Swagger
A ativação e habilitação do Swagger na aplicação são feitas pela anotação @EnableSwagger2 na classe de configuração, como a classe SwaggerConfig. Essa anotação permite que o Swagger seja ativado no contexto do Spring Boot.
Em seguida, a documentação da API é gerada automaticamente pela configuração com o Docket, que é baseado nos controladores e endpoints da aplicação. A documentação é disponibilizada em um formato visual e interativo através de uma interface web, como o Swagger UI, que permite explorar e testar os endpoints diretamente.

2. Roteiro de Acesso à Documentação
A documentação do Swagger pode ser acessada diretamente pelo navegador no seguinte endereço:

http://localhost:8080/swagger-ui.html

A partir daí, a classe ProdutoResource (que é o controller) é mapeada e você pode ver todos os endpoints disponíveis, parâmetros necessários, exemplos de requisição e resposta, e até mesmo testar as chamadas da API diretamente na interface.

3. Configuração do Swagger
A configuração do Swagger foi realizada de maneira simples. Foi criada uma classe de configuração (SwaggerConfig) que define todos os detalhes da API, como:

Informações gerais: Nome, versão e descrição da API.
Endpoints: Detalhes de todos os métodos HTTP (GET, POST, PUT, DELETE, etc.), com parâmetros, status codes e descrições.
Modelos de dados: Definição de objetos usados nas requisições e respostas.
Exemplo de configuração:

java
private ApiInfo apiInfo() {
  return new ApiInfoBuilder().title("Curso Swagger JDEV Treinamento")
                             .description("Api e Doc do Curso do Dalmo Facuri")
                             .version("0.0.1")
                             .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                             .license("Apache License")
                             .contact(new Contact("Dalmo Facuri", "http://xx.com.br", "xxx@.com.br"))
                             .build();
}
4. Benefícios do Swagger na API
Documentação interativa: Facilita a compreensão de como a API funciona, com exemplos claros e interação direta.
Facilidade de testes: Com a interface do Swagger, é possível testar as APIs diretamente sem a necessidade de usar ferramentas externas, como o Postman.
Padronização: Ele padroniza a documentação, facilitando a colaboração entre equipes e o consumo da API por outras pessoas.

Como testar os endpoints?
A documentação interativa do Swagger permite que você faça requisições diretamente da interface web.
Para testar um endpoint:

1. Acesse a interface do Swagger em http://localhost:8080/swagger-ui.html
2. Navegue até o endpoint desejado.
3. Clique no botão "Try it out".
4. Preencha os parâmetros necessários e clique em "Execute".
5. Veja a resposta da API diretamente na interface.

Contribuições

Caso queira contribuir para o projeto, fique à vontade para melhorias na documentação ou na API.

