package co.com.saraitel.gestionsaraitel.transversal.utilitarios;

import java.time.*;
import java.time.temporal.ChronoUnit;

public final class UtilFecha {

    public static final LocalDate FECHA_DEFECTO = LocalDate.of(1800, Month.JANUARY, 1);
    public static final LocalDateTime FECHA_HORA_DEFECTO = LocalDateTime.of(1800, Month.JANUARY, 1, 0, 0, 0);
    public static final LocalDate FECHA_COLOMBIA = LocalDate.now(ZoneId.of("America/Bogota"));
    public static final LocalDateTime FECHA_HORA_COLOMBIA = LocalDateTime.now(ZoneId.of("America/Bogota"));

    private UtilFecha() {
    }

    public static boolean esNula(final LocalDate fecha) {
        return UtilObjeto.esNulo(fecha);
    }

    public static boolean esNula(final LocalDateTime fechaHora) {
        return UtilObjeto.esNulo(fechaHora);
    }

    public static LocalDate obtenerValorDefecto(final LocalDate fecha, final LocalDate valorDefecto) {
        return esNula(fecha) ? valorDefecto : fecha;
    }

    public static LocalDate obtenerValorDefecto(final LocalDate fecha) {
        return obtenerValorDefecto(fecha, FECHA_DEFECTO);
    }

    public static LocalDateTime obtenerValorDefecto(final LocalDateTime fechaHora, final LocalDateTime valorDefecto) {
        return esNula(fechaHora) ? valorDefecto : fechaHora;
    }

    public static LocalDateTime obtenerValorDefecto(final LocalDateTime fechaHora) {
        return obtenerValorDefecto(fechaHora, FECHA_HORA_DEFECTO);
    }

    public static LocalDate obtenerFechaActual() {
        return FECHA_COLOMBIA;
    }

    public static LocalDateTime obtenerFechaHoraActual() {
        return FECHA_HORA_COLOMBIA;
    }

    public static LocalDate obtenerSoloFecha(final LocalDateTime fechaHora) {
        return obtenerValorDefecto(fechaHora).toLocalDate();
    }
    
    public static boolean esAnterior(final LocalDate fecha, final LocalDate fechaReferencia) {
        return obtenerValorDefecto(fecha).isBefore(obtenerValorDefecto(fechaReferencia));
    }

    public static boolean esPosterior(final LocalDate fecha, final LocalDate fechaReferencia) {
        return obtenerValorDefecto(fecha).isAfter(obtenerValorDefecto(fechaReferencia));
    }

    public static boolean esFechaPasada(final LocalDate fecha) {
        return esAnterior(fecha, obtenerFechaActual());
    }

    public static boolean esFechaFutura(final LocalDate fecha) {
        return esPosterior(fecha, obtenerFechaActual());
    }

    public static boolean esHoy(final LocalDate fecha) {
        return obtenerFechaActual().equals(fecha);
    }

    public static boolean fechaEstaEnRango(final LocalDate fecha, final LocalDate fechaInicial,
            final LocalDate fechaFinal, final boolean incluirExtremos) {

        var fechaSegura = obtenerValorDefecto(fecha);
        var inicio = obtenerValorDefecto(fechaInicial);
        var fin = obtenerValorDefecto(fechaFinal);

        return incluirExtremos
                ? !fechaSegura.isBefore(inicio) && !fechaSegura.isAfter(fin)
                : fechaSegura.isAfter(inicio) && fechaSegura.isBefore(fin);
    }

    public static int obtenerDiasEntre(final LocalDate fechaInicial, final LocalDate fechaFinal) {
        return (int) ChronoUnit.DAYS.between(obtenerValorDefecto(fechaInicial), obtenerValorDefecto(fechaFinal));
    }

    public static LocalDate sumarDias(final LocalDate fecha, final int dias) {
        return obtenerValorDefecto(fecha).plusDays(dias);
    }

    public static LocalDate restarDias(final LocalDate fecha, final int dias) {
        return obtenerValorDefecto(fecha).minusDays(dias);
    }
}