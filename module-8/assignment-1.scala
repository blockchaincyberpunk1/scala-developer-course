// Step 1: Set Up a Sample Project
// Create a new Scala project using sbt (Simple Build Tool) or your preferred build tool.
// Add the necessary dependencies to your build.sbt file to include the Slick library.

// build.sbt
// Add the Slick and database driver dependencies
libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.3.3",
  "org.postgresql" % "postgresql" % "42.2.14" // Example: PostgreSQL driver
)

// Step 2: Configure the Database Connection
// Choose a database system (e.g., PostgreSQL, MySQL) that you want to connect to.
// Define a configuration for the database connection using Slick's configuration settings.

import slick.jdbc.PostgresProfile.api._ // Import the necessary Slick components

object DatabaseConfiguration {
  // Define a case class to hold database configuration
  case class DatabaseConfig(url: String, user: String, password: String, driver: String)

  // Database configuration details
  val config = DatabaseConfig(
    url = "jdbc:postgresql://localhost:5432/mydatabase", // Example PostgreSQL URL
    user = "username",
    password = "password",
    driver = "org.postgresql.Driver" // Example PostgreSQL driver
  )
}

// Step 3: Implement Database Interaction
// Create a simple Scala program that uses the configured database connection to perform interactions.

object DatabaseInteraction {
  def main(args: Array[String]): Unit = {
    // Create a database connection using the configured settings
    val db = Database.forURL(
      url = DatabaseConfiguration.config.url,
      user = DatabaseConfiguration.config.user,
      password = DatabaseConfiguration.config.password,
      driver = DatabaseConfiguration.config.driver
    )

    // Define a case class representing a table row
    case class User(id: Int, name: String, age: Int)

    // Define a Table object
    class Users(tag: Tag) extends Table[User](tag, "users") {
      def id = column[Int]("id", O.PrimaryKey)
      def name = column[String]("name")
      def age = column[Int]("age")
      def * = (id, name, age) <> (User.tupled, User.unapply)
    }

    // Create an instance of the Users table
    val users = TableQuery[Users]

    // Perform a simple query and print the results
    val query = users.filter(_.age > 18) // Select users older than 18
    val result = db.run(query.result)
    result.foreach(println)
  }
}


// Step 4: Test the Configuration
// Run your Scala program and verify that it successfully establishes a connection to the database.
// Test your database interaction code to ensure that it works as expected.

// To run the program, navigate to the project directory and use sbt to run the code:
// sbt run

// In this assignment, you've learned how to set up a database connection using the Slick library, configure the connection settings, and perform basic database interactions using Slick's query API. Understanding how to configure and interact with databases is crucial for building data-driven Scala applications.