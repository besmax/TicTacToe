package bes.max.tictactoe

import bes.max.tictactoe.game.Playground
import org.junit.Test
import org.junit.*

class PlaygroundTests {

    private val playgroundForTest = Playground()

    @Test
    fun prepareFieldForGamePopulatesField() {
        playgroundForTest.prepareFieldForGame()
        for (i in 1..9)
            Assert.assertEquals(' ', playgroundForTest.field[i])
    }

    @Test
    fun prepareFieldForGameChangesWinnerOfTheGame() {
        playgroundForTest.prepareFieldForGame()
        Assert.assertEquals("No one, it's a draw", playgroundForTest.winnerOfTheGame)
    }

    @Test
    fun occupyPositionOnTheFieldOccupiesAvailableCell() {
        playgroundForTest.prepareFieldForGame()
        Assert.assertEquals(true, playgroundForTest.occupyPositionOnTheField(1, '0'))
        Assert.assertEquals('0', playgroundForTest.field[1])
    }

    @Test
    fun occupyPositionOnTheFieldNotOccupiesUnavailableCell() {
        playgroundForTest.prepareFieldForGame()
        playgroundForTest.occupyPositionOnTheField(1, 'X')
        Assert.assertEquals(false, playgroundForTest.occupyPositionOnTheField(1, '0'))
        Assert.assertEquals('X', playgroundForTest.field[1])
    }

    @Test
    fun occupyPositionOnTheFieldReturnsFalseWhenPosition0() {
        playgroundForTest.prepareFieldForGame()
        Assert.assertEquals(false, playgroundForTest.occupyPositionOnTheField(0, '0'))
    }

    @Test
    fun checkTheRowsForWinnerFindsWinnerInRow() {
        playgroundForTest.prepareFieldForGame()
        playgroundForTest.occupyPositionOnTheField(1, 'X')
        playgroundForTest.occupyPositionOnTheField(2, 'X')
        playgroundForTest.occupyPositionOnTheField(3, 'X')
        Assert.assertEquals(true, playgroundForTest.checkTheRowsForWinner('X'))
    }
    @Test
    fun checkTheRowsForWinnerChangesWinner() {
        playgroundForTest.prepareFieldForGame()
        playgroundForTest.userSymbol = 'X'
        playgroundForTest.computerSymbol = '0'
        playgroundForTest.occupyPositionOnTheField(1, 'X')
        playgroundForTest.occupyPositionOnTheField(2, 'X')
        playgroundForTest.occupyPositionOnTheField(3, 'X')
        playgroundForTest.checkTheRowsForWinner('X')
        Assert.assertEquals("X", playgroundForTest.winnerOfTheGame)
    }

    @Test
    fun checkTheRowsForWinnerReturnsFalseWhenNoWinner() {
        playgroundForTest.prepareFieldForGame()
        playgroundForTest.userSymbol = 'X'
        playgroundForTest.computerSymbol = '0'
        playgroundForTest.occupyPositionOnTheField(1, 'X')
        playgroundForTest.occupyPositionOnTheField(2, '0')
        playgroundForTest.occupyPositionOnTheField(3, 'X')
        Assert.assertEquals(false, playgroundForTest.checkTheRowsForWinner('X'))
    }

    @Test
    fun checkTheColumnsForWinnerFindsWinnerInRow() {
        playgroundForTest.prepareFieldForGame()
        playgroundForTest.occupyPositionOnTheField(1, 'X')
        playgroundForTest.occupyPositionOnTheField(4, 'X')
        playgroundForTest.occupyPositionOnTheField(7, 'X')
        Assert.assertEquals(true, playgroundForTest.checkTheColumnsForWinner('X'))
    }
    @Test
    fun checkTheColumnsForWinnerChangesWinner() {
        playgroundForTest.prepareFieldForGame()
        playgroundForTest.userSymbol = 'X'
        playgroundForTest.computerSymbol = '0'
        playgroundForTest.occupyPositionOnTheField(2, 'X')
        playgroundForTest.occupyPositionOnTheField(5, 'X')
        playgroundForTest.occupyPositionOnTheField(8, 'X')
        playgroundForTest.checkTheColumnsForWinner('X')
        Assert.assertEquals("X", playgroundForTest.winnerOfTheGame)
    }

    @Test
    fun checkTheColumnsForWinnerReturnsFalseWhenNoWinner() {
        playgroundForTest.prepareFieldForGame()
        playgroundForTest.userSymbol = 'X'
        playgroundForTest.computerSymbol = '0'
        playgroundForTest.occupyPositionOnTheField(1, 'X')
        playgroundForTest.occupyPositionOnTheField(4, '0')
        playgroundForTest.occupyPositionOnTheField(7, 'X')
        Assert.assertEquals(false, playgroundForTest.checkTheColumnsForWinner('X'))
    }

    @Test
    fun checkTheDiagonalsForWinnerFindsWinnerInRow() {
        playgroundForTest.prepareFieldForGame()
        playgroundForTest.occupyPositionOnTheField(1, 'X')
        playgroundForTest.occupyPositionOnTheField(5, 'X')
        playgroundForTest.occupyPositionOnTheField(9, 'X')
        Assert.assertEquals(true, playgroundForTest.checkTheDiagonalsForWinner('X'))
    }
    @Test
    fun checkTheDiagonalsForWinnerChangesWinner() {
        playgroundForTest.prepareFieldForGame()
        playgroundForTest.userSymbol = 'X'
        playgroundForTest.computerSymbol = '0'
        playgroundForTest.occupyPositionOnTheField(1, 'X')
        playgroundForTest.occupyPositionOnTheField(5, 'X')
        playgroundForTest.occupyPositionOnTheField(9, 'X')
        playgroundForTest.checkTheDiagonalsForWinner('X')
        Assert.assertEquals("X", playgroundForTest.winnerOfTheGame)
    }

    @Test
    fun checkTheDiagonalsForWinnerReturnsFalseWhenNoWinner() {
        playgroundForTest.prepareFieldForGame()
        playgroundForTest.userSymbol = 'X'
        playgroundForTest.computerSymbol = '0'
        playgroundForTest.occupyPositionOnTheField(1, 'X')
        playgroundForTest.occupyPositionOnTheField(5, '0')
        playgroundForTest.occupyPositionOnTheField(9, 'X')
        Assert.assertEquals(false, playgroundForTest.checkTheDiagonalsForWinner('X'))
    }

    @Test
    fun doWeHaveWinnerReturnsFalseWhenWeHaveNoWinner() {
        playgroundForTest.prepareFieldForGame()
        playgroundForTest.userSymbol = 'X'
        playgroundForTest.computerSymbol = '0'
        playgroundForTest.occupyPositionOnTheField(1, 'X')
        playgroundForTest.occupyPositionOnTheField(5, '0')
        playgroundForTest.occupyPositionOnTheField(9, 'X')
        Assert.assertEquals(false, playgroundForTest.doWeHaveWinner('X'))
    }

    @Test
    fun findPositionsWithSymbolReturnsCorrectList() {
        playgroundForTest.prepareFieldForGame()
        playgroundForTest.occupyPositionOnTheField(1, 'X')
        playgroundForTest.occupyPositionOnTheField(5, '0')
        playgroundForTest.occupyPositionOnTheField(9, 'X')
        val actual = playgroundForTest.findPositionsWithSymbol('X')
        Assert.assertEquals(1, actual[0])
        Assert.assertEquals(9, actual[1])
    }

}