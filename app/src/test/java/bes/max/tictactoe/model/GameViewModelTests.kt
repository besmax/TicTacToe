package bes.max.tictactoe.model

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import bes.max.tictactoe.model.GameViewModel
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test

class GameViewModelTests {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun gameFieldIsUpdatedAfterUserMove() {
        val gameViewModel = GameViewModel()
        gameViewModel.gameField.observeForever {}
        gameViewModel.setSymbol('X')
        gameViewModel.makeUserMove(1)
        assertEquals('X', gameViewModel.gameField.value?.get(1))
    }

    @Test
    fun winnerPropertyIsUpdatedWhenGameEnds() {
        val gameViewModel = GameViewModel()
        gameViewModel.winner.observeForever {}
        gameViewModel.setSymbol('X')
        gameViewModel.makeUserMove(1)
        gameViewModel.makeUserMove(2)
        gameViewModel.makeUserMove(3)
        gameViewModel.checkForGameToContinue()
        assertEquals("user", gameViewModel.winner.value)
    }

    @Test
    fun checkForGameToContinueReturnsTrueWhenUserWins() {
        val gameViewModel = GameViewModel()
        gameViewModel.setSymbol('X')
        gameViewModel.makeUserMove(1)
        gameViewModel.makeUserMove(2)
        gameViewModel.makeUserMove(3)
        assertEquals(true, gameViewModel.checkForGameToContinue())
    }

    @Test
    fun checkForGameToContinueReturnsFalseWhenGameIsNotOver() {
        val gameViewModel = GameViewModel()
        gameViewModel.setSymbol('X')
        gameViewModel.makeUserMove(1)
        gameViewModel.makeUserMove(2)
        gameViewModel.makeUserMove(5)
        assertEquals(false, gameViewModel.checkForGameToContinue())
    }

    @Test
    fun clearFieldIsClearPreviousMoves() {
        val gameViewModel = GameViewModel()
        gameViewModel.gameField.observeForever {}
        gameViewModel.setSymbol('X')
        gameViewModel.makeUserMove(1)
        gameViewModel.makeUserMove(2)
        gameViewModel.makeUserMove(5)
        assertEquals('X', gameViewModel.gameField.value?.get(1))
        gameViewModel.clearField()
        assertEquals(' ', gameViewModel.gameField.value?.get(1))
    }

}