package com.financialProject.Controller;


import com.financialProject.Dao.UsuarioDao;
import com.financialProject.Model.Usuario;
import com.financialProject.Service.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = {"/user"})
public class UserController {

    @Autowired
    UserService us;

    @Autowired
    PasswordEncoder pass;

    @GetMapping("")
    public String pageUser(Model model, Authentication auth){

        Usuario u = new Usuario();

        model.addAttribute("usuario",u);

        return "CadastroUsuario";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute Usuario usuario,
                           Model model,Authentication auth){


        String senha= usuario.getSenha();
        usuario.setSenha(pass.encode(senha));
        usuario.setRole("Normal");

        us.saveUser(usuario);

        return "redirect:/Login";

    }

}
