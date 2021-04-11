package com.dvp6.grupo1.support.controller;

import com.dvp6.grupo1.support.model.SupportEntity;
import com.dvp6.grupo1.support.model.SupportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupportController {

    @Autowired
    private SupportRepository supportRepository;

    @PostMapping("/openTicket")
    public ResponseEntity<String> openTicket(@RequestBody SupportEntity supportEntity) {
        supportRepository.save(supportEntity);
        return new ResponseEntity<>("Ticket aberto com sucesso!", HttpStatus.OK);
    }

    @GetMapping("/getAllTickets")
    public Iterable<SupportEntity> getAllTickets() {
        return supportRepository.findAll();
    }

}
