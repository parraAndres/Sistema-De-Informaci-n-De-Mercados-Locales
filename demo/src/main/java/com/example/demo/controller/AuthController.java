package com.example.demo.controller;

import com.example.demo.model.Usuario; // Import Usuario
import com.example.demo.service.UsuarioService; // Import UsuarioService
import org.springframework.beans.factory.annotation.Autowired; // For dependency injection
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // For passing data to the view
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute; // For form binding
import org.springframework.web.bind.annotation.PostMapping; // For handling POST requests

@Controller
public class AuthController {

    @Autowired // Inject UsuarioService
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/registro")
    public String showRegistrationForm(Model model) {
        model.addAttribute("usuario", new Usuario()); // Add a new empty Usuario object to the model
        return "registro";
    }

    @PostMapping("/registro")
    public String registerUser(@ModelAttribute("usuario") Usuario usuario, Model model) {
        try {
            // Check if user already exists
            if (usuarioService.findByEmail(usuario.getEmail()) != null) {
                model.addAttribute("error", "El email ya está registrado");
                return "registro";
            }
            usuarioService.save(usuario); // Save the new user using the service
            return "redirect:/login?registered"; // Redirect to login page with a success parameter
        } catch (Exception e) {
            model.addAttribute("error", "Error al registrar el usuario: " + e.getMessage());
            return "registro";
        }
    }
}
