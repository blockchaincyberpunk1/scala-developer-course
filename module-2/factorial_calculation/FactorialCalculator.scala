object FactorialCalculator {
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }

  def main(args: Array[String]): Unit = {
    val number = 5
    println(s"The factorial of $number is ${factorial(number)}")
  }
}
