package com.financialProject.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@DiscriminatorValue("U")

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 30,nullable = false)
    private String nome;
    @Column(length = 90,nullable = false)
    private String sobrenome;
    @Column(length = 30,nullable = false)
    private String email;
    @Column(length = 11,nullable = false)
    private String cpf;
    @Column(length = 30,nullable = false)
    private String login;
    @Column(length = 120,nullable = false)
    private String senha;
    @Column(length = 120,nullable = false)
    private String role;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;
    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimoAcesso;


}
