package com.example.androiddevcert

data class Song(val title: String, val artist: String, val publishYear: String, var playCount: Int)  {
    var isPopular: Boolean = playCount >= 1000
}

fun printSongDescription(song: Song) {
    println("MATU: ${song.title}, performed by ${song.artist}, was released in ${song.publishYear}. It is ${song.isPopular} that the song is popular as it has a playcount of ${song.playCount}")

}

