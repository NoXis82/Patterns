package structure.facade.some_complex_media_library

//Фабрика видеокодеков кодеков
class CodecFactory {

    companion object {
        fun extract(file: VideoFile): Codec {
            val type = file.getCodecType()
            if (type == "mp4") {
                println("CodecFactory: extracting mpeg audio...")
                return MPEG4CompressionCodec()
            } else {
                println("CodecFactory: extracting ogg audio...")
                return OggCompressionCodec()
            }
        }
    }
}