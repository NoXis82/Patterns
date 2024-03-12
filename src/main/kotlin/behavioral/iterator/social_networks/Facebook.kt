package behavioral.iterator.social_networks

import behavioral.iterator.iterators.FacebookIterator
import behavioral.iterator.iterators.ProfileIterator
import behavioral.iterator.profile.Profile

//Facebook
class Facebook(cache: List<Profile>?) : SocialNetwork {
    private var profiles: List<Profile>? = null

    init {
        if (cache != null) {
            this.profiles = cache
        } else {
            this.profiles = arrayListOf()
        }
    }

    fun requestProfileFromFacebook(profileEmail: String): Profile? {
        // Здесь бы был POST запрос к одному из адресов API Facebook. Но вместо
        // этого мы эмулируем долгое сетевое соединение, прямо как в реальной
        // жизни...
        simulateNetworkLatency()
        println("Facebook: Loading profile $profileEmail over the network...")
        // ...и возвращаем тестовые данные.
        return findProfile(profileEmail)
    }

    fun requestProfileFriendsFromFacebook(profileEmail: String, contactType: String): List<String>? {
        // Здесь бы был POST запрос к одному из адресов API Facebook. Но вместо
        // этого мы эмулируем долгое сетевое соединение, прямо как в реальной
        // жизни...
        simulateNetworkLatency()
        println("Facebook: Loading $contactType list of $profileEmail over the network...")
        // ...и возвращаем тестовые данные.
        return findProfile(profileEmail)?.getContacts(contactType)
    }

    private fun findProfile(profileEmail: String): Profile? {
        for (profile in profiles!!) {
            if (profile.getEmail() == profileEmail) {
                return profile
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

    override fun createCoworkersIterator(profileEmail: String): ProfileIterator {
        return FacebookIterator(this, "coworkers", profileEmail)
    }

    override fun createFriendsIterator(profileEmail: String): ProfileIterator {
        return FacebookIterator(this, "friends", profileEmail)
    }
}