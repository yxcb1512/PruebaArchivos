
package QuizRegistroPersona;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class QuizRegistroPersona {

    private String nombreCompleto;
    private String id;
    private int edad;
    private String correo;
    private int telefono;

    private static final String nombreArchivo = "personas.txt";

    public QuizRegistroPersona() {

        Scanner sc = new Scanner(System.in);

        System.out.println("--- Bienvenido(a) al Registro de Datos ---");

        System.out.println("Ingrese su Nombre Completo.");
        this.nombreCompleto = sc.nextLine();
        while (nombreCompleto.isEmpty()) {
            System.out.print("Nombre vacio. Intente de nuevo: ");
            nombreCompleto = sc.nextLine();
        }System.out.println("Nombre guardado con exito!");

        
        System.out.println("Ingrese su numero de cedula.");
        this.id = sc.nextLine();
        while (id.length() < 6) {
            System.out.print("Cedula invalida. Intente de nuevo: ");
            id = sc.nextLine();
        }System.out.println("Cedula guardada con exito!");

        System.out.println("Ingrese su edad:");
        while (true) {
            if (sc.hasNextInt()) {
                edad = sc.nextInt();
                if (edad > 0 && edad <= 117) {
                    break;
                } else {
                    System.out.println("Edad invalida. Ingresela nuevamente:");
                }
            } else {
                System.out.println("Debe ingresar un numero valido.");
                sc.next();
            }
        }System.out.println("Su edad ha sido guardada con exito!");

        sc.nextLine();

        System.out.println("Ingrese su Correo Electronico.");
        this.correo = sc.nextLine();
        while (!correo.contains("@")) {
            System.out.print("Correo invalido. Recuerde que el correo debe contener un @. Intentelo de nuevo: ");
            correo = sc.nextLine();
        }System.out.println("Excelente!, su correo ha sido guardado con exito");

        System.out.println("Ingrese su numero de telefono:");
        String telefonoStr = sc.nextLine();
        while (!telefonoStr.matches("\\d{8,}")) {
            System.out.println("El numero debe contener al menos 8 digitos. Intentelo de nuevo:");
            telefonoStr = sc.nextLine();
        }

        try {
            telefono = Integer.parseInt(telefonoStr);
        } catch (NumberFormatException e) {
            telefono = 0;
        } System.out.println("Numero de telefono guardado con exito.");

        guardarRegistro();
    }

    private void guardarRegistro() {
        LocalDateTime hora = LocalDateTime.now();
        DateTimeFormatter formatoDeFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String fechaHora = hora.format(formatoDeFecha);

        String lineaRegistro = "Nombre: "+nombreCompleto + "  |  "+ "Cédula: "+ id + "  |  "+"Edad: "+ edad +"  |  "
                +"Correo Eléctronico: "+ correo + "  |  "+"Numero De Teléfono" + telefono + "  |  " +"Fecha y hora del registro: "+ fechaHora+"\n";

        String salida = "Nombre: " + nombreCompleto + "\n"
                + "Numero de cedula: " + id + "\n"
                + "Edad: " + edad + "\n"
                + "Correo electronico: " + correo + "\n"
                + "Telefono: " + telefono + "\n"
                + "Fecha y Hora: " + fechaHora;

        System.out.println("\nRegistro completado:\n" + salida);

        try (FileWriter fw = new FileWriter(nombreArchivo, true); BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(lineaRegistro);
            bw.newLine();

            System.out.println("Muchas gracias por su registro. Todos sus datos han sido trasladados a: " + nombreArchivo);

        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
