package repositorio;

import com.mycompany.sistema.reservas.dominio.modelo.Reserva;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ReservaArchivoRepository implements ReservaRepository {

    private static final String NOMBRE_ARCHIVO = "reservas.txt";

    @Override
    public void guardar(Reserva reserva) {
        String linea = construirLinea(reserva);

        try (FileWriter writer = new FileWriter(NOMBRE_ARCHIVO, true)) {
            writer.write(linea + System.lineSeparator());
            System.out.println("[Repositorio Archivo] Reserva " + reserva.getId() + " registrada en " + NOMBRE_ARCHIVO);
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar la reserva en el archivo: " + e.getMessage(), e);
        }
    }

    private String construirLinea(Reserva reserva) {
        return LocalDateTime.now() + " | "
                + "ID=" + reserva.getId() + " | "
                + "Cliente=" + reserva.getCliente().getNombre() + " | "
                + "Periodo=" + reserva.getPeriodo() + " | "
                + "Estado=" + reserva.getEstado();
    }
}