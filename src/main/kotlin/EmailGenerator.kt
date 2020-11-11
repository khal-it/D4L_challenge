import java.io.File
import java.io.FileWriter


class EmailGenerator {

    companion object {
        const val emailCount = 1000000
        val timestamp: Long = System.currentTimeMillis()
    }

    val outputDirPath: String = "output"
    val emailFilePath: String = "$outputDirPath/emails_$timestamp.txt"


    fun generateEmails() {
        createOutputDirIfNotExistent()
        generateRandomEmailsAndWriteToFile()
    }


    private fun generateRandomEmailsAndWriteToFile() {
        val writer = FileWriter(emailFilePath)
        for (i in 1..emailCount) {
            val email: String = generateRandomEmail();
            writer.write(email + System.lineSeparator());
        }
        writer.close();
    }


    private fun createOutputDirIfNotExistent() {
        val directory = File(outputDirPath)
        if (!directory.exists()) {
            directory.mkdir()
        }
    }


}
