package com.example.pratica01

import kotlin.random.Random

class Aposta {
    private var numeros: MutableSet<Int>

    constructor() {
        this.numeros = mutableSetOf()
        this.setNumeros();
    }

    private fun setNumeros() {
        while(numeros.size < 6) {
            numeros.add(Random.nextInt(1, 61))
        }
    }

    override fun toString(): String {
        return this.numeros.toString()
    }
}