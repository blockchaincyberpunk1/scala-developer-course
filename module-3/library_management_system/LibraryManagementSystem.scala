// Define a class named Book with constructor parameters title, author, and isbn
class Book(val title: String, val author: String, val isbn: String) {
  // Define a method to display the book information
  def displayBookInfo(): Unit = {
    println(s"Title: $title")
    println(s"Author: $author")
    println(s"ISBN: $isbn")
  }
}

// Define a class named User with constructor parameters name and libraryId
class User(val name: String, val libraryId: String) {
  // Create a mutable map to store borrowed books along with their due dates
  var borrowedBooks: Map[String, String] = Map()

  // Define a method to borrow a book
  def borrowBook(book: Book, dueDate: String): Unit = {
    // Add the book title and due date to the borrowedBooks map
    borrowedBooks += (book.title -> dueDate)
    println(s"$name borrowed '${book.title}' until $dueDate")
  }

  // Define a method to return a book
  def returnBook(book: Book): Unit = {
    // Remove the book from the borrowedBooks map
    borrowedBooks -= book.title
    println(s"$name returned '${book.title}'")
  }
}

// Define a trait named LibraryItem with abstract methods isAvailable, borrow, and return
trait LibraryItem {
  def isAvailable: Boolean
  def borrow(user: User, dueDate: String): Unit
  def `return`(user: User): Unit
}

// Define a class named BookItem that extends the LibraryItem trait
class BookItem(val book: Book) extends LibraryItem {
  // Initialize optional variables to track who borrowed the book and the due date
  var borrowedBy: Option[User] = None
  var dueDate: Option[String] = None

  // Implement the isAvailable method to check if the book is available for borrowing
  override def isAvailable: Boolean = borrowedBy.isEmpty

  // Implement the borrow method to borrow the book
  override def borrow(user: User, dueDate: String): Unit = {
    // Set the borrower and due date
    borrowedBy = Some(user)
    this.dueDate = Some(dueDate)
    println(s"${user.name} borrowed '${book.title}' until $dueDate")
  }

  // Implement the return method to return the book
  override def `return`(user: User): Unit = {
    // Reset borrower and due date
    borrowedBy = None
    dueDate = None
    println(s"${user.name} returned '${book.title}'")
  }
}

// Define a class named MagazineItem that extends the LibraryItem trait
class MagazineItem extends LibraryItem {
  // Implement the isAvailable method for magazines
  override def isAvailable: Boolean = true

  // Implement the borrow method for magazines
  override def borrow(user: User, dueDate: String): Unit = {
    println("Magazines cannot be borrowed")
  }

  // Implement the return method for magazines
  override def `return`(user: User): Unit = {
    println("Magazines cannot be returned")
  }
}

// Define a class named Library to manage books, users, and borrowed items
class Library {
  // Initialize lists to store books and users
  var books: List[BookItem] = List()
  var users: List[User] = List()

  // Define a method to add a book to the library
  def addBook(book: Book): Unit = {
    // Create a new BookItem instance and add it to the books list
    books = new BookItem(book) :: books
    println(s"'${book.title}' added to the library")
  }

  // Define a method to add a user to the library
  def addUser(user: User): Unit = {
    // Add the user to the users list
    users = user :: users
    println(s"${user.name} added to the library users")
  }
}

// Define the main object to demonstrate the functionality of the Library Management System
object LibraryManagementSystem {
  def main(args: Array[String]): Unit = {
    // Create a new Library instance
    val library = new Library()

    // Create instances of books, users, and items
    val book1 = new Book("The Alchemist", "Paulo Coelho", "978-0062315007")
    val book2 = new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084")
    val user1 = new User("Alice", "A123")
    val user2 = new User("Bob", "B456")

    // Add books and users to the library
    library.addBook(book1)
    library.addBook(book2)
    library.addUser(user1)
    library.addUser(user2)

    // Find book items based on books
    val book1Item = library.books.find(_.book == book1).get
    val book2Item = library.books.find(_.book == book2).get

    // Demonstrate borrowing and returning actions
    user1.borrowBook(book1Item.book, "2023-09-01")
    user2.borrowBook(book2Item.book, "2023-08-30")

    user1.returnBook(book1Item.book)
    user2.returnBook(book2Item.book)
  }
}
