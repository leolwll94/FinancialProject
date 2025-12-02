package com.financialProject.Dao;

import com.financialProject.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioDao extends JpaRepository<Usuario,Integer> {

    public Usuario findByLoginAndSenha(String login, String senha);


    Usuario findByLogin(String username);
}
