package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Entrada implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id_entrada;
    @Basic
    @Temporal(TemporalType.DATE)
    Date fecha;
    @Temporal(TemporalType.TIME)
    Date hora;

    public Entrada() {
    }

    public Entrada(int id_entrada, Date fecha, Date hora) {
        this.id_entrada = id_entrada;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getId_entrada() {
        return id_entrada;
    }

    public Date getFecha() {
        return fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setId_entrada(int id_entrada) {
        this.id_entrada = id_entrada;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

}
