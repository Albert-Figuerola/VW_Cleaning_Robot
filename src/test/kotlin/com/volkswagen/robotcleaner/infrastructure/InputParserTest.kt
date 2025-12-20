package test.kotlin.com.volkswagen.robotcleaner.infrastructure

import main.kotlin.com.volkswagen.robotcleaner.domain.model.Direction
import main.kotlin.com.volkswagen.robotcleaner.domain.model.Position
import main.kotlin.com.volkswagen.robotcleaner.infrastructure.input.parser.InputParser
import org.junit.jupiter.api.Assertions
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

        Assertions.assertEquals(2, commands.size)

        val firstCommand = commands.first()
        Assertions.assertEquals(Position(1, 2), firstCommand.position)
        Assertions.assertEquals(Direction.N, firstCommand.direction)
        Assertions.assertEquals("LMLMLMLMM", firstCommand.instructions)

        val secondCommand = commands[1]
        Assertions.assertEquals(Position(3, 3), secondCommand.position)
        Assertions.assertEquals(Direction.E, secondCommand.direction)
        Assertions.assertEquals("MMRMMRMRRM", secondCommand.instructions)


        Assertions.assertTrue(grid.isInside(Position(5, 5)))
    }

}