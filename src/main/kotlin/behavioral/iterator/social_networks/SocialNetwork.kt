package behavioral.iterator.social_networks

import behavioral.iterator.iterators.ProfileIterator

//Интерфейс социальной сети
interface SocialNetwork {
    fun createFriendsIterator(profileEmail: String): ProfileIterator
    fun createCoworkersIterator(profileEmail: String): ProfileIterator
}