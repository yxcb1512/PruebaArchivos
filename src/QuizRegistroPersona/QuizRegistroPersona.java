
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

    private static final String NOMBRE_ARCHIVO = "personas.txt";
    private static final String SEPARADOR = "|";

    public QuizRegistroPersona() {

        Scanner sc = new Scanner(System.in);

        System.out.println("--- INICIO DE REGISTRO ---");

        System.out.println("Ingrese su Nombre Completo.");
        this.nombreCompleto = sc.nextLine();
        while (nombreCompleto.isEmpty()) {
            System.out.print("Nombre vacio. Intente de nuevo: ");
            nombreCompleto = sc.nextLine();
        }

        System.out.println("Ingrese su numero de cedula.");
        this.id = sc.nextLine();
        while (id.length() < 6) {
            System.out.print("Cedula invalida. Intente de nuevo: ");
            id = sc.nextLine();
        }

        System.out.println("Ingrese su edad:");
        while (true) {
            if (sc.hasNextInt()) {
                edad = sc.nextInt();
                if (edad > 0 && edad <= 117) {
                    break;
                } else {
                    System.out.println("Edad invalida. Ingresela de nuevo:");
                }
            } else {
                System.out.println("Debe ingresar un numero valido.");
                sc.next();
            }
        }

        sc.nextLine();

        System.out.println("Ingrese su Correo Electronico.");
        this.correo = sc.nextLine();
        while (!correo.contains("@")) {
            System.out.print("Correo invalido. Intente de nuevo: ");
            correo = sc.nextLine();
        }

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
        }

        guardarRegistro();
    }

    private void guardarRegistro() {
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formatoDeFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String fechaHora = ahora.format(formatoDeFecha);

        String lineaRegistro = nombreCompleto + SEPARADOR + id + SEPARADOR + edad + SEPARADOR
                + correo + SEPARADOR + telefono + SEPARADOR + fechaHora;

        String salida = "Nombre: " + nombreCompleto + "\n"
                + "Numero de cedula: " + id + "\n"
                + "Edad: " + edad + "\n"
                + "Correo electronico: " + correo + "\n"
                + "Telefono: " + telefono + "\n"
                + "Fecha y Hora: " + fechaHora;

        System.out.println("\nRegistro completado:\n" + salida);

        try (FileWriter fw = new FileWriter(NOMBRE_ARCHIVO, true); BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(lineaRegistro);
            bw.newLine();

            System.out.println("Registro guardado en " + NOMBRE_ARCHIVO);

        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
