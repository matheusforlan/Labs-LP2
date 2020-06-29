package saga;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteTest {
	
	private Cliente cliente1;
	private Cliente cliente2;
	private Cliente cliente3;
	Fornecedor fornecedor;
	
	@BeforeEach
	void setup() {
		this.cliente1 = new Cliente ("111", "Zé Pequeno" , "LSD", "ZePequeno@gmail.com");
		this.cliente2 = new Cliente ("222" , "Zé Ramalho", "SPLAB", "ZeRamalho@gmail.com");
		this.cliente3 = new Cliente ("111", " João" , "LSD", "Joao@gmail.com");
		this.fornecedor = new Fornecedor("João", "Joao@gmail.com" , "5555");
		
		
	}

	

	@Test
	void testHashCode() {
		assertTrue( this.cliente1.hashCode() == this.cliente3.hashCode());
		assertFalse (this.cliente1.hashCode() == this.cliente2.hashCode());
		
	}

	@Test
	void testToString() {
	
		assertEquals( "Zé Pequeno - LSD - ZePequeno@gmail.com", this.cliente1.toString());
	}

	@Test
	void testEqualsObject() {
		
		assertTrue ( this.cliente1.equals(this.cliente3));
		assertFalse (this.cliente1 == null);
		assertFalse( this.cliente1.equals(this.fornecedor));
		assertTrue (this.cliente1.equals(this.cliente3));
		
	}

}
