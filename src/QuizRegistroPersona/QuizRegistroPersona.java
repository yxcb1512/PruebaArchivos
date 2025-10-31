
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
    
    public QuizRegistroPersona(){
    
    Scanner sc = new Scanner(System.in);
    
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

        System.out.println("Ingrese su edad");
        this.edad = sc.nextInt();
        while(edad<0 || edad>117){
            System.out.println("Edad invalida. Ingresela de nuevo.");
            sc.next();
        }edad = sc.nextInt();

        System.out.println("Ingrese su Correo Electronico.");
        this.correo = sc.nextLine();
        while (!correo.contains("@")) {
            System.out.print("Correo inválido. Intente de nuevo: ");
            correo = sc.nextLine();
        }

        System.out.println("Ingrese su Numero de telefono.");
        this.telefono = sc.nextInt();
        while(telefono<=7){
            System.out.println("El numero debe contener al menos 8 digitos. intentelo nuevamente.");
            sc.next();
        }telefono= sc.nextInt();
       
         LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String fechaHora = ahora.format(formato);

        String linea = persona.nombreCompleto + "|" +
                       persona.id + "|" +
                       persona.edad + "|" +
                       persona.correo + "|" +
                       persona.telefono + "|" +
                       fechaHora;
        
    }
    
    
        
        
    }
    
}
