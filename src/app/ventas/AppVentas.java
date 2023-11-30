
package app.ventas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author maria
 */
public class AppVentas {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        boolean bandera = true;
        
        int opcion = 0;
        
        while(bandera){
            System.out.println("1. Ventas regulares");
            System.out.println("2. Ventas a credito");
            System.out.println("3. Clientes registrados");
            System.out.println("4. Salir");
            
            try {
                 System.out.print("Seleccione una opcion: ");
                 opcion = scanner.nextInt();
            } catch (Exception e) {
                 System.out.println("\n*** Escoja un numero valido ***");
                 //Restablece flag a true para continuar el bucle
                 bandera = true;
                 //Limpia el buffer del scanner
                 scanner.nextLine();
            }
            
            switch (opcion) {
                case 1:
                    Opcion1();
                    break;
                case 2:
                    Opcion2();
                    break;
                case 3:
                    Opcion3();
                    break;
                case 4:
                    bandera = false;
                    System.out.println("Hasta luego");
                    break;
                default:
                    System.out.println("Elija una opcion del 1 - 4\n");
                    break;
            }
        }
         
    }//Fin main
    
     private static void Opcion1(){
                    Scanner scanner = new Scanner(System.in);
                    // Ventas regulares
                    System.out.println("\n***Ventas regulares ***\n");
                    System.out.print("Ingrese la cantidad de ventas: ");
                    int cantidadVentas = scanner.nextInt();
                    double totalPagado = 0;

                    for (int i = 0; i < cantidadVentas; i++) {
                        System.out.println("Venta " + (i + 1) + ":");
                        System.out.print("Nombre del articulo: ");
                        String nombreArticulo = scanner.next();
                        System.out.print("Valor unitario del articulo: ");
                        double valorUnitario = scanner.nextDouble();
                        System.out.print("Cantidad vendida: ");
                        int cantidadVendida = scanner.nextInt();

                        double valorBruto = valorUnitario * cantidadVendida;
                        double iva = valorBruto * 0.19;
                        double valorPagar = valorBruto + iva;
                        totalPagado += valorPagar;
                        double promedioTotal = (totalPagado / (i + 1));

                        System.out.println("a) Nombre del articulo: " + nombreArticulo);
                        System.out.println("b) Valor bruto de la venta: " + valorBruto);
                        System.out.println("c) Valor del IVA (19%): " + iva);
                        System.out.println("d) Valor a pagar: " + valorPagar);
                        System.out.println("e) Promedio de valores pagados: " + promedioTotal + "\n");
                    }
      }
     
      private static void Opcion2(){
                    Scanner scanner = new Scanner(System.in);
                    // Ventas a crédito
                    System.out.println("Ventas a credito:");
                    System.out.print("Ingrese el valor total del credito: ");
                    double valorTotalCredito = scanner.nextDouble();
                    System.out.print("Ingrese la cantidad de cuotas pagadas: ");
                    int cuotasPagadas = scanner.nextInt();

                    double valorRestante = valorTotalCredito;
                    for (int i = 0; i < cuotasPagadas; i++) {
                        System.out.print("Ingrese el valor de la cuota pagada " + (i + 1) + ": ");
                        double valorCuota = scanner.nextDouble();
                        valorRestante -= valorCuota;
                    }

                    System.out.println("Total pagado por el cliente: " + (valorTotalCredito - valorRestante));
                    System.out.println("Valor que le resta por pagar: " + valorRestante);
      }
      
       private static void Opcion3(){
                    ArrayList<Credito> creditos = new ArrayList<>();
                    Scanner scanner = new Scanner(System.in);
                    // Clientes registrados
                    System.out.println("Clientes registrados:");
                    System.out.print("Ingrese la cantidad de clientes: ");
                    int cantidadClientes = scanner.nextInt();

                    for (int i = 0; i < cantidadClientes; i++) {
                        System.out.println("Cliente " + (i + 1) + ":");
                        System.out.print("Nombre del cliente: ");
                        String nombreCliente = scanner.next();
                        System.out.print("Valor del credito: ");
                        double valorCredito = scanner.nextDouble();
                        creditos.add(new Credito(nombreCliente, valorCredito));
                    }

                    // Ordenar la lista de créditos alfabéticamente por nombre
                    Collections.sort(creditos, Comparator.comparing(Credito::getNombreCliente));

                    // Mostrar el listado ordenado
                    for (Credito credito : creditos) {
                        System.out.println("Nombre: " + credito.getNombreCliente() + ", Valor del credito: " + credito.getValorCredito());
                    }
      }
  
}
