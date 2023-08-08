package Menu

import cart.InputUser.Companion.readIntInput
import cart.ShowCart
import execution.ExecutinOpcaoFinal
import execution.ExecutionPagamento

class ShowPaymentMenu :DisplayMenu{

    override fun exibirMenu() {
        println("=== FINALIZAR PEDIDO ===")
        println("Formas de pagamento:")
        println("1. Cartão de crédito")
        println("2. Cartão de débito")
        println("3. Vale refeição")
        println("4. Dinheiro")
        ShowCart().exibirCarrinho()
        ExecutionPagamento().execute(readIntInput("Qual a forma de pagamento:"))
    }
}