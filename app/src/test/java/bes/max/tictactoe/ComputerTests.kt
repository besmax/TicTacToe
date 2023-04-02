package bes.max.tictactoe

import bes.max.tictactoe.game.Playground
import bes.max.tictactoe.game.player.Computer
import org.junit.Assert.assertEquals
import org.junit.Test


class ComputerTests {

    private val  playground = Playground()
    private val  computerForTest = Computer('X', playground)

    @Test
    fun makeMoveReturnsTrueWhenFindsCentralPosition() {
        playground.prepareFieldForGame()
        computerForTest.makeMove(1)

        assertEquals(true, computerForTest.makeMove(-1))
    }

}