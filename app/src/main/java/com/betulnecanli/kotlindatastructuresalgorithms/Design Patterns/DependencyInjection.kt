// Service interface
interface MessageService {
    fun sendMessage(message: String)
}

// Implementation of the MessageService interface
class EmailService : MessageService {
    override fun sendMessage(message: String) {
        println("Sending email: $message")
    }
}

// Client class that depends on MessageService
class NotificationService(private val messageService: MessageService) {
    fun sendNotification(message: String) {
        println("Preparing notification...")
        messageService.sendMessage(message)
        println("Notification sent successfully.")
    }
}

fun main() {
    // Using Dependency Injection to provide the dependency (EmailService) to NotificationService
    val emailService = EmailService()
    val notificationService = NotificationService(emailService)

    // Client code can now use the notification service without worrying about creating dependencies.
    notificationService.sendNotification("Hello, this is a notification!")
}
