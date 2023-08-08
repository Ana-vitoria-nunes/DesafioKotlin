package Payment

class PagamentoCartao: ProcessPayment {
        override fun payment():String{
            return "Compra finalizada com sucesso! Boa refeição. Pagamento: Cartão"
        }
}