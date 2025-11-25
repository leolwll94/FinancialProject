package com.financialProject.Controller;


import com.financialProject.Dao.UsuarioDao;
import com.financialProject.Model.Usuario;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = {"/Login","/"})
public class LoginController {

    @Autowired
    UsuarioDao ud;

    @GetMapping("")
    public String pageLogin(Model model, Authentication auth){

        Usuario u = new Usuario();

        model.addAttribute("usuario",u);
        return "Login";

    }


    @GetMapping("/userLogin")
    public String buscaUsuario(@RequestParam("login") String login, @RequestParam("senha") String senha,
                                Model model, Authentication auth){

        String retorno;

        Usuario u = ud.findByLoginAndSenha(login,senha);

        if (u != null) {
            model.addAttribute("usuario", u);
            return  "redirect:/home";
        }

        return "redirect:/Login?erro=true";
    }

}
