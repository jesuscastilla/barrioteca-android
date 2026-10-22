package com.lebeche.barrioteca.sync

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.Locale

/**
 * Utilidades de fechas compartidas por la sincronización y las notificaciones.
 * Se extraen de `SyncEngine` para poder testearlas sin depender del reloj real.
 */
object DateUtils {

    private val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.US)
    private val outputFormatter = DateTimeFormatter.ofPattern("d 'de' MMMM", Locale.forLanguageTag("es-ES"))

    /**
     * Días entre `today` y `dateStr` (formato `yyyy-MM-dd`).
     * Valor negativo = fecha pasada. Devuelve `null` si la fecha es inválida.
     */
    fun daysUntil(dateStr: String, today: LocalDate = LocalDate.now()): Int? {
        if (dateStr.isBlank()) return null
        return runCatching {
            val target = LocalDate.parse(dateStr.trim(), inputFormatter)
            ChronoUnit.DAYS.between(today, target).toInt()
        }.getOrNull()
    }

    /** Formatea `yyyy-MM-dd` como `"d de MMMM"` en español. */
    fun formatDate(dateStr: String): String {
        return runCatching {
            val d = LocalDate.parse(dateStr.trim(), inputFormatter)
            d.format(outputFormatter)
        }.getOrDefault(dateStr)
    }
}
