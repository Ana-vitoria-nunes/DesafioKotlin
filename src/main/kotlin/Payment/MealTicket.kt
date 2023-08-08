package Payment

class MealTicket : ProcessPayment {
    override fun payment():String{
        return "Compra finalizada com sucesso! Boa refeição. Pagamento: Vale refeição"
    }
}