import java.util.concurrent.TimeUnit
fun main() {
    val carrinho = Carrinho()
    while (true) {
    println()
    println("=====Bem vindo a Delícia Burger=====")
    println("Hoje a Delícia Burger está comemorando 1 ano de lançamento!" +
            "\nPor esse motivo todos os adicionais estão saindo como brinde para nossos clientes!")
        try {
            println()
            println("===== MENU INICIAL =====")
            println("1. Lanche")
            println("2. Bebida")
            println("Escolha a opção desejada: ")
            val opcao = readln().toInt()

            when (opcao) {
                1 -> {
                    carrinho.exibirMenuLanches()
                    carrinho.exibirOpcoesFinais()
                }
                2 -> {
                    carrinho.exibirMenuBebidas()
                    carrinho.exibirCarrinho()
                    carrinho.exibirOpcoesFinais()
                }
                else -> {
                    println("Opção inválida.")
                }
            }
            TimeUnit.SECONDS.sleep(4)
        } catch (e: NumberFormatException) {
            println("Formato inválido, para escolher o item, você deve informar o número dele.")
        }
    }
}