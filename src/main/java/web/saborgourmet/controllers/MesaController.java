package web.saborgourmet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.saborgourmet.models.Mesa;
import web.saborgourmet.services.MesaService;

import java.util.List;
import java.util.Optional;

@Controller // Anotación que indica que esta clase es un controlador de Spring MVC
@RequestMapping("/mesas") // Define la URL base para todas las rutas en este controlador
public class MesaController {

    @Autowired // Inyección automática del servicio MesaService
    private MesaService mesaService;

    // Método para listar todas las mesas
    @GetMapping("/listar")
    public String listarMesas(Model model) {
        // Obtiene todas las mesas desde el servicio
        List<Mesa> mesas = mesaService.getAllMesas();
        // Añade la lista de mesas al modelo para que sea accesible en la vista
        model.addAttribute("mesas", mesas);
        // Retorna la vista 'mesas-listar' para mostrar las mesas
        return "mesas-listar";
    }

    // Método para obtener los detalles de una mesa específica
    @GetMapping("/detalle/{id}")
    public String obtenerMesa(@PathVariable Long id, Model model) {
        // Busca la mesa por su ID
        Optional<Mesa> mesa = mesaService.getMesaById(id);
        // Si la mesa existe, la añade al modelo y muestra la vista de detalles
        if (mesa.isPresent()) {
            model.addAttribute("mesa", mesa.get());
            return "mesas-detalle";
        } else {
            // Si no se encuentra la mesa, redirige a la lista de mesas
            return "redirect:/mesas/listar";
        }
    }

    // Método para mostrar el formulario de creación de una nueva mesa
    @GetMapping("/crear")
    public String crearMesaForm(Model model) {
        // Crea una nueva instancia de la clase Mesa y la añade al modelo
        model.addAttribute("mesa", new Mesa());
        // Retorna la vista 'mesas-crear' para mostrar el formulario de creación
        return "mesas-crear";
    }

    // Método para guardar una nueva mesa
    @PostMapping("/guardar")
    public String guardarMesa(@ModelAttribute Mesa mesa) {
        // Guarda o actualiza la mesa utilizando el servicio
        mesaService.saveOrUpdateMesa(mesa);
        // Redirige a la lista de mesas después de guardar
        return "redirect:/mesas/listar";
    }

    // Método para mostrar el formulario de edición de una mesa existente
    @GetMapping("/editar/{id}")
    public String editarMesa(@PathVariable Long id, Model model) {
        // Busca la mesa por su ID
        Optional<Mesa> mesa = mesaService.getMesaById(id);
        // Si la mesa existe, la añade al modelo y muestra la vista de edición
        if (mesa.isPresent()) {
            model.addAttribute("mesa", mesa.get());
            return "mesas-editar";
        } else {
            // Si no se encuentra la mesa, redirige a la lista de mesas
            return "redirect:/mesas/listar";
        }
    }

    // Método para actualizar una mesa después de editarla
    @PostMapping("/actualizar")
    public String actualizarMesa(@ModelAttribute Mesa mesa) {
        // Guarda o actualiza la mesa utilizando el servicio
        mesaService.saveOrUpdateMesa(mesa);
        // Redirige a la lista de mesas después de la actualización
        return "redirect:/mesas/listar";
    }

    // Método para eliminar una mesa
    @GetMapping("/eliminar/{id}")
    public String eliminarMesa(@PathVariable Long id) {
        // Elimina la mesa utilizando el servicio
        mesaService.deleteMesa(id);
        // Redirige a la lista de mesas después de la eliminación
        return "redirect:/mesas/listar";
    }
}
