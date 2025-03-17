package modelo;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
/**
 *
 * @author Dariel Capellan
 */
public class Vaca {
    private int id;
    private String raza;
    private int edad;
    private String genealogia;
    private int granjaId;
    private EstadoSalud estadoSalud;
    private EstadoReproductivo estadoReproductivo;

    private List<RegistroSalud> historialSalud = new ArrayList<>();
    private int contadorRegistros = 1;

    // Enum anidado dentro de la clase Vaca
    public enum EstadoSalud {
        SANA,
        ENFERMA,
        EN_OBSERVACION
    }

    public enum EstadoReproductivo {
        GESTANTE,
        DISPONIBLE,
        NO_CONOCIDO
    }

    // Constructor
    public Vaca(int id, String raza, int edad, String genealogia, int granjaId, EstadoSalud estadoSalud, EstadoReproductivo estadoReproductivo) {
        this.id = id;
        this.raza = raza;
        this.edad = edad;
        this.genealogia = genealogia;
        this.granjaId = granjaId;
        this.estadoSalud = estadoSalud != null ? estadoSalud : EstadoSalud.EN_OBSERVACION;
        this.estadoReproductivo = estadoReproductivo != null ? estadoReproductivo : EstadoReproductivo.NO_CONOCIDO;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) {
        if (edad >= 0) {
            this.edad = edad;
        } else {
            System.out.println("La edad no puede ser negativa.");
        }
    }

    public String getGenealogia() { return genealogia; }
    public void setGenealogia(String genealogia) { this.genealogia = genealogia; }

    public int getGranjaId() { return granjaId; }
    public void setGranjaId(int granjaId) { this.granjaId = granjaId; }

    public EstadoSalud getEstadoSalud() { return estadoSalud; }

    public EstadoReproductivo getEstadoReproductivo() { return estadoReproductivo; }

    public void actualizarDatos(String nuevaRaza, int nuevaEdad, String nuevaGenealogia, int nuevoGranjaId, EstadoSalud nuevoEstadoSalud, EstadoReproductivo nuevoEstadoReproductivo) {
        this.setRaza(nuevaRaza);
        this.setEdad(nuevaEdad);
        this.setGenealogia(nuevaGenealogia);
        this.setGranjaId(nuevoGranjaId);
        this.actualizarEstadoSalud(nuevoEstadoSalud, "Actualización de datos", "Sin tratamiento");
        this.actualizarEstadoReproductivo(nuevoEstadoReproductivo);
    }

    public void actualizarEstadoSalud(EstadoSalud nuevoEstadoSalud, String descripcion, String tratamiento) {
        if (nuevoEstadoSalud != null) {
            this.estadoSalud = nuevoEstadoSalud;
                RegistroSalud registro = new RegistroSalud(contadorRegistros++, this.id, java.time.LocalDate.now(), nuevoEstadoSalud, descripcion, tratamiento);
            historialSalud.add(registro);
            System.out.println("Estado de salud actualizado a: " + nuevoEstadoSalud);
        } else {
            System.out.println("Estado de salud no válido.");
        }
    }

    public void actualizarEstadoReproductivo(EstadoReproductivo nuevoEstadoReproductivo) {
        if (nuevoEstadoReproductivo != null) {
            this.estadoReproductivo = nuevoEstadoReproductivo;
            System.out.println("Estado reproductivo actualizado a: " + nuevoEstadoReproductivo);
        } else {
            System.out.println("Estado reproductivo no válido.");
        }
    }

    public void mostrarInfo() {
        System.out.println("ID: " + id +
                ", Raza: " + raza +
                ", Edad: " + edad +
                ", Genealogía: " + genealogia +
                ", Granja ID: " + granjaId +
                ", Estado de salud: " + estadoSalud +
                ", Estado reproductivo: " + estadoReproductivo);
    }

    public void mostrarHistorialSalud() {
        System.out.println("Historial de salud de la vaca ID: " + id);
        for (RegistroSalud registro : historialSalud) {
            registro.mostrarRegistro();
        }
    }
}
