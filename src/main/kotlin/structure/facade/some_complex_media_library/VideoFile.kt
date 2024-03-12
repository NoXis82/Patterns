package structure.facade.some_complex_media_library

//Класс видеофайла
class VideoFile() {
    private var name: String? = null
    private var codecType: String? = null

    constructor(name: String) : this() {
        this.name = name
        this.codecType = name.substring(name.indexOf(".") + 1);
    }

    fun getCodecType(): String? {
        return codecType
    }

    fun getName(): String? {
        return name
    }
}