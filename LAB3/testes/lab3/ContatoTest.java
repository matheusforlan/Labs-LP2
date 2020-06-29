package lab3;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContatoTest {
	 private Contato contatoTeste1;
	   private Contato contatoTeste2;
	   private Contato contatoTeste3;
	   
	   @BeforeEach
	   public void criaContato() {
	        this.contatoTeste1 = new Contato ("Matheus", "Forlán", "4455 6677");
	        this.contatoTeste2 = new Contato ("Matheus", "Forlán", "4455 6677");
	        this.contatoTeste3 = new Contato ("Ana", "Carolina", "4002 8922");
	   }

	@Test
	void testHashCode() {
		  assertTrue( this.contatoTeste1.hashCode() == this.contatoTeste2.hashCode());
	       assertFalse(this.contatoTeste1.hashCode() == this.contatoTeste3.hashCode());
	}

	@Test
	void testContato() {
		 
		assertEquals("Matheus", this.contatoTeste1.getNome());
          assertEquals("Forlán" ,  this.contatoTeste1.getSobrenome());
          assertEquals("4455 6677", this.contatoTeste1.getTelefone());
          
          assertNotEquals("Matias", this.contatoTeste2.getNome());
          assertNotEquals("Fernando" , this.contatoTeste2.getSobrenome());
          assertNotEquals("9988 7766", this.contatoTeste2.getTelefone());
	}

	@Test
	void testToString() {
			assertEquals("Matheus Forlán" , this.contatoTeste1.toString());
	       assertNotEquals("Matias Fernando" , this.contatoTeste2.toString());
	       assertEquals("Ana Carolina" , this.contatoTeste3.toString());
	}

	@Test
	void testEqualsObject() {
		
		assertTrue(this.contatoTeste1.equals(this.contatoTeste2));
        
        assertFalse(this.contatoTeste1.equals(this.contatoTeste3));
	}

}
