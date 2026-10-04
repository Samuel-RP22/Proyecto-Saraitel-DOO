package co.com.saraitel.gestionsaraitel.transversal.utilitarios;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public final class UtilFecha {

    public static final LocalDateTime FECHA_HORA_DEFECTO = LocalDateTime.of(1800, Month.JANUARY, 1, 0, 0, 0);
    private static final ZoneId ZONA_HORARIA_COLOMBIA = ZoneId.of("America/Bogota");

    
    private UtilFecha() {
    }

    public static LocalDateTime obtenerValorDefecto(final LocalDateTime fecha, final LocalDateTime valorDefecto) {
        return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(fecha, valorDefecto);
    }

    public static LocalDateTime obtenerValorDefecto(final LocalDateTime fechaHora) {
        return obtenerValorDefecto(fechaHora, FECHA_HORA_DEFECTO);
    }

    public static LocalDateTime obtenerFechaHoraActual() {
        return LocalDateTime.now(ZONA_HORARIA_COLOMBIA);
    }
    
    public static LocalDate obtenerSoloFecha(final LocalDateTime fechaHora) {
        return obtenerValorDefecto(fechaHora).toLocalDate();
    }
    
    public static boolean esAnterior(final LocalDateTime fecha, final LocalDateTime fechaReferencia) {
        return obtenerValorDefecto(fecha).isBefore(obtenerValorDefecto(fechaReferencia));
    }

    public static boolean esPosterior(final LocalDateTime fecha, final LocalDateTime fechaReferencia) {
        return obtenerValorDefecto(fecha).isAfter(obtenerValorDefecto(fechaReferencia));
    }

    public static boolean esFechaPasada(final LocalDateTime fecha) {
        return esAnterior(fecha, obtenerFechaHoraActual());
    }

    public static boolean esFechaFutura(final LocalDateTime fecha) {
        return esPosterior(fecha, obtenerFechaHoraActual());
    }

    public static boolean esHoy(final LocalDateTime fecha) {
        return obtenerSoloFecha(fecha).equals(obtenerSoloFecha(obtenerFechaHoraActual()));
    }

    public static boolean fechaEstaEnRango(final LocalDateTime fecha, final LocalDateTime fechaInicial,
            final LocalDateTime fechaFinal) {

        var fechaComparada = obtenerValorDefecto(fecha);
        var inicio = obtenerValorDefecto(fechaInicial);
        var fin = obtenerValorDefecto(fechaFinal);

        return !fechaComparada.isBefore(inicio) && !fechaComparada.isAfter(fin);
    }

    public static int obtenerDiasEntre(final LocalDateTime fechaInicial, final LocalDateTime fechaFinal) {
        return (int) ChronoUnit.DAYS.between(obtenerSoloFecha(fechaInicial), obtenerSoloFecha(fechaFinal));
    }

    public static LocalDateTime sumarDias(final LocalDateTime fecha, final int dias) {
        return obtenerValorDefecto(fecha).plusDays(dias);
    }

    public static LocalDateTime restarDias(final LocalDateTime fecha, final int dias) {
        return obtenerValorDefecto(fecha).minusDays(dias);
    }
}