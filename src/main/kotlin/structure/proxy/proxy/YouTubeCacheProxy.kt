package structure.proxy.proxy

import structure.proxy.some_cool_media_library.ThirdPartyYouTubeClass
import structure.proxy.some_cool_media_library.ThirdPartyYouTubeLib
import structure.proxy.some_cool_media_library.Video


//Сервисный класс для работы с кешем
class YouTubeCacheProxy() : ThirdPartyYouTubeLib {
    private val youtubeService: ThirdPartyYouTubeLib = ThirdPartyYouTubeClass()
    private var cachePopular = HashMap<String, Video>()
    private var cacheAll = HashMap<String, Video>()

    override fun popularVideos(): HashMap<String, Video> {
        if (cachePopular.isEmpty()) {
            cachePopular = youtubeService.popularVideos()
        } else {
            println("Retrieved list from cache.")
        }
        return cachePopular
    }

    override fun getVideo(videoId: String): Video {
        var video = cacheAll[videoId]
        if (video == null) {
            video = youtubeService.getVideo(videoId)
            cacheAll[videoId] = video
        } else {
            println("Retrieved video '$videoId' from cache.")
        }
        return video
    }

    fun reset() {
        cachePopular.clear()
        cacheAll.clear()
    }

}