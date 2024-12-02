package web.saborgourmet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.saborgourmet.models.Cliente;
import web.saborgourmet.services.ClienteService;

import java.util.List;
import java.util.Optional;

@Controller //  indica que esta clase es un controlador de Spring MVC
@RequestMapping("/clientes") // Define la URL base para todas las rutas en este controlador
public class ClienteController {

    @Autowired // Inyecta automáticamente una instancia de ClienteService en este controlador
    private ClienteService clienteService;

    // Mapea y muestra la lista de clientes
    @GetMapping("/listar")
    public String listarClientes(Model model) {
        // Obtiene todos los clientes mediante el servicio
        List<Cliente> clientes = clienteService.getAllClientes();
        // Agrega los clientes al modelo para poder acceder a ellos en la vista
        model.addAttribute("clientes", clientes);
        // Retorna la vista 'clientes-listar' para mostrar la lista
        return "clientes-listar";
    }

    // Mapeo para obtener detalles de un cliente específico
    @GetMapping("/detalle/{id}")
    public String obtenerCliente(@PathVariable Long id, Model model) {
        // Busca un cliente por su ID
        Optional<Cliente> cliente = clienteService.getClienteById(id);
        // Si el cliente existe, lo agrega al modelo y retorna la vista de detalle
        if (cliente.isPresent()) {
            model.addAttribute("cliente", cliente.get());
            return "clientes-detalle";
        } else {
            // Si no se encuentra el cliente, redirige a la lista de clientes
            return "redirect:/clientes/listar";
        }
    }

    // Mapeo para mostrar el formulario de creación de un nuevo cliente
    @GetMapping("/crear")
    public String crearClienteForm(Model model) {
        // Agrega un nuevo objeto Cliente al modelo para usarlo en el formulario
        model.addAttribute("cliente", new Cliente());
        // Retorna la vista 'clientes-crear' con el formulario vacío
        return "clientes-crear";
    }

    // Mapeo para guardar un nuevo cliente después de enviar el formulario
    @PostMapping("/guardar")
    public String guardarCliente(@ModelAttribute Cliente cliente) {
        // Guarda o actualiza el cliente utilizando el servicio
        clienteService.saveOrUpdateCliente(cliente);
        // Redirige a la lista de clientes después de guardar
        return "redirect:/clientes/listar";
    }

    // Mapeo para mostrar el formulario de edición de un cliente
    @GetMapping("/editar/{id}")
    public String editarCliente(@PathVariable Long id, Model model) {
        // Busca el cliente por su ID
        Optional<Cliente> cliente = clienteService.getClienteById(id);
        // Si el cliente existe, lo agrega al modelo y retorna la vista de edición
        if (cliente.isPresent()) {
            model.addAttribute("cliente", cliente.get());
            return "clientes-editar";
        } else {
            // Si no se encuentra el cliente, redirige a la lista de clientes
            return "redirect:/clientes/listar";
        }
    }

    // Mapeo para actualizar un cliente después de editarlo
    @PostMapping("/actualizar")
    public String actualizarCliente(@ModelAttribute Cliente cliente) {
        // Guarda o actualiza el cliente utilizando el servicio
        clienteService.saveOrUpdateCliente(cliente);
        // Redirige a la lista de clientes después de la actualización
        return "redirect:/clientes/listar";
    }

    // Mapeo para eliminar un cliente
    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        // Elimina el cliente por su ID utilizando el servicio
        clienteService.deleteCliente(id);
        // Redirige a la lista de clientes después de la eliminación
        return "redirect:/clientes/listar";
    }
}
