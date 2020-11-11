import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.BufferedReader
import java.io.FileReader
import java.util.*

class EmailSender {
    private val emailGenerator: EmailGenerator = EmailGenerator()

    init {
        emailGenerator.generateEmails()
    }

    /**
     * mocks sending emails with coroutines.
     * coroutines are used to improve performance
     */
    fun sendEmails() {
        runBlocking {
            getEmailsFromFile().forEach { email ->
                launch {
                    sendEmail(email)
                }
            }
        }
    }


    private suspend fun sendEmail(email: String) {
        println("sending email to $email ... ")
        delay(1000)
        println("email sent to $email ")

    }


    private fun getEmailsFromFile(): ArrayList<String> {
        val emails = ArrayList<String>()
        BufferedReader(FileReader(emailGenerator.emailFilePath)).use { br ->
            while (br.ready()) {
                emails.add(br.readLine())
            }
        }
        return emails;
    }

}

/**
 * Run main to test code
 * Generates email file in output dir and mocks sending emails
 */
fun main() {
    val emailSender = EmailSender();
    emailSender.sendEmails()
}