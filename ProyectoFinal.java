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
            System.out.println("     SISTEMA DE VENTAS TECNOSTORE      ");
            System.out.println("1. Mostrar inventario disponible");
            System.out.println("2. Registrar una venta (Facturar)");
            System.out.println("3. Ver reporte de ingresos y ventas");
            System.out.println("4. Salir del programa");
            System.out.print("Seleccione una opcion: ");
            
            opcion = sc.nextInt();
            
        } while (opcion != 4);
    }
}