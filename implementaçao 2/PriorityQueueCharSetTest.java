package segunda;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PriorityQueueCharSetTest {

	private PriorityQueueCharSet pQ;

	@Test
	public void deveAdiconarCaracteres() {
		pQ = new PriorityQueueCharSet();
		pQ.insert("Lula");
		pQ.insert("Bolo");

		assertFalse(pQ.isEmpty());
	}

	@Test
	public void deveRemoverOElementoPrioritario() {
		pQ = new PriorityQueueCharSet();
		pQ.insert("orange");
		pQ.insert("aple");
		pQ.insert("uva");
		pQ.insert("abacaxi");

		assertEquals("uva", pQ.findMax());
		assertEquals("uva", pQ.deleteMax());
		assertEquals("aple", pQ.findMax());

	}

	@Test
	public void deveRetornarOElementoPrioritarioSemRemovelo() {
		pQ = new PriorityQueueCharSet();
		pQ.insert("orange");
		pQ.insert("aple");
		pQ.insert("banana");
		pQ.insert("abacaxi");
		pQ.insert("cereja");

		assertEquals("aple", pQ.findMax());
		assertEquals("aple", pQ.findMax());

	}

	@Test
	public void deveRemoverTodosOsElementosDaFila() {
		pQ = new PriorityQueueCharSet();
		pQ.insert("orange");
		pQ.insert("aple");
		pQ.insert("banana");
		pQ.insert("abacaxi");
		pQ.insert("cereja");

		pQ.makeEmpty();

		assertTrue(pQ.isEmpty());

	}

	@Test
	public void deveRetornarOTamanhoDaFila() {
		pQ = new PriorityQueueCharSet();
		pQ.insert("orange");
		pQ.insert("aple");
		pQ.insert("banana");
		pQ.insert("abacaxi");
		pQ.insert("cereja");

		assertEquals(5, pQ.size());
	}

	@Test
	public void deveRemoverOElementoDaFila() {
		pQ = new PriorityQueueCharSet();
		pQ.insert("orange");
		pQ.insert("aple");
		pQ.insert("banana");
		pQ.insert("abacaxi");
		pQ.insert("cereja");

		assertEquals(5, pQ.size());

		pQ.deleteMax();
		assertEquals(4, pQ.size());

		pQ.deleteMax();
		assertEquals(3, pQ.size());

	}

	@Test
	public void deveAumentarOtamanhoDaLista() {
		pQ = new PriorityQueueCharSet();
		pQ.insert("orange");
		pQ.insert("aple");

		assertEquals(2, pQ.size());

		pQ.insert("banana");
		pQ.insert("abacaxi");

		assertEquals(4, pQ.size());

		pQ.insert("cereja");

		assertEquals(5, pQ.size());

	}

	public void deveAlterarAPrioridadeDoElemento() {
		pQ = new PriorityQueueCharSet();
		
		pQ.insert("1");
		pQ.insert("53");
		pQ.insert("2");
		pQ.insert("5");
		pQ.insert("67");
		pQ.insert("43");
		pQ.insert("22");
		
		assertEquals("1 - 1\r\n"
				+ " 2 - 2\r\n"
				+ " 5 - 3\r\n"
				+ " 22 - 4\r\n"
				+ " 43 - 5\r\n"
				+ " 53 - 6\r\n"
				+ " 67 - 7", pQ.printar());
		
		pQ.changePriority(3, 7);
		
		
		assertEquals("1 - 1\r\n"
				+ " 2 - 2\r\n"
				+ " 5 - 3\r\n"
				+ " 43 - 4\r\n"
				+ " 53 - 5\r\n"
				+ " 67 - 6\r\n"
				+ " 22 - 7", pQ.printar());
		
		pQ.changePriority(3, 7);
		
		assertEquals("1 - 1\r\n"
				+ " 2 - 2\r\n"
				+ " 5 - 3\r\n"
				+ " 53 - 4\r\n"
				+ " 67 - 5\r\n"
				+ " 22 - 6\r\n"
				+ " 43 - 7", pQ.printar());

}
	@Test
	public void naoPodeMudarPrioridadeSeAListaEstiverVaziaOuNTiverElementoNaPosicao() {
		pQ = new PriorityQueueCharSet();
		
		assertFalse(pQ.changePriority(1, 1));
		
		pQ.insert("1");
		pQ.insert("53");
		pQ.insert("2");
		pQ.insert("5");
		
		assertFalse(pQ.changePriority(10, 10));
		
	}
	
}
