/*
  Autor: Guilherme Rubio
  e-mail: guilherme.rubio@outlook.com.br
  Data: 13/04/2021
*/

package com.dvp6.grupo1.support.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
  Classe repositório do Spring Data JPA.
*/
@Repository
public interface SupportRepository extends JpaRepository<SupportEntity, Long> {

    /*
      Objeto responsável por armazenar todos os registros por usuário.
    */ 
    List<SupportEntity> findByUsername (String username);

    /*
      Objeto responsável por armazenar todos os registros por status.
    */ 
    List<SupportEntity> findByStatus (String status);

}
