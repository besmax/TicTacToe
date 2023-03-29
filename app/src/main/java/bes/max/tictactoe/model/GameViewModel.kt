package bes.max.tictactoe.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import bes.max.tictactoe.game.Playground
import bes.max.tictactoe.game.player.Computer
import bes.max.tictactoe.game.player.Human
import bes.max.tictactoe.game.player.Player

class GameViewModel : ViewModel() {

    private var computer: Player
    private var human: Player
    private var playground: Playground = Playground()

    private val _gameField = MutableLiveData<MutableMap<Int, Char>>()
    val gameField: LiveData<MutableMap<Int, Char>> = _gameField

    private val _winner = MutableLiveData<String>()
    val winner: LiveData<String> = _winner


    init {
        computer = Computer(' ', playground)
        human = Human(' ', playground)
        playground.prepareFieldForGame()
        _gameField.value = playground.field
    }

    fun setSymbol(symbol: Char) {
        human.symbol = symbol
        playground.userSymbol = human.symbol
        when (symbol) {
            '0' -> {
                computer.symbol = 'X'
                playground.computerSymbol = computer.symbol
                computer.makeMove()
                _gameField.value = playground.field
            }
            else -> computer.symbol = '0'
        }
    }

    fun makeUserMove(cellNumber: Int): Boolean {
        val result = human.makeMove(cellNumber)
        _gameField.value = playground.field
        return result
    }

    fun makeComputerMove(): Boolean {
        val result = computer.makeMove()
        _gameField.value = playground.field
        return result
    }

    fun checkForGameToContinue(): Boolean {
        val result = playground.doWeHaveWinner(human.symbol)
        if (result) {
            _winner.value = when (playground.winnerOfTheGame) {
                computer.symbol.toString() -> "computer"
                human.symbol.toString() -> "user"
                else -> {
                    "no one"
                }
            }
        }
        return result
    }

    fun clearField() {
        playground.prepareFieldForGame()
        _gameField.value = playground.field
    }


}