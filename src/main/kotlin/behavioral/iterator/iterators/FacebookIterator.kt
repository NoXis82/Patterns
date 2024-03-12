package behavioral.iterator.iterators

import behavioral.iterator.profile.Profile
import behavioral.iterator.social_networks.Facebook


//Итератор пользователей сети Facebook
class FacebookIterator(
    private val facebook: Facebook,
    private val type: String,
    private val email: String
) : ProfileIterator {
    private var currentPosition = 0
    private val emails = arrayListOf<String>()
    private val profiles = arrayListOf<Profile?>()

    private fun lazyLoad() {
        if (emails.size == 0) {
            val profiles = facebook.requestProfileFriendsFromFacebook(email, type)
            profiles?.forEach {
                this.emails.add(it)
                this.profiles.add(null)
            }
        }
    }

    override fun hasNext(): Boolean {
        lazyLoad()
        return currentPosition < emails.size
    }

    override fun getNext(): Profile? {
        if (!hasNext()) return null
        val friendEmail = emails[currentPosition]
        var friendProfile = profiles[currentPosition]
        if (friendProfile == null) {
           friendProfile = facebook.requestProfileFromFacebook(friendEmail)
           profiles.add(currentPosition, friendProfile)
        }
        currentPosition++
        return friendProfile
    }

    override fun reset() {
        currentPosition = 0
    }
}