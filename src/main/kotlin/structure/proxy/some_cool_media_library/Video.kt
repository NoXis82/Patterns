package structure.proxy.some_cool_media_library

//Видеофайл
class Video() {
    var id: String? = null
    var title: String? = null
    var data: String? = null

    constructor(id: String, title: String) : this() {
        this.id = id
        this.title = title
        this.data = "Random video."
    }
}