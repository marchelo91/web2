package web.saborgourmet.services;

import org.springframework.stereotype.Service; // Importamos la anotación Service de Spring
import web.saborgourmet.models.Reserva; // Importamos la entidad Reserva
import web.saborgourmet.repositories.ReservaRepository; // Importamos el repositorio de Reserva

import java.util.List; // Importamos la clase List
import java.util.Optional; // Importamos la clase Optional

// Anotamos la clase con @Service para que sea reconocida como un servicio en Spring
@Service
public class ReservaService {

    private final ReservaRepository reservaRepository; // Declaramos una dependencia al repositorio de Reserva

    // Constructor que recibe el repositorio de Reserva, utilizado para la inyección de dependencias
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    // Método para crear o actualizar una reserva
    public Reserva saveOrUpdateReserva(Reserva reserva) {
        return reservaRepository.save(reserva); // Llama al método save() de JpaRepository para guardar o actualizar
    }

    // Método para obtener todas las reservas
    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll(); // Llama al método findAll() para obtener todas las reservas
    }

    // Método para obtener una reserva por su ID
    public Optional<Reserva> getReservaById(Long id) {
        return reservaRepository.findById(id); // Llama al método findById() para obtener una reserva por su ID
    }

    // Método para eliminar una reserva por su ID
    public void deleteReserva(Long id) {
        reservaRepository.deleteById(id); // Llama al método deleteById() para eliminar una reserva por su ID
    }
}
