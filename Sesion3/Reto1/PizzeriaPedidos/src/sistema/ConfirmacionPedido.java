package sistema;

import java.util.List;
import java.util.Optional;

public class ConfirmacionPedido {
    public static void main(String[] args) {
        List<Pedido> pedidos = List.of(
                new Pedido("Zayne", "domicilio", "669-551"),
                new Pedido("Caleb", "local", null),
                new Pedido("Sofia", "domicilio", "669-831"),
                new Pedido("Juan Pablo", "domicilio", null)
        );

        pedidos.stream()
                .filter(p -> "domicilio".equalsIgnoreCase(p.getTipoEntrega()))
                .map(Pedido::getTelefono)
                .flatMap(Optional::stream)
                .map(telefono -> "Confirmación enviada al número: " + telefono)
                .forEach(System.out::println);
    }
}