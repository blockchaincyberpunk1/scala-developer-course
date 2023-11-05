import scala.io.StdIn

object CommandLineTool {
  def main(args: Array[String]): Unit = {

    // Step 1: Scenario Selection
    println("Welcome to the Basic Calculator App!")
    println("Select an operation:")
    println("1. Addition")
    println("2. Subtraction")
    println("3. Multiplication")
    println("4. Division")
    print("Enter the operation number: ")

    // Step 2: Read user input and implement the logic
    val operation = StdIn.readInt()

    if (operation >= 1 && operation <= 4) {
      print("Enter the first number: ")
      val num1 = StdIn.readDouble()

      print("Enter the second number: ")
      val num2 = StdIn.readDouble()

      val result = operation match {
        case 1 => num1 + num2
        case 2 => num1 - num2
        case 3 => num1 * num2
        case 4 => if (num2 != 0) num1 / num2 else {
          println("Division by zero is not allowed.")
          sys.exit(1)
        }
      }

      // Step 3: Display the output
      println(s"Result: $result")
    } else {
      println("Invalid operation selection.")
    }
  }
}


/* 
Explanation:

Scenario Selection: The user is welcomed to the Basic Calculator App. The available operations are displayed with numbers assigned to each operation.

Read User Input and Implement Logic: The program uses StdIn.readInt() to read the operation number selected by the user. Then, it prompts the user to enter two numbers and reads them using StdIn.readDouble().

Calculate Result: Based on the selected operation, the program uses pattern matching to calculate the result. It handles division by zero as an edge case.

Display Output: The calculated result is displayed to the user.

Error Handling: The program ensures that the selected operation is within the valid range (1-4) and handles division by zero errors.

This Scala program creates a simple interactive command-line tool that allows the user to perform basic arithmetic operations. It demonstrates how to read user input, perform calculations, and provide meaningful output. By using StdIn from the scala.io package, the program interacts with the user in a command-line environment.

Remember to run the program in a command-line environment and follow the prompts to interact with the Basic Calculator App.

*/