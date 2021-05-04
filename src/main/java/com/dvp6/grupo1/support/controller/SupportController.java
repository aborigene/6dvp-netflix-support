/*
  Autor: Guilherme Rubio
  e-mail: guilherme.rubio@outlook.com.br
  Data: 14/04/2021
*/

package com.dvp6.grupo1.support.controller;

import com.dvp6.grupo1.support.model.SupportEntity;
import com.dvp6.grupo1.support.model.SupportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

/*
  Classe responsável por expor as APIs.
*/
@RestController
public class SupportController {

  /*
   * Instancia a classe do repositório do JPA.
   */
  @Autowired
  public SupportRepository supportRepository;

  /*
   * Criando a rota / com o verbo GET.
   */
  @GetMapping("/")
  public ResponseEntity<String> home() {
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /*
   * Criando a rota /getAllTickets com o verbo GET. Retorna a lista com todos os
   * chamados.
   */
  @GetMapping("/getAllTickets")
  public Iterable<SupportEntity> getAllTickets() {
    return supportRepository.findAll();
  }

  /*
   * Criando a rota /getTicketsByUser com o verbo GET. Retorna a lista com todos
   * os chamados por usuário.
   */
  @GetMapping("/getTicketsByUser")
  @ResponseBody
  public Iterable<SupportEntity> getTicketsByUser(@RequestBody String username) {
    return supportRepository.findByUsername(username);
  }

  /*
   * Criando a rota /getTicketsByStatus com o verbo GET. Retorna a lista com todos
   * os chamados por status.
   */
  @GetMapping("/getTicketsByStatus")
  @ResponseBody
  public Iterable<SupportEntity> getTicketsByStatus(@RequestBody String status) {
    return supportRepository.findByStatus(status);
  }

}
