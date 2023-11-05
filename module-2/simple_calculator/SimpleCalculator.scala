object SimpleCalculator {
  def main(args: Array[String]): Unit = {
    val num1 = 20
    val num2 = 5
    println(s"Sum: ${num1 + num2}")
    println(s"Difference: ${num1 - num2}")
    println(s"Product: ${num1 * num2}")
    println(s"Quotient: ${num1.toDouble / num2}")
  }
}
