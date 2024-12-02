package web.saborgourmet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String mostrarHome(Model model) {
        model.addAttribute("titulo", "Bienvenido a Sabor Gourmet");
        return "index"; // Vista raíz de la aplicación
    }
}
