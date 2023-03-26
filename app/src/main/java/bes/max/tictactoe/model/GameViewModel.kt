package bes.max.tictactoe.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import bes.max.tictactoe.game.Playground
import bes.max.tictactoe.game.player.Computer
import bes.max.tictactoe.game.player.Human
import bes.max.tictactoe.game.player.Player

class GameViewModel: ViewModel() {

    private var computer: Player
    private var human: Player
    private var playground: Playground = Playground()

    private val _gameField = MutableLiveData<MutableMap<Int, Char>>()
    val gameField: LiveData<MutableMap<Int, Char>> = _gameField



    init {
        computer = Computer('0', playground)
        human = Human('X', playground)
        playground.prepareFieldForGame()
        _gameField.value = playground.field
    }

    fun setSymbol(symbol: Char) {
        human.symbol = symbol
        when (symbol) {
            '0' -> {
                computer.symbol = 'X'
                computer.makeMove()
                _gameField.value = playground.field
            }
            else -> computer.symbol = '0'
        }
    }

    fun makeUserMove(cellNumber: Int): Boolean {
        return if (human.makeMove(cellNumber)) {
            val result: Boolean
            result = computer.makeMove()
            _gameField.value = playground.field
            result
        } else {
            false
        }
    }

}