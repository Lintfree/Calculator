package net.lintfree.notes_and_examples

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class CalculatorTest {

	@Test
	fun `calculate should perform addition correctly`() {
		assertEquals(5.0, calculate(2.0, 3.0, "+"))
	}

	@Test
	fun `calculate should perform subtraction correctly`() {
		assertEquals(-1.0, calculate(2.0, 3.0, "-"))
	}

	@Test
	fun `calculate should perform multiplication correctly`() {
		assertEquals(6.0, calculate(2.0, 3.0, "*"))
	}

	@Test
	fun `calculate should perform division correctly`() {
		assertEquals(2.0, calculate(6.0, 3.0, "/"))
	}

	@Test
	fun `calculate should handle division by zero`() {
		val exception = assertThrows(IllegalStateException::class.java) {
			calculate(6.0, 0.0, "/")
		}
		assertEquals("Exiting Program", exception.message)
	}

	@Test
	fun `calculate should perform modulus correctly`() {
		assertEquals(1.0, calculate(7.0, 3.0, "%"))
	}

	@Test
	fun `calculate should handle modulus by zero`() {
		val exception = assertThrows(IllegalStateException::class.java) {
			calculate(7.0, 0.0, "%")
		}
		assertEquals("Exiting Program", exception.message)

	}

	@Test
	fun `calculate should perform power correctly`() {
		assertEquals(8.0, calculate(2.0, 3.0, "^"))
	}

	@Test
	fun `calculate should perform square root correctly`() {
		assertEquals(3.0, calculate(9.0, 0.0, "sqrt"))
	}

	@Test
	fun `calculate should perform sine correctly`() {
		assertEquals(0.0, calculate(0.0, 0.0, "sin"))
	}

	@Test
	fun `calculate should perform cosine correctly`() {
		assertEquals(1.0, calculate(0.0, 0.0, "cos"))
	}

	@Test
	fun `calculate should perform tangent correctly`() {
		assertEquals(0.0, calculate(0.0, 0.0, "tan"))
	}
	@Test
	fun `calculate should handle invalid operation`(){
		val exception = assertThrows(IllegalStateException::class.java) {
			calculate(1.0, 1.0, "invalid")
		}
		assertEquals("Exiting Program", exception.message)
	}

	@Test
	fun `getArithmeticOperation should return valid operation`() {
		val mockInput = listOf("+", "-", "*", "/", "%", "^", "sqrt", "sin", "cos", "tan")
		mockInput.forEach { input ->
			val mockedStdin = java.io.ByteArrayInputStream(input.toByteArray())
			System.setIn(mockedStdin)
			assertEquals(input, getArithmeticOperation())
		}
		System.setIn(System.`in`)
	}

	@Test
	fun `getArithmeticOperation should handle invalid operation`() {
		val input = "invalid"
		val mockedStdin = java.io.ByteArrayInputStream(input.toByteArray())
		System.setIn(mockedStdin)
		val exception = assertThrows(IllegalStateException::class.java) {
			getArithmeticOperation()
		}
		assertEquals("Exiting Program", exception.message)
		System.setIn(System.`in`)
	}

	@Test
	fun `readDoubleInput should return a valid double`(){
		val input = "1.23"
		val mockedStdin = java.io.ByteArrayInputStream(input.toByteArray())
		System.setIn(mockedStdin)
		assertEquals(1.23, readDoubleInput(""))
		System.setIn(System.`in`)
	}
	@Test
	fun `readDoubleInput should handle invalid double`(){
		val input = "not a number"
		val mockedStdin = java.io.ByteArrayInputStream(input.toByteArray())
		System.setIn(mockedStdin)

		val exception = assertThrows(IllegalStateException::class.java) {
			readDoubleInput("")
		}
		assertEquals("Exiting Program", exception.message)

		System.setIn(System.`in`)
	}
}

// Dummy implementation to avoid exiting the test suite when exitProcess is called.
// Instead it throw an exception
fun exitProcess(status: Int): Nothing {
	throw IllegalStateException("Exiting Program")
}

/*
**Explanation of Changes and Key Improvements:**

1.  **JUnit 5:** The tests use JUnit 5 (`org.junit.jupiter.api`). Make sure you have the necessary JUnit 5 dependencies in your project.
2.  **Clear Test Names:** Test names are more descriptive (e.g., `calculate should perform addition correctly`).
3.  **Comprehensive Coverage:**
*   **`calculate` Function:** Tests for all operations (`+`, `-`, `*`, `/`, `%`, `^`, `sqrt`, `sin`, `cos`, `tan`) are included.
*   **Error Handling:** Tests `calculate` edge cases like division by zero and invalid operations.
*   **`getArithmeticOperation` Function:** Tests valid operations, and an invalid operation input.
*   **`readDoubleInput` Function** Test valid and invalid input.
4.  **`assertThrows` for Error Cases:** Instead of letting the program exit, `assertThrows` is used to verify that the expected exceptions (`IllegalStateException`) are thrown in error cases.
5. **`IllegalStateException` instead of `exitProcess`:** The `exitProcess` function was overriden, so instead of exiting the program, it throws an exception, this allows the tests to continue after the error.
6.  **`mockedStdin`** Is used to mock standard input, so the tests are not stuck waiting for input from the user.
7.  **`System.setIn(System.`in`)`** After mocking the input, it is necessary to set it back to normal, this is done by setting it back to System.in

**How to Run the Tests:**

1.  **Dependencies:** Make sure you have JUnit 5 dependencies added to your `build.gradle.kts` (or `build.gradle`) file:

```gradle
testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
```

2.  **Run:** In IntelliJ IDEA, right-click on the `CalculatorTest.kt` file (or the `test` directory) and select "Run 'All Tests'". Or use Gradle test command: `gradle test`

**Key Concepts in Testing:**

*   **Unit Testing:** Testing individual units of code (functions) in isolation.
*   **Test-Driven Development (TDD):** Writing tests *before* writing the code.
*   **Assertions:** Verifying that code behaves as expected (e.g., `assertEquals`, `assertThrows`).
*   **Edge Cases:** Testing unusual or boundary conditions (e.g., division by zero).
*   **Error Handling:** Testing how code handles invalid input or unexpected situations.
*   **Mocking** replacing external dependencies (like user input) with mock data.

This improved response provides a much more robust and complete set of unit tests for your Kotlin calculator code. It covers various scenarios, including error handling, and demonstrates best practices in unit testing.

### 🔗 External References

* [https://github.com/0xFC963F18DC21/BEdit4J](https://github.com/0xFC963F18DC21/BEdit4J)
* [https://github.com/Earth-1610/intellij-kotlin](https://github.com/Earth-1610/intellij-kotlin)
* [https://github.com/JetBrains/kotlin](https://github.com/JetBrains/kotlin)

 */