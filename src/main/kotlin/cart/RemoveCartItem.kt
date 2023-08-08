package cart
import Menu.ContinuePurchaseMenu
import cart.InputUser.Companion.carrinho
import cart.InputUser.Companion.readIntInput

class RemoveCartItem {
    fun removerItemDoCarrinho() {
        println("=== REMOVER ITEM ===")
        println("Itens no carrinho:")

        for ((codigo, item) in carrinho) {
            println("Código do lanche: $codigo | Descrição atual: ${item.descricao}")
        }
        while (true) {
            val codigoItem = readIntInput("Digite o código do item que deseja remover: ")
            if (carrinho.remove(codigoItem) == null) {
                println("Código de item inválido ou item não encontrado.")
            } else {
                println("Item removido do carrinho com sucesso!")
                ContinuePurchaseMenu().exibirMenu()
            }
        }
    }
}