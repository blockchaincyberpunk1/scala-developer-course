object EvenOddChecker {
  def main(args: Array[String]): Unit = {
    val number = 7
    if (number % 2 == 0) println(s"$number is even")
    else println(s"$number is odd")
  }
}
