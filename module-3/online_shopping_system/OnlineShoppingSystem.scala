// Online Shopping System in Scala: Object-Oriented Design Assessment

// Step 1: Defining the Product Class
class Product(private val productId: String, private val productName: String, private val price: Double) {
  // Method to display product information
  def displayInfo(): Unit = {
    println(s"Product ID: $productId")
    println(s"Product Name: $productName")
    println(s"Price: $price")
  }
}

// Step 2: Defining the Customer Class
class Customer(private val customerId: String, private val name: String, private val email: String) {
  // Method to display customer information
  def displayInfo(): Unit = {
    println(s"Customer ID: $customerId")
    println(s"Name: $name")
    println(s"Email: $email")
  }
}

// Step 3: Defining the ShoppingCartAction Trait
trait ShoppingCartAction {
  // Method to add a product to the shopping cart
  def addToCart(product: Product): Boolean

  // Method to remove a product from the shopping cart
  def removeFromCart(product: Product): Boolean

  // Method to calculate and return the total price of items in the cart
  def checkout(): Double
}

// Step 4: Implementing the ShoppingCart Class
class ShoppingCart extends ShoppingCartAction {
  private var cartItems: List[Product] = List()

  // Method to add a product to the cart
  def addToCart(product: Product): Boolean = {
    cartItems = product :: cartItems
    true
  }

  // Method to remove a product from the cart
  def removeFromCart(product: Product): Boolean = {
    cartItems = cartItems.filterNot(_ == product)
    true
  }

  // Method to calculate the total price and clear the cart
  def checkout(): Double = {
    val total = cartItems.map(_.price).sum
    cartItems = List()
    total
  }
}

// Step 5: Testing the Online Shopping System
object Main {
  def main(args: Array[String]): Unit = {
    // Creating instances of Product
    val product1 = new Product("P123", "Smartphone", 499.99)
    val product2 = new Product("P456", "Headphones", 59.99)

    // Creating an instance of Customer
    val customer = new Customer("C789", "Alice", "alice@example.com")

    // Creating an instance of ShoppingCart
    val shoppingCart = new ShoppingCart()

    // Adding products to the cart
    shoppingCart.addToCart(product1)
    shoppingCart.addToCart(product2)

    // Displaying customer information
    println("Customer Information:")
    customer.displayInfo()

    // Displaying cart contents
    println("\nCart Contents:")
    shoppingCart.cartItems.foreach(_.displayInfo())

    // Calculating and displaying the total price
    println("\nTotal Price: $" + shoppingCart.checkout())
  }
}
