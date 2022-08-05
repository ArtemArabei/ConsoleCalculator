package com.example.consolecalculator

import java.util.*

class Calculator {

    fun rpnToAnswer(rpn: String): Double? {
        try {
            var operand = String()
            val stack: Stack<Double> = Stack()
            var i = 0
            while (i < rpn.length) {
                if (rpn[i] == ' ') {
                    i++
                    continue
                }
                if (PriorityGetter.getPriority(rpn[i]) == 0) {
                    while (rpn[i] != ' ' && PriorityGetter.getPriority(rpn[i]) == 0) {
                        operand += rpn[i++]
                        if (i == rpn.length) break
                    }
                    stack.push(operand.toDouble())
                    operand = String()
                }
                if (PriorityGetter.getPriority(rpn[i]) > 1) {
                    val tmp1: Double = stack.pop()
                    val tmp2: Double = stack.pop()
                    when (rpn[i]) {
                        '+' -> stack.push(tmp2 + tmp1)
                        '-' -> stack.push(tmp2 - tmp1)
                        '*' -> stack.push(tmp2 * tmp1)
                        '/' -> stack.push(tmp2 / tmp1)
                    }
                }
                i++
            }
            return stack.pop()
        } catch (e: Exception) {
            return null
        }

    }
}
