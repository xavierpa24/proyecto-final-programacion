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

            switch (opcion) {
                case 1:
                    mostrarInventario(productos, inventario);
                    break;
                case 2:
                    realizarVenta(productos, inventario, sc);
                    break;
                case 3:
                    generarReporteFinanciero(productos, inventario);
                    break;
                case 4:
                    System.out.println("Cerrando el sistema de facturacion TecnoStore. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente con una del menu (1-4).");
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
            System.out.printf(" %-7d %-22s $%-11d %-8d\n", 
                inventario[i][0], productos[i], inventario[i][1], inventario[i][2]);
        }
    }

    public static void realizarVenta(String[] productos, int[][] inventario, Scanner sc) {
        System.out.print("Ingrese el codigo del producto a vender: ");
        int codigoBuscado = validarEntero(sc);
        int indiceEncontrado = -1;

        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i][0] == codigoBuscado) {
                indiceEncontrado = i;
                break;
            }
        }

        if (indiceEncontrado == -1) {
            System.out.println("Error: El codigo ingresado no pertenece a ningun producto.");
            return;
        }

        System.out.print("Ingrese la cantidad de unidades a comprar: ");
        int cantidad = validarEntero(sc);

        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor a cero.");
            return;
        }

        int stockActual = inventario[indiceEncontrado][2];
        if (cantidad > stockActual) {
            System.out.println("No hay suficiente stock. Unidades disponibles actuales: " + stockActual);
        } 
        else {
            inventario[indiceEncontrado][2] -= cantidad;
            inventario[indiceEncontrado][3] += cantidad;
            
            int totalFacturado = inventario[indiceEncontrado][1] * cantidad;
            System.out.println("¡VENTA REGISTRADA CON EXITO!");
            System.out.println("Factura: " + cantidad + "x " + productos[indiceEncontrado] + " - Total: $" + totalFacturado + "k");
        }
    }

    public static void generarReporteFinanciero(String[] productos, int[][] inventario) {
        int totalDineroCaja = 0;
        int totalUnidadesTienda = 0;
        int indiceMasVendido = 0;
        int maxUnidadesVendidas = -1;

        for (int i = 0; i < inventario.length; i++) {
            int unidadesVendidas = inventario[i][3];
            int precioUnitario = inventario[i][1];
            
            totalDineroCaja += (unidadesVendidas * precioUnitario);
            totalUnidadesTienda += unidadesVendidas;

            if (unidadesVendidas > maxUnidadesVendidas) {
                maxUnidadesVendidas = unidadesVendidas;
                indiceMasVendido = i;
            }
        }

        System.out.println("REPORTE DE CAJA Y MOVIMIENTOS FIN DE DIA:");
        System.out.println("• Dinero total recaudado en caja: $" + totalDineroCaja + "k");
        System.out.println("• Total de productos despachados: " + totalUnidadesTienda + " unidades.");
        
        if (totalUnidadesTienda > 0) {
            System.out.println("• Producto mas vendido hoy: " + productos[indiceMasVendido] + " (" + maxUnidadesVendidas + " unds).");
        } else {
            System.out.println("• Producto mas vendido hoy: No se han registrado ventas aun.");
        }
    }

    public static int validarEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Tipo de dato incorrecto. Por favor, digite un numero entero: ");
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