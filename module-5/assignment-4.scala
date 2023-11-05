Exploring Pattern Matching in Collections
Assignment Overview
Welcome to the fascinating world of pattern matching in collections using Scala! In this assignment, we'll delve into the art of pattern matching, not just with case classes, but also with elements within collections. Pattern matching's power extends to collections, allowing us to elegantly match and manipulate elements within them. Let's dive into the code and explore how pattern matching can be applied to various collections.

Step 1: Understanding Pattern Matching in Collections
Pattern matching is like a detective's tool that helps us identify specific patterns within our data. When applied to collections, it enables us to identify and manipulate specific elements based on patterns.

Step 2: Provided Collections and Matching Goals
Let's start by examining the collections and identifying what we want to achieve:

Collection 1: List of Integers
We have a list of integers, and we want to identify even numbers.

Collection 2: Map of Names and Ages
We have a map containing names as keys and ages as values. We want to find adults (ages >= 18).

Collection 3: Sequence of Strings
We have a sequence of strings representing fruits. We want to extract the names of tropical fruits.

Step 3: Applying Pattern Matching to Collections
Collection 1: List of Integers
scala
Copy code
val numbers = List(1, 4, 7, 10, 13)

numbers.foreach {
  case even if even % 2 == 0 => println(s"$even is even")
  case odd => println(s"$odd is odd")
}
Collection 2: Map of Names and Ages
scala
Copy code
val ages = Map("Alice" -> 25, "Bob" -> 17, "Charlie" -> 30)

ages.foreach {
  case (name, age) if age >= 18 => println(s"$name is an adult")
  case (name, age) => println(s"$name is a minor")
}
Collection 3: Sequence of Strings
scala
Copy code
val fruits = Seq("Apple", "Banana", "Mango", "Pineapple", "Coconut")

fruits.foreach {
  case "Mango" | "Pineapple" | "Coconut" => println(s"Found tropical fruit: $fruit")
  case fruit => println(s"Non-tropical fruit: $fruit")
}
Step 4: Real-World Use Cases
Pattern matching in collections can replace conventional loops and conditional checks. It makes code more readable and expressive. For instance:

Simplifying Filtering
Instead of using loops and if statements, pattern matching elegantly filters elements based on specific conditions.

Custom Transformations
Pattern matching can be used to transform elements based on certain criteria, replacing complex transformations with concise pattern matching.

Additional Insights
Pattern matching in collections is like a treasure hunt. You specify what you're looking for, and Scala's pattern matching does the rest. It's a powerful tool that adds elegance and readability to your code, making complex operations feel like child's play.




