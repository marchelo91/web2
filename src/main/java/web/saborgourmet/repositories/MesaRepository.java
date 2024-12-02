package web.saborgourmet.repositories;

import org.springframework.data.jpa.repository.JpaRepository; // Importamos la interfaz JpaRepository de Spring Data JPA
import web.saborgourmet.models.Mesa; // Importamos la entidad Mesa

// La interfaz MesaRepository extiende JpaRepository para proporcionar operaciones CRUD automáticamente
public interface MesaRepository extends JpaRepository<Mesa, Long> {
    // JpaRepository ya proporciona los métodos básicos como save(), findById(), delete(), etc.
    
}
