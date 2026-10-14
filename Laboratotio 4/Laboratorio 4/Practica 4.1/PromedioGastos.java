public class PromedioGastos {
    public static void main(String[] args) {
        
        double[] gastos = {30000, 45000, 20000, 10000};

        double suma = 0;
        int cantidadMayores = 0;

        
        for (int i = 0; i < gastos.length; i++) {
            suma = suma + gastos[i]; 

            
            if (gastos[i] > 25000) {
                cantidadMayores++; 
            }
        }

        
        double promedio = suma / gastos.length;

        
        System.out.println("Total: " + suma);
        System.out.println("Cantidad: " + gastos.length);
        System.out.println("Promedio: " + promedio);
        System.out.println("Mayores que 25000: " + cantidadMayores);
    }
}