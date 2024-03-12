package behavioral.iterator.profile


//Профиль пользователя
class Profile(private val email: String, private val name: String, vararg contacts: String) {
    private val contacts = hashMapOf<String, ArrayList<String>>()

    init {
        // Parse contact list from a set of "friend:email@gmail.com" pairs.
        for (contact in contacts) {
            val parts = contact.split(":")
            var contactType = "friend"
            var contactEmail: String
            if (parts.size == 1) {
                contactEmail = parts[0]
            } else {
                contactType = parts[0]
                contactEmail = parts[1]
            }
            if (!this.contacts.containsKey(contactType)) {
                this.contacts[contactType] = arrayListOf()
            }
            this.contacts[contactType]?.add(contactEmail)
        }
    }

    fun getEmail(): String {
        return email
    }

    fun getName(): String {
        return name
    }

    fun getContacts(contactType: String): List<String>? {
        if (!this.contacts.containsKey(contactType)) {
            this.contacts[contactType] = arrayListOf()
        }
        return contacts[contactType]
    }
}