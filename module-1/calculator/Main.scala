object Main {
  def main(args: Array[String]): Unit = {
    val num1 = 5.0
    val num2 = 3.0

    val resultAdd = Calculator.add(num1, num2)
    val resultSubtract = Calculator.subtract(10.0, 4.0)
    val resultMultiply = Calculator.multiply(6.0, 7.0)
    val resultDivide = Calculator.divide(20.0, 5.0)

    resultDivide match {
      case Some(result) =>
        println(s"Addition: $resultAdd")
        println(s"Subtraction: $resultSubtract")
        println(s"Multiplication: $resultMultiply")
        println(s"Division: $result")
      case None =>
        println("Division error")
    }
  }
}
