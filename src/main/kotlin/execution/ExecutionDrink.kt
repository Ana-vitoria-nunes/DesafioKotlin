package execution
import cart.InputUser
import cart.InputUser.Companion.carrinho
import cart.ItemCarrinho
import kotlin.random.Random

class ExecutionDrink : MenuOption {
    override fun execute(opcao: Int){
        when (opcao) {
            1 -> {
                val quant = InputUser.readIntInput("Quantos refrigerante você deseja:")
                val descricao = listOf("null")
                for (i in 1..quant) {
                    var codigo: Int
                    do {
                        codigo = Random.nextInt(3000, 4000)
                    } while (codigo in carrinho)

                    val item = ItemCarrinho("Refrigerante", 1, 8.0, descricao)
                    carrinho[codigo] = item
                }
            }
            2 -> {
                val quant = InputUser.readIntInput("Quantos suco você deseja:")
                val descricao = listOf("null")
                for (i in 1..quant) {
                    var codigo: Int
                    do {
                        codigo = Random.nextInt(4001, 5000)
                    } while (codigo in carrinho)
                    val item = ItemCarrinho("Suco", 1, 6.0, descricao)
                    carrinho[codigo] = item
                }
            }
            else -> {
                println("Opção inválida. Digite novamente.")
            }
        }
    }
}
