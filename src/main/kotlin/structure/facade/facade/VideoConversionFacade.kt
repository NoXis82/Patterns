package structure.facade.facade

import structure.facade.some_complex_media_library.*
import java.io.File


//Фасад библиотеки работы с видео
class VideoConversionFacade {
    fun convertVideo(fileName: String, format: String): File {
        println("VideoConversionFacade: conversion started.")
        val file = VideoFile(fileName)
        val sourceCodec: Codec = CodecFactory.extract(file)
        val destinationCodec = if (format == "mp4") {
            OggCompressionCodec()
        } else {
            MPEG4CompressionCodec()
        }
        val buffer: VideoFile = BitrateReader.read(file, sourceCodec)
        val intermediateResult: VideoFile = BitrateReader.convert(buffer, destinationCodec)
        val result = AudioMixer().fix(intermediateResult)
        println("VideoConversionFacade: conversion completed.")
        return result
    }
}