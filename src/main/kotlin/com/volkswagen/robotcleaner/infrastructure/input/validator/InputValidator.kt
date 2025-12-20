package main.kotlin.com.volkswagen.robotcleaner.infrastructure.input.validator

import main.kotlin.com.volkswagen.robotcleaner.infrastructure.input.exception.InvalidGridException
import main.kotlin.com.volkswagen.robotcleaner.infrastructure.input.exception.InvalidInputException
import main.kotlin.com.volkswagen.robotcleaner.infrastructure.input.exception.InvalidInstructionsException
import main.kotlin.com.volkswagen.robotcleaner.infrastructure.input.exception.InvalidPositionException

class InputValidator {

    fun validateInput(lines: List<String>) {
        if (lines.isEmpty() || lines.size == 1 || lines.size % 2 == 0) {
            throw InvalidInputException("The data rows are incorrect.")
        }
    }

    fun validateGrid(line: String) {
        val parts = line.split(" ")

        if (parts.size != 2) {
            throw InvalidGridException(line)
        }

        parts.forEach { part ->
            if (part.toIntOrNull() == null) {
                throw InvalidGridException(line)
            }
        }
    }

    fun validatePosition(line: String) {
        val parts = line.split(" ")

        if (parts.size != 3) {
            throw InvalidPositionException(line)
        }

        if (parts[0].toIntOrNull() == null || parts[1].toIntOrNull() == null) {
            throw InvalidPositionException(line, "Position coordinates must be integers.")
        }

        if (parts[2] !in listOf("N", "E", "S", "W")) {
            throw InvalidPositionException(line, "Direction must be one of N, E, S or W.")
        }
    }

    fun validateInstructions(line: String) {
        if (line.isEmpty()) {
            throw InvalidInstructionsException(line)
        }

        if (!line.all { it.toString() in listOf("L", "R", "M") }) {
            throw InvalidInstructionsException(line)
        }
    }

}