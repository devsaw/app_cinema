package br.digitalhouse.app_cinema.data

class ListBuilder {
    var listaDeImagens = mutableListOf<Imagens>()

    fun add(image: Int) {
        var itens = Imagens(image)
        listaDeImagens.add(itens)
    }
}