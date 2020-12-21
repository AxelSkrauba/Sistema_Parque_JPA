package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id_empleado;
    @Basic
    String dni;
    String nombre;
    String apellido;
    String cargo;

    @OneToOne(cascade = CascadeType.ALL)
    Usuario unUsuario;

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }

    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public Empleado() {
    }

    public Empleado(int id_empleado, String dni, String nombre, String apellido, String cargo, Usuario unUsuario) {
        this.id_empleado = id_empleado;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.unUsuario = unUsuario;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}
