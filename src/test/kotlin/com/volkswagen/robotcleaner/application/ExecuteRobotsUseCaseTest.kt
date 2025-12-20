package test.kotlin.com.volkswagen.robotcleaner.application

import main.kotlin.com.volkswagen.robotcleaner.application.usecase.ExecuteRobotUseCase
import main.kotlin.com.volkswagen.robotcleaner.application.dto.RobotCommand
import main.kotlin.com.volkswagen.robotcleaner.domain.model.Direction
import main.kotlin.com.volkswagen.robotcleaner.domain.model.Grid
import main.kotlin.com.volkswagen.robotcleaner.domain.model.Position
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ExecuteRobotsUseCaseTest {

    @Test
    @DisplayName("Testing ExecuteRobotsUseCase")
    fun testExecuteRobotsUseCase() {
        val grid = Grid(5, 5)
        val commands = listOf(
            RobotCommand(
                Position(1, 2),
                Direction.N,
                "LMLMLMLMM"
            ),
            RobotCommand(
                Position(3, 3),
                Direction.E,
                "MMRMMRMRRM"
            )
        )

        val useCase = ExecuteRobotUseCase()

        val result = useCase.run(grid, commands)

        assertEquals(2, result.size)

        assertEquals(Position(1, 3), result[0].position)
        assertEquals(Direction.N, result[0].direction)

        assertEquals(Position(5, 1), result[1].position)
        assertEquals(Direction.E, result[1].direction)
    }

}