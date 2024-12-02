package web.saborgourmet.services;

import org.springframework.stereotype.Service; // Importamos la anotación Service de Spring
import web.saborgourmet.models.Mesa; // Importamos la entidad Mesa
import web.saborgourmet.repositories.MesaRepository; // Importamos el repositorio de Mesa

import java.util.List; // Importamos la clase List
import java.util.Optional; // Importamos la clase Optional

// Anotamos la clase con @Service para que sea reconocida como un servicio en Spring
@Service
public class MesaService {

    private final MesaRepository mesaRepository; // Declaramos una dependencia al repositorio de Mesa

    // Constructor que recibe el repositorio de Mesa, utilizado para la inyección de dependencias
    public MesaService(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }

    // Método para crear o actualizar una mesa
    public Mesa saveOrUpdateMesa(Mesa mesa) {
        return mesaRepository.save(mesa); // Llama al método save() de JpaRepository para guardar o actualizar
    }

    // Método para obtener todas las mesas
    public List<Mesa> getAllMesas() {
        return mesaRepository.findAll(); // Llama al método findAll() para obtener todas las mesas
    }

    // Método para obtener una mesa por su ID
    public Optional<Mesa> getMesaById(Long id) {
        return mesaRepository.findById(id); // Llama al método findById() para obtener una mesa por su ID
    }

    // Método para eliminar una mesa por su ID
    public void deleteMesa(Long id) {
        mesaRepository.deleteById(id); // Llama al método deleteById() para eliminar una mesa por su ID
    }
}
