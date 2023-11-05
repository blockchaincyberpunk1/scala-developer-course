object LeapYearChecker {
  def isLeapYear(year: Int): Boolean = {
    (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)
  }

  def main(args: Array[String]): Unit = {
    val year = 2024
    if (isLeapYear(year)) println(s"$year is a leap year")
    else println(s"$year is not a leap year")
  }
}
