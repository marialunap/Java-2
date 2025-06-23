package calidad;

import java.util.List;


public class Sucursal {
    private final String nombre;
    private final List<Encuesta> listaEncuestas;

    public Sucursal(String nombre, List<Encuesta> listaEncuestas) {
        this.nombre = nombre;
        this.listaEncuestas = listaEncuestas;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Encuesta> getEncuestas() {
        return listaEncuestas;
    }
}