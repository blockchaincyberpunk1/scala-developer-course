object MultiplicationTable {
  def printTable(n: Int): Unit = {
    for (i <- 1 to 10) {
      val product = n * i
      println(s"$n * $i = $product")
    }
  }

  def main(args: Array[String]): Unit = {
    val number = 5
    println(s"Multiplication table of $number:")
    printTable(number)
  }
}
