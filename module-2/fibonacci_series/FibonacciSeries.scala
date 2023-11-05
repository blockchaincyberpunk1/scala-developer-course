object FibonacciSeries {
  def fibonacci(n: Int): List[Int] = {
    if (n <= 0) List()
    else if (n == 1) List(0)
    else {
      val series = fibonacci(n - 1)
      series :+ (series.takeRight(2).sum)
    }
  }

  def main(args: Array[String]): Unit = {
    val terms = 10
    println(s"The Fibonacci series up to $terms terms: ${fibonacci(terms).mkString(", ")}")
  }
}
