package br.digitalhouse.app_cinema.login.model

data class UsuarioDataClass(
    var login: String,
    var senha: String
) {

    fun validaEmail(login: String): Boolean {
        var variavel = false
        if ( login.contains("@"))
            variavel = true
            return variavel
    }


    private fun validaEspeciais(senha: String): Boolean {
        val listaEspeciais: List<String> =
            listOf(
                "!",
                "@",
                "#",
                "$",
                "¨",
                "&",
                "*",
                "(",
                ")",
                "'",
                "-",
                "=",
                "+",
                "_",
                ".",
                ",",
                "/",
                "%",
                ":",
                ";",
                "?"
            )
        var variavel = false
        for (character in listaEspeciais)
            if (senha.contains(character))
                variavel = true
        return variavel
    }


    private fun validaNumeros(senha: String): Boolean {
        val listaNumeros: List<String> =
            listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "0")
        var variavel = false
        for (character in listaNumeros)
            if (senha.contains(character))
                variavel = true
        return variavel
    }

    private fun validaTamanho(senha: String): Boolean {
        var variavel = false
        if (senha.length >= 8)
            variavel = true
            return variavel
    }


    fun validaSenha(senha: String): Boolean {
        val variavelEsp = validaEspeciais(senha)
        val variavelNum = validaNumeros(senha)
        val variavelTam = validaTamanho(senha)
        var variavel = false
        if (variavelEsp && variavelNum && variavelTam)
            variavel = true
        return variavel
    }
}
