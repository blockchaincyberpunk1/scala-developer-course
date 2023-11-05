def writeToFile(data: String, filename: String): Unit = {
    val file = new java.io.File(filename)
    val writer = new java.io.PrintWriter(file)
    writer.write(data)
    writer.close()
}

// The writeToFile function also has a side effect—it writes data to a file. While this might be the intended behavior, it's essential to consider the implications on file handling and error handling.