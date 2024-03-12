package structure.proxy.some_cool_media_library

//Реализация удалённого сервиса
class ThirdPartyYouTubeClass() : ThirdPartyYouTubeLib {
    override fun popularVideos(): HashMap<String, Video> {
        connectToServer("http://www.youtube.com")
        return getRandomVideos()
    }

    override fun getVideo(videoId: String): Video {
        connectToServer("http://www.youtube.com/$videoId")
        return getSomeVideo(videoId)
    }

    // -----------------------------------------------------------------------
    // Поддельные методы имитации сетевой активности. Они такие же медленные, как и в жизни
    private fun random(min: Int, max: Int): Int {
        return min + (Math.random() * ((max - min) + 1)).toInt()
    }

    private fun experienceNetworkLatency() {
        val randomLatency = random(5, 10)
        for (i in 0 until randomLatency) {
            try {
                Thread.sleep(100)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }

    private fun connectToServer(server: String) {
        println("Connecting to $server ...")
        experienceNetworkLatency()
        println("Connected!\n")
    }

    private fun getRandomVideos(): HashMap<String, Video> {
        println("Downloading populars... ")
        experienceNetworkLatency()
        val hmap = HashMap<String, Video>()
        hmap["catzzzzzzzzz"] = Video("sadgahasgdas", "Catzzzz.avi")
        hmap["mkafksangasj"] = Video("mkafksangasj", "Dog play with ball.mp4")
        hmap["dancesvideoo"] = Video("asdfas3ffasd", "Dancing video.mpq")
        hmap["dlsdk5jfslaf"] = Video("dlsdk5jfslaf", "Barcelona vs RealM.mov")
        hmap["3sdfgsd1j333"] = Video("3sdfgsd1j333", "Programing lesson#1.avi")

        print("Done!\n")
        return hmap
    }

    private fun getSomeVideo(videoId: String): Video {
        println("Downloading video... ")
        experienceNetworkLatency()
        val video = Video(videoId, "Some video title")
        println("Done!\n")
        return video
    }
}