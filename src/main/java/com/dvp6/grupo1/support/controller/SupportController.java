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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*
  Classe responsável por expor as APIs.
*/
@RestController
public class SupportController {

    /*
      Instancia a classe do repositório do JPA.  
    */
    @Autowired
    private SupportRepository supportRepository;


    /*
      Criando a rota /openTicket com o verbo POST.
      Responsável por abertura de um novo chamado.
    */
    @PostMapping("/openTicket")
    public ResponseEntity<String> openTicket(@RequestBody SupportEntity supportEntity) {
        supportRepository.save(supportEntity);
        return new ResponseEntity<>("Ticket aberto com sucesso!", HttpStatus.OK);
    }

    /*
      Criando a rota /getAllTickets com o verbo GET.
      Retorna a lista com todos os chamados.
    */
    @GetMapping("/getAllTickets")
    public Iterable<SupportEntity> getAllTickets() {
        return supportRepository.findAll();
    }

    /*
      Criando a rota /getTicketsByUser com o verbo GET.
      Retorna a lista com todos os chamados por usuário.
    */
    @GetMapping("/getTicketsByUser")
    @ResponseBody
    public Iterable<SupportEntity> getTicketsByUser(@RequestParam String username) {
        return supportRepository.findByUsername(username);
    }

    /*
      Criando a rota /getTicketsByStatus com o verbo GET.
      Retorna a lista com todos os chamados por status.
    */
    @GetMapping("/getTicketsByStatus")
    @ResponseBody
    public Iterable<SupportEntity> getTicketsByStatus(@RequestParam String status) {
        return supportRepository.findByStatus(status);
    }

}
