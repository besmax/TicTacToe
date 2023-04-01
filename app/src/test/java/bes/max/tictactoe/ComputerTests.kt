package bes.max.tictactoe

import bes.max.tictactoe.game.Playground
import bes.max.tictactoe.game.player.Computer
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito
import org.mockito.Mockito.anyChar
import org.mockito.Mockito.mock


class ComputerTests {

    private val  playground = Playground()
    private val  computerForTest = Computer('X', playground)

    @Test
    fun makeMoveReturnsTrueWhenFindsCentralPosition() {
        playground.prepareFieldForGame()
        computerForTest.makeMove(1)

        assertEquals(true, computerForTest.makeMove(-1))
    }

    @Test
    fun makeMoveReturnsFalseWhenNoAvailablePosition() {
        val playgroundMock = mock(Playground::class.java)
        val  computerForTestWithMock = Computer('X', playgroundMock)
        Mockito.`when`(playgroundMock.findPositionsWithSymbol(anyChar())).thenReturn(null)
        repeat(9) {
            computerForTestWithMock.makeMove(1)
        }

        assertEquals(false, computerForTestWithMock.makeMove(-1))
    }

}