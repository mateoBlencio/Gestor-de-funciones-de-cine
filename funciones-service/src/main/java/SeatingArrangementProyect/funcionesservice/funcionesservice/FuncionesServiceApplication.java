package SeatingArrangementProyect.funcionesservice.funcionesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FuncionesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuncionesServiceApplication.class, args);
	}

}
