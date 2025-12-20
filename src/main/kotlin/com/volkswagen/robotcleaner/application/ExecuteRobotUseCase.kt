package main.kotlin.com.volkswagen.robotcleaner.application

import main.kotlin.com.volkswagen.robotcleaner.domain.model.Grid
import main.kotlin.com.volkswagen.robotcleaner.domain.model.Robot

class ExecuteRobotUseCase {

    fun execute(grid: Grid, commands: List<RobotCommand>): List<Robot> {
        return commands.map {
            val robot = Robot(
                it.position,
                it.direction,
                grid
            )
            robot.executeInstructions(it.instructions)
            robot
        }
    }

}