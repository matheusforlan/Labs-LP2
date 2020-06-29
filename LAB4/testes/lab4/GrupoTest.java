package lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GrupoTest {
	private Grupo grupo1;
	private Grupo grupo2;
	private Grupo grupo3;

	private Aluno aluno;	
	
	
	@BeforeEach
	void setup() { 
		this.grupo1 = new Grupo("OsFerrados");
		this.grupo2 = new Grupo("BarNilson");
		this.grupo3 = new Grupo("BarNilson");
		this.aluno = new Aluno("65", "Matheus Forlan", "cc");
		
	}
	

	@Test
	void testHashCode() {
		
	        assertFalse(this.grupo1.hashCode() == this.grupo2.hashCode());
	        assertTrue(this.grupo3.hashCode() == this.grupo3.hashCode());
	        
	}



	@Test
	void testToString() {
	
		this.grupo1.alocarAluno(this.aluno);
		
		assertEquals("* 65 - Matheus Forlan - cc\n", this.grupo1.toString());
	}

	@Test
	void testEqualsObject() {
		 
			assertFalse(this.grupo1.equals(null));
	        assertFalse(this.grupo1.equals(this.grupo2));
	        assertTrue(this.grupo2.equals(this.grupo3));
	        assertFalse(this.grupo1.equals(aluno));
	        
	}

}
