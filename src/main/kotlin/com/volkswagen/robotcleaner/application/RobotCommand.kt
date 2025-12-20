package main.kotlin.com.volkswagen.robotcleaner.application

import main.kotlin.com.volkswagen.robotcleaner.domain.model.Direction
import main.kotlin.com.volkswagen.robotcleaner.domain.model.Position

data class RobotCommand (
    val position: Position,
    val direction: Direction,
    val instructions: String
)