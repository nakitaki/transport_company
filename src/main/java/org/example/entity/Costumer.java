package org.example.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "costumer")
public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "costumer")
    private Set<Transport> transports;

}
