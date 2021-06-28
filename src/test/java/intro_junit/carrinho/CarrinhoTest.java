package intro_junit.carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import intro_junit.produto.Produto;
import intro_junit.produto.ProdutoNaoEncontradoException;

public class CarrinhoTest {
	private Carrinho carrinho;
	private Produto produto01;
	private Produto produto02;
	private Produto produto03;

	@BeforeEach
	public void inicializa() {
		carrinho = new Carrinho();

		produto01 = new Produto("Produto 01", 100.00);
		produto02 = new Produto("Produto 02", 50.00);
		produto03 = new Produto("Produto 03", 25.00);
	}

	@DisplayName("Testa adição de item ao carrinho e quantidade.")
	@Test
	public void testAddItem() {
		carrinho.addItem(produto01);
		int quantidade = carrinho.getQtdeItems();

		assertEquals(1, quantidade);
	}

	@DisplayName("Testa valor total do carrinho.")
	@Test
	public void testValorTotal() {
		carrinho.addItem(produto01);
		carrinho.addItem(produto02);
		carrinho.addItem(produto03);
		double valorTotal = carrinho.getValorTotal();

		assertEquals(175.00, valorTotal);
	}

	@DisplayName("Testa remoção de item com sucesso.")
	@Test
	public void testRemocaoItemComSucesso() {
		carrinho.addItem(produto01);
		carrinho.addItem(produto02);
		carrinho.addItem(produto03);
		try {
			carrinho.removeItem(produto03);
			assertEquals(2, carrinho.getQtdeItems());
		} catch (ProdutoNaoEncontradoException e) {
			fail();
		}
	}

	@DisplayName("Testa remoção de item com fracasso.")
	@Test
	public void testRemocaoItemComFracasso() {
		carrinho.addItem(produto01);
		carrinho.addItem(produto02);

		assertThrows(ProdutoNaoEncontradoException.class, () -> carrinho.removeItem(produto03));
	}

	@DisplayName("Testa esvaziamento de carrinho.")
	@Test
	public void testEsvaziaCarrinho() {
		carrinho.addItem(produto01);
		carrinho.addItem(produto02);
		carrinho.addItem(produto03);

		carrinho.esvazia();
		assertEquals(0, carrinho.getQtdeItems());
	}
}
