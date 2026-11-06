public class CompararCantidades {

        public static void main(String[] args) {
                int inventario = 12;
                int cantidadSolicitada = 8;

                boolean inventarioSuficiente = inventario >= cantidadSolicitada;
                boolean inventarioIgual = inventario == cantidadSolicitada;
                boolean inventarioInsuficiente = inventario <= cantidadSolicitada;

                System.out.println(inventarioInsuficiente);
                System.out.println(inventarioIgual);
                System.out.println(inventarioSuficiente);

        
        }
    
}
