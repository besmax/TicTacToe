package bes.max.tictactoe.game

import bes.max.tictactoe.game.player.Player

class Game(
    val computer: Player,
    val human: Player,
    val playground: Playground,
) {

//    fun play() {
//        console.print(playground!!.showCurrentPlayground())
//        while (true) {
//            if (human.getSymbol() === '0') {
//                computer.makeMove(1)
//                if (playground!!.doWeHaveWinner(computer.getSymbol())) break
//                human.makeMove(getPositionNumberFromUser())
//                console.print(playground!!.showCurrentPlayground())
//                if (playground!!.doWeHaveWinner(human.getSymbol())) break
//            } else {
//                human.makeMove(getPositionNumberFromUser())
//                console.print(playground!!.showCurrentPlayground())
//                if (playground!!.doWeHaveWinner(human.getSymbol())) break
//                computer.makeMove(1)
//                if (playground!!.doWeHaveWinner(computer.getSymbol())) break
//            }
//        }
//        console.printFromFile("output_winner")
//        console.print(playground.getWinnerOfTheGame())
//    }
//
//    fun getPositionNumberFromUser(): Int {
//        var inputPosition = 0
//        while (inputPosition < 1 || inputPosition > playground.getSize() * playground.getSize()) {
//            console.printFromFile("input_cell")
//            inputPosition = inputChecker.checkInput(1)
//        }
//        return inputPosition
//    }

}