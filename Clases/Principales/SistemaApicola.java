package Clases.Principales;

import Clases.Principales.*;
import java.util.*;

public class SistemaApicola {
    private static DatosApicola datosApicola = new DatosApicola();
    
    public static void registrarApicultor() {
        System.out.println("REGISTRO DEL NUEVO APICULTOR");
    
        try {
            // SE piden los datos del nuevo apicultor
            String nombre = Utils.solicitarCampo("Ingrese el nombre del apicultor: ");
            String telefono = Utils.solicitarCampo("Ingrese el teléfono del apicultor: ");
            int edad = solicitarEdad();
            int experiencia = solicitarExperiencia(edad);
            String direccion = Utils.solicitarCampo("Ingrese la dirección del apicultor: ");
            String identificacion = Utils.solicitarCampo("Ingrese la identificación (DNI/ID/Cédula) del apicultor: ");
    
            // Crear objeto Apicultor
            Apicultor nuevoApicultor = new Apicultor(nombre, telefono, edad, experiencia, direccion, identificacion);
    
            // Agregar el apicultor a la lista correspondiente (en este caso, a datosApicola)
            datosApicola.agregarApicultor(nuevoApicultor);
    
            // Confirmar el registro
            System.out.println("✅ Apicultor registrado correctamente.");
        } catch (Exception e) {
            System.out.println("❌ Error al registrar el apicultor: " + e.getMessage());
        }
}

    public static void asignarAbejaReina() {
        // TODO: Mostrar lista de colmenas sin reina
        // TODO: Permitir elegir colmena
        // TODO: Pedir datos de la abeja reina (nombre, edad, etc.)
        // TODO: Validar datos
        // TODO: Asignar la abeja reina a la colmena seleccionada
        // TODO: Confirmar asignación
    }

    public static void mostrarInformacion() {
        // TODO: Mostrar submenú con tipos de información a mostrar
        // TODO: Dependiendo de la opción, mostrar:
        //   - Colmenas registradas
        //   - Apicultores
        //   - Abejas reinas
        //   - Historial de inspecciones
        // TODO: Permitir volver al menú principal
    }

    //codigo de la colmena necesario para el codigo del apicultor 
    package Clases.Principales;

    public class Apicultor {
        private String nombre;
        private String telefono;
        private int edad;
        private int experiencia;
        private String direccion;
        private String identificacion;

    public Apicultor(String nombre, String telefono, int edad, int experiencia, String direccion, String identificacion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.edad = edad;
        this.experiencia = experiencia;
        this.direccion = direccion;
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }
    }

    //codigo de apicultor
    public static void asignarApicultorAColmena() {
    List<Colmena> colmenas = datosApicola.getListaColmenas();
    List<Apicultor> apicultores = datosApicola.getListaApicultores();

    if (colmenas.isEmpty() || apicultores.isEmpty()) {
        System.out.println(" Debe haber al menos una colmena y un apicultor registrados.");
        return;
    }

    
    System.out.println("🔸 Colmenas disponibles:");
    for (int i = 0; i < colmenas.size(); i++) {
        Colmena c = colmenas.get(i);
        String asignado = (c.getApicultorAsignado() == null) ? "Sin asignar" : "Asignado a " + c.getApicultorAsignado().getNombre();
        System.out.println((i + 1) + ". ID: " + c.getId() + " | " + asignado);
    }
    int colmenaIndex = Utils.solicitarEntero("Seleccione una colmena por número: ") - 1;

    if (colmenaIndex < 0 || colmenaIndex >= colmenas.size()) {
        System.out.println(" Índice de colmena inválido.");
        return;
    }

   
    System.out.println("🔹 Apicultores disponibles:");
    for (int i = 0; i < apicultores.size(); i++) {
        Apicultor a = apicultores.get(i);
        System.out.println((i + 1) + ". " + a.getNombre() + " (ID: " + a.getIdentificacion() + ")");
    }
    int apicultorIndex = Utils.solicitarEntero("Seleccione un apicultor por número: ") - 1;

    if (apicultorIndex < 0 || apicultorIndex >= apicultores.size()) {
        System.out.println(" Índice de apicultor inválido.");
        return;
    }

    Colmena colmenaSeleccionada = colmenas.get(colmenaIndex);
    if (colmenaSeleccionada.getApicultorAsignado() != null) {
        System.out.println(" Esta colmena ya tiene un apicultor asignado.");
        return;
    }

    Apicultor apicultorSeleccionado = apicultores.get(apicultorIndex);
    colmenaSeleccionada.setApicultorAsignado(apicultorSeleccionado);

    System.out.println(" Apicultor asignado correctamente a la colmena.");
}

    public static void editarInformacion() {
        // TODO: Mostrar submenú: ¿qué desea editar? (colmena, apicultor, abeja reina, inspección)
        // TODO: Según elección, mostrar lista de elementos
        // TODO: Permitir seleccionar uno
        // TODO: Pedir nuevos datos
        // TODO: Validar y aplicar cambios
        // TODO: Confirmar edición
    }
}
