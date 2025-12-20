package main.kotlin.com.volkswagen.robotcleaner.infrastructure.output

import main.kotlin.com.volkswagen.robotcleaner.domain.model.Robot

class OutputFormatter {

    fun format(robots: List<Robot>): String =
        robots.joinToString("\n") {
            "${it.position.x} ${it.position.y} ${it.direction}"
        }

}