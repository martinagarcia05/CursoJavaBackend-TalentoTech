public class Paciente {
    private int dni;
    private String nombre;
    private String apellido;
    private String obraSocial;

    // metodo constructor
    public Paciente(int dniP, String nombreP, String apellidoP, String obraSocialP) {
        dni = dniP;
        nombre = nombreP;
        apellido = apellidoP;
        obraSocial = obraSocialP;
    }
}