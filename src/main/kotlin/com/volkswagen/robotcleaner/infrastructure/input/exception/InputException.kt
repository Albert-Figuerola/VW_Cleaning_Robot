package main.kotlin.com.volkswagen.robotcleaner.infrastructure.input.exception

sealed class InputException(message: String) : RuntimeException(message)

class InvalidInputException(message: String) :
    InputException(message)

class InvalidGridException(input: String) :
    InputException("Invalid grid format: $input. Expected format: 'N N' (Int)")

class InvalidPositionException(input: String, message: String? = null) :
    InputException("Invalid robot position: $input. Expected format: 'X Y D'. $message")

class InvalidInstructionsException(input: String) :
    InputException("Invalid robot instructions: $input. Only L, R and M are allowed (uppercase)")