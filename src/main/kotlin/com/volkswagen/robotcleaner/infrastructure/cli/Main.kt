package main.kotlin.com.volkswagen.robotcleaner.infrastructure.cli

import main.kotlin.com.volkswagen.robotcleaner.application.ExecuteRobotUseCase
import main.kotlin.com.volkswagen.robotcleaner.infrastructure.input.InputParser
import main.kotlin.com.volkswagen.robotcleaner.infrastructure.output.OutPutFormatter

fun main() {
    println("Enter input:")

    val lines = generateSequence(::readLine)
        .takeWhile { it.isNotBlank() }
        .toList()

    val (grid, commands) = InputParser().parse(lines)

    val robots = ExecuteRobotUseCase().execute(grid, commands)
    val outPut = OutPutFormatter().format(robots)

    println("Output:")
    println(outPut)

}