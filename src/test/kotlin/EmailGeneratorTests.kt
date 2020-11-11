import org.junit.jupiter.api.Test
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern
import kotlin.test.assertTrue


class EmailGeneratorTests {
    private val emailGenerator: EmailGenerator = EmailGenerator();


    @Test
    fun checkIfOutputDirWasCreated() {
        emailGenerator.generateEmails()
        assertTrue(
            File(emailGenerator.outputDirPath).exists(),
            message = "Output file was not created. Make sure to create the output file if it doesn't exist"
        )
    }

    @Test
    fun checkValidityOfEmail() {
        val email: String = generateRandomEmail()
        assertTrue(isValidEmailAddress(email), message = "$email is not a valid email")
    }

    @Test
    fun checkGeneratedEmailCount() {
        emailGenerator.generateEmails()
        val emails = ArrayList<String>()

        BufferedReader(FileReader(emailGenerator.emailFilePath)).use { br ->
            while (br.ready()) {
                emails.add(br.readLine())
            }
        }
        assertTrue(
            emails.size == 1000000,
            message = "number of generated emails shoud be 1 million but was ${emails.size}"
        )


    }


    private fun isValidEmailAddress(emailStr: String?): Boolean {
        val validEmailAddressRegex: Pattern =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE)
        val matcher: Matcher = validEmailAddressRegex.matcher(emailStr)
        return matcher.find()
    }


}