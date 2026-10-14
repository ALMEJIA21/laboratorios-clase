import java.util.ArrayList;
import java.util.Scanner;

public class ListaTareas {
    public static void main(String[] args) {
        // Creamos el Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Creamos la lista vacía de tareas
        ArrayList<String> tareas = new ArrayList<>();

        // 1. Introducir cuatro tareas mediante Scanner
        System.out.println("=== INGRESO DE TAREAS ===");
        for (int i = 1; i <= 4; i++) {
            System.out.print("Introduce la tarea " + i + ": ");
            String tarea = scanner.nextLine();
            tareas.add(tarea);
        }

        // 2. Muestra las tareas numeradas
        System.out.println("\n=== LISTA DE TAREAS ACTUALES ===");
        for (int i = 0; i < tareas.size(); i++) {
            System.out.println((i + 1) + ". " + tareas.get(i));
        }

        // 3. Consulta la cantidad de tareas
        System.out.println("\nCantidad total de tareas: " + tareas.size());

        // 4. Prueba la búsqueda de una tarea que NO existe antes de eliminar
        System.out.println("\n=== PRUEBA DE BÚSQUEDA (TAREA INEXISTENTE) ===");
        String tareaPrueba = "Estudiar física cuántica"; // Una tarea que probablemente no esté
        boolean existePrueba = tareas.contains(tareaPrueba);
        System.out.println("¿Existe la tarea \"" + tareaPrueba + "\"? " + (existePrueba ? "Sí" : "No"));

        // 5. Pregunta por una tarea y comprueba si existe (búsqueda normal)
        System.out.println("\n=== BUSCAR UNA TAREA ===");
        System.out.print("¿Qué tarea deseas buscar?: ");
        String tareaBuscada = scanner.nextLine();
        
        if (tareas.contains(tareaBuscada)) {
            System.out.println("¡Sí! La tarea \"" + tareaBuscada + "\" está registrada en la lista.");
        } else {
            System.out.println("No se encontró la tarea \"" + tareaBuscada + "\" en la lista.");
        }

        // 6. Elimina una tarea por su nombre si está registrada
        System.out.println("\n=== ELIMINAR UNA TAREA ===");
        System.out.print("Introduce el nombreexacto de la tarea que deseas eliminar: ");
        String tareaAEliminar = scanner.nextLine();

        if (tareas.remove(tareaAEliminar)) {
            System.out.println("¡La tarea \"" + tareaAEliminar + "\" ha sido eliminada con éxito!");
        } else {
            System.out.println("No se pudo eliminar porque la tarea no existe en la lista.");
        }

        // 7. Muestra la lista actualizada
        System.out.println("\n=== LISTA DE TAREAS ACTUALIZADA ===");
        if (tareas.isEmpty()) {
            System.out.println("La lista de tareas está vacía.");
        } else {
            for (int i = 0; i < tareas.size(); i++) {
                System.out.println((i + 1) + ". " + tareas.get(i));
            }
        }

        // Cerramos el scanner para evitar fugas de recursos
        scanner.close();
    }
}
//Ejercicio