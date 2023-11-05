import scala.io.StdIn
import java.io.{FileNotFoundException, IOException}

object FileManipulationTool {
  def main(args: Array[String]): Unit = {

    // Step 1: Scenario Selection
    println("Welcome to the File Manipulation Tool!")
    println("Select an operation:")
    println("1. Read File")
    println("2. Process File")
    print("Enter the operation number: ")

    // Step 2: Read user input and implement the logic
    val operation = StdIn.readInt()

    if (operation >= 1 && operation <= 2) {
      try {
        print("Enter the file path: ")
        val filePath = StdIn.readLine()

        operation match {
          case 1 => readFile(filePath)
          case 2 => processFile(filePath)
        }
      } catch {
        case e: FileNotFoundException =>
          println(s"Error: File not found - ${e.getMessage}")
        case e: IOException =>
          println(s"Error: I/O error - ${e.getMessage}")
        case _: Throwable =>
          println("An unexpected error occurred.")
      }
    } else {
      println("Invalid operation selection.")
    }
  }

  // Helper method to read file
  def readFile(filePath: String): Unit = {
    val source = scala.io.Source.fromFile(filePath)
    for (line <- source.getLines()) {
      println(line)
    }
    source.close()
  }

  // Helper method to process file
  def processFile(filePath: String): Unit = {
    // Simulate processing by printing a message
    println(s"Processing file at $filePath...")
  }
}


/* 
Explanation:

Scenario Selection: The user is welcomed to the File Manipulation Tool. The available operations are displayed with numbers assigned to each operation.

Read User Input and Implement Logic: The program reads the operation number selected by the user using StdIn.readInt(). Then, it prompts the user to enter a file path and reads it using StdIn.readLine().

Error Handling Implementation: The program uses try-catch blocks to handle potential errors, such as a FileNotFoundException or an IOException. It also includes a catch-all case for unexpected errors.

Helper Methods: Two helper methods, readFile and processFile, are defined to simulate reading and processing files, respectively.

Displaying Error Messages: Meaningful error messages are displayed to the user based on the type of error encountered.

Error Handling Strategy: The program gracefully handles errors without crashing and continues to provide user instructions and feedback.

To test the application, you can intentionally provide incorrect file paths or simulate other errors by entering invalid inputs. The program will respond with relevant error messages.

This Scala program demonstrates how to implement effective error handling techniques using try-catch blocks. It ensures that the command-line application provides helpful error messages and remains robust in the face of unexpected scenarios.

*/