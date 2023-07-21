import java.util.concurrent.TimeUnit
fun main() {
    val carrinho = Carrinho()
    println()
    println("=====Bem vindo a Delícias Burger=====")
    while (true) {
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
                    carrinho.exibirCarrinho()
                    carrinho.exibirOpcoesFinais()
                }
                2 -> {
                    carrinho.exibirMenuBebidas()
                    carrinho.exibirCarrinho()
                    carrinho.exibirOpcoesFinais()
                }
                else -> {
                    println("Opção inválida Main.")
                }
            }
            TimeUnit.SECONDS.sleep(2)
        } catch (e: NumberFormatException) {
            println("Formato inválido, para escolher o item, você deve informar o número dele.")
        }
    }
}