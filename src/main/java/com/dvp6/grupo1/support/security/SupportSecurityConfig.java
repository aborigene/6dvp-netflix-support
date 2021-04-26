/*
  Autor: Guilherme Rubio
  e-mail: guilherme.rubio@outlook.com.br
  Data: 13/04/2021
*/

package com.dvp6.grupo1.support.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/*
  Classe responsável pela configuração do Spring Security.
*/
@EnableWebSecurity
public class SupportSecurityConfig extends WebSecurityConfigurerAdapter {

  /*
   * Método responsável por deixar a documentação anomina.
   */
  @Override
  public void configure(WebSecurity http) throws Exception {
    http.ignoring().antMatchers("/swagger-support");
  }

  /*
   * Método responsável filtar as permissões para as rotas com base no token jwt.
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable();
    http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class).authorizeRequests()
        .antMatchers("/getAllTickets").authenticated().antMatchers("/getTicketsByUser").authenticated()
        .antMatchers("/getTicketsByStatus").authenticated();

  }
}
