package com.financialProject.Service;


import com.financialProject.Configuration.ConfigSecurity;
import com.financialProject.Configuration.user.UserLogado;
import com.financialProject.Dao.UsuarioDao;
import com.financialProject.Model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UsuarioDao usuDao;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u = usuDao.findByLogin(username);

        if (u == null){
            throw new UsernameNotFoundException("Usuário não encontrado");
        }else if(u !=null){
            System.out.println(u.getNome());
        }
        return new UserLogado(u);
    }

    @Transactional
    public void saveUser(Usuario usu){

        usuDao.save(usu);
    }
}
