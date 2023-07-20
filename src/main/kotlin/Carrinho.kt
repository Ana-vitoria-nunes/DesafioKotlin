import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random
data class ItemCarrinho(val nome: String, val quantidade: Int, var valor: Double, var descricao:List<String>)
class Carrinho {

    val carrinho = mutableMapOf<Int, ItemCarrinho>()
    fun exibirMenuLanches() {
        println("=== LANCHES ===")
        println("1. X-burger - R$ 10,00")
        println("2. X-salada - R$ 12,00")
        print("Escolha o lanche desejado: ")
        val adicionar = readln().toInt()

        when (adicionar) {
            1 -> {
                println("Quantos X-burger você deseja:")
                val quant = readln().toInt()
                val descricao = listOf("Pão com gergelim", "Hambúrguer de carne", "Queijo cheddar","Bacon","Alface", "Tomate", "Cebola", "Molho especial")
                for (i in 1..quant) {
                    val item = ItemCarrinho("X-burger",1, 10.00, descricao)
                    val codigo = Random.nextInt(100, 199)
                    carrinho[codigo] = item
                }
            }
            2 -> {
                println("Quantos X-salada você deseja:")
                val quant = readln().toInt()
                val descricao = listOf("Pão com gergelim", "Hambúrguer de carne", "Queijo prato", "Alface", "Tomate", "Cebola", "Ketchup", "Maionese")
                for (i in 1..quant) {
                    val item = ItemCarrinho("X-salada", 1, 12.00 * quant, descricao)
                    val codigo = Random.nextInt(100, 199)
                    carrinho[codigo] = item
                }
            }
            else -> println("Opção inválida.")
        }
    }
    fun exibirMenuBebidas() {
        println("=== BEBIDAS ===")
        println("1. Refrigerante - R$ 8,00")
        println("2. Suco - R$ 6,00")
        print("Escolha a bebida desejada: ")
        val adicionar = readln().toInt()
        when (adicionar) {
            1 -> {
                println("Quantos refrigerante você deseja:")
                val quant = readln().toInt()
                val descricao = listOf<String>("null")
                for (i in 1..quant) {
                    val item = ItemCarrinho("Refrigerante", 1, 8.00 * quant, descricao)
                    val codigo = Random.nextInt(200, 300)
                    carrinho[codigo] = item
                }
            }
            2 -> {
                println("Quantos suco você deseja:")
                val quant = readln().toInt()
                val descricao = listOf<String>("null")
                for (i in 1..quant) {
                    val item = ItemCarrinho("Suco", 1, 6.00, descricao)
                    val codigo = Random.nextInt(200, 300)
                    carrinho[codigo] = item
                }
            }
            else -> {
                println("Opção inválida.")
            }
        }
    }
    fun exibirOpcoesFinais() {
        println("=== OPÇÕES FINAIS ===")
        println("1. Comprar mais itens")
        println("2. Editar item")
        println("3. Remover item")
        println("4. Finalizar pedido")
        val opcao = readln().toInt()

        when (opcao) {
            1 -> {
                return
            }
            2 -> {
                editarItemNoCarrinho1()
                exibirOpcoesFinais()
            }
            3 -> {
                removerItemDoCarrinho()
                exibirCarrinho()
                exibirOpcoesFinais()
            }
            4 -> {
                finalizarPedido()
            }
            else -> println("Opção inválida.")
        }
    }
    fun exibirCarrinho() {
        println("======================== NOTA FISCAL ========================")
        println("Data/Hora: ${SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Date())}")
        println("=============================================================")

        for ((codigo, item) in carrinho) {
            println("Código do lanche: $codigo")
            println("Nome: ${item.nome} | Quantidade: ${item.quantidade} | Valor Unitário: R$ ${String.format("%.2f", item.valor)}")
            println("Descrição: ${item.descricao}")
            println("-------------------------------------------------------------")
        }
        val totalCompra = carrinho.values.sumOf { it.valor }
        println("Valor total da compra: R$ ${String.format("%.2f", totalCompra)}")
        println("=============================================================")
    }
    fun removerItemDoCarrinho() {
        println("=== REMOVER ITEM ===")
        println("Itens no carrinho:")

        for ((codigo, item) in carrinho) {
            println("Código do lanche: $codigo | Descrição atual: ${item.descricao}")
        }
        print("Digite o código do item que deseja remover: ")
        val codigoItem = readlnOrNull()?.toInt() ?: return

        if (carrinho.remove(codigoItem) == null) {
            println("Código de item inválido ou item não encontrado.")
        } else {
            println("Item removido do carrinho com sucesso!")
        }
    }
    fun finalizarPedido() {
        println("=== FINALIZAR PEDIDO ===")
        println("Valor total do pedido: R$ ${carrinho.values.sumOf { it.valor }}")

        println("Formas de pagamento:")
        println("1. Cartão de crédito")
        println("2. Cartão de débito")
        println("3. Vale refeição")
        println("4. Dinheiro")
        val formaPagamento = readln().toInt()

        when (formaPagamento) {
            1 -> {
                println("Compra finalizada com sucesso! Boa refeição. Pagamento: Cartão de crédito")
                carrinho.clear()
            }
            2 -> {
                println("Compra finalizada com sucesso! Boa refeição. Pagamento: Cartão de débito")
                carrinho.clear()
            }
            3 -> {
                println("Compra finalizada com sucesso! Boa refeição. Pagamento: Vale refeição")
                carrinho.clear()
            }
            4 -> {
                println("Digite o valor em dinheiro:")
                val totalCompra = carrinho.values.sumOf { it.valor }

                var pagouValorSuficiente = false

                while (!pagouValorSuficiente) {
                    val valorPago = readln().toDouble()
                    val troco = valorPago - totalCompra

                    if (troco >= 0) {
                        println("Compra finalizada com sucesso! Boa refeição. Pagamento em dinheiro.")
                        if (troco > 0) {
                            println("Troco: R$ $troco")
                        }
                        carrinho.clear()
                        pagouValorSuficiente = true // Sai do loop
                    } else {
                        println("Valor insuficiente. Digite novamente o valor do dinheiro:")
                    }
                }
            }

            else -> println("Forma de pagamento inválida.")
        }
    }
    fun editarItemNoCarrinho1() {
        println("=== EDITAR ITEM ===")
        println("Itens no carrinho:")
        exibirCarrinho()
        print("Digite o código do item que deseja editar: ")
        val codigoItem = readlnOrNull()?.toInt() ?: return

        var itemSelecionado = carrinho[codigoItem]

        if (itemSelecionado == null) {
            println("Código de item inválido ou item não encontrado.")
            return
        }
        println("Descrição atual do item: ${itemSelecionado.descricao.joinToString(", ")}")
        println("Escolha uma opção:")
        println("1. Adicionar ingredientes")
        println("2. Remover ingredientes")
        val opcao = readln().toInt()

        when (opcao) {
            1 -> {
                println("=== ADICIONAR ADICIONAIS ===")
                println("Adicionais disponíveis:")
                val adicionais = mutableMapOf<String,Double>()
                adicionais["Bacon"]=2.00
                adicionais["Ovo"]=1.50
                adicionais["Queijo Extra"]=1.00
                var cont=1
                for ((chave,valor)in adicionais){
                    println("${cont}. $chave - R$ ${String.format("%.2f", valor)}")
                    cont++
                }
                print("Escolha o número do adicional que deseja adicionar ou 0 para cancelar: ")
                val opcaoAdicional = readln().toInt()

                if (opcaoAdicional == 0) {
                    println("Operação cancelada. O item não foi alterado.")
                    return
                }
                val adicionalSelecionado = adicionais.entries.elementAtOrNull(opcaoAdicional - 1)

                if (adicionalSelecionado == null) {
                    println("Opção inválida.")
                    return
                }
                val (nomeAdicional, precoAdicional) = adicionalSelecionado
                itemSelecionado.descricao = itemSelecionado.descricao + listOf(nomeAdicional)
                itemSelecionado.valor += precoAdicional

                println("$nomeAdicional adicionado ao item com sucesso! Preço adicional: R$ ${String.format("%.2f", precoAdicional)}")
            }
            2 -> {
                println("=== REMOVER INGREDIENTES ===")
                println("Ingredientes atuais do item:")
                for ((index, ingrediente) in itemSelecionado.descricao.withIndex()) {
                    println("${index + 1}. $ingrediente")
                }
                print("Escolha o número do ingrediente que deseja remover ou 0 para cancelar: ")
                val opcaoIngrediente = readln().toInt()

                if (opcaoIngrediente == 0) {
                    println("Operação cancelada. O item não foi alterado.")
                    return
                }

                if (opcaoIngrediente !in 1..itemSelecionado.descricao.size) {
                    println("Opção inválida.")
                    return
                }
                val ingredienteRemovido = itemSelecionado.descricao[opcaoIngrediente - 1]
                itemSelecionado.descricao = itemSelecionado.descricao - listOf(ingredienteRemovido)
                println("$ingredienteRemovido removido do item com sucesso!")
            }
            else -> {
                println("Opção inválida.")
                return
            }
        }
        println("Descrição do item atualizada com sucesso!")
    }

}