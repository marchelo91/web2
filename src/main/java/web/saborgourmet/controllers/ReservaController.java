package web.saborgourmet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.saborgourmet.models.Reserva;
import web.saborgourmet.services.ReservaService;

import java.util.List;
import java.util.Optional;

@Controller // Anotación que indica que esta clase es un controlador de Spring MVC
@RequestMapping("/reservas") // Define la URL base para todas las rutas en este controlador
public class ReservaController {

    @Autowired // Inyección automática del servicio ReservaService
    private ReservaService reservaService;

    // Método para listar todas las reservas
    @GetMapping("/listar")
    public String listarReservas(Model model) {
        // Obtiene todas las reservas desde el servicio
        List<Reserva> reservas = reservaService.getAllReservas();
        // Añade la lista de reservas al modelo para que sea accesible en la vista
        model.addAttribute("reservas", reservas);
        // Retorna la vista 'reservas-listar' para mostrar las reservas
        return "reservas-listar";
    }

    // Método para obtener los detalles de una reserva específica
    @GetMapping("/detalle/{id}")
    public String obtenerReserva(@PathVariable Long id, Model model) {
        // Busca la reserva por su ID
        Optional<Reserva> reserva = reservaService.getReservaById(id);
        // Si la reserva existe, la añade al modelo y muestra la vista de detalles
        if (reserva.isPresent()) {
            model.addAttribute("reserva", reserva.get());
            return "reservas-detalle";
        } else {
            // Si no se encuentra la reserva, redirige a la lista de reservas
            return "redirect:/reservas/listar";
        }
    }

    // Método para mostrar el formulario de creación de una nueva reserva
    @GetMapping("/crear")
    public String crearReservaForm(Model model) {
        // Crea una nueva instancia de la clase Reserva y la añade al modelo
        model.addAttribute("reserva", new Reserva());
        // Retorna la vista 'reservas-crear' para mostrar el formulario de creación
        return "reservas-crear";
    }

    // Método para guardar una nueva reserva
    @PostMapping("/guardar")
    public String guardarReserva(@ModelAttribute Reserva reserva) {
        // Guarda o actualiza la reserva utilizando el servicio
        reservaService.saveOrUpdateReserva(reserva);
        // Redirige a la lista de reservas después de guardar
        return "redirect:/reservas/listar";
    }

    // Método para mostrar el formulario de edición de una reserva existente
    @GetMapping("/editar/{id}")
    public String editarReserva(@PathVariable Long id, Model model) {
        // Busca la reserva por su ID
        Optional<Reserva> reserva = reservaService.getReservaById(id);
        // Si la reserva existe, la añade al modelo y muestra la vista de edición
        if (reserva.isPresent()) {
            model.addAttribute("reserva", reserva.get());
            return "reservas-editar";
        } else {
            // Si no se encuentra la reserva, redirige a la lista de reservas
            return "redirect:/reservas/listar";
        }
    }

    // Método para actualizar una reserva después de editarla
    @PostMapping("/actualizar")
    public String actualizarReserva(@ModelAttribute Reserva reserva) {
        // Guarda o actualiza la reserva utilizando el servicio
        reservaService.saveOrUpdateReserva(reserva);
        // Redirige a la lista de reservas después de la actualización
        return "redirect:/reservas/listar";
    }

    // Método para eliminar una reserva
    @GetMapping("/eliminar/{id}")
    public String eliminarReserva(@PathVariable Long id) {
        // Elimina la reserva utilizando el servicio
        reservaService.deleteReserva(id);
        // Redirige a la lista de reservas después de la eliminación
        return "redirect:/reservas/listar";
    }
}
