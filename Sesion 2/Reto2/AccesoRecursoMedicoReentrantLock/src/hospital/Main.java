package hospital;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        System.out.println("🏥 Iniciando simulación de acceso al recurso...");

        RecursoMedico salaCirugia = new RecursoMedico("Sala de cirugía");


        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(new Profesional("Dra. Sánchez", salaCirugia));
        executor.submit(new Profesional("Dr. Lozano", salaCirugia));
        executor.submit(new Profesional("Dr. Valdivia", salaCirugia));
        executor.submit(new Profesional("Dra. Luna", salaCirugia));

        executor.shutdown();
    }
}
