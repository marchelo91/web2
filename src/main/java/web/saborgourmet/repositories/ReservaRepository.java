package web.saborgourmet.repositories;

import org.springframework.data.jpa.repository.JpaRepository; // Importamos la interfaz JpaRepository de Spring Data JPA
import web.saborgourmet.models.Reserva; // Importamos la entidad Reserva

// La interfaz ReservaRepository extiende JpaRepository para proporcionar operaciones CRUD automáticamente
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    // JpaRepository ya proporciona los métodos básicos como save(), findById(), delete(), etc.
   
}
