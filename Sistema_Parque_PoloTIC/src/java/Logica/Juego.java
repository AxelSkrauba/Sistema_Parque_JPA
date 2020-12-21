package Logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Juego implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id_juego;
    @Basic
    String nombre;

    @OneToOne(cascade = CascadeType.ALL)
    Horario horario;

    @OneToMany
    List<Entrada> listaEntradas;

    @OneToMany
    List<Empleado> listaEmpleados;

    public Juego() {
    }

    public Juego(int id_juego, String nombre, Horario horario, List<Entrada> listaEntradas, List<Empleado> listaEmpleados) {
        this.id_juego = id_juego;
        this.nombre = nombre;
        this.horario = horario;
        this.listaEntradas = listaEntradas;
        this.listaEmpleados = listaEmpleados;
    }

    public int getId_juego() {
        return id_juego;
    }

    public String getNombre() {
        return nombre;
    }

    public Horario getHorario() {
        return horario;
    }

    public List<Entrada> getListaEntradas() {
        return listaEntradas;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setId_juego(int id_juego) {
        this.id_juego = id_juego;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public void setListaEntradas(List<Entrada> listaEntradas) {
        this.listaEntradas = listaEntradas;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    

}
