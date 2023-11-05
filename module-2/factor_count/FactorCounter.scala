object FactorCounter {
  def countFactors(n: Int): Int = {
    (1 to n).count(n % _ == 0)
  }

  def main(args: Array[String]): Unit = {
    val number = 12
    println(s"Number of factors of $number: ${countFactors(number)}")
  }
}
