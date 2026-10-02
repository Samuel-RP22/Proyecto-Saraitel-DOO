package co.com.saraitel.gestionsaraitel.transversal.utilitarios;

import java.time.*;
import java.time.temporal.ChronoUnit;

public final class UtilFecha {

    private static volatile UtilFecha INSTANCIA;

    public static final LocalDate FECHA_DEFECTO = LocalDate.of(1900, 1, 1);
    public static final LocalDateTime FECHA_HORA_DEFECTO = LocalDateTime.of(1900, 1, 1, 0, 0, 0);

    private UtilFecha() {
    }

    public static UtilFecha getUtilFecha() {
        if (UtilObjeto.esNulo(INSTANCIA)) {
            synchronized (UtilFecha.class) {
                if (UtilObjeto.esNulo(INSTANCIA)) {
                    INSTANCIA = new UtilFecha();
                }
            }
        }
        return INSTANCIA;
    }

    // ---------- Validación de nulos ----------

    public boolean esNula(final LocalDate fecha) {
        return UtilObjeto.esNulo(fecha);
    }

    public boolean esNula(final LocalDateTime fechaHora) {
        return UtilObjeto.esNulo(fechaHora);
    }

    // ---------- Valores por defecto ----------

    public LocalDate obtenerValorDefecto(final LocalDate fecha, final LocalDate valorDefecto) {
        return esNula(fecha) ? valorDefecto : fecha;
    }

    public LocalDate obtenerValorDefecto(final LocalDate fecha) {
        return obtenerValorDefecto(fecha, FECHA_DEFECTO);
    }

    public LocalDateTime obtenerValorDefecto(final LocalDateTime fechaHora, final LocalDateTime valorDefecto) {
        return esNula(fechaHora) ? valorDefecto : fechaHora;
    }

    public LocalDateTime obtenerValorDefecto(final LocalDateTime fechaHora) {
        return obtenerValorDefecto(fechaHora, FECHA_HORA_DEFECTO);
    }

    // ---------- Fecha y hora actual ----------

    public LocalDate obtenerFechaActual() {
        return LocalDate.now();
    }

    public LocalDateTime obtenerFechaHoraActual() {
        return LocalDateTime.now();
    }

    // ---------- Conversiones ----------

    public LocalDate obtenerSoloFecha(final LocalDateTime fechaHora) {
        return obtenerValorDefecto(fechaHora).toLocalDate();
    }

    public LocalDateTime obtenerInicioDelDia(final LocalDate fecha) {
        return obtenerValorDefecto(fecha).atStartOfDay();
    }

    // ---------- Comparaciones ----------

    public boolean esAnterior(final LocalDate fecha, final LocalDate fechaReferencia) {
        return obtenerValorDefecto(fecha).isBefore(obtenerValorDefecto(fechaReferencia));
    }

    public boolean esPosterior(final LocalDate fecha, final LocalDate fechaReferencia) {
        return obtenerValorDefecto(fecha).isAfter(obtenerValorDefecto(fechaReferencia));
    }

    public boolean esFechaPasada(final LocalDate fecha) {
        return esAnterior(fecha, obtenerFechaActual());
    }

    public boolean esFechaFutura(final LocalDate fecha) {
        return esPosterior(fecha, obtenerFechaActual());
    }

    public boolean esHoy(final LocalDate fecha) {
        return obtenerFechaActual().equals(fecha);
    }

    public boolean fechaEstaEnRango(final LocalDate fecha, final LocalDate fechaInicial,
            final LocalDate fechaFinal, final boolean incluirExtremos) {

        var fechaSegura = obtenerValorDefecto(fecha);
        var inicio = obtenerValorDefecto(fechaInicial);
        var fin = obtenerValorDefecto(fechaFinal);

        return incluirExtremos
                ? !fechaSegura.isBefore(inicio) && !fechaSegura.isAfter(fin)
                : fechaSegura.isAfter(inicio) && fechaSegura.isBefore(fin);
    }

    // ---------- Cálculos ----------

    public long obtenerDiasEntre(final LocalDate fechaInicial, final LocalDate fechaFinal) {
        return ChronoUnit.DAYS.between(obtenerValorDefecto(fechaInicial), obtenerValorDefecto(fechaFinal));
    }

    public int obtenerEdad(final LocalDate fechaNacimiento) {
        return Period.between(obtenerValorDefecto(fechaNacimiento), obtenerFechaActual()).getYears();
    }

    public LocalDate sumarDias(final LocalDate fecha, final long dias) {
        return obtenerValorDefecto(fecha).plusDays(dias);
    }

    public LocalDate restarDias(final LocalDate fecha, final long dias) {
        return obtenerValorDefecto(fecha).minusDays(dias);
    }
}