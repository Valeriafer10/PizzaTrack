import java.util.Scanner;

public class Gestionpedidos {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Pila pilaPrincipal = new Pila(); // Undo
        Pila pilaSecundaria = new Pila(); // Redo

        int opcion;

        do {

            System.out.println("\n=== PIZZA TRACK ===");
            System.out.println("1. Registrar Pizza");
            System.out.println("2. Deshacer (Undo)");
            System.out.println("3. Rehacer (Redo)");
            System.out.println("4. Mostrar Pedido Actual");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Nombre de la pizza: ");
                    String nombre = sc.nextLine();

                    String[] ingredientes = new String[3];

                    for (int i = 0; i < 3; i++) {
                        System.out.print("Ingrediente " + (i + 1) + ": ");
                        ingredientes[i] = sc.nextLine();
                    }

                    Pizza nuevaPizza = new Pizza(nombre, ingredientes);

                    pilaPrincipal.push(nuevaPizza);

                    System.out.println("Pizza registrada.");

                    break;

                case 2:

                    Pizza deshacer = pilaPrincipal.pop();

                    if (deshacer != null) {

                        pilaSecundaria.push(deshacer);
                        System.out.println("Pedido deshecho.");

                    } else {

                        System.out.println("No hay pedidos para deshacer.");
                    }

                    break;

                case 3:

                    Pizza rehacer = pilaSecundaria.pop();

                    if (rehacer != null) {

                        pilaPrincipal.push(rehacer);
                        System.out.println("Pedido rehecho.");

                    } else {

                        System.out.println("No hay pedidos para rehacer.");
                    }

                    break;

                case 4:

                    Pizza actual = pilaPrincipal.peek();

                    if (actual != null) {

                        System.out.println("Pedido actual:");
                        actual.mostrarPizza();

                    } else {

                        System.out.println("No hay pedidos registrados.");
                    }

                    break;

                case 0:

                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");

            }

        } while (opcion != 0);

        sc.close();
    }
}