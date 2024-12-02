package web.saborgourmet.models;

import jakarta.persistence.*;
import java.util.List;

@Entity // Anotación que indica que esta clase es una entidad JPA
@Table(name = "mesas") // Define el nombre de la tabla en la base de datos
public class Mesa {
    
    @Id // Anotación que indica que este campo es la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Especifica que el valor de la clave primaria se genera automáticamente en la base de datos
    private Long id; // Identificador único de la mesa
    
    private String numeroMesa; // Número o identificador de la mesa
    private int capacidad; // Capacidad de personas que puede atender la mesa
    
    // Utilizamos is para la propiedad booleana
    private boolean disponible; // Indica si la mesa está disponible para ser reservada

    // Relación uno a muchos con la entidad Reserva
    @OneToMany(mappedBy = "mesa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas; // Lista de reservas asociadas a la mesa

    // Constructor vacío 
    public Mesa() {}

    // Constructor con parámetros
    public Mesa(String numeroMesa, int capacidad, boolean disponible) {
        this.numeroMesa = numeroMesa;
        this.capacidad = capacidad;
        this.disponible = disponible;
    }

    // Getters y Setters 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(String numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
