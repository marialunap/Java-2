package Ordenes;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista) {
        System.out.println("📋 Órdenes registradas:");
        for (OrdenProduccion orden : lista) {
            orden.mostrarResumen();
        }
        System.out.println();
    }

    public static void procesarPErsonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional){
        System.out.println("\n💰 Procesando órdenes personalizadas... ");
        lista.forEach(o ->{
            if (o instanceof OrdenPersonalizada orden) {
                System.out.println("✅ Orden " + orden.codigo+ " ajustada con costo adicional de $" + costoAdicional);
            }
        });
    }

    public static void main(String[] args) {

        List<OrdenMasa> ordenMasa =
                List.of(new OrdenMasa("A123", 500),
                        new OrdenMasa("A124", 750));
        List<OrdenPersonalizada> ordenPersonalizada =
                List.of(new OrdenPersonalizada("P456",100, "ClienteX"),
                        new OrdenPersonalizada("P789", 150, "ClienteY"));
        List<OrdenPrototipo> ordenPrototipo =
                List.of(new OrdenPrototipo("T789", 10, "Diseño"),
                        new OrdenPrototipo("T790", 5, "Pruebas"));

        mostrarOrdenes(ordenMasa);
        mostrarOrdenes(ordenPersonalizada);
        mostrarOrdenes(ordenPrototipo);

        procesarPErsonalizadas(new ArrayList<OrdenProduccion>(ordenPersonalizada), 200);

        System.out.println("📊 Resumen total de órdenes:");
        System.out.println("🔧 Producción en masa: " + ordenMasa.size());
        System.out.println("🛠️ Personalizadas: " + ordenPersonalizada.size());
        System.out.println("🧪 Prototipos: " + ordenPrototipo.size());
    }
}
