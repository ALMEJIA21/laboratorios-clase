public class CalculadoraDescuento {

    
    public static double calcularDescuento(double subtotal, double porcentaje) {
        double resultadoDescuento = subtotal * porcentaje;
        return resultadoDescuento; 
    }

   
    public static void main(String[] args) {
        double subtotal = 200000;
        double descuento = calcularDescuento(subtotal, 0.10);
        
        System.out.println(descuento); 
    }
}