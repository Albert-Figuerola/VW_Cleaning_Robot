package test.kotlin.com.volkswagen.robotcleaner.domain.model

import main.kotlin.com.volkswagen.robotcleaner.domain.model.Direction
import main.kotlin.com.volkswagen.robotcleaner.domain.model.Grid
import main.kotlin.com.volkswagen.robotcleaner.domain.model.Position
import main.kotlin.com.volkswagen.robotcleaner.domain.model.Robot
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class GridTest {

    @Test
    @DisplayName("Testing the grid")
    fun testGrid() {
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