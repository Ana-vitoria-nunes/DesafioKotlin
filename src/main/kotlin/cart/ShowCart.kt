package cart
import cart.InputUser.Companion.carrinho
import java.text.SimpleDateFormat
import java.util.*

class ShowCart(){
    fun exibirCarrinho() {
        println("======================== NOTA FISCAL ========================")
        println("Data/Hora: ${SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Date())}")
        println("=============================================================")

        var totalCompra=0.0
        for ((codigo, item) in carrinho) {
            println("Código do produto: $codigo")
            println("Nome: ${item.nome} | Quantidade: ${item.quantidade} | Valor Unitário: R$ ${item.valor}")
            println("Descrição: ${item.descricao}")
            println("-------------------------------------------------------------")
            totalCompra +=item.valor
        }

        println("Valor total da compra: R$ $totalCompra")
        println("=============================================================")
    }
}