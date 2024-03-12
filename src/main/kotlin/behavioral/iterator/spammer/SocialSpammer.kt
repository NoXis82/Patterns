package behavioral.iterator.spammer

import behavioral.iterator.social_networks.SocialNetwork


//Приложение рассылки сообщений
class SocialSpammer(private val network: SocialNetwork) {

    fun sendSpamToFriends(profileEmail: String, message: String) {
        println("\nIterating over friends...\n")
        val iterator = network.createFriendsIterator(profileEmail)
        while (iterator.hasNext()) {
            val profile = iterator.getNext()
            sendMessage(profile?.getEmail(), message)
        }
    }

    fun sendSpamToCoworkers(profileEmail: String, message: String) {
        println("\nIterating over coworkers...\n");
        val iterator = network.createCoworkersIterator(profileEmail)
        while (iterator.hasNext()) {
            val profile = iterator.getNext()
            sendMessage(profile?.getEmail(), message)
        }
    }

    private fun sendMessage(email: String?, message: String) {
        println("Sent message to: $email. Message body: $message")
    }
}