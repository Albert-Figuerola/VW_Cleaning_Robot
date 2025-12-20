package main.kotlin.com.volkswagen.robotcleaner.domain.model

enum class Direction {
    N, E, S, W;

    fun turnLeft(): Direction = when (this) {
        N -> W
        W -> S
        S -> E
        E -> N
    }

    fun turnRight(): Direction = when (this) {
        N -> E
        E -> S
        S -> W
        W -> N
    }

    fun moveForward(position: Position): Position = when (this) {
        N -> position.copy(y = position.y + 1)
        E -> position.copy(x = position.x + 1)
        S -> position.copy(y = position.y - 1)
        W -> position.copy(x = position.x - 1)
    }

}