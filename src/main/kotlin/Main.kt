import Menu.ShowMainMenu

fun main() {
    while (true) {
        println()
        println("=====Bem vindo a Delícia Burger=====")
        println("Hoje a Delícia Burger está comemorando 1 ano de lançamento!" +
                "\nPor esse motivo todos os adicionais estão saindo como brinde para nossos clientes!")
        try {
           ShowMainMenu().exibirMenu()

            Thread.sleep(4000)
        } catch (e: NumberFormatException) {
            println("Formato inválido, para escolher o item, você deve informar o número dele.")
        }
    }
}
