package com.example.openapigradel;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class swaggerConfig {

    @Bean
    // Docket. bean in a Spring Boot configuration to configure Swagger 2 for the application.
    // A Springfox. Docket. instance provides the primary API configuration with sensible defaults and convenience methods for configuration.
    public Docket postApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("open-api").apiInfo(apiInfo()).select().paths(postPaths()).build();
    }

    private Predicate<String> postPaths(){
        return or(regex("/api/posts.*"),regex("/api/demo.*"));
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("openApi").description("Open Api Desc").contact("contact")
                .license("shivaraj@gmail.com").licenseUrl("shivaraj@gmail.com").version("1.0.0").build();
    }

}
