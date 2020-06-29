package saga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProdutoTest {
	
	private ProdutoSimples produto1;
	private ProdutoSimples produto2;
	private ProdutoSimples produto3;
	
	@BeforeEach
	void setup() {
		this.produto1 = new ProdutoSimples("Banana", "Amarela", 2.25);
		this.produto2 = new ProdutoSimples ("Café", "Expresso", 4.80);
		this.produto3 = new ProdutoSimples ("Café", "Expresso", 7.49);
		
	}
	

	@Test
	void testHashCode() {
		assertFalse (this.produto1.hashCode() == this.produto2.hashCode());
		assertTrue (this.produto2.hashCode() == this.produto3.hashCode());
		
		
	}

	@Test
	void testToString() {
		assertEquals("Banana - Amarela - R$2,25", this.produto1.toString());
	}

	@Test
	void testEqualsObject() {
		assertTrue (this.produto2.equals(this.produto3));
		assertFalse (this.produto1.equals(produto3));
		assertFalse (this.produto1.equals(null));
		
	}

}
