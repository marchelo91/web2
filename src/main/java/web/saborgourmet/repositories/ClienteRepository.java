package web.saborgourmet.repositories;

import org.springframework.data.jpa.repository.JpaRepository; // Importamos la interfaz JpaRepository de Spring Data JPA
import web.saborgourmet.models.Cliente; // Importamos la entidad Cliente

// La interfaz ClienteRepository extiende JpaRepository para obtener las funcionalidades CRUD automáticamente
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // JpaRepository ya proporciona los métodos básicos como save(), findById(), delete(), etc.
   
}
