package com.example.pratica02

import kotlin.random.Random

class Sorteio {

    private var valor: Int
    private var valorMin: Int = 1
    private var valorMax: Int = 100
    private lateinit var status: String

    constructor(){
        this.valor = Random.nextInt(valorMin, valorMax + 1)
    }

    fun chute(chute: Int): String{
        this.status = ""
        
        if(chute == this.valor) {
            this.status = "ganhou"
            return this.status
        } else if (chute < valorMin || chute > valorMax) {
            this.status = "perdeu"
            return this.status
        } else if(chute < valor) {
            this.valorMin = chute
            this.status = "Continue tentando"
            return this.status
        } else {
            this.valorMax = chute
            this.status = "Continue tentando"
            return this.status
        }
    }

    fun getValorMin(): Int {
        return this.valorMin
    }

    fun getValorMax(): Int {
        return this.valorMax
    }

}