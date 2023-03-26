package bes.max.tictactoe.game

class Playground {

    private var size = 3
    private var winnerOfTheGame: String? = null
    private var userSymbol = '#'
    private var computerSymbol = '#'
    val field = mutableMapOf<Int, Char>()

    fun prepareFieldForGame() {
        winnerOfTheGame = "No one, it's a draw"
        for (i in 1..size * size) field[i] = 'A'
    }

//    fun showCurrentPlayground(): String {
//        val result = StringBuilder("")
//        var elementNumber = 1
//        for (i in 1..size) {
//            for (j in 1..size) {
//                if (elementNumber < 10) result.append(" ")
//                if (field[elementNumber] == 'A') result.append(elementNumber)
//                    .append(" ") else if (field[elementNumber] == '0') {
//                    if (elementNumber > 9) result.append(" ")
//                    result.append('0')
//                        .append(" ")
//                } else if (field[elementNumber] == 'x' || field[elementNumber] == 'X') {
//                    if (elementNumber > 9) result.append(" ")
//                    result.append('X')
//                        .append(" ")
//                }
//                elementNumber++
//            }
//            result.append(System.lineSeparator())
//        }
//        return result.toString()
//    }

    fun occupyPositionOnTheField(positionNumber: Int, userOrNot: Char): Boolean {
        if (positionNumber == 0) return false
        return if (field[positionNumber] == 'A') {
            field[positionNumber] = userOrNot
            true
        } else {
            false
        }
    }

    fun checkTheRowsForWinner(winnerSymbol: Char): Boolean {
        var result = false
        var elementNumber = 1
        for (i in 1..size) {
            val uniqueSymbolsInRow: MutableSet<Char?> = HashSet()
            for (j in 1..size) {
                uniqueSymbolsInRow.add(field[elementNumber])
                elementNumber++
            }
            if (uniqueSymbolsInRow.size == 1 && !uniqueSymbolsInRow.contains('A')) {
                result = true
                if (uniqueSymbolsInRow.contains(computerSymbol)) winnerOfTheGame = "computer (row)"
                if (uniqueSymbolsInRow.contains(userSymbol)) winnerOfTheGame = "player (row)"
            }
        }
        return result
    }

    fun checkTheColumnsForWinner(winnerSymbol: Char): Boolean {
        var result = false
        for (i in 1..size) {
            val uniqueSymbolsInColumn: MutableSet<Char?> = HashSet()
            var elementNumber = i
            for (j in 1..size) {
                uniqueSymbolsInColumn.add(field[elementNumber])
                elementNumber += size
            }
            if (uniqueSymbolsInColumn.size == 1 && !uniqueSymbolsInColumn.contains('A')) {
                result = true
                if (uniqueSymbolsInColumn.contains(computerSymbol)) winnerOfTheGame =
                    "computer (column)"
                if (uniqueSymbolsInColumn.contains(userSymbol)) winnerOfTheGame = "player (column)"
            }
        }
        return result
    }

    fun checkTheDiagonalsForWinner(winnerSymbol: Char): Boolean {
        var result = false
        val uniqueSymbolsInDiagonal: MutableSet<Char> = HashSet()
        run {
            var i = 1
            while (i <= field.size) {
                field[i]?.let { uniqueSymbolsInDiagonal.add(it) }
                i += size + 1
            }
        }
        if (uniqueSymbolsInDiagonal.size == 1 && !uniqueSymbolsInDiagonal.contains('A')) {
            result = true
            if (uniqueSymbolsInDiagonal.contains(computerSymbol)) winnerOfTheGame =
                "computer (diagonal)"
            if (uniqueSymbolsInDiagonal.contains(userSymbol)) winnerOfTheGame = "player (diagonal)"
        }
        uniqueSymbolsInDiagonal.clear()
        var i = size
        while (i <= field.size - size + 1) {
            field[i]?.let { uniqueSymbolsInDiagonal.add(it) }
            i = i + size - 1
        }
        if (uniqueSymbolsInDiagonal.size == 1 && !uniqueSymbolsInDiagonal.contains('A')) {
            result = true
            if (uniqueSymbolsInDiagonal.contains(computerSymbol)) winnerOfTheGame =
                "computer (diagonal)"
            if (uniqueSymbolsInDiagonal.contains(userSymbol)) winnerOfTheGame = "player (diagonal)"
        }
        return result
    }

    fun doWeHaveWinner(winnerSymbol: Char): Boolean =
        when {
            (checkTheRowsForWinner(winnerSymbol)) -> true
            (checkTheColumnsForWinner(winnerSymbol)) -> true
            (checkTheDiagonalsForWinner(winnerSymbol)) -> true
            (!field.containsValue('A')) -> true
            else -> false
        }

    fun findPositionsWithSymbol(symbol: Char): List<Int> {
        val positions: MutableList<Int> = ArrayList()
        field.forEach { (k: Int, v: Char) ->
            if (v == symbol) positions.add(k)
        }
        return positions
    }

}