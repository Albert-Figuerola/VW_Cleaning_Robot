package main.kotlin.com.volkswagen.robotcleaner.domain.model

class Grid(
    private val maxX: Int,
    private val maxY: Int
) {
    fun isInside(position: Position): Boolean =
        position.x in 0..<maxX && position.y in 0..<maxY
}