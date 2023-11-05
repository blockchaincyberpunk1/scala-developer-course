object PalindromeChecker {
  def isPalindrome(str: String): Boolean = {
    str == str.reverse
  }

  def main(args: Array[String]): Unit = {
    val word = "radar"
    if (isPalindrome(word)) println(s"$word is a palindrome")
    else println(s"$word is not a palindrome")
  }
}
