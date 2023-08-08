package execution
import Menu.ContinuePurchaseMenu
import Payment.Cash
import Payment.MealTicket
import Payment.PagamentoCartao
import cart.InputUser.Companion.carrinho
import main

class ExecutionPagamento:MenuOption {
    override fun execute(opcao: Int){
        when (opcao) {
            1 -> {
               println( PagamentoCartao().payment())
                carrinho.clear()
                return
            }
            2 -> {
                println(PagamentoCartao().payment())
                carrinho.clear()
                return
            }
            3 -> {
                println(MealTicket().payment())
                carrinho.clear()
                return
            }
            4 -> {
               println(Cash().payment())
                carrinho.clear()
               return

            }
            else -> {
                println("Forma de pagamento inválida.")
                ContinuePurchaseMenu().exibirMenu()
            }
        }
    }
}