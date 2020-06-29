package saga;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FornecedorTest {
	private Fornecedor fornecedor1;
	private Fornecedor fornecedor2;
	private Fornecedor fornecedor3;
	
	@BeforeEach
	void setup() {
		
		this.fornecedor1 = new Fornecedor ("Messias", "messias@gmail.com", "4444");
		this.fornecedor2 = new Fornecedor ("Raki", "raki@gmail.com", "5555");
		this.fornecedor3 = new Fornecedor ("Raki", "rakitic@gmail.com", "7777");	
		
	}
	

	@Test
	void testHashCode() {
		
		assertFalse (this.fornecedor1.hashCode() == this.fornecedor2.hashCode());
		assertTrue (this.fornecedor2.hashCode() == this.fornecedor3.hashCode());
		
	}

	@Test
	void testToString() {
		
		assertEquals("Messias - messias@gmail.com - 4444", this.fornecedor1.toString());
		
	}

	@Test
	void testEqualsObject() {
		assertTrue( this.fornecedor2.equals(fornecedor3));
		assertFalse (this.fornecedor1.equals(fornecedor2));
		assertFalse (this.fornecedor1 == null);
		
	}

	@Test
	void testExisteProduto() {
		
		this.fornecedor1.adicionaProduto("Sabão", "Pó", 3.75);
		assertTrue (true == this.fornecedor1.existeProduto("Sabão", "Pó"));
		assertTrue(false == this.fornecedor1.existeProduto("Pão", "Amanteigado"));
		
	}


	@Test
	void testDadosDeUmProduto() {
		this.fornecedor1.adicionaProduto("Sabão", "Pó", 3.75);
		assertTrue ("Sabão - Pó - R$3,75".equals(this.fornecedor1.exibeProduto("Sabão", "Pó")));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.fornecedor1.exibeProduto("Sabão","Em barra"));
		
	}


	@Test
	void testRemoverProduto() {
		
		this.fornecedor1.adicionaProduto("Sabão", "Pó", 3.75);
		assertTrue( true == this.fornecedor1.existeProduto("Sabão", "Pó"));
		this.fornecedor1.removeProduto("Sabão", "Pó");
		assertTrue (false == this.fornecedor1.existeProduto("Sabão", "Pó"));
		
		
		
	}

	@Test
	void testEditarDadosProduto() {
		this.fornecedor1.adicionaProduto("Sabão", "Pó", 3.75);
		this.fornecedor1.editaProduto("Sabão", "Pó",  4.20);
		assertTrue (4.20 == this.fornecedor1.pegaProduto("Sabão", "Pó").getPreco());
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.fornecedor1.editaProduto("Pippos", "Vitaminado",  2.00));
	}

}
