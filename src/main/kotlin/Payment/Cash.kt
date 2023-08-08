package Payment

import cart.InputUser.Companion.carrinho
import cart.InputUser.Companion.readDobleInput
import cart.InputUser.Companion.readIntInput
import cart.ShowCart

class Cash : ProcessPayment {
    override fun payment(): String {
        val totalCompra = carrinho.values.sumOf { it.valor }
        while (true) {
            val valorPago = readIntInput("Digite o valor em dinheiro:")
            val troco = valorPago - totalCompra
            if (troco >=0) {
                return "Compra finalizada com sucesso! Boa refeição. Pagamento em dinheiro.Troco: R$ $troco"
            } else {
                println("Valor inválido. Digite novamente o valor do dinheiro:")
            }
        }
    }
}
