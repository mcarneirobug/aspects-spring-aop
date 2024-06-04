package br.com.matheus.aspects_spring_aop;

import br.com.matheus.aspects_spring_aop.dummy.DummyService;
import br.com.matheus.aspects_spring_aop.hello.HelloService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AspectsSpringAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AspectsSpringAopApplication.class, args);
	}

	@Bean
	ApplicationRunner runner(DummyService ds, HelloService hs) {
		return args -> {
			hs.hello();
			ds.dummy();
		};
	}

}
