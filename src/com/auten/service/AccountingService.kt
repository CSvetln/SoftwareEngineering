package com.auten.service.softwareengineering

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

class AccountingService() {
    fun isDateValid(date: String): Boolean {
        val format = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        return try {
            LocalDate.parse(date, format)
            true
        } catch (e: DateTimeParseException) {
            false
        }
    }

    fun isVolValid(vol: String): Boolean {
        return try{
            vol.toInt()>0
        } catch (e: Exception) {
            false
        }
    }
}