// Define the Contact class to represent individual contacts
class Contact(val name: String, val phoneNumber: String, val email: String) {
  // Method to display contact information
  def displayContact(): Unit = {
    println(s"Name: $name")
    println(s"Phone Number: $phoneNumber")
    println(s"Email: $email")
  }
}

// Define a trait named Group that represents a collection of contacts
trait Group {
  // Initialize the list of contacts as an empty list
  var contacts: List[Contact] = List()

  // Method to add a contact to the group
  def addContact(contact: Contact): Unit = {
    // Add the new contact to the list of contacts
    contacts = contact :: contacts
  }

  // Method to list all contacts in the group
  def listContacts(): Unit = {
    // Iterate through each contact in the list and display their information
    contacts.foreach(_.displayContact())
  }
}

// Create a class named FavoritesGroup that extends the Group trait
class FavoritesGroup extends Group {
  // Initialize the list of favorite contacts as an empty list
  var favoriteContacts: List[Contact] = List()

  // Method to mark a contact as a favorite
  def markFavorite(contact: Contact): Unit = {
    // Add the contact to the list of favorite contacts
    favoriteContacts = contact :: favoriteContacts
  }

  // Override the listContacts method to display only favorite contacts
  override def listContacts(): Unit = {
    // Iterate through each favorite contact and display their information
    favoriteContacts.foreach(_.displayContact())
  }
}

// Create a class named RestrictedGroup that extends the Group trait
class RestrictedGroup extends Group {
  // Initialize the list of restricted contacts as an empty list
  var restrictedContacts: List[Contact] = List()

  // Method to restrict access to a contact
  def restrictAccess(contact: Contact): Unit = {
    // Add the contact to the list of restricted contacts
    restrictedContacts = contact :: restrictedContacts
  }

  // Override the listContacts method to exclude restricted contacts
  override def listContacts(): Unit = {
    // Filter out restricted contacts from the list of contacts
    val unrestrictedContacts = contacts.filterNot(restrictedContacts.contains)
    // Iterate through each unrestricted contact and display their information
    unrestrictedContacts.foreach(_.displayContact())
  }
}

// Main object to demonstrate the functionality of the Contact Management System
object ContactManagementSystem {
  def main(args: Array[String]): Unit = {
    // Create instances of contacts
    val contact1 = new Contact("Alice", "123-456-7890", "alice@example.com")
    val contact2 = new Contact("Bob", "987-654-3210", "bob@example.com")
    val contact3 = new Contact("Charlie", "555-123-4567", "charlie@example.com")

    // Create an instance of FavoritesGroup
    val favoritesGroup = new FavoritesGroup()
    // Add contacts to the group
    favoritesGroup.addContact(contact1)
    favoritesGroup.addContact(contact2)
    // Mark a contact as a favorite
    favoritesGroup.markFavorite(contact1)

    // Create an instance of RestrictedGroup
    val restrictedGroup = new RestrictedGroup()
    // Add contacts to the group
    restrictedGroup.addContact(contact1)
    restrictedGroup.addContact(contact3)
    // Restrict access to a contact
    restrictedGroup.restrictAccess(contact3)

    // Display all contacts in the favorites group
    println("All Contacts:")
    favoritesGroup.listContacts()

    // Display only favorite contacts
    println("\nFavorite Contacts:")
    favoritesGroup.listContacts()

    // Display contacts with restricted access excluded
    println("\nContacts with Restricted Access:")
    restrictedGroup.listContacts()
  }
}
