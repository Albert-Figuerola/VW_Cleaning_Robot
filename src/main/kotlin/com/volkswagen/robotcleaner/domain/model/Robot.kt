package main.kotlin.com.volkswagen.robotcleaner.domain.model

class Robot (
    initPosition: Position,
    initDirection: Direction,
    private val grid: Grid
) {
    var position: Position = initPosition
    var direction: Direction = initDirection

    fun executeInstructions(instructions: String) {
        instructions.forEach { instruction ->
            when (instruction) {
                'L' -> direction = direction.turnLeft()
                'R' -> direction = direction.turnRight()
                'M' -> moveForward()
                else -> throw IllegalArgumentException("Invalid instruction: $instruction")
            }
        }
    }

    private fun moveForward() {
        val nextPosition = direction.moveForward(position)
        if (grid.isInside(nextPosition)) {
            position = nextPosition
        }
    }

}