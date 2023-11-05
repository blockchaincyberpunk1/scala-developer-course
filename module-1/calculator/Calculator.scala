object Calculator {
  def add(a: Double, b: Double): Double = a + b

  def subtract(a: Double, b: Double): Double = a - b

  def multiply(a: Double, b: Double): Double = a * b

  def divide(a: Double, b: Double): Option[Double] = {
    if (b == 0) {
      println("Cannot divide by zero!")
      None
    } else {
      Some(a / b)
    }
  }
}
