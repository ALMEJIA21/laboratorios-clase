public class Operadoreslógicos {
     public static void main(String[]args){
        int edad = 21;
        boolean documentoValido = true;

        boolean puedeIngresar = edad >= 18 && documentoValido;

        System.out.println(puedeIngresar);

        boolean tieneCarnet = false;
        boolean tieneAutorizacion = true;

        boolean puedeEntrar = tieneCarnet || tieneAutorizacion;

        System.out.println(puedeEntrar);

     }
}
