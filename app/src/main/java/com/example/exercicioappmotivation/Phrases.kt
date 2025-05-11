package com.example.exercicioappmotivation

import kotlin.random.Random

data class Phrases (val description: String, val id: Int)


class PhrasesList{

    private val sun = MotivationConstants.CATEGORY.sun
    private val happy = MotivationConstants.CATEGORY.happy
    private val all = MotivationConstants.CATEGORY.all

    val listOfPhrases = listOf<Phrases>(
        Phrases("Não sabendo que era impossível, foi lá e fez.", happy),
        Phrases("Você não é derrotado quando perde, você é derrotado quando desiste!", happy),
        Phrases("Quando está mais escuro, vemos mais estrelas!", happy),
        Phrases("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", happy),
        Phrases("Não pare quando estiver cansado, pare quando tiver terminado.", happy),
        Phrases("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", happy),
        Phrases("A melhor maneira de prever o futuro é inventá-lo.", sun),
        Phrases("Você perde todas as chances que você não aproveita.", sun),
        Phrases("Fracasso é o condimento que dá sabor ao sucesso.", sun),
        Phrases(" Enquanto não estivermos comprometidos, haverá hesitação!", sun),
        Phrases("Se você não sabe onde quer ir, qualquer caminho serve.", sun),
        Phrases("Se você acredita, faz toda a diferença.", sun),
        Phrases("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", sun)
    )

    fun getPhrases(category: Int): String{
        var filter = listOfPhrases
        if (category != all){
            filter = listOfPhrases.filter { it.id == category }
        }
        val randomPhraseIndex = Random.nextInt(filter.size)
        val randomPhrase = listOfPhrases[randomPhraseIndex].description
        return randomPhrase

    }

}