// Hello, World! Program
object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Hello, World!")
  }
}

// Variables and Data Types
val x: Int = 10  // Immutable variable
var y: String = "Hello"  // Mutable variable
val pi: Double = 3.14159
val isTrue: Boolean = true

// Strings
val message: String = "Scala is awesome!"
println(message.toUpperCase())  // "SCALA IS AWESOME!"
println(message.toLowerCase())  // "scala is awesome!"
println(message.length())       // Length of the string
println(message.charAt(0))      // Access character at index

// Numeric Operations
val sum: Int = 5 + 3
val product: Int = 5 * 3
val quotient: Double = 10.0 / 3

// Arrays
val numbers: Array[Int] = Array(1, 2, 3, 4, 5)
println(numbers(0))  // Access element at index 0
println(numbers.length)  // Length of the array

// Control Structures
if (x > 0) {
  println("x is positive")
} else if (x < 0) {
  println("x is negative")
} else {
  println("x is zero")
}

for (i <- 1 to 5) {
  println(i)
}

while (y != "Bye") {
  println(y)
  y = "Bye"
}

// Functions
def greet(name: String): String = {
  s"Hello, $name!"
}
println(greet("Alice"))  // "Hello, Alice!"

// Classes and Objects
class Person(name: String, age: Int) {
  def greet(): Unit = {
    println(s"Hello, my name is $name and I'm $age years old.")
  }
}

val person = new Person("John", 30)
person.greet()

// Traits (Similar to Interfaces)
trait Animal {
  def sound(): String
}

class Dog extends Animal {
  def sound(): String = "Woof"
}

// Pattern Matching
val day = "Wednesday"
val typeOfDay = day match {
  case "Monday" | "Tuesday" | "Wednesday" | "Thursday" | "Friday" => "Weekday"
  case "Saturday" | "Sunday" => "Weekend"
}

// Collections
val list: List[Int] = List(1, 2, 3, 4, 5)
val map: Map[String, Int] = Map("one" -> 1, "two" -> 2)
val set: Set[Int] = Set(1, 2, 3)

// File I/O
import scala.io.Source
val lines: List[String] = Source.fromFile("file.txt").getLines().toList

// Error Handling
try {
  // Code that might throw an exception
} catch {
  case e: Exception => println(s"An error occurred: ${e.getMessage}")
} finally {
  // Code that runs regardless of whether an exception occurred
}

// Interoperability with Java
import java.util.ArrayList
val javaList = new ArrayList[String]()
javaList.add("Java")
javaList.add("Scala")
