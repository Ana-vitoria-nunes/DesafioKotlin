package execution
import cart.InputUser.Companion.carrinho
import cart.InputUser.Companion.readIntInput
import cart.ItemCarrinho
import main
import kotlin.random.Random
class MenuLanche : MenuOption {
    override fun execute(opcao: Int){
        when (opcao) {
            1 -> {
                val quant = readIntInput("Quantos X-burger você deseja:")
                val descricao = listOf(
                    "Pão com gergelim", "Hambúrguer de carne", "Queijo cheddar",
                    "Bacon", "Alface", "Tomate", "Cebola", "Molho especial"
                )
                for (i in 1..quant) {
                    var codigo: Int
                    do {
                        codigo = Random.nextInt(1, 1000)
                    } while (codigo in carrinho)

                    val item = ItemCarrinho("X-burger", 1, 10.0, descricao)
                    carrinho[codigo] = item
                }
            }
            2 -> {
                val quant = readIntInput("Quantos X-salada você deseja:")
                val descricao = listOf(
                    "Pão com gergelim", "Hambúrguer de carne", "Queijo prato",
                    "Alface", "Tomate", "Cebola", "Ketchup", "Maionese"
                )
                for (i in 1..quant) {
                    var codigo: Int
                    do {
                        codigo = Random.nextInt(1001, 2000)
                    } while (codigo in carrinho)

                    val item = ItemCarrinho("X-salada", 1, 12.0, descricao)
                    carrinho[codigo] = item
                }
            }

            else -> {
                println("Opção inválida. Digite novamente.")
                main()
            }
        }
    }
}