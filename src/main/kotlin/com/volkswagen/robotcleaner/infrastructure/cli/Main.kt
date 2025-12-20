package main.kotlin.com.volkswagen.robotcleaner.infrastructure.cli

import main.kotlin.com.volkswagen.robotcleaner.application.usecase.ExecuteRobotUseCase
import main.kotlin.com.volkswagen.robotcleaner.infrastructure.input.parser.InputParser
import main.kotlin.com.volkswagen.robotcleaner.infrastructure.output.OutputFormatter

fun main() {
    println("Enter input:")

    val lines = generateSequence(::readLine)
        .takeWhile { it.isNotBlank() }
        .toList()

    val (grid, commands) = InputParser().parse(lines)

    val robots = ExecuteRobotUseCase().run(grid, commands)
    val outPut = OutputFormatter().format(robots)

    println("Output:")
    println(outPut)

}