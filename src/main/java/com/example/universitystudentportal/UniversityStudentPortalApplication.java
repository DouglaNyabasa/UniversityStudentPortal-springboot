package com.example.universitystudentportal;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(title = "University Portal API", version = "1.0.0"),
		servers = @Server(url = "http://localhost:8080"),
		tags = {@Tag(name = "ALL ENDPOINTS",description = "This Tag consist of all Generic EndPoints")}
)
public class UniversityStudentPortalApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(UniversityStudentPortalApplication.class, args);
	}

}
