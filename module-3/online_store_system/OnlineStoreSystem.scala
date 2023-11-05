// Define the Product class
class Product(val name: String, val price: Double) {
  // Method to display product information
  def displayInfo(): Unit = {
    println(s"Product: $name, Price: $$${price}")
  }
}

// Define the Customer class
class Customer(val name: String, val email: String, var balance: Double) {
  // Method to display customer information
  def displayInfo(): Unit = {
    println(s"Customer: $name, Email: $email, Balance: $$${balance}")
  }
}

// Define the Discountable trait
trait Discountable {
  // Method to apply discount to the price
  def applyDiscount(originalPrice: Double): Double
}

// Define the Order class that extends Discountable trait
class Order(val customer: Customer, val product: Product, val quantity: Int) extends Discountable {
  // Method to calculate total price after applying discount
  def calculateTotal(): Double = {
    val originalTotal = product.price * quantity
    applyDiscount(originalTotal)
  }

  // Method to display order information
  def displayOrderInfo(): Unit = {
    println(s"Order for ${customer.name}: ${product.name} x $quantity, Total: $$${calculateTotal()}")
  }

  // Override method to apply discount based on Discountable trait
  override def applyDiscount(originalPrice: Double): Double = {
    val discountPercentage = 0.1 // 10% discount
    originalPrice * (1 - discountPercentage)
  }
}

// Creating instances of classes
val product1 = new Product("Smartphone", 599.99)
val customer1 = new Customer("Alice", "alice@example.com", 1000)
val order1 = new Order(customer1, product1, 2)

// Displaying information
product1.displayInfo() // Display product information
customer1.displayInfo() // Display customer information
order1.displayOrderInfo() // Display order information


/* 
Notes:

I start by defining the Product class with a constructor that takes name and price as parameters.
The displayInfo method in the Product class is used to display product information using string interpolation.
Similarly, the Customer class is defined with attributes name, email, and balance. The displayInfo method is used to display customer information.
The Discountable trait is created with an abstract method applyDiscount which will be implemented by classes that extend it.
The Order class extends the Discountable trait and has attributes customer, product, and quantity.
The calculateTotal method in the Order class calculates the total price after applying the discount using the applyDiscount method from the trait.
The displayOrderInfo method displays order information, including the customer's name, product name, quantity, and total after discount.
The applyDiscount method in the Order class overrides the method from the Discountable trait and applies a 10% discount.
Instances of Product, Customer, and Order classes are created with appropriate parameters.
Finally, the displayInfo and displayOrderInfo methods are called to display information about the product, customer, and order.

 */