package politicas;
 
/**
 *
 * @author DanielMafla
 */
public class DescuentoEstadiaLarga implements PoliticaDescuento {
 
    private final int diasEstadia; // cantidad de días que dura la reserva
 
    // El servicio que use esta política debe calcular los días
    // (fechaFin - fechaInicio) y pasarlos aquí al crear el objeto.
    public DescuentoEstadiaLarga(int diasEstadia) {
        this.diasEstadia = diasEstadia;
    }
 
    @Override
    public double aplicarDescuento(double montoBase) {
        if (diasEstadia > 7) {
            return montoBase * 0.75; // 25% de descuento
        }
        return montoBase; // si no supera 7 días, no aplica el descuento
    }
}
 