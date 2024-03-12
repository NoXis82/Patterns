package behavioral.iterator

import behavioral.iterator.profile.Profile
import behavioral.iterator.social_networks.Facebook
import behavioral.iterator.social_networks.LinkedIn
import behavioral.iterator.spammer.SocialSpammer
import java.util.*


fun main() {
    println("Please specify social network to target spam tool (default:Facebook):")
    println("1. Facebook")
    println("2. LinkedIn")
    val scanner = Scanner(System.`in`)
    val choice = scanner.nextLine()
    val network = when (choice) {
        "2" -> LinkedIn(createTestProfiles())
        else -> Facebook(createTestProfiles())
    }
    val spammer = SocialSpammer(network)
    spammer.sendSpamToFriends(
        "anna.smith@bing.com",
        "Hey! This is Anna's friend Josh. Can you do me a favor and like this post [link]?"
    )
    spammer.sendSpamToCoworkers(
        "anna.smith@bing.com",
        "Hey! This is Anna's boss Jason. Anna told me you would be interested in [link].")
}

private fun createTestProfiles(): List<Profile>? {
    val data: MutableList<Profile> = ArrayList()
    data.add(
        Profile(
            "anna.smith@bing.com",
            "Anna Smith",
            "friends:mad_max@ya.com",
            "friends:catwoman@yahoo.com",
            "coworkers:sam@amazon.com"
        )
    )
    data.add(
        Profile(
            "mad_max@ya.com",
            "Maximilian",
            "friends:anna.smith@bing.com",
            "coworkers:sam@amazon.com"
        )
    )
    data.add(
        Profile(
            "bill@microsoft.eu",
            "Billie",
            "coworkers:avanger@ukr.net"
        )
    )
    data.add(
        Profile(
            "avanger@ukr.net",
            "John Day",
            "coworkers:bill@microsoft.eu"
        )
    )
    data.add(
        Profile(
            "sam@amazon.com",
            "Sam Kitting",
            "coworkers:anna.smith@bing.com",
            "coworkers:mad_max@ya.com",
            "friends:catwoman@yahoo.com"
        )
    )
    data.add(
        Profile(
            "catwoman@yahoo.com",
            "Liza",
            "friends:anna.smith@bing.com",
            "friends:sam@amazon.com"
        )
    )
    return data
}
//Результат выполнения
//Please specify social network to target spam tool (default:Facebook):
//1. Facebook
//2. LinkedIn
//> 1

//Iterating over friends...

//Facebook: Loading 'friends' list of 'anna.smith@bing.com' over the network...
//Facebook: Loading profile 'mad_max@ya.com' over the network...
//Sent message to: 'mad_max@ya.com'. Message body: 'Hey! This is Anna's friend Josh. Can you do me a favor and like this post [link]?'
//Facebook: Loading profile 'catwoman@yahoo.com' over the network...
//Sent message to: 'catwoman@yahoo.com'. Message body: 'Hey! This is Anna's friend Josh. Can you do me a favor and like this post [link]?'

//Iterating over coworkers...

//Facebook: Loading 'coworkers' list of 'anna.smith@bing.com' over the network...
//Facebook: Loading profile 'sam@amazon.com' over the network...
//Sent message to: 'sam@amazon.com'. Message body: 'Hey! This is Anna's boss Jason. Anna told me you would be interested in [link].'