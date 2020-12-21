package Logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id_persona;
    @Basic
    String nombre;
    String apellido;
    
    @OneToMany
    List<Entrada> listaEntradas;

    public Persona() {
    }

    public Persona(int id_persona, String nombre, String apellido, List<Entrada> listaEntradas) {
        this.id_persona = id_persona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.listaEntradas = listaEntradas;
    }

    public void setListaEntradas(List<Entrada> listaEntradas) {
        this.listaEntradas = listaEntradas;
    }

    public List<Entrada> getListaEntradas() {
        return listaEntradas;
    }

    public int getId_persona() {
        return id_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
}
