/*
  Autor: Guilherme Rubio
  e-mail: guilherme.rubio@outlook.com.br
  Data: 13/04/2021
*/

package com.dvp6.grupo1.support;

import com.dvp6.grupo1.support.model.SupportEntity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/*
  Classe Main do projeto.
*/
@ComponentScan(basePackages = "com.dvp6.grupo1.support.*")
@SpringBootApplication()
public class SupportApplication {

  public static void main(String[] args) {
    SpringApplication.run(SupportApplication.class, args);
  }

  /*
    Inicializa o entity manager junto com o microserviço.
  */
  @Bean
	public SupportEntity supportEntity() {
		return new SupportEntity();
	}

}
