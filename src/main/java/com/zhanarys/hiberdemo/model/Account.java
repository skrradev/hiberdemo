package com.zhanarys.hiberdemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author zh.turemuratov on 1/17/20
 */

@Entity
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String accountNumber;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

}
