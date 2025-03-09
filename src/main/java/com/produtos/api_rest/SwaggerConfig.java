package com.produtos.api_rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.collect.Lists;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 //Habilitação e configuração do Swagger
public class SwaggerConfig {
	
	@Bean
	public Docket apiDocSwagger() {
		
		return new Docket(DocumentationType.SWAGGER_2).select()
				                                   
				                                      //Especifica o pacote base onde as Classes de recursos (os endpoints da API) estão localizadas.
				                                       .apis(RequestHandlerSelectors.basePackage("com.produtos.api_rest.resources"))
				                                        
				                                       //Para identificar Classes que são anotadas com @RestController
				                                       //.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				                                      
				                                        //Métodos da Classe que são anotados com @GetMapping.
				                                       //.apis(RequestHandlerSelectors.withMethodAnnotation(GetMapping.class))
				                                       
				                                      //Métodos da Classe que são anotados com @DeleteMapping.
				                                      //.apis(RequestHandlerSelectors.withMethodAnnotation(DeleteMapping.class))
				                                       .paths(PathSelectors.any())
				                                        //.paths(PathSelectors.ant("/{id}"))
				                                      .build()
				                                      .useDefaultResponseMessages(false)
				                                       //Permite configurar respostas HTTP globais para todos os métodos(GET, POST, etc.) 
				                                      .globalResponseMessage(RequestMethod.GET, responseCodeHttp())
		                                              .apiInfo(apiInfo())
		                                               .securityContexts(securityContext())
		                                               //.securitySchemes(Lists.newArrayList(new ApiKey("JWT", "Authorization", "header")))
		                                              .securitySchemes(Lists.newArrayList(listApiKey()));
	}
	
	private List<ApiKey> listApiKey(){
		 List<ApiKey> apiKeys = new ArrayList<>();
		 apiKeys.add(new ApiKey("JWT", "Authorization", "header"));
		 return apiKeys;
	}
	
	//Os principais HTTP Error
	private List<ResponseMessage> responseCodeHttp(){
		List<ResponseMessage> list = new ArrayList<>();
		
		list.add(new ResponseMessageBuilder()
				            .code(500)
				            .message("Erro interno do servidor")
				            .responseModel(new ModelRef("Error"))
				            .build());
		
		list.add(new ResponseMessageBuilder()
	            .code(404)
	            .message("Conteúdo não encontrado")
	            .responseModel(new ModelRef("Error"))
	            .build());
		
		list.add(new ResponseMessageBuilder()
	            .code(401)
	            .message("Não autorizado")
	            .responseModel(new ModelRef("Error"))
	            .build());
		
		list.add(new ResponseMessageBuilder()
	            .code(403)
	            .message("Acesso negado")
	            .responseModel(new ModelRef("Error"))
	            .build());
		
		 
		return list;
		
	 }
	//Método que configura os dados para a interface do Swagger como título, versão, contatos etc.
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Curso Swagger JDEV Treinamento")
				                   .description("Api e Doc do Curso do Dalmo Facuri")
				                   .version("0.0.1")
				                   .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
				                   .license("Apache Lincense")
				                   .contact(new Contact("Dalmo Facuri", "http://jdevtreinamento.com.br", "mffacuri@terra.com.br"))
				                   .build();
	}
	  
	//Parte de segurança - JWT(Json Web Token)
	private List<SecurityContext> securityContext() {
		List<SecurityContext> list = new ArrayList<>();
		list.add(SecurityContext.builder().securityReferences(defaultAuth()).build());
	    return list;
	}
	
	 
	//Parte de segurança - JWT(Json Web Token)
	private List<SecurityReference> defaultAuth(){
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
		
	}
	  
	
	

}
