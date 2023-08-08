package cart
data class ItemCarrinho(val nome: String, val quantidade: Int, var valor: Double, var descricao: List<String>)
class InputUser {
    companion object {
        val carrinho = mutableMapOf<Int, ItemCarrinho>()
        fun readIntInput(prompt: String): Int {
            while (true) {
                println(prompt)
                val input = readlnOrNull()
                try {
                    if (input != null) {
                        return input.toInt()
                    } else {
                        throw NumberFormatException()
                    }
                } catch (e: NumberFormatException) {
                    println("Entrada inválida. Por favor, digite um número inteiro válido.")
                }
            }
        }
        fun readDobleInput(prompt: String): Double {
            while (true) {
                println(prompt)
                val input = readlnOrNull()
                try {
                    if (input != null) {
                        return input.toDouble()
                    } else {
                        throw NumberFormatException()
                    }
                } catch (e: NumberFormatException) {
                    println("Entrada inválida. Por favor, digite um número válido.")
                }
            }
        }
    }
}