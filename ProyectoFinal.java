import java.util.Scanner;

public class ProyectoFinal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] productos = {"Consola PS5", "Xbox Series X", "Laptop Gamer", "Audifonos Bluetooth", "Teclado Mecanico"};
        int[][] inventario = {
            {101, 2500, 10, 0},
            {102, 2000, 12, 0},
            {103, 3500, 5,  0},
            {104,  250, 20, 0},
            {105,  180, 15, 0}
        };

        int opcion;
        do {
            mostrarMenu();
            opcion = validarEntero(sc);

            if (opcion == 1) {
                mostrarInventario(productos, inventario);
            }
            if (opcion != 4) {
                esperarEnter(sc);
            }
        } while (opcion != 4);
    }

    public static void mostrarMenu() {
        System.out.println("     SISTEMA DE VENTAS TECNOSTORE      ");
        System.out.println("1. Mostrar inventario disponible");
        System.out.println("2. Registrar una venta (Facturar)");
        System.out.println("3. Ver reporte de ingresos y ventas");
        System.out.println("4. Salir del programa");
        System.out.print("Seleccione una opcion: ");
    }

    public static void mostrarInventario(String[] productos, int[][] inventario) {
        System.out.println("INVENTARIO EN TIENDA:");
        System.out.printf("%-8s %-22s %-12s %-8s\n", "CODIGO", "PRODUCTO", "PRECIO (K)", "STOCK");
        for (int i = 0; i < productos.length; i++) {
            System.out.printf(" %-7d %-22s $%-11d %-8d\n", inventario[i][0], productos[i], inventario[i][1], inventario[i][2]);
        }
    }

    public static int validarEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Tipo de dato incorrecto. Ingrese un numero entero: ");
            sc.next();
        }
        int numero = sc.nextInt();
        sc.nextLine();
        return numero;
    }

    public static void esperarEnter(Scanner sc) {
        System.out.println("Presione la tecla [Enter] para regresar al menu...");
        sc.nextLine();
    }
}