// Data Transformation and Analysis in Scala: Functional Programming Assessment

// Step 1: Data Preparation

// Defining a case class to represent employee records
case class Employee(name: String, department: String, salary: Double, experience: Int)

// Creating a list of employee records
val employeeData: List[Employee] = List(
  Employee("Alice", "Engineering", 60000, 3),
  Employee("Bob", "Sales", 45000, 1),
  Employee("Charlie", "Engineering", 75000, 6),
  Employee("David", "HR", 50000, 2)
  // ... add more records as needed
)

// Display original employee data
println("Original Employee Data:")
employeeData.foreach(emp => println(emp))

// Step 2: Higher-Order Functions

// Function to calculate a new salary based on a given factor
def mapSalary(salary: Double, factor: Double => Double): Double = factor(salary)

// Function to filter employees by department
def filterByDepartment(department: String, employees: List[Employee]): List[Employee] =
  employees.filter(_.department == department)

// Step 3: Immutability and Transformation

// Using higher-order functions to transform the dataset

// Calculating increased salaries for all employees
val increasedSalaries: List[Double] = employeeData.map(emp => mapSalary(emp.salary, _ * 1.1))

// Extracting employees from the Engineering department
val engineeringEmployees: List[Employee] = filterByDepartment("Engineering", employeeData)

// Display transformed data
println("\nTransformed Data:")
increasedSalaries.zipWithIndex.foreach { case (salary, index) =>
  println(s"${employeeData(index).name}: Original Salary = ${employeeData(index).salary}, Increased Salary = $salary")
}

// Step 4: Pattern Matching

// Function to categorize years of experience into levels
def yearsOfExperienceLevel(years: Int): String = years match {
  case x if x < 2 => "Junior"
  case x if x >= 2 && x <= 5 => "Mid-Level"
  case _ => "Senior"
}

// Step 5: Transform and Analyze

// Transforming employee years of experience using pattern matching
val transformedExperience: List[String] = employeeData.map(emp => yearsOfExperienceLevel(emp.experience))

// Display transformed experience levels
println("\nTransformed Experience Levels:")
transformedExperience.zipWithIndex.foreach { case (level, index) =>
  println(s"${employeeData(index).name}: Experience Level = $level")
}

// Conclusion

// This assessment demonstrated the application of functional programming concepts in Scala for data transformation and analysis.

// I utilized higher-order functions, immutability, and pattern matching to efficiently process employee records.

// Each step adhered to the principles of functional programming, resulting in concise and readable code.

// This exercise enhances my understanding of functional programming's capabilities and equips me with valuable skills for real-world data manipulation tasks.
