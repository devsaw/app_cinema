package br.digitalhouse.app_cinema.data

class ListBuilderClass {
    var listaDeImagens = mutableListOf<ImageClass>()

    fun add(image: Int) {
        var itens = ImageClass(image)
        listaDeImagens.add(itens)
    }
}