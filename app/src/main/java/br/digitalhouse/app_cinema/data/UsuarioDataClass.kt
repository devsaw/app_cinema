package br.digitalhouse.app_cinema.data

data class UsuarioDataClass(
    val login: String,
    val senha: String
) {

    fun validaEmail(login: String): Boolean {
        var variavel = false
        if (login.contains("@"))
            variavel = true
        return variavel
    }

    fun validaTamanho(senha: String): Boolean {
        return senha.count() >= 8
    }

    fun validaEspeciais(senha: String): Boolean {
        val listaEspeciais: List<String> =
            listOf("!", "@", "#", "$", "¨", "&", "*", "(", ")", "'", "-", "=", "+", "_", ".", ",", "/", "%", ":", ";", "?")
        var variavel = false
        for (character in listaEspeciais)
            if (senha.contains(character))
                variavel = true
        return variavel
    }

    fun validaNumeros(senha: String): Boolean {
        val listaNumeros: List<String> =
            listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "0")
        var variavel = false
        for (character in listaNumeros)
            if (senha.contains(character))
                variavel = true
        return variavel
    }

    fun validaSenha(senha: String): Boolean {
        val variavelEspeciais: Boolean = validaEspeciais(senha)
        val variavelNumeros: Boolean = validaNumeros(senha)
        val variavelTamanho: Boolean = validaTamanho(senha)
        var variavel = false
        if ((variavelEspeciais && variavelNumeros && variavelTamanho))
            variavel = true
        return variavel
    }
}
