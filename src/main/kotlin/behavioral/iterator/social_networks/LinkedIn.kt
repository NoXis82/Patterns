package behavioral.iterator.social_networks

import behavioral.iterator.iterators.LinkedInIterator
import behavioral.iterator.iterators.ProfileIterator
import behavioral.iterator.profile.Profile

//LinkedIn
class LinkedIn(cache: List<Profile>?) : SocialNetwork {
    private var contacts: List<Profile>? = null

    init {
        if (cache != null) {
            this.contacts = cache
        } else {
            this.contacts = arrayListOf()
        }
    }

    fun requestContactInfoFromLinkedInAPI(profileEmail: String): Profile? {
        // Здесь бы был POST запрос к одному из адресов API LinkedIn. Но вместо
        // этого мы эмулируем долгое сетевое соединение, прямо как в реальной
        // жизни...
        simulateNetworkLatency()
        println("LinkedIn: Loading profile $profileEmail over the network...")
        // ...и возвращаем тестовые данные.
        return findProfile(profileEmail)
    }

    fun requestRelatedContactsFromLinkedInAPI(profileEmail: String, contactType: String): List<String>? {
        // Здесь бы был POST запрос к одному из адресов API LinkedIn. Но вместо
        // этого мы эмулируем долгое сетевое соединение, прямо как в реальной
        // жизни...
        simulateNetworkLatency()
        println("LinkedIn: Loading $contactType list of $profileEmail over the network...")
        // ...и возвращаем тестовые данные.
        return findProfile(profileEmail)?.getContacts(contactType)
    }

    private fun findProfile(profileEmail: String): Profile? {
        for (contact in contacts!!) {
            if (contact.getEmail() == profileEmail) {
                return contact
            }
        }
        return null
    }

    private fun simulateNetworkLatency() {
        try {
            Thread.sleep(2500)
        } catch (ex: InterruptedException) {
            ex.printStackTrace()
        }
    }

    override fun createFriendsIterator(profileEmail: String): ProfileIterator {
        return LinkedInIterator(this, "friends", profileEmail)
    }

    override fun createCoworkersIterator(profileEmail: String): ProfileIterator {
        return LinkedInIterator(this, "coworkers", profileEmail)
    }
}