package com.financialProject;


import com.financialProject.Dao.UsuarioDao;
import com.financialProject.Model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@SpringBootApplication
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main implements ApplicationRunner {


    public static void main(String[] args) {
                SpringApplication.run(Main.class, args);
        }

        @Autowired
        UsuarioDao ud;


    @Override
    public void run(ApplicationArguments args) throws Exception {





        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate data = LocalDate.parse("1900-11-11", formatter);

        Date dataConvertida = Date.from(
                data.atStartOfDay(ZoneId.systemDefault()).toInstant()
        );
        Usuario u = new Usuario(0,
                "Teste",
                "Exemplo",
                "teste@Teste.com",
                "11111111111",
                "teste",
                "teste",
                "normal",
                dataConvertida,
                null);

        ud.save(u);


    }
}