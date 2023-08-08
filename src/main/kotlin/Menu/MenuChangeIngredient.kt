package Menu

import cart.InputUser.Companion.readIntInput
import execution.ExecutionModificarProduto
import execution.MenuLanche

class MenuChangeIngredient:DisplayMenu {
    override fun exibirMenu(){
        println("Escolha uma opção:")
        println("1. Adicionar ingredientes")
        println("2. Remover ingredientes")

        ExecutionModificarProduto().execute(readIntInput("Qual você deseja:"))
    }
}