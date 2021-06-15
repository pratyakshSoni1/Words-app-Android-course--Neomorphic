package com.smartphone_codes.words.DataSources

class DataSource {
    fun loadLetters():List<Char> {
        val lst = mutableListOf<Char>()
        lst.addAll('A'.rangeTo('Z'))
        return lst}

    fun loadWords(words:Array<String>):Array<String>{
        return words

    }


}