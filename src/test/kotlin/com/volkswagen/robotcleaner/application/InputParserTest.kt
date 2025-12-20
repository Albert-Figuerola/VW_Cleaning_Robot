package test.kotlin.com.volkswagen.robotcleaner.application

import main.kotlin.com.volkswagen.robotcleaner.domain.model.Direction
import main.kotlin.com.volkswagen.robotcleaner.domain.model.Position
import main.kotlin.com.volkswagen.robotcleaner.infrastructure.input.InputParser
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class InputParserTest {

    private val parser = InputParser()

    @Test
    @DisplayName("Test of the input parser")
    fun testParse() {
        val input = listOf(
            "5 5",
            "1 2 N",
            "LMLMLMLMM",
            "3 3 E",
            "MMRMMRMRRM"
        )

        val (grid, commands) = parser.parse(input)

        assertEquals(2, commands.size)

        val firstCommand = commands.first()
        assertEquals(Position(1, 2), firstCommand.position)
        assertEquals(Direction.N, firstCommand.direction)
        assertEquals("LMLMLMLMM", firstCommand.instructions)

        val secondCommand = commands[1]
        assertEquals(Position(3, 3), secondCommand.position)
        assertEquals(Direction.E, secondCommand.direction)
        assertEquals("MMRMMRMRRM", secondCommand.instructions)


        assertTrue(grid.isInside(Position(5, 5)))
    }

}