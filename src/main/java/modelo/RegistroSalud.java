package modelo;
import java.time.LocalDate;

/**
 *
 * @author Dariel Capellan
 */
public class RegistroSalud {
    private int id;
    private int vacaId;
    private LocalDate fecha;
    private Vaca.EstadoSalud estadoSalud;
    private String descripcion;
    private String tratamiento;
       
    //Constructor
public RegistroSalud(int id, int vacaId, LocalDate fecha, Vaca.EstadoSalud estadoSalud, String descripcion, String tratamiento){
    this.id = id;
    this.vacaId = vacaId;
    this.fecha = fecha;
    this.estadoSalud = estadoSalud;
    this.descripcion = descripcion;
    this.tratamiento = tratamiento;
    }

    //Getters y Setters
public int getId(){return id;}
public void setId(int Id){this.id = id;}

public int getVacaId(){return vacaId;}
public void setvacaId(int vacaId){this.vacaId = vacaId;}

public LocalDate getFecha() { return fecha; }
public void setFecha(LocalDate fecha) { this.fecha = fecha; }

public Vaca.EstadoSalud getEstadoSalud(){ return estadoSalud; }
public void setEstadoSalud(Vaca.EstadoSalud estadoSalud){ this.estadoSalud = estadoSalud; }

public String getDescripcion(){return descripcion;}
public void setdescripcion(String descripcion){this.descripcion = descripcion;}

public String getTratamiento(){return tratamiento;}
public void settratamiento(String tratamiento){this.tratamiento = tratamiento;}

    //Metodo registrar un nuevo estado de salud
public void actualizarRegistroSalud(Vaca.EstadoSalud nuevoEstado, String nuevaDescripcion, String nuevoTratamiento, LocalDate nuevaFecha){
        this.fecha = nuevaFecha;
        this.estadoSalud = nuevoEstado;
        this.descripcion = nuevaDescripcion;
        this.tratamiento = nuevoTratamiento;

        System.out.println("Registro de salud actualizado.");
    }
public void mostrarRegistro() {
    System.out.println("Registro #" + id +
        ": Fecha: " + fecha +
        ", Estado de salud: " + estadoSalud +
        ", Descripción: " + descripcion +
        ", Tratamiento: " + tratamiento);
    }
}

