package EjerciciosPracticos;

import java.util.ArrayList;

public class clase3 {

    public static void main(String[] args) {

        //Dada una cadena " té CHAi ", formateala para que quede "Té Chai".
        String s1 = " té CHAi ";
        String combinacion = s1.toLowerCase().trim();
        String[] palabras=combinacion.split(" ");
        StringBuilder sb = new StringBuilder(); //txt3= txt1+txt2
        for (String palabra : palabras) {
            if(!palabra.isEmpty()){
                sb.append(Character.toUpperCase(palabra.charAt(0)))
                        .append(palabra.substring(1).toLowerCase())
                        .append(" ");
            }
        }
        System.out.println(sb);
        //Mostrá su longitud, su primera letra y verificá si contiene la palabra "Chai".
        int longitud = sb.toString().length();
        System.out.println("Longitud: " + longitud);
        String st = sb.toString();
        System.out.print(st.charAt(0));
        System.out.println("¿Contiene 'Chai'? " + st.contains("Chai"));

        /*Creá un array de 5 productos.Imprimí sus elementos y luego intentá agregar un sexto producto (analizá el resultado).*/
        ArrayList<String> productos = new ArrayList<>();

        productos.add("cacao");
        productos.add("cafe");
        productos.add("harina");
        productos.add("manteca");
        productos.add("mermelada");
        System.out.println("\n Lista del Super");
        for (String producto : productos) {
            System.out.println(producto);
        }
        System.out.println("\n Lista del Super 2.0");
        productos.add("leche");
        for (String producto : productos) {
            System.out.println(producto);
        }

        //Agregá varios productos, eliminá uno, verificá si otro existe y luego imprimí la lista final.
        productos.removeIf(p -> p.equalsIgnoreCase("harina"));
        System.out.println("\n Lista del Super 3.0");
        for (String producto : productos) {
            System.out.println(producto);
        }
    }
}
