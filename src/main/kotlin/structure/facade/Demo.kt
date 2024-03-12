package structure.facade

import structure.facade.facade.VideoConversionFacade


fun main() {
    val converter = VideoConversionFacade()
    val mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4")
}
//Результат выполнения
//VideoConversionFacade: conversion started.
//CodecFactory: extracting ogg audio...
//BitrateReader: reading file...
//BitrateReader: writing file...
//AudioMixer: fixing audio...
//VideoConversionFacade: conversion completed.