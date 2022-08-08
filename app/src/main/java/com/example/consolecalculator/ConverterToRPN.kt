package com.example.consolecalculator

import java.util.*

class ConverterToRPN {

    private fun convertExpression(inputText: String): String {
        var outputText = ""
        for (index in inputText.indices) {
            val symbol = inputText[index]
            if (symbol == '-') {
                if ((index == 0) || (inputText[index - 1] == '(')) outputText += "0"
            }
            outputText += symbol
        }
        return outputText
    }

    fun expressionToRPN(inputText: String): String {
        val outputText = convertExpression(inputText)
        var rpn = ""
        val stack: Stack<Char> = Stack()
        var priority: Int
        for (i in outputText.indices) {
            priority = PriorityGetter.getPriority(outputText[i])
            when (priority) {
                0 -> rpn += outputText[i]
                1 -> stack.push(outputText[i])
                in 2..3 -> {
                    rpn += ' '
                    while (!stack.empty()) {
                        rpn += if (PriorityGetter.getPriority(stack.peek()) >= priority) stack.pop() else break
                    }
                    stack.push(outputText[i])
                }
                -1 -> {
                    rpn += ' '
                    while (PriorityGetter.getPriority(stack.peek()) != 1) rpn += stack.pop()
                    stack.pop()
                }
            }
        }
        while (!stack.empty()) rpn += stack.pop()
        return rpn
    }

}