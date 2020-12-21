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
public class Horario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id_horario;
    @Basic
    @Temporal(TemporalType.TIME)
    Date horario_inicio;
    @Temporal(TemporalType.TIME)
    Date horario_fin;

    public Horario() {
    }

    public Horario(int id_horario, Date horario_inicio, Date horario_fin) {
        this.id_horario = id_horario;
        this.horario_inicio = horario_inicio;
        this.horario_fin = horario_fin;
    }

    public int getId_horario() {
        return id_horario;
    }

    public Date getHorario_inicio() {
        return horario_inicio;
    }

    public Date getHorario_fin() {
        return horario_fin;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    public void setHorario_inicio(Date horario_inicio) {
        this.horario_inicio = horario_inicio;
    }

    public void setHorario_fin(Date horario_fin) {
        this.horario_fin = horario_fin;
    }
    
}
