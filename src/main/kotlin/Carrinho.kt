import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random

data class ItemCarrinho(val nome: String, val quantidade: Int, var valor: Double, var descricao: List<String>)
class Carrinho {

    val carrinho = mutableMapOf<Int, ItemCarrinho>()
    fun exibirMenuLanches() {

        println("=== LANCHES ===")
        println("1. X-burger - R$ 10,00")
        println("2. X-salada - R$ 12,00")
        print("Escolha o lanche desejado: ")

        while (true) {
            val adicionar = readln().toIntOrNull()
            when (adicionar) {
                1 -> {
                    val quant =readIntInput("Quantos X-burger você deseja:")
                    val descricao = listOf(
                        "Pão com gergelim",
                        "Hambúrguer de carne",
                        "Queijo cheddar",
                        "Bacon",
                        "Alface",
                        "Tomate",
                        "Cebola",
                        "Molho especial"
                    )
                    for (i in 1..quant) {
                        val item = ItemCarrinho("X-burger", 1, 10.00, descricao)
                        val codigo = Random.nextInt(100, 199)
                        carrinho[codigo] = item
                    }
                    break
                }

                2 -> {
                    val quant = readIntInput("Quantos X-salada você deseja:")
                    val descricao = listOf(
                        "Pão com gergelim",
                        "Hambúrguer de carne",
                        "Queijo prato",
                        "Alface",
                        "Tomate",
                        "Cebola",
                        "Ketchup",
                        "Maionese"
                    )
                    for (i in 1..quant) {
                        val item = ItemCarrinho("X-salada", 1, 12.00 * quant, descricao)
                        val codigo = Random.nextInt(100, 199)
                        carrinho[codigo] = item
                    }
                    break
                }

                else -> {
                    println("Opção inválida. Digite novamente lanche")

                }
            }
        }
    }

    fun exibirMenuBebidas() {
        println("=== BEBIDAS ===")
        println("1. Refrigerante - R$ 8,00")
        println("2. Suco - R$ 6,00")
        print("Escolha a bebida desejada: ")
        while (true) {
            val adicionar = readln().toIntOrNull()
            when (adicionar) {
                1 -> {
                    val quant = readIntInput("Quantos refrigerante você deseja:")
                    val descricao = listOf("null")
                    for (i in 1..quant) {
                        val item = ItemCarrinho("Refrigerante", 1, 8.00 * quant, descricao)
                        val codigo = Random.nextInt(200, 300)
                        carrinho[codigo] = item
                    }
                    break
                }

                2 -> {
                    val quant = readIntInput("Quantos suco você deseja:")
                    val descricao = listOf<String>("null")
                    for (i in 1..quant) {
                        val item = ItemCarrinho("Suco", 1, 6.00, descricao)
                        val codigo = Random.nextInt(200, 300)
                        carrinho[codigo] = item
                    }
                    break
                }

                else -> {
                    println("Opção inválida.Digite novamente bebida.")
                }
            }
        }
    }

    fun exibirOpcoesFinais() {
        println("=== OPÇÕES FINAIS ===")
        println("1. Comprar mais itens")
        println("2. Editar item")
        println("3. Remover item")
        println("4. Finalizar pedido")

        while (true) {
            val opcao = readIntInput("Qual você deseja final:")
            when (opcao) {
                1 -> {
                    return
                }

                2 -> {
                    editarItemNoCarrinho()
                    exibirOpcoesFinais()
                    break
                }

                3 -> {
                    removerItemDoCarrinho()
                    exibirCarrinho()
                    exibirOpcoesFinais()
                    break
                }

                4 -> {
                    finalizarPedido()
                    break
                }

                else -> {
                    println("Opção inválida. Digite novamente final.")
                }
            }
        }
    }

    fun exibirCarrinho() {
        println("======================== NOTA FISCAL ========================")
        println("Data/Hora: ${SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Date())}")
        println("=============================================================")

        for ((codigo, item) in carrinho) {
            println("Código do lanche: $codigo")
            println(
                "Nome: ${item.nome} | Quantidade: ${item.quantidade} | Valor Unitário: R$ ${
                    String.format(
                        "%.2f",
                        item.valor
                    )
                }"
            )
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
        while (true) {
            val codigoItem = readIntInput("Digite o código do item que deseja remover: ")
            if (carrinho.remove(codigoItem) == null) {
                println("Código de item inválido ou item não encontrado.")
            } else {
                println("Item removido do carrinho com sucesso!")
                return
            }
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
        val formaPagamento = readIntInput("Qual você deseja:")
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
            }
            4 -> {
                println("Digite o valor em dinheiro:")
                val totalCompra = carrinho.values.sumOf { it.valor }

                var pagouValorSuficiente = false

                while (!pagouValorSuficiente) {
                    val valorPago = readln()
                    val input = valorPago.replace(",", ".").toDoubleOrNull()
                    if (input != null) {
                        val troco = input - totalCompra

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
                    } else {
                        println("valor invalido.Digite novamente")
                    }
                }
            }
            else -> {
                println("Forma de pagamento inválida.")
                return
            }
        }
    }

    fun editarItemNoCarrinho() {
        println("=== EDITAR ITEM ===")
        println("Itens no carrinho:")
        exibirCarrinho()
        print("Digite o código do item que deseja editar: ")
        val codigoItem = readln().toIntOrNull()

        val itemSelecionado = carrinho[codigoItem]

        if (itemSelecionado == null) {
            println("Código de item inválido ou item não encontrado.")
            return
        }

        println("Descrição atual do item: ${itemSelecionado.descricao}")
        println("Escolha uma opção:")
        println("1. Adicionar ingredientes")
        println("2. Remover ingredientes")

        val opcao = readIntInput("Qual você deseja:")

        when (opcao) {
            1 -> {
                println("=== ADICIONAR ADICIONAIS ===")
                println("Promoção:Hoje a Delícia Burger está comemorando 1 ano de lançamento!\n Por esse motivo adicional grátis para cada hambúrguer comprado!")
                println("Adicionais disponíveis:")
                val adicionais = mutableMapOf<String, Double>()
                adicionais["Milho"] = 0.00
                adicionais["Batata palha"] = 0.00
                adicionais["ovo"] = 0.00
                adicionais["Bacon"] = 0.00
                adicionais["Picles"] = 0.00
                adicionais["Cebola Caramelizada"] = 0.00
                var cont = 1
                for ((chave, valor) in adicionais) {
                    println("${cont}. $chave - R$ ${String.format("%.2f", valor)}")
                    cont++
                }
                    val opcaoAdicional = readIntInput("Escolha o número do adicional que deseja adicionar ou 0 para cancelar: ")
                    if (opcaoAdicional == 0) {
                        println("Operação cancelada. O item não foi alterado.")
                        return
                    }
                    val adicionalSelecionado = adicionais.entries.elementAtOrNull(opcaoAdicional!! - 1)
                    if (adicionalSelecionado != null) {
                        val (nomeAdicional, precoAdicional) = adicionalSelecionado
                        itemSelecionado.descricao = itemSelecionado.descricao + listOf(nomeAdicional)
                        itemSelecionado.valor += precoAdicional
                        println(
                            "$nomeAdicional adicionado ao item com sucesso! Preço adicional: R$ ${
                                String.format("%.2f", precoAdicional)
                            }"
                        )
                        return
                    }
            }
            2 -> {
                println("=== REMOVER INGREDIENTES ===")
                println("Ingredientes atuais do item:")
                for ((index, ingrediente) in itemSelecionado.descricao.withIndex()) {
                    println("${index + 1}. $ingrediente")
                }
                val opcaoIngrediente = readIntInput("Escolha o número do ingrediente que deseja remover ou 0 para cancelar: ")

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
                println("Opção inválida.Digite novamente pp")
            }
        }
    }

    fun readIntInput(prompt: String): Int {
        while (true) {
            print(prompt)
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
}