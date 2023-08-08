package Menu

import cart.InputUser.Companion.readIntInput
import execution.ExecutionDrink

class ShowDrinkMenu : DisplayMenu {
    override fun exibirMenu() {
        println("=== BEBIDAS ===")
        println("1. Refrigerante - R$ 8,00")
        println("2. Suco - R$ 6,00")
        ExecutionDrink().execute(readIntInput("Escolha a bebida desejada: "))
    }
}