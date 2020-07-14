package aluguel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import aluguel.Aluguel;

public class AluguelTest {

	@Test
	public void testDia00RRCL () {
		Aluguel aluguel = new Aluguel();
		double result = aluguel.insertProject(0, 350.0);
		assertEquals(-1, result,0.01);
	}

	@Test
	public void testDia01RRCL () {
		Aluguel aluguel = new Aluguel();
		double result = aluguel.insertProject(1, 350.0);
		double desconto = 350.0  -(350.0 * 0.10);
		assertEquals(desconto, result,0.01);
	}

	@Test
	public void testDia5RRCL () {
		Aluguel aluguel = new Aluguel();
		double result = aluguel.insertProject(5, 350.0);
		double desconto = 350.0 - 350.0 * 0.10;
		assertEquals(desconto, result,0.01);
	}

	@Test
	public void testDia6RRCL () {
		Aluguel aluguel = new Aluguel();
		double result = aluguel.insertProject(6, 350.0);
		double desconto = 350.0 - 350.0 * 0.05;
		assertEquals(desconto, result,0.01);
	}

	@Test
	public void testDia10RRCL () {
		Aluguel aluguel = new Aluguel();
		double result = aluguel.insertProject(10, 350.0);
		double desconto = 350.0 - 350.0 * 0.05;
		assertEquals(desconto, result,0.01);
	}

	@Test
	public void testDia11RRCL () {
		Aluguel aluguel = new Aluguel();
		double result = aluguel.insertProject(11, 350.0);
		assertEquals(350.0, result,0.01);
	}

	@Test
	public void testDia15RRCL () {
		Aluguel aluguel = new Aluguel();
		double result = aluguel.insertProject(15, 350.0);
		assertEquals(350.0, result,0.01);
	}

	@Test
	public void testDia16RRCL () {
		Aluguel aluguel = new Aluguel();
		double result = aluguel.insertProject(16, 350.0);
		assertEquals(357.35, result,0.01);
	}

	@Test
	public void testDia30RRCL () {
		Aluguel aluguel = new Aluguel();
		double result = aluguel.insertProject(30, 350.0);
		assertEquals(362.25, result,0.01);
	}

	@Test
	public void testDia31RRCL () {
		Aluguel aluguel = new Aluguel();
		double result = aluguel.insertProject(31, 350.0);
		assertEquals(-1, result,0.01);
	}
}
