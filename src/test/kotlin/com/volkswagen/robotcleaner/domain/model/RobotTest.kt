package test.kotlin.com.volkswagen.robotcleaner.domain.model

import main.kotlin.com.volkswagen.robotcleaner.domain.model.Direction
import main.kotlin.com.volkswagen.robotcleaner.domain.model.Grid
import main.kotlin.com.volkswagen.robotcleaner.domain.model.Position
import main.kotlin.com.volkswagen.robotcleaner.domain.model.Robot
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RobotTest {

    @Test
    @DisplayName("Test of the first commands")
    fun testExecuteFirstCommandTest() {
        val grid = Grid(5, 5)
        val robot = Robot(
            Position(1, 2),
            Direction.N,
            grid = grid
        )

        robot.execute("LMLMLMLMM")

        assertEquals(Position(1, 3), robot.position)
        assertEquals(Direction.N, robot.direction)
    }

    @Test
    @DisplayName("Test of the second commands")
    fun testExecuteSecondCommandTest() {
        val grid = Grid(5, 5)
        val robot = Robot(
            Position(3, 3),
            Direction.E,
            grid = grid
        )

        robot.execute("MMRMMRMRRM")

        assertEquals(Position(5, 1), robot.position)
        assertEquals(Direction.E, robot.direction)
    }

    @Test
    @DisplayName("Testing the wall")
    fun testWall() {
        val grid = Grid(5, 5)
        val robot = Robot(
            Position(0, 0),
            Direction.S,
            grid = grid
        )

        robot.execute("M")

        assertEquals(Position(0,0), robot.position)
    }

}