package com.example.consolecalculator

class PriorityGetter {

    companion object {

        fun getPriority(symbol: Char): Int {
            return when (symbol) {
                '*' -> 3
                '/' -> 3
                '+' -> 2
                '-' -> 2
                '(' -> 1
                ')' -> -1
                else -> 0
            }
        }

    }
}