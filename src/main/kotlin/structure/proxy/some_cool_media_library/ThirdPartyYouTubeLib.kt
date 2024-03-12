package structure.proxy.some_cool_media_library


//Интерфейс удалённого сервиса
interface ThirdPartyYouTubeLib {
    fun popularVideos(): HashMap<String, Video>
    fun getVideo(videoId: String): Video
}