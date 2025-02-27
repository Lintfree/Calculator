package net.lintfree.notes_and_examples

import kotlin.math.pow
import kotlin.system.exitProcess

fun main() {

	println("*** Welcome to the Console Calculator ***")
	showChoices()
	val operation = getArithmeticOperation()

	if (operation == "sqrt" || operation == "sin" || operation == "cos" || operation == "tan") {
		println("Please enter the number:")
		val number = readDoubleInput("Number:")
		val result = calculate(number, 0.0, operation)
		println("The result is: $result")
	} else {
		println("Please enter the first number:")
		val firstNumber = readDoubleInput("Number 1:")
		println("Please enter the second number:")
		val secondNumber = readDoubleInput("Number 2:")

		//Calculate and display result
		val result = calculate(firstNumber, secondNumber, operation)
		println("The result is: $result")
	}
}

fun showChoices() {
	println("Please select an operation:")
	println("Addition ( + )")
	println("Subtraction ( - )")
	println("Multiplication ( * )")
	println("Division ( / )")
	println("Modulus ( % )")
	println("Power ( ^ )")
	println("Square Root ( sqrt )")
	println("Sine ( sin )")
	println("Cosine ( cos )")
	println("Tangent ( tan )")
}

fun readDoubleInput(prompt: String): Double {
	while (true) try {
		print(prompt)
		return readLine() !!.toDouble()
	}
	catch (_: NumberFormatException) {
		println("Invalid input: Please enter a valid number.")
		exitProcess(1) //error code 1 for invalid input
	}
}

fun getArithmeticOperation(): String {
	print("\n Enter an arithmetic operation: (+, -, *, /, %, ^, sqrt, sin, cos, tan): ")
	val operation = readLine()
	return when (operation) {
		"+", "-", "*", "/", "%", "^", "sqrt", "sin", "cos", "tan" -> operation
		else -> {
			println("Invalid operation: Exiting program")
			exitProcess(2)
		}
	}
}

fun calculate(firstNumber: Double , secondNumber: Double, operation: String): Double {
	return when (operation) {
		"+" -> firstNumber + secondNumber
		"-" -> firstNumber - secondNumber
		"*" -> firstNumber * secondNumber
		"/" -> if ( secondNumber != 0.0) firstNumber / secondNumber else {
			println("Division by zero is not allowed: Exiting program")
			exitProcess(3)
			}
		"%" -> if ( secondNumber != 0.0) firstNumber % secondNumber else {
			println("Division by zero is not allowed: Exiting program")
			exitProcess(3)
			}
		"^" -> firstNumber.pow(secondNumber)
		"sqrt" -> kotlin.math.sqrt(firstNumber)
		"sin" -> kotlin.math.sin(firstNumber)
		"cos" -> kotlin.math.cos(firstNumber)
		"tan" -> kotlin.math.tan(firstNumber)
		else -> {
		println("Invalid operation: Exiting program")
		exitProcess(2)
		}
	}
}

// for testing purposes
//fun exitProcess1(status: Int): Nothing {
	//throw IllegalStateException("Exiting Program")
//}
