package Logica;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {

        //Para crear un usuario inicial en la DB e ingresar al sistema
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("admin");
        usuario.setContrasenia("admin");

        Controladora control = new Controladora();
        control.crearUsuario(usuario);
    }
}
