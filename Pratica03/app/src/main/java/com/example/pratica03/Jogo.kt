package com.example.pratica03

class Jogo {
    var times: MutableList<Int>

    init {
        this.times = mutableListOf(
            R.drawable.elefante,
            R.drawable.leao,
            R.drawable.macaco,
            R.drawable.onca,
            R.drawable.panda,
            R.drawable.peixe,
            R.drawable.rino,
            R.drawable.zebra,
        )
        this.times.shuffle()
    }
}