package br.digitalhouse.app_cinema.model

data class UsuarioDataClass(
    var login: String,
    var senha: String,
) {

    fun validaEspeciais(senha: String): Boolean {
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
        var valEsp = false
        for (character in listaEspeciais)
            if (senha.contains(character))
                valEsp = true
        return valEsp
    }


    fun validaNumeros(senha: String): Boolean {
        val listaNumeros: List<String> =
            listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "0")
        var valNum = false
        for (character in listaNumeros)
            if (senha.contains(character))
                valNum = true
        return valNum
    }

    fun validaTamanho(senha: String) = senha.length >= 8

    fun verificaSenha(senha: String) =
        validaTamanho(senha) && validaEspeciais(senha) && validaNumeros(senha)

    fun verificaEmail(login: String) = login.contains("@")


}