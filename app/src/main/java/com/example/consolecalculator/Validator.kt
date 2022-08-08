package com.example.consolecalculator

class Validator {

    private fun checkIsNullOrEmpty(inputText: String): Boolean {
        return inputText.isEmpty()
    }

    private fun checkOnIllegalSymbols(inputText: String): Boolean {
        val reg = "[0123456789+-/*() ]+".toRegex()
        return !inputText.let { reg.matches(it) }
    }

    private fun checkOnCharacterSequence(inputText: String): Boolean {
        val editedText = inputText.filterNot { it.isWhitespace() }
        for (index in 0..(editedText.length - 2)) {
            val symbol = editedText[index]
            val symbol2 = editedText[index + 1]
            if (((symbol == '-') || (symbol == '+') || (symbol == '*') || (symbol == '/'))
                && ((symbol2 == '-') || (symbol2 == '+') || (symbol2 == '*') || (symbol2 == '/'))
            ) {
                return true
            }
        }
        return false
    }

    private fun checkOnSymbolOfMathExpression(inputText: String): Boolean {
        for (index in inputText.indices) {
            val symbol = inputText[index]
            if ((symbol == '-') || (symbol == '+') || (symbol == '*') || (symbol == '/')) {
                return false
            }
        }
        return true
    }

    fun validate(inputText: String): Boolean {
        var result = false
        if (checkIsNullOrEmpty(inputText)) {
            println("Вы ввели пустую строку, попробуйте еще раз")
        } else if (checkOnIllegalSymbols(inputText)) {
            println("В математическом выражении присутствуют недопустимые символы, попробуйте еще раз")
        } else if (checkOnCharacterSequence(inputText)) {
            println("Вы ввели неверное математическое выражение, попробуйте еще раз")
        } else if (checkOnSymbolOfMathExpression(inputText)) {
            println("Вы не ввели ни одного символа математических операций, попробуйте еще раз")
        } else
            result = true
        return result
    }

}