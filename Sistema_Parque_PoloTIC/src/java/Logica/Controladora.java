package Logica;

import Persistencia.ControladoraPersistencia;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    //METODOS USUARIO
    public void crearUsuario(Usuario usuario) {
        controlPersis.crearUsuario(usuario);
    }

    public List<Usuario> getListaUsuarios() {
        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();
        return listaUsuarios;
    }

    public Usuario getUsuario(String id_usuario) {
        return controlPersis.traerUsuarioEnParticular(id_usuario);
    }

    public void editarUsuario(Usuario usuario) {
        controlPersis.modificarUsuario(usuario);
    }

    //METODOS EMPLEADO
    public void crearEmpleado(Empleado empleado) {
        controlPersis.crearEmpleado(empleado);
    }

    public Empleado getEmpleado(String id_empleado) {
        return controlPersis.traerEmpleadoEnParticular(id_empleado);
    }

    public void editarEmpleado(Empleado empleado) {
        controlPersis.modificarEmpleado(empleado);
    }

    public void eliminarEmpleado(String id_empleado) {
        controlPersis.eliminarEmpleado(id_empleado);
    }

    public List<Empleado> getListaEmpleados() {
        List<Empleado> listaEmpleados = controlPersis.traerEmpleados();
        return listaEmpleados;
    }

    //METODOS HORARIO
    public void crearHorario(Horario horario) {
        controlPersis.crearHorario(horario);
    }

    public void editarHorario(Horario horario) {
        controlPersis.modificarHorarios(horario);
    }

    //METODOS JUEGO
    public void crearJuego(Juego juego) {
        controlPersis.crearJuego(juego);
    }

    public List<Juego> getListaJuegos() {
        List<Juego> listaJuegos = controlPersis.traerJuegos();
        return listaJuegos;
    }

    public Juego getJuego(String id_juego) {
        return controlPersis.traerJuegoEnParticular(id_juego);
    }

    public void editarJuego(Juego juego) {
        controlPersis.modificarJuego(juego);
    }

    public void eliminarJuego(String id_juego) {
        controlPersis.eliminarJuego(id_juego);
    }

    //METODOS PERSONA
    public void crearPersona(Persona persona) {
        controlPersis.crearPersona(persona);
    }

    public List<Persona> getListaPersonas() {
        List<Persona> listaPersonas = controlPersis.traerPersonas();
        return listaPersonas;
    }

    public Persona getPersona(String id_persona) {
        return controlPersis.traerPersonaEnParticular(id_persona);
    }

    public void editarPersona(Persona persona) {
        controlPersis.modificarPersona(persona);
    }

    public void eliminarPersona(String id_persona) {
        controlPersis.eliminarPersona(id_persona);
    }

    //METODOS ENTRADA
    public void crearEntrada(Entrada entrada) {
        controlPersis.crearEntrada(entrada);
    }

    public List<Entrada> getListaEntradas() {
        List<Entrada> listaEntradas = controlPersis.traerEntradas();
        return listaEntradas;
    }

    //METODOS EXTRA, FUNCIONES ESPECIFICAS
    public boolean comprobarIngreso(String nombreUsuario, String contrasenia) {
        //Devuelve TRUE si existe el usuario y clave dados
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        listaUsuarios = controlPersis.traerUsuarios();

        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasenia().equals(contrasenia)) {
                return true;
            }
        }
        return false;
    }

    public String getPersonaFromIdEntrada(String id_entrada) {
        //Devuelve el nombre completo de la persona, en base a la id de una
        //entrada en su lista
        List<Persona> listPersonas = getListaPersonas();
        for (Persona persona : listPersonas) {
            List<Entrada> listaEntradas = persona.getListaEntradas();
            for (Entrada entrada : listaEntradas) {
                if (entrada.getId_entrada() == Integer.parseInt(id_entrada)) {
                    String cliente = persona.getNombre() + " " + persona.getApellido();
                    return cliente;
                }
            }
        }
        return null;
    }

    public String getJuegoFromIdEntrada(String id_entrada) {
        //Devuelve el nombre del juego, en base a la id de una entrada en
        //su lista
        List<Juego> listJuegos = getListaJuegos();
        for (Juego juego : listJuegos) {
            List<Entrada> listaEntradas = juego.getListaEntradas();
            for (Entrada entrada : listaEntradas) {
                if (entrada.getId_entrada() == Integer.parseInt(id_entrada)) {
                    String juegoNombre = juego.getNombre();
                    return juegoNombre;
                }
            }
        }
        return null;
    }

    public boolean verificarFechaVenta(String fechaVenta) {
        //Verifica si la fecha de venta no pertenece al pasado
        String fechaActual = getFechaActual();

        String[] actualS = fechaActual.split("-");
        int actualAnio = Integer.parseInt(actualS[0]);
        int actualMes = Integer.parseInt(actualS[1]);
        int actualDia = Integer.parseInt(actualS[2]);

        String[] ventaS = fechaVenta.split("-");
        int ventaAnio = Integer.parseInt(ventaS[0]);
        int ventaMes = Integer.parseInt(ventaS[1]);
        int ventaDia = Integer.parseInt(ventaS[2]);

        if (ventaAnio > actualAnio) {
            return true;
        } else {
            if (ventaAnio == actualAnio && ventaMes > actualMes) {
                return true;
            } else {
                if (ventaAnio == actualAnio && ventaMes == actualMes && ventaDia >= actualDia) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public boolean verificarHoraVenta(Date hora_inicio, Date hora_fin, String hora) {
        String horaInicio = convertirDateToTime(hora_inicio);
        String horaFin = convertirDateToTime(hora_fin);
        String[] InicioS = horaInicio.split(":");
        String[] FinS = horaFin.split(":");
        String[] HoraS = hora.split(":");

        int HoraInicio = Integer.parseInt(InicioS[0]);
        int MinutoInicio = Integer.parseInt(InicioS[1]);
        int HoraFin = Integer.parseInt(FinS[0]);
        int MinutoFin = Integer.parseInt(FinS[1]);
        int Hora = Integer.parseInt(HoraS[0]);
        int Minuto = Integer.parseInt(HoraS[1]);

        int segundoInicio = HoraInicio * 60 * 60 + MinutoInicio * 60;
        int segundoFin = HoraFin * 60 * 60 + MinutoFin * 60;
        int segundo = Hora * 60 * 60 + Minuto * 60;

        //Caso abierto siempre
        if(segundoInicio == segundoFin){
            return true;
        }
        //Caso intervalo orden ascendente
        if (segundoInicio <= segundo && segundo <= segundoFin) {
            return true;
        } else {
            //Caso intervalor orden invertido
            if (segundoFin < segundoInicio) {
                //24 horas * 60 minutos * 60 segundos = 86400 segundos
                if (segundoInicio <= segundo && segundo <= 86400) {
                    return true;
                }
                if (0 <= segundo && segundo <= segundoFin) {
                    return true;
                }
            }
            return false;
        }
    }

    //METODOS CONVERSIONES ENTRE DATE, STRING Y TIME
    public static String getFechaActual() {
        //Retorna un STRING con la fecha actual formato "dd-MM-yyyy"
        Date ahora = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        return formatoFecha.format(ahora);
    }

    public static String getHoraActual() {
        //Retorna un STRING con la hora actual formato "hh:mm"
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm");
        return formateador.format(ahora);
    }

    public static synchronized java.util.Date deStringToDate(String fecha) {
        //Convierte un String a un tipo DATE en formato yyyy-MM-dd
        //Retorna la fecha en formato Date
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); //formato guión
        Date fechaEnviar = null;
        try {
            fechaEnviar = df.parse(fecha);
            return fechaEnviar;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static synchronized java.util.Date deStringToDate2(String fecha) {
        //Convierte un String a un tipo DATE en formato dd/MM/yyyy
        //Retorna la fecha en formato Date
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy"); //formato barra
        Date fechaEnviar = null;
        try {
            fechaEnviar = formatoDelTexto.parse(fecha);
            return fechaEnviar;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String DateAString(Date fecha) {
        //Convertir Date a String
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        return formatoFecha.format(fecha);
    }
    
    public static String DateAString2(Date fecha) {
        //Convertir Date a String
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        return formatoFecha.format(fecha);
    }

    public static Date convertirHoraStringADate(String horaString) throws ParseException {
        //Convertir Hora a String. Hora llega como HH:MM
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
        Date hora = new Date();

        hora = formatoHora.parse(horaString);

        return hora;
    }

    public String convertirDateToTime(Date convertir) {
        //JPA devuelve TIME como DATE con una fecha por defecto en el 1970
        //Este metodo deja expresada la hora segun DB
        SimpleDateFormat formateador = new SimpleDateFormat("HH:mm");
        return formateador.format(convertir);
    }

}
