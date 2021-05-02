/*
  Autor: Guilherme Rubio
  e-mail: guilherme.rubio@outlook.com.br
  Data: 14/04/2021
*/

package com.dvp6.grupo1.support.broker;

import com.dvp6.grupo1.support.model.SupportEntity;
import com.dvp6.grupo1.support.model.SupportRepository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
  Classe responsável por consumir as filas no RabbitMQ.
*/
@Component
public class SupportBrokerConsumer {

    @Autowired
    private SupportRepository supportRepository;
    
    @Autowired
    private SupportEntity supportEntity;

    /*
      Método para ler a fila e salvas os dados no banco.
    */
    @RabbitListener(queues = SupportBrokerConfig.QUEUE)
    public void consumer(Message message) throws JsonMappingException, JsonProcessingException {
      try {
        ObjectMapper mapper = new ObjectMapper();        
        supportEntity = mapper.readValue(new String(message.getBody()), SupportEntity.class);
        supportEntity.setStatus("open");
        supportRepository.save(supportEntity);
      } catch (Exception e) {
        System.out.println("erro: " + e);
      }  
      
    }
}
