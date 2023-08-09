package Menu
import cart.InputUser.Companion.readIntInput
import execution.ExecutionSnack

class ShowSnackMenu : DisplayMenu {
    override fun exibirMenu(){
        println("=== LANCHES ===")
        println("1. X-burger - R$ 10,00")
        println("2. X-salada - R$ 12,00")
        ExecutionSnack().execute(readIntInput("Escolha o lanche desejado: "))
    }
}