package EjerciciosPracticos;
import java.util.Scanner;
import java.util.ArrayList;

/*En TechLab, Silvia (Product Owner) ha recibido nuevas solicitudes del cliente “Sibelius”. El equipo de desarrollo
(Matías y Sabrina) se enfrenta a varios pequeños problemas cotidianos del proyecto de e-commerce.
Cada uno de estos problemas se resolverá aplicando un concepto de programación. Los problemas que enfrentaremos en
TalentoLab esta semana son los siguientes:*/

public class clase2 {
    public static void main(String[] args) {
        //1-Necesitamos llevar un registro del stock de productos.
        ArrayList<String> productos = new ArrayList<>();
        ArrayList<String> stock = new ArrayList<>();
        ArrayList<String> prexu = new ArrayList<>();
        boolean a = true;
        String b;
        Scanner input = new Scanner(System.in);
        System.out.println("\n------------------------Carga de Productos--------------------------------");
        while (a) {
            System.out.print("ingrese el nombre del producto... ");
            String nom = input.nextLine();
            System.out.print("ingrese el stock del producto... ");
            String st = input.nextLine();
            System.out.print("ingrese el precio unitario del producto... ");
            String pxu = input.nextLine();
            System.out.print("seguir cargando? (y)");
            b = input.nextLine();
            productos.add(nom);
            stock.add(st);
            prexu.add(pxu);
            if (!b.equals("y")) {
                a = false;
            }
        }
        //3- Requerimos solicitar datos al cliente para personalizar la experiencia.
        System.out.println("\n-----------------Ingrese sus datos para realizar la Compra Online------------------------");
        System.out.println("ingrese su nombre ");
        String nomU = input.nextLine();
        System.out.println("ingrese su apellido ");
        String ape = input.nextLine();
        System.out.println("ingrese su edad ");
        int age = Integer.parseInt(input.nextLine());


        //2-El cliente quiere saber el costo total de un pedido sumando el precio unitario por la cantidad de productos.
        int cant;
        int sum = 0;
        System.out.println("\n------------------------Compra Online--------------------------------");
        if (age>18) {
            for (int i = 0; i < productos.size(); i++) {
                System.out.println("agregar " + productos.get(i) + "? (y)");
                String rta = input.nextLine();
                if (rta.equals("y")) {
                    System.out.println("cantidad?");
                    cant = Integer.parseInt(input.nextLine());
                    //4- Debemos verificar si tenemos suficiente stock para cubrir una demanda específica.
                    if (cant <= 0 || cant > Integer.parseInt(stock.get(i))) {
                        System.out.println("error");
                    } else {
                        sum += cant * Integer.parseInt(prexu.get(i));
                    }
                }
            }
            System.out.println("\n------------------------Detalle Compra Online--------------------------------");
            System.out.println("Cliente: " + nomU + ape);
            System.out.println("total a pagar: $" + sum);
        }else {
            System.out.println("Debe ser mayor de 18 años para comprar");
        }
        /*5- Hay que procesar una lista de productos pendientes de revisión.
        Primero intentaremos una solución con while y luego notaremos que for podría ser más elegante. */
        System.out.println("\n------------------------Agregar Productos en Revisión--------------------------------");
        ArrayList<String> enRevision = new ArrayList<>();
        for (String producto : productos) {
            System.out.println("agregar " + producto + " a 'pendiente de revision'? (y) ");
            String rta = input.nextLine();
            if (rta.equals("y")) {
                enRevision.add(producto);
            }
        }
        System.out.println("\n------------------------Productos en Revisión--------------------------------");
        for (String pr : enRevision) {
            System.out.println("->"+pr);
        }
    }
}
