package org.zerock.b01.config;

import jdk.jshell.SourceCodeAnalysis;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

//    @Bean
//    public Docket api(){
//        return new Docket(DocumentationType.OAS_30)
//                .useDefaultResponseMessage(false)
//                .select()
//                .apis(RequestHandlerSelector.basePackage("org.zerock.b01.controller"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(apiInfo());
//    }
//
//    private ApiInfo apiInfo{
//        return new ApiInfoBuider()
//                .title("Boot 01 Project Swagger")
//                .build();
//    }


    @Bean
    public GroupedOpenApi restApi() {

        return GroupedOpenApi.builder()
                .pathsToMatch("/api/**")
                .group("REST API")
                .build();

    }

    @Bean
    public GroupedOpenApi commonApi() {

        return GroupedOpenApi.builder()
                .pathsToMatch("/**/*")
                .pathsToExclude("/api/**/*")
                .group("Common API")
                .build();

    }

}
