package web.saborgourmet.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity // Anotación que indica que esta clase es una entidad JPA
@Table(name = "reservas") // Define el nombre de la tabla en la base de datos
public class Reserva {
    
    @Id // Anotación que indica que este campo es la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Especifica que el valor de la clave primaria se genera automáticamente en la base de datos
    private Long id; // Identificador único de la reserva
    
    private LocalDateTime fechaHora; // Fecha y hora de la reserva
    private int cantidadPersonas; // Número de personas para la reserva

    // Relación muchos a uno con la entidad Cliente (varias reservas pueden ser de un solo cliente)
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false) // Especifica la columna "cliente_id" en la base de datos
    private Cliente cliente; // El cliente asociado a la reserva

    // Relación muchos a uno con la entidad Mesa (varias reservas pueden corresponder a una sola mesa)
    @ManyToOne
    @JoinColumn(name = "mesa_id", nullable = false) // Especifica la columna "mesa_id" en la base de datos
    private Mesa mesa; // La mesa asociada a la reserva

    // Constructor vacío 
    public Reserva() {}

    // Constructor con parámetros
    public Reserva(LocalDateTime fechaHora, int cantidadPersonas, Cliente cliente, Mesa mesa) {
        this.fechaHora = fechaHora;
        this.cantidadPersonas = cantidadPersonas;
        this.cliente = cliente;
        this.mesa = mesa;
    }

    // Getters y Setters 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
}
