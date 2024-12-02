package web.saborgourmet.services;

import org.springframework.stereotype.Service; // Importamos la anotación Service de Spring
import web.saborgourmet.models.Cliente; // Importamos la entidad Cliente
import web.saborgourmet.repositories.ClienteRepository; // Importamos el repositorio de Cliente

import java.util.List; // Importamos la clase List
import java.util.Optional; // Importamos la clase Optional

// Anotamos la clase con @Service para que sea reconocida como un servicio en Spring
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository; // Declaramos una dependencia al repositorio de Cliente

    // Constructor que recibe el repositorio de Cliente, utilizado para la inyección de dependencias
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Método para crear o actualizar un cliente
    public Cliente saveOrUpdateCliente(Cliente cliente) {
        return clienteRepository.save(cliente); // Llama al método save() de JpaRepository para guardar o actualizar
    }

    // Método para obtener todos los clientes
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll(); // Llama al método findAll() para obtener todos los clientes
    }

    // Método para obtener un cliente por su ID
    public Optional<Cliente> getClienteById(Long id) {
        return clienteRepository.findById(id); // Llama al método findById() para obtener un cliente por su ID
    }

    // Método para eliminar un cliente por su ID
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id); // Llama al método deleteById() para eliminar un cliente por su ID
    }
}
