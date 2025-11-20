import Entity.ClienteEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Estudio> estudiosDB = obtenerEstudiosRadiologia();
        ArrayList<ClienteEntity> pacientesDB = obtenerPacientes();
        int idSiguiente = estudiosDB.size() + 1;
        int opcionUsuario;

        System.out.println("Te damos la bienvenida a la app de compras 🛒");
        label:
        while (true) {
            System.out.println("""
          Ingrese el número equivalente a la opción:
          0 - Finaliza el programa
          1 - Crea un Estudio de Radiología
          2 - Listar Estudios de Radiología
          3 - Búsqueda por nombre
          4 - Editar nombre Estudio de Radiología
          5 - Borrar Estudio de Radiología
          6 - Sacar turno
          7 - Registrar Paciente
          """);
            opcionUsuario = entrada.nextInt();

            switch (opcionUsuario) {
                case 1 -> {
                    crearEstudio(idSiguiente, estudiosDB);
                    idSiguiente += 1;
                }
                case 2 -> listarEstudios(estudiosDB);
                case 3 -> buscarEstudioPorNombre(estudiosDB);
                case 4 -> editarEstudio(estudiosDB);
                case 5 -> borrarEstudio(estudiosDB);
                case 6 -> System.out.println("sacar turno: Funcionalida en progreso...\n");
                case 7 -> registrarPaciente(pacientesDB);
                case 0 -> {
                    System.out.println("Gracias por usar la app!");
                    break label; // corta el bucle donde se ejecuta
                }
                default -> System.out.println("Opción incorrecta, intente de nuevo");
            }
        }
    }

    public static void crearEstudio(int id, ArrayList<Estudio> estudios) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Creando Nuevo Estudio");
        System.out.print("Ingrese el nombre del nuevo estudio: ");
        String nombre = entrada.nextLine();
        System.out.print("Ingrese el precio del nuevo estudio: $");
        double precio = entrada.nextDouble();
        // TODO: cambiarlo cuando veamos static
        estudios.add(new Estudio(id, nombre, precio));

        // TODO: agregar un mensaje de confirmación cuando se crea el producto
        pausa();
    }

    public static void listarEstudios(ArrayList<Estudio> estudios ) {
        System.out.println("=======================================");
        System.out.println("        LISTA DE ESTUCIOS");
        System.out.println("=======================================");

        if (estudios == null || estudios.isEmpty()) {
            System.out.println("⚠️  No hay estudios para mostrar.");
        } else {
            for (Estudio estudio : estudios) {
                System.out.printf(" %2d. %s - Precio particular: $%.2f%n ", estudio.id, estudio.nombre, estudio.precioParticular);
            }
        }

        System.out.println("=======================================");
        pausa();
    }

    public static void buscarEstudioPorNombre(ArrayList<Estudio> estudios) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese un nombre de un producto: ");
        String busqueda = entrada.nextLine();
        ArrayList<Estudio> estudiosEncontrados = new ArrayList<>();

        for (Estudio estudio : estudios) {
            if (estaIncluido(estudio.nombre, busqueda)) {
                estudiosEncontrados.add(estudio);
            }
        }

        listarEstudios(estudiosEncontrados);
    }

    public static void editarEstudio(List<Estudio> estudios) {
        // el listado de productos tiene las direcciones de memoria de los productos originales
        Scanner entrada = new Scanner(System.in);
        // aca obtenemos la direccion de memoria que nos permite modificar el objeto original
        // que es uno de los que esta en el listado
        Estudio estudio = obtenerEstudiosPorId(estudios);
        // TODO: validar que encontramos el producto
        String nombreOriginal = estudio.nombre;
        System.out.println("Producto a editar:");
        System.out.println(nombreOriginal);
        // TODO: validar que el usuario quiere editar el producto que se encontro
        System.out.print("Ingrese el nuevo nombre: ");
        String nuevoNombre = entrada.nextLine();

        // ["p1", "p2", "p3"]
        // set(1, "p38")
        // ["p1", "p38", "p3"]
        // actualizamos el nombre en el producto
        estudio.nombre = nuevoNombre;

        System.out.printf("El nombre del estudio cambio de %s a %s", nombreOriginal, nuevoNombre);
    }

    public static void borrarEstudio(List<Estudio> estudios) {
        Scanner entrada = new Scanner(System.in);
        Estudio estudio = obtenerEstudiosPorId(estudios);
        // TODO: validar que encontramos el producto
        String nombreOriginal = estudio.nombre;
        System.out.println("Estudio a borrar:");
        System.out.println(nombreOriginal);
        // TODO: validar que el usuario quiere borrar el producto que se encontro

        // aca borramos el producto
        estudios.remove(estudio);
        System.out.println("Borrado exitosamente!");
    }

    public static void registrarPaciente(ArrayList<ClienteEntity> clienteEntities) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Creando Nuevo Paciente");
        System.out.print("Ingrese el dni del nuevo paciente: ");
        int dni = entrada.nextInt();
        entrada.nextLine();
        System.out.print("Ingrese el nombre del nuevo paciente: ");
        String nombre = entrada.nextLine();
        System.out.print("Ingrese el apellido del nuevo paciente: ");
        String apellido = entrada.nextLine();
        System.out.print("Ingrese la obra social del paciente en MAYUSCULA: ");
        String os = entrada.nextLine();



        // TODO: cambiarlo cuando veamos static
        clienteEntities.add(new ClienteEntity(dni, nombre, apellido, os));

        // TODO: agregar un mensaje de confirmación cuando se crea el producto
        pausa();
    }

    /* UTILIDADES */
    /* Busqueda por id - ahora mismo solo funciona con el indice, en el futuro se va a cambiar */
    public static Estudio obtenerEstudiosPorId(List<Estudio> estudios) {
        Scanner entrada = new Scanner(System.in);
        // TODO: validacion de datos
        System.out.println("Ingrese el id del estudio: ");
        int idBusqueda = entrada.nextInt();

        for (Estudio estudio : estudios) {
            if (estudio.id == idBusqueda) {
                return estudio;
            }
        }

        return null; // el null representa que no encontramos el producto
    }

    public static boolean estaIncluido(String nombreCompleto, String nombreParcial) {
        String nombreCompletoFormateado = formatoBusqueda(nombreCompleto);

        return nombreCompletoFormateado.contains(formatoBusqueda(nombreParcial));
    }

    public static String formatoBusqueda(String texto) {
        return texto.trim().toLowerCase();
    }

    public static void pausa() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Pulse ENTER para continuar...");
        entrada.nextLine();
        for (int i = 0; i < 20; ++i) {
            System.out.println();
        }
        // TODO: limpiar la pantalla de la consola
    }

    public static ArrayList<Estudio> obtenerEstudiosRadiologia() {
        ArrayList<Estudio> estudios = new ArrayList<>();

        estudios.add(new Estudio(1, "Mamografía", 30000));
        estudios.add(new Estudio(2, "Ecografía", 10000));
        estudios.add(new Estudio(3, "Radiografía de torax", 20000));
        estudios.add(new Estudio(4, "Radiografía de torax frente", 25000));
        estudios.add(new Estudio(5, "Radiografía de torax frente y perfil", 30000));
        estudios.add(new Estudio(6, "Radiografía de ambos pies frente", 25000));
        estudios.add(new Estudio(7, "Radiografía de ambos pies frente y perfil", 30000));
        return estudios;
    }
    public static ArrayList<ClienteEntity> obtenerPacientes() {
        ArrayList<ClienteEntity> clienteEntities = new ArrayList<>();

        clienteEntities.add(new ClienteEntity(11111111, "Martina", "Garcia Amendola", "IOMA"));
        clienteEntities.add(new ClienteEntity(22221111, "Antonio", "Juarez", "OSDE"));
        clienteEntities.add(new ClienteEntity(22229999, "Maria", "Gonzales", "OSPE"));
        return clienteEntities;
    }
}
