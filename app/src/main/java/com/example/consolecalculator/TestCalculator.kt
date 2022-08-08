package com.example.consolecalculator

fun main() {

    val inputText = ExpressionReader().readExpression()
    if (Validator().validate(inputText)) {
        val rpn = ConverterToRPN().expressionToRPN(inputText)
        val result = Calculator().rpnToAnswer(rpn)
        println(result ?: "Обнаружена иная ошибка, не учтенная при разработке :)")
    }

}