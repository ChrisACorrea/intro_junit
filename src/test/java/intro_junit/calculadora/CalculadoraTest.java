package intro_junit.calculadora;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {

	private Calculadora calc;

	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}

	@DisplayName("Testa a soma de dois números")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);
		assertEquals(9, soma);
	}

	@DisplayName("Testa a divisão de dois números")
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}

	@DisplayName("Testa divisão por zero com Equals")
	@Test
	public void testDivisaoPorZero() {
		try {
			calc.divisao(8, 0);
			fail("Exceção não lançada");
		} catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}
	}

	@DisplayName("Testa divisão por zero com Assert Throws")
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class, () -> calc.divisao(8, 0));
	}

	/* FUNÇÕES CRIADAS PARA O EXERCÍCIO DE JUNIT */

	@DisplayName("Testa a subtração de dois números")
	@Test
	public void testSubtraçãoDoisNumeros() {
		int subtracao = calc.subtracao(4, 5);
		assertEquals(-1, subtracao);
	}

	@DisplayName("Testa a multiplicação de dois números")
	@Test
	public void testMultiplicacaoDoisNumeros() {
		int multiplicacao = calc.multiplicacao(4, 5);
		assertEquals(20, multiplicacao);
	}

	@DisplayName("Testa a somatória de um número")
	@Test
	public void testSomatorio() {
		int somatoria = calc.somatoria(5);
		assertEquals(15, somatoria);
	}

	@DisplayName("Testa número positivo")
	@Test
	public void testEhPositivo() {
		assertTrue(calc.ehPositivo(6));
	}

	@DisplayName("Testa comparação")
	@Test
	public void testComparacao() {
		assertThat(calc.compara(2, 2), equalTo(0));
		assertThat(calc.compara(2, 1), equalTo(1));
		assertThat(calc.compara(1, 2), equalTo(-1));
	}

}
