package no.alirizakeles.aijobmatcher.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("AI Job Matcher API")
                        .version("1.0.0")
                        .description("REST API for managing job postings and AI-powered job matching.")
                        .contact(new Contact()
                                .name("Ali Riza Keles")
                                .email("alirizakeles66@gmail.com")
                        )
                );
    }
}