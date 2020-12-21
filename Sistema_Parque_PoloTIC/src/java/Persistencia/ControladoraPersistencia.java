package Persistencia;

import Logica.Empleado;
import Logica.Entrada;
import Logica.Horario;
import Logica.Juego;
import Logica.Persona;
import Logica.Usuario;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {

    EmpleadoJpaController empleadoJPA = new EmpleadoJpaController();
    UsuarioJpaController usuarioJPA = new UsuarioJpaController();
    HorarioJpaController horarioJPA = new HorarioJpaController();
    JuegoJpaController juegoJPA = new JuegoJpaController();
    PersonaJpaController personaJPA = new PersonaJpaController();
    EntradaJpaController entradaJPA = new EntradaJpaController();

    //METODOS EMPLEADO
    public void crearEmpleado(Empleado empleado) {
        //Crea un empleado a partir del objeto del parámetro
        try {
            empleadoJPA.create(empleado);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarEmpleado(String id_empleado) {
        //Elimina el empleado con el ID dado
        try {
            empleadoJPA.destroy(Integer.parseInt(id_empleado));
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarEmpleado(Empleado empleado) {
        //Modifica el empleado dado como parámetro
        try {
            empleadoJPA.edit(empleado);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Empleado> traerEmpleados() {
        //Devuelve una lista con todos los empleados
        List<Empleado> listaEmpleados = empleadoJPA.findEmpleadoEntities();
        return listaEmpleados;
    }

    public Empleado traerEmpleadoEnParticular(String id_empleado) {
        //Devuelve el empleado correspondiente al ID dado
        Empleado empleado = empleadoJPA.findEmpleado(Integer.parseInt(id_empleado));
        return empleado;
    }

    //METODOS USUARIO
    public void crearUsuario(Usuario usuario) {
        usuarioJPA.create(usuario);
    }

    public List<Usuario> traerUsuarios() {
        //Devuelve una lista con todos los usuarios
        List<Usuario> listaUsuarios = usuarioJPA.findUsuarioEntities();
        return listaUsuarios;
    }
    
    public Usuario traerUsuarioEnParticular(String id_usuario) {
        //Devuelve el empleado correspondiente al ID dado
        Usuario usuario = usuarioJPA.findUsuario(Integer.parseInt(id_usuario));
        return usuario;
    }

    public void modificarUsuario(Usuario usuario) {
        //Modifica el usuario dado como parámetro
        try {
            usuarioJPA.edit(usuario);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //METODOS HORARIO
    public void crearHorario(Horario horario) {
        horarioJPA.create(horario);
    }
    
    public void modificarHorarios(Horario horario) {
        //Modifica el horario dado como parámetro
        try {
            horarioJPA.edit(horario);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //METODOS JUEGO
    public void crearJuego(Juego juego) {
        try {
            juegoJPA.create(juego);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Juego> traerJuegos() {
        //Devuelve una lista con todos los juegos
        List<Juego> listaJuegos = juegoJPA.findJuegoEntities();
        return listaJuegos;
    }
    
    public Juego traerJuegoEnParticular(String id_juego) {
        //Devuelve el juego correspondiente al ID dado
        Juego juego = juegoJPA.findJuego(Integer.parseInt(id_juego));
        return juego;
    }

    public void modificarJuego(Juego juego) {
        //Modifica el juego dado como parámetro
        try {
            juegoJPA.edit(juego);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarJuego(String id_juego) {
        //Elimina el juego con el ID dado
        try {
            juegoJPA.destroy(Integer.parseInt(id_juego));
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //METODOS PERSONA
    public void crearPersona(Persona persona) {
        try {
            personaJPA.create(persona);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Persona> traerPersonas() {
        //Devuelve una lista con todas las personas
        List<Persona> listaPersonas = personaJPA.findPersonaEntities();
        return listaPersonas;
    }

    public Persona traerPersonaEnParticular(String id_persona) {
        //Devuelve la persona correspondiente al ID dado
        Persona persona = personaJPA.findPersona(Integer.parseInt(id_persona));
        return persona;
    }

    public void modificarPersona(Persona persona) {
        //Modifica la persona dada como parámetro
        try {
            personaJPA.edit(persona);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarPersona(String id_persona) {
        //Elimina la persona con el ID dado
        try {
            personaJPA.destroy(Integer.parseInt(id_persona));
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //METODOS ENTRADA
    public void crearEntrada(Entrada entrada) {
        try {
            entradaJPA.create(entrada);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Entrada> traerEntradas() {
        //Devuelve una lista con todas las entradas
        List<Entrada> listaEntradas = entradaJPA.findEntradaEntities();
        return listaEntradas;
    }

}

