package bes.max.tictactoe.game.player

import bes.max.tictactoe.game.Playground

class Human(
    override var symbol: Char,
    private val playground: Playground
): Player {
    override fun makeMove(positionNumber: Int): Boolean
    = playground.occupyPositionOnTheField(positionNumber, symbol)
}