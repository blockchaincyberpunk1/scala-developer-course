import scopt.OptionParser

// Step 2: Define the case class to represent the configuration
case class AppConfig(shape: String = "", dimensions: List[Double] = Nil)

object CommandLineApp {
  def main(args: Array[String]): Unit = {

    // Step 1: Define the scopt option parser
    val parser = new OptionParser[AppConfig]("CommandLineApp") {
      head("CommandLineApp", "1.0")
      opt[String]('s', "shape")
        .required()
        .action((value, config) => config.copy(shape = value))
        .text("Shape type: circle, rectangle, etc.")
      opt[Seq[Double]]('d', "dimensions")
        .required()
        .valueName("<dim1>,<dim2>...")
        .action((value, config) => config.copy(dimensions = value.toList))
        .text("Dimensions of the shape")
    }

    // Step 3: Parse the command-line arguments
    parser.parse(args, AppConfig()) match {
      case Some(config) =>
        // Step 4: Implement the logic based on the scenario (calculating area)
        val area = config.shape.toLowerCase match {
          case "circle" if config.dimensions.length == 1 => math.Pi * math.pow(config.dimensions.head, 2)
          case "rectangle" if config.dimensions.length == 2 => config.dimensions.head * config.dimensions(1)
          case _ =>
            println("Invalid input. Check shape type and dimensions.")
            sys.exit(1)
        }
        println(s"The area of ${config.shape} is $area")
      case None =>
        // Error in parsing command-line arguments
        println("Error parsing command-line arguments")
        sys.exit(1)
    }
  }
}


/* 
Explanation:

Import the scopt library: import scopt.OptionParser is necessary to use the scopt library for command-line argument parsing.

Define the case class: AppConfig is a case class that represents the configuration of the command-line application. It includes shape and dimensions as its attributes.

Create the main function: The main entry point of the program where the argument parsing and processing logic will be implemented.

Define the OptionParser: An instance of OptionParser is created, specifying the program name as "CommandLineApp". The opt method is used to define options that the user can provide in the command line.

Define options: opt[String]('s', "shape") defines an option for the shape type. It's marked as required using .required() and uses the .action method to update the configuration's shape attribute.

Define options with values: opt[Seq[Double]]('d', "dimensions") defines an option for the dimensions. It's also marked as required and uses .valueName to specify the format of values. .action updates the configuration's dimensions attribute.

Parse command-line arguments: The parser.parse(args, AppConfig()) line parses the provided command-line arguments and returns an Option[AppConfig].

Process parsed arguments: Using pattern matching, the program checks if arguments were successfully parsed. If so, it calculates the area based on the shape and dimensions provided.

Calculate area: The area calculation is implemented using pattern matching to differentiate between different shapes and their corresponding dimensions.

Handle errors: If the provided shape or dimensions are invalid, an error message is displayed, and the program exits with an error code.

Handle parsing errors: If there's an error in parsing the command-line arguments, an error message is displayed, and the program exits with an error code.

Overall, this Scala program utilizes the scopt library to parse command-line arguments, process user input, and calculate the area of geometric shapes based on the provided dimensions. It demonstrates how to create a user-friendly command-line application that responds to user input and provides meaningful output.

*/