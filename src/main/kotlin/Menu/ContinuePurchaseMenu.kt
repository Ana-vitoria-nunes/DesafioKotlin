package Menu
import cart.InputUser.Companion.readIntInput
import execution.ExecutionOpcaoFinal

class ContinuePurchaseMenu : DisplayMenu {
    override fun exibirMenu() {
        println("=== OPÇÕES FINAIS ===")
        println("1. Comprar mais itens")
        println("2. Editar item")
        println("3. Remover item")
        println("4. Finalizar pedido")
        return ExecutionOpcaoFinal().execute(readIntInput("Qual você deseja final:"))
    }
}