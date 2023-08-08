package execution

import Menu.ContinuePurchaseMenu
import Menu.ShowDrinkMenu
import Menu.ShowSnackMenu

class ExecutionMenuPrincipal : MenuOption {
    override fun execute(opcao: Int){
        when (opcao) {
            1 -> {
                ShowSnackMenu().exibirMenu()
               ContinuePurchaseMenu().exibirMenu()
            }

            2 -> {
                ShowDrinkMenu().exibirMenu()
                ContinuePurchaseMenu().exibirMenu()
            }
            else -> {
                println("Opção inválida.")
            }
        }
    }
}