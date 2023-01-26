package com.example.integerationwithtwodatabases.modelsql;

//import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Data
@Entity
@Table(name="studenttable")
public class modelsql {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="studentid")
    private int studentid;
    @Column(name="name")
    private String name;
    @Column(name="lastname")
    private String lastname;

}
