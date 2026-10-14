public class Contador {

    int valor;

    public Contador() {
        this.valor = 0; // Se inicializa en cero sin pedirlo por parámetro
    }

    void aumentar() {
        valor++;
    }

    void mostrar() {
        System.out.println("Valor: " + valor);
    }
}