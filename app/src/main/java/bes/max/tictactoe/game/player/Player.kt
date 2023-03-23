package bes.max.tictactoe.game.player

import bes.max.tictactoe.game.Playground

interface Player {

    abstract fun makeMove(positionNumber: Int): Boolean
}