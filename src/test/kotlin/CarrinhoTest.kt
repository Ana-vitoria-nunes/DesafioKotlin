import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CarrinhoTest {

    @Test
    fun getProdutosAdicionados() {
    }

    @Test
    fun deveAdicionarXburgerALista() {
        val inputStream = "2".byteInputStream()
        val carrinho = Carrinho()
        assertEquals(1, carrinho.carrinho.size)
        assertEquals("X-Burgue",carrinho.exibirMenuLanches())
    }
}
