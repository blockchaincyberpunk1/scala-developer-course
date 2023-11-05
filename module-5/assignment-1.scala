Exploring Pattern Matching in Scala: Exercises and Applications
Assignment Overview
Welcome to the world of Scala, where patterns become your allies in solving intricate problems. In this assignment, we'll delve into the captivating realm of pattern matching. You'll be presented with scenarios that challenge you to harness the power of pattern matching to tackle specific tasks. Let's embark on this journey to unravel the mysteries of pattern matching.

Step 1: Understanding Pattern Matching
Pattern matching in Scala is akin to deciphering a puzzle. It's a technique that allows you to match complex data structures and extract meaningful information from them. Pattern matching can be applied to various data types, such as case classes, lists, tuples, and more. It's your key to unlocking concise and elegant solutions to intricate problems.

Step 2: Scenario Presentation
Let's dive into the scenarios where pattern matching shines brightly:

Scenario 1: Checking a Number's Classification
You're given a number, and your task is to classify it as "even," "odd," or "prime." Harness pattern matching to unveil the number's hidden identity.

Scenario 2: Parsing User Input
Imagine you're building a chatbot that needs to parse user input. Extract the user's intent from the input by matching specific patterns within the text.

Scenario 3: Processing JSON Data
You're working with JSON data that represents different shapes. Your mission is to extract the type of shape and its dimensions using pattern matching.

Step 3: Applying Pattern Matching
Let's roll up our sleeves and apply pattern matching to solve these scenarios:

Scenario 1: Checking a Number's Classification
scala
Copy code
object NumberClassification {
  def classifyNumber(number: Int): String = number match {
    case n if n % 2 == 0 => "Even"
    case n if n % 2 != 0 => "Odd"
    case n if isPrime(n) => "Prime"
    case _ => "Other"
  }

  def isPrime(n: Int): Boolean = n > 1 && (2 until n).forall(n % _ != 0)
}
Scenario 2: Parsing User Input
scala
Copy code
object UserInputParser {
  def parseInput(input: String): String = input match {
    case s if s.contains("hello") => "Greeting"
    case s if s.contains("bye") => "Farewell"
    case _ => "Unknown"
  }
}
Scenario 3: Processing JSON Data
scala
Copy code
sealed trait Shape
case class Circle(radius: Double) extends Shape
case class Rectangle(width: Double, height: Double) extends Shape

object JsonShapeParser {
  def parseJson(json: String): String = {
    import org.json4s._
    import org.json4s.native.JsonMethods._

    val shape: Shape = parse(json).extract[Shape]
    shape match {
      case Circle(radius) => s"Circle with radius $radius"
      case Rectangle(width, height) => s"Rectangle with dimensions $width x $height"
      case _ => "Unknown shape"
    }
  }
}
Step 4: Implications and Benefits
Pattern matching is more than just syntax; it's a gateway to elegant solutions and enhanced code readability. By matching patterns, you're creating code that concisely expresses your intent. This clarity leads to better maintainability and less room for errors. Pattern matching also enables you to handle complex data structures with precision, making your code a joy to work with.

Additional Insights
As you embrace pattern matching, remember that it's a versatile tool that can simplify complex scenarios. Whether you're categorizing numbers, deciphering user input, or parsing JSON data, pattern matching is your trusty companion. Its power lies in its ability to transform intricate problems into elegant solutions.

Pattern matching isn't just a technique; it's a mindset. By understanding the essence of patterns, you're equipped to create solutions that resonate with the elegance and simplicity that Scala stands for.