package Curso;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.Arrays;

public class Main {
    public static void mostrarMateriales(List<? extends MaterialCurso> lista) {
        System.out.println("\n📚 Materiales del curso:");
        for (MaterialCurso material : lista) {
            material.mostrarDetalle();
        }
    }

    public static void contarDuracionVideos(List<? extends Video> lista) {
        int total = 0;
        for (Video v : lista) {
            total += v.getDuracion();
        }
        System.out.println("\n🎥 Duración total de videos: " + total + " minutos");
    }

    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista) {
        System.out.println();
        for (Object obj : lista) {
            if (obj instanceof Ejercicio ejercicio) {
                ejercicio.setRevisado(true);
                System.out.println("✅ Ejercicio '" + ejercicio.getTitulo() + "' marcado como revisado.");
            }
        }
    }

    public static void filtrarPorAutor(List<? extends MaterialCurso> lista, Predicate<MaterialCurso> filtro) {
        System.out.println("\n🔍 Filtrando materiales por autor:");
        for (MaterialCurso material : lista) {
            if (filtro.test(material)) {
                material.mostrarDetalle();
            }
        }
    }

    public static void main(String[] args) {
        List<MaterialCurso> materiales = Arrays.asList(
                new Video("Introducción a Java", "Mario", 15),
                new Video("POO en Java", "Carlos", 20),
                new Articulo("Historia de Java", "Ana", 1200),
                new Articulo("Tipos de datos", "Luis", 800),
                new Ejercicio("Variables y tipos", "Luis"),
                new Ejercicio("Condicionales", "Mario")
        );

        List<Video> videos = new ArrayList<>();
        List<Ejercicio> ejercicios = new ArrayList<>();
        for (MaterialCurso m : materiales) {
            if (m instanceof Video) {
                videos.add((Video) m);
            } else if (m instanceof Ejercicio) {
                ejercicios.add((Ejercicio) m);
            }
        }

        mostrarMateriales(materiales);

        contarDuracionVideos(videos);

        marcarEjerciciosRevisados(ejercicios);

        filtrarPorAutor(materiales, m -> m.getAutor().equals("Mario"));
    }
}
