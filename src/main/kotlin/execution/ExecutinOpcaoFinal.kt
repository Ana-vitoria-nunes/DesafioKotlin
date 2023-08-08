package execution

import Menu.MenuChangeIngredient
import Menu.ShowMainMenu
import Menu.ShowPaymentMenu
import cart.RemoveCartItem

class ExecutinOpcaoFinal :MenuOption {

    override fun execute(opcao: Int){
        when (opcao) {
            1 -> {
                ShowMainMenu().exibirMenu()
            }
            2 -> {
                MenuChangeIngredient().exibirMenu()
            }
            3 -> {
                RemoveCartItem().removerItemDoCarrinho()
            }
            4 -> {
                ShowPaymentMenu().exibirMenu()
            }
            else -> {
                println("Opção inválida. Digite novamente.")
            }
        }
    }
}