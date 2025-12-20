package main.kotlin.com.volkswagen.robotcleaner.infrastructure

import main.kotlin.com.volkswagen.robotcleaner.application.RobotCommand
import main.kotlin.com.volkswagen.robotcleaner.domain.model.Direction
import main.kotlin.com.volkswagen.robotcleaner.domain.model.Grid
import main.kotlin.com.volkswagen.robotcleaner.domain.model.Position

class InputParser {

    fun parse(lines: List<String>): Pair<Grid, List<RobotCommand>> {
        val (maxX, maxY) = lines.first().split(" ").map { it.toInt() }
        val grid = Grid(maxX, maxY)

        val commands: MutableList<RobotCommand> = mutableListOf()

        var positionLine = 1

        while (positionLine < lines.size) {
            val (x, y, direction) = lines[positionLine].split(" ")
            val instructionLine = lines[positionLine + 1]

            commands.add(
                RobotCommand(
                    position = Position(x.toInt(), y.toInt()),
                    direction = Direction.valueOf(direction),
                    instructions = instructionLine
                )
            )

            positionLine += 2
        }
        return Pair(grid, commands)
    }

}