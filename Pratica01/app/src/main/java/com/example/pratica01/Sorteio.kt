package com.example.pratica01

import kotlin.random.Random

class Sorteio {

    private var valor: Int
    private var valorMin: Int = 1
    private var valorMax: Int = 100

    constructor(){
        this.valor = Random.nextInt(valorMin, valorMax + 1)
    }

    fun chute(chute: Int): String{
        if(chute == this.valor) {
            return "Jogador ganhou"
        } else if (chute < valorMin || chute > valorMax) {
            return "Jogador perdeu"
        } else if(chute < valor) {
            this.valorMin = chute
            return "Continue tentando"
        } else {
            this.valorMax = chute
            return "Continue tentando"
        }
    }

    fun getValor(): Int {
        return this.valor
    }

    fun getValorMin(): Int {
        return this.valorMin
    }

    fun getValorMax(): Int {
        return this.valorMax
    }
}