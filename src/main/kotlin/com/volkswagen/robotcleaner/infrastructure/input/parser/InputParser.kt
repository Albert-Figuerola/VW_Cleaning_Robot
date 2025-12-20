package main.kotlin.com.volkswagen.robotcleaner.infrastructure.input.parser

import main.kotlin.com.volkswagen.robotcleaner.application.dto.RobotCommand
import main.kotlin.com.volkswagen.robotcleaner.domain.model.Direction
import main.kotlin.com.volkswagen.robotcleaner.domain.model.Grid
import main.kotlin.com.volkswagen.robotcleaner.domain.model.Position
import main.kotlin.com.volkswagen.robotcleaner.infrastructure.input.validator.InputValidator

class InputParser(
    private val validator: InputValidator = InputValidator()
) {

    fun parse(lines: List<String>): Pair<Grid, List<RobotCommand>> {
        validator.validateInput(lines)
        validator.validateGrid(lines.first())

        val (maxX, maxY) = lines.first().split(" ").map { it.toInt() }
        val grid = Grid(maxX, maxY)

        val commands: MutableList<RobotCommand> = mutableListOf()

        var positionLine = 1

        while (positionLine < lines.size) {
            val instructionsLine = positionLine + 1

            validator.validatePosition(lines[positionLine])
            validator.validateInstructions(lines[instructionsLine])

            val (x, y, direction) = lines[positionLine].split(" ")
            val instructions = lines[instructionsLine]

            commands.add(
                RobotCommand(
                    position = Position(x.toInt(), y.toInt()),
                    direction = Direction.valueOf(direction),
                    instructions = instructions
                )
            )

            positionLine += 2
        }

        return Pair(grid, commands)
    }

}