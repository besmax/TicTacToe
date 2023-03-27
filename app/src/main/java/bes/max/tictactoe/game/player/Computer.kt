package bes.max.tictactoe.game.player

import bes.max.tictactoe.game.Playground
import java.util.*

class Computer(
    override var symbol: Char,
    private val playground: Playground
) : Player {

    override fun makeMove(positionNumber: Int): Boolean {
        while(true) {
            return when {
                occupyPosition(findPositionNumber(playground.findPositionsWithSymbol(defineUserSymbol()))) -> true
                occupyPosition(findPositionNumber(playground.findPositionsWithSymbol(defineUserSymbol()))) -> true
                occupyPosition(findRandomPosition()) -> true
                else -> false
            }
        }
    }

    private fun findPositionNumber(positions: List<Int?>): Int {
        var result = 0
        val availablePositions = playground.findPositionsWithSymbol(' ')
        if (availablePositions!!.contains(5)) result = 5
        if (positions.contains(1) && positions.contains(2) && availablePositions.contains(3) ||
            positions.contains(6) && positions.contains(9) && availablePositions.contains(3) ||
            positions.contains(5) && positions.contains(7) && availablePositions.contains(3)
        )
            result = 3 else if (
            positions.contains(2) && positions.contains(3) && availablePositions.contains(1) ||
            positions.contains(4) && positions.contains(7) && availablePositions.contains(1) ||
            positions.contains(5) && positions.contains(9) && availablePositions.contains(1)
        )
            result = 1 else if (
            positions.contains(1) && positions.contains(3) && availablePositions.contains(2) ||
            positions.contains(5) && positions.contains(8) && availablePositions.contains(2)
        )
            result = 2 else if (
            positions.contains(1) && positions.contains(7) && availablePositions.contains(4) ||
            positions.contains(5) && positions.contains(6) && availablePositions.contains(4)
        )
            result = 4 else if (
            positions.contains(4) && positions.contains(5) && availablePositions.contains(6) ||
            positions.contains(3) && positions.contains(9) && availablePositions.contains(6)
        )
            result = 6 else if (
            positions.contains(1) && positions.contains(4) && availablePositions.contains(7)
            || positions.contains(3) && positions.contains(5) && availablePositions.contains(7) ||
            positions.contains(8) && positions.contains(9) && availablePositions.contains(7)
        ) result =7 else if (
            positions.contains(7) && positions.contains(9) && availablePositions.contains(8) ||
            positions.contains(2) && positions.contains(5) && availablePositions.contains(8))
            result =8 else if (
            positions.contains(1) && positions.contains(5) && availablePositions.contains(9) ||
            positions.contains(3) && positions.contains(6) && availablePositions.contains(9) ||
            positions.contains(7) && positions.contains(8) && availablePositions.contains(9)
        ) result = 9
        return result
    }

    private fun findRandomPosition(): Int {
        val availablePositions = playground.findPositionsWithSymbol(' ')
        return availablePositions!![Random().nextInt(availablePositions.size)]
    }

    fun occupyPosition(positionNumber: Int): Boolean {
        var result = false
        if (playground.occupyPositionOnTheField(positionNumber, symbol)) result = true
        return result
    }

    fun defineUserSymbol(): Char {
        return if (symbol == '0') 'X' else '0'
    }
}