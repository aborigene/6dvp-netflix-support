/*
  Autor: Guilherme Rubio
  e-mail: guilherme.rubio@outlook.com.br
  Data: 14/04/2021
*/

package com.dvp6.grupo1.support.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
  Classe responsável por criar uma entidade vinculada com o banco de dados.
*/
@Entity
@Table(name = "support")
public class SupportEntity {

    /*
      Vinculando a variaveis as colunas do banco de dados.
    */    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "subject")
    private String subject;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;


    /*
      Método construtor da classe.
    */
    public SupportEntity() {
    }

    public SupportEntity(String username, String subject, String description, String status) {
        this.username = username;
        this.subject = subject;
        this.description = description;
        this.status = status;
    }

    /*
      Métodos Getters e Setters.
    */    
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
