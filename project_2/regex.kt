import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    // Define regular expression patterns
    val patterns = mapOf(
        "Email" to "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex(),
        "Phone Number" to "^\\+?[0-9]{10,15}$".toRegex(), // Matches + followed by 10 to 15 digits
        "URL" to "^(https?://)?(www\\.)?[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(/\\S*)?$".toRegex(),
        "Password" to "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$".toRegex(),
        "Date (YYYY-MM-DD)" to "^(\\d{4})-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$".toRegex()
    )

    // Get input from the user
    println("Enter the type of input to check (email, phone, url, password, date): ")
    val inputType = scanner.nextLine().trim().lowercase()

    println("Enter the value to check: ")
    val inputValue = scanner.nextLine()

    // Validate the input based on the selected type
    when (inputType) {
        "email" -> checkPattern("Email", inputValue, patterns["Email"])
        "phone" -> checkPattern("Phone Number", inputValue, patterns["Phone Number"])
        "url" -> checkPattern("URL", inputValue, patterns["URL"])
        "password" -> checkPattern("Password", inputValue, patterns["Password"])
        "date" -> checkPattern("Date (YYYY-MM-DD)", inputValue, patterns["Date (YYYY-MM-DD)"])
        else -> println("Invalid input type selected.")
    }
}

// Function to check the pattern and print the result
fun checkPattern(type: String, value: String, pattern: Regex?) {
    if (pattern != null && pattern.matches(value)) {
        println("The $type '$value' is valid.")
    } else {
        println("The $type '$value' is not valid.")
    }
}
