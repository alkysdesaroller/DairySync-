package test;

import ModuloDariel.models.Vaca;
import ModuloDariel.models.RegistroSalud;
import ModuloDariel.models.RegistroReproductivo;
import ModuloDariel.usecase.VacaServicio;
import ModuloDariel.usecase.RegistroSaludServicio;
import ModuloDariel.usecase.RegistroReproductivoServicio;
import java.time.LocalDate;
/**
 *
 * @author darie
 */
public class MainTest {
    //Instancias de los servicios
    public static void main(String [] args){
    RegistroSaludServicio registroSaludServicio = new RegistroSaludServicio();
    RegistroReproductivoServicio registroReproductivoServicio = new RegistroReproductivoServicio();    
    VacaServicio vacaServicio = new VacaServicio(registroSaludServicio);
    
    //Instancia del objeto "Vaca"
    Vaca vaca1 = vacaServicio.registrarVaca("Holstein", 3, "Generacion AB", 101);
    System.out.println("Vaca nueva registrada.");
    vaca1.mostrarInfo();
    
    //Actualizamos el estado de salud de la vaca ya creada
    vacaServicio.actualizarEstadoSalud(vaca1, Vaca.EstadoSalud.SANA, "La vaca fue revisada y esta en buen estado", "Se recomiendan vitaminas para mejor desarrollo");
    System.out.println("Estado de salud de la vaca actualizado");
    vaca1.mostrarInfo();
    
    //Mostramos el historial de salud de la vaca
    System.out.println("\nHistorial de salud de la vaca:");
    vacaServicio.mostrarRegistrosSaludPorVaca(vaca1.getId());
    
    //Crear registro reproductivo de la vaca
    registroReproductivoServicio.crearRegistroReproductivo(
            0,                                          //Id del registro 
            LocalDate.of(2024, 07, 18),                  //fechaEstadoReproductivo
            LocalDate.now(),                    //fechaParto
            Vaca.EstadoReproductivo.PREÑADA,      //Estado
            102,                                  //id Madre
            101,                                  //id padre
            vaca1.getId()                                 //id de la vaca
    );
    System.out.println("\nRegistro reproductivo creado.");
    registroReproductivoServicio.mostrarTodosLosRegistros();
    
    //Actualizar estado reproductio de la vaca
    vacaServicio.actualizarEstadoReproductivo(vaca1, Vaca.EstadoReproductivo.PARIDA);
    System.out.println("\nRegistro reproductivo actualizado.");
    
    //Mostrar todas las vacas
    System.out.println("\nMostrando todas las vacas registradas: ");
    vacaServicio.mostrarTodasLasVacas();
    }
}
