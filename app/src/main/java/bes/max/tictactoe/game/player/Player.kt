package bes.max.tictactoe.game.player

import bes.max.tictactoe.game.Playground

interface Player {

    abstract var symbol: Char

    abstract fun makeMove(positionNumber: Int = -1): Boolean
}