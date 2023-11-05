// Step 1: Define the Account class to represent a bank account
class Account(private val accountNumber: String, private var balance: Double) {
  
  // Method to display account information
  def displayInfo(): Unit = {
    println(s"Account Number: $accountNumber")
    println(s"Balance: $balance")
  }
  
  // Method to withdraw money from the account
  def withdraw(amount: Double): Boolean = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      true // Withdrawal successful
    } else {
      false // Withdrawal failed
    }
  }
}

// Step 2: Define the Customer class to represent a bank customer
class Customer(private val name: String, private val address: String, private val accounts: List[Account]) {
  
  // Method to display customer information and account details
  def displayInfo(): Unit = {
    println(s"Customer Name: $name")
    println(s"Address: $address")
    println("Accounts:")
    accounts.foreach(_.displayInfo()) // Display account information using foreach
  }
}

// Step 3: Define the Transaction trait with executeTransaction method
trait Transaction {
  def executeTransaction(account: Account, amount: Double): Boolean
}

// Step 4: Define the Deposit class that implements the Transaction trait
class Deposit extends Transaction {
  def executeTransaction(account: Account, amount: Double): Boolean = {
    if (amount > 0) {
      account.balance += amount // Increase the account balance
      true // Deposit successful
    } else {
      false // Deposit failed
    }
  }
}

// Step 5: Define the Withdrawal class that implements the Transaction trait
class Withdrawal extends Transaction {
  def executeTransaction(account: Account, amount: Double): Boolean = {
    account.withdraw(amount) // Use the withdraw method from the Account class
  }
}

// Step 6: Create instances and test the Online Banking System
object Main {
  def main(args: Array[String]): Unit = {
    val account1 = new Account("123456", 1000.0)
    val account2 = new Account("654321", 500.0)
    val customer = new Customer("Alice", "123 Main St", List(account1, account2))
    
    println("Customer Information:")
    customer.displayInfo()
    
    val deposit = new Deposit()
    val withdrawal = new Withdrawal()
    
    val depositAmount = 200.0
    val withdrawalAmount = 300.0
    
    println(s"\nDepositing $depositAmount to Account 1...")
    deposit.executeTransaction(account1, depositAmount)
    account1.displayInfo()
    
    println(s"\nWithdrawing $withdrawalAmount from Account 2...")
    withdrawal.executeTransaction(account2, withdrawalAmount)
    account2.displayInfo()
  }
}
