package behavioral.iterator.iterators

import behavioral.iterator.profile.Profile
import behavioral.iterator.social_networks.LinkedIn

//Итератор пользователей сети LinkedIn
class LinkedInIterator(
    private val linkedIn: LinkedIn,
    private val type: String,
    private val email: String
) : ProfileIterator {
    private var currentPosition = 0
    private val emails = arrayListOf<String>()
    private val contacts = arrayListOf<Profile?>()

    private fun lazyLoad() {
        if (emails.size == 0) {
            val profiles = linkedIn.requestRelatedContactsFromLinkedInAPI(email, type)
            profiles?.forEach {
                this.emails.add(it)
                this.contacts.add(null)
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
        var friendProfile = contacts[currentPosition]
        if (friendProfile == null) {
            friendProfile = linkedIn.requestContactInfoFromLinkedInAPI(friendEmail)
            contacts.add(currentPosition, friendProfile)
        }
        currentPosition++
        return friendProfile
    }

    override fun reset() {
        currentPosition = 0
    }
}