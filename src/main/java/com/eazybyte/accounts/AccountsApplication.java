package com.eazybyte.accounts;

import com.eazybyte.accounts.DTO.AccountContactDTO;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableConfigurationProperties(value = AccountContactDTO.class)
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info= @Info(
				title = "Asim's Employee API",
				description = "Employee's CRUD operation",
				summary = "Performing Employee CRUD operation using SpringBoot and Swagger",
				contact = @Contact(
						name = "Asimo",
						url = "www.asimo.com",
						email = "asim@gmail.com"
				),
				license = @License(
						name = "X132123"
				),
				version = "api"


		), //servers dropdown
		servers = {
				@Server(
						description = "Dev",
						url = "http://localhost:8080"
				),
				@Server(
						description = "Test",
						url = "http://localhost:8080"
				)
		}
)
public class  AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
