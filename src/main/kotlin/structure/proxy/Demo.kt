package structure.proxy

import structure.proxy.downloader.YouTubeDownloader
import structure.proxy.proxy.YouTubeCacheProxy
import structure.proxy.some_cool_media_library.ThirdPartyYouTubeClass


fun main() {
    val naiveDownloader = YouTubeDownloader(ThirdPartyYouTubeClass())
    val smartDownloader = YouTubeDownloader(YouTubeCacheProxy())

    val naive: Long = test(naiveDownloader).toLong()
    val smart: Long = test(smartDownloader).toLong()
    println("Time saved by caching proxy: ${naive - smart} ms")
}

private fun test(downloader: YouTubeDownloader): Long {
    val startTime = System.currentTimeMillis()

    // User behavior in our app:
    downloader.renderPopularVideos()
    downloader.renderVideoPage("catzzzzzzzzz")
    downloader.renderPopularVideos()
    downloader.renderVideoPage("dancesvideoo")
    // Users might visit the same page quite often.
    downloader.renderVideoPage("catzzzzzzzzz")
    downloader.renderVideoPage("someothervid")

    val estimatedTime = System.currentTimeMillis() - startTime
    print("Time elapsed: $estimatedTime ms\n")
    return estimatedTime
}

//Результат выполнения
//Connecting to http://www.youtube.com... Connected!
//Downloading populars... Done!

//-------------------------------
//Most popular videos on YouTube (imagine fancy HTML)
//ID: sadgahasgdas / Title: Catzzzz.avi
//ID: asdfas3ffasd / Title: Dancing video.mpq
//ID: 3sdfgsd1j333 / Title: Programing lesson#1.avi
//ID: mkafksangasj / Title: Dog play with ball.mp4
//ID: dlsdk5jfslaf / Title: Barcelona vs RealM.mov
//-------------------------------

//Connecting to http://www.youtube.com/catzzzzzzzzz... Connected!
//Downloading video... Done!

//-------------------------------
//Video page (imagine fancy HTML)
//ID: catzzzzzzzzz
//Title: Some video title
//Video: Random video.
//-------------------------------

//Connecting to http://www.youtube.com... Connected!
//Downloading populars... Done!

//-------------------------------
//Most popular videos on YouTube (imagine fancy HTML)
//ID: sadgahasgdas / Title: Catzzzz.avi
//ID: asdfas3ffasd / Title: Dancing video.mpq
//ID: 3sdfgsd1j333 / Title: Programing lesson#1.avi
//ID: mkafksangasj / Title: Dog play with ball.mp4
//ID: dlsdk5jfslaf / Title: Barcelona vs RealM.mov
//-------------------------------

//Connecting to http://www.youtube.com/dancesvideoo... Connected!
//Downloading video... Done!

//-------------------------------
//Video page (imagine fancy HTML)
//ID: dancesvideoo
//Title: Some video title
//Video: Random video.
//-------------------------------

//Connecting to http://www.youtube.com/catzzzzzzzzz... Connected!
//Downloading video... Done!

//-------------------------------
//Video page (imagine fancy HTML)
//ID: catzzzzzzzzz
//Title: Some video title
//Video: Random video.
//-------------------------------

//Connecting to http://www.youtube.com/someothervid... Connected!
//Downloading video... Done!

//-------------------------------
//Video page (imagine fancy HTML)
//ID: someothervid
//Title: Some video title
//Video: Random video.
//-------------------------------

//Time elapsed: 9354ms
//Connecting to http://www.youtube.com... Connected!
//Downloading populars... Done!

//-------------------------------
//Most popular videos on YouTube (imagine fancy HTML)
//ID: sadgahasgdas / Title: Catzzzz.avi
//ID: asdfas3ffasd / Title: Dancing video.mpq
//ID: 3sdfgsd1j333 / Title: Programing lesson#1.avi
//ID: mkafksangasj / Title: Dog play with ball.mp4
//ID: dlsdk5jfslaf / Title: Barcelona vs RealM.mov
//-------------------------------

//Connecting to http://www.youtube.com/catzzzzzzzzz... Connected!
//Downloading video... Done!

//-------------------------------
//Video page (imagine fancy HTML)
//ID: catzzzzzzzzz
//Title: Some video title
//Video: Random video.
//-------------------------------

//Retrieved list from cache.

//-------------------------------
//Most popular videos on YouTube (imagine fancy HTML)
//ID: sadgahasgdas / Title: Catzzzz.avi
//ID: asdfas3ffasd / Title: Dancing video.mpq
//ID: 3sdfgsd1j333 / Title: Programing lesson#1.avi
//ID: mkafksangasj / Title: Dog play with ball.mp4
//ID: dlsdk5jfslaf / Title: Barcelona vs RealM.mov
//-------------------------------

//Connecting to http://www.youtube.com/dancesvideoo... Connected!
//Downloading video... Done!

//-------------------------------
//Video page (imagine fancy HTML)
//ID: dancesvideoo
//Title: Some video title
//Video: Random video.
//-------------------------------

//Retrieved video 'catzzzzzzzzz' from cache.

//-------------------------------
//Video page (imagine fancy HTML)
//ID: catzzzzzzzzz
//Title: Some video title
//Video: Random video.
//-------------------------------

//Connecting to http://www.youtube.com/someothervid... Connected!
//Downloading video... Done!

//-------------------------------
//Video page (imagine fancy HTML)
//ID: someothervid
//Title: Some video title
//Video: Random video.
//-------------------------------

//Time elapsed: 5875ms
//Time saved by caching proxy: 3479ms