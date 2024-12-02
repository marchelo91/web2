package web.saborgourmet.models;

import jakarta.persistence.*;
import java.util.List;

@Entity // Anotación que indica que esta clase es una entidad JPA
@Table(name = "clientes") // Define el nombre de la tabla en la base de datos
public class Cliente {
    
    @Id // Anotación que indica que este campo es la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Especifica que el valor de la clave primaria se genera automáticamente en la base de datos
    private Long id; // Identificador único del cliente

    private String nombre; // Nombre del cliente
    private String apellido; // Apellido del cliente
    private String email; // Correo electrónico del cliente
    private String telefono; // Número de teléfono del cliente

    // Relación uno a muchos con la entidad Reserva
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas; // Lista de reservas asociadas al cliente

    // Constructor vacío 
    public Cliente() {}

    // Constructor con parámetros
    public Cliente(String nombre, String apellido, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    // Getters y Setters 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
