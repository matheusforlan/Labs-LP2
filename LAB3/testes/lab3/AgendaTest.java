package lab3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class AgendaTest {
	private Agenda agendaTeste1;
    private Agenda agendaTeste2;
    private Agenda agendaTeste3;
    private Agenda agendaTeste4;
    
 @BeforeEach
    
    public void criaAgenda() {
        agendaTeste1 = new Agenda();
        agendaTeste2 = new Agenda();
        agendaTeste3 = new Agenda();
        agendaTeste4 = new Agenda();
        agendaTeste1.cadastraContato( "Matheus",
                "Forlán","4455 6677",  "65");
        agendaTeste1.cadastraContato( "Matias",
                "Fernandes","1111 2222",  "74");
        
        
        agendaTeste2.cadastraContato( "Matias",
                "Fernandes","1111 2222",  "74");
        agendaTeste2.cadastraContato( "Matheus",
                "Forlán","4455 6677",  "65");
        
        agendaTeste4.cadastraContato( "Matias",
                "Fernandes","1111 2222",  "24");
        
        agendaTeste4.cadastraContato( "Matheus",
                "Forlán", "4455 6677",  "37");
        
        
    }

	@Test
	void testHashCode() {
		assertTrue(agendaTeste1.hashCode() == agendaTeste2.hashCode());
        assertFalse(agendaTeste1.hashCode() == agendaTeste3.hashCode());
	}

	@Test
	void testCadastraContato() {
		assertEquals( true, agendaTeste1.cadastraContato("João", "Arthur", "5555 5555", "1"));
		assertEquals( false, agendaTeste1.cadastraContato("João", "Arthur", "5555 5555", "0"));
		assertEquals( true, agendaTeste1.cadastraContato("Monitor", "Desenrolado", "5555 5555", "100"));
		assertEquals( false, agendaTeste1.cadastraContato("Matheus", "Gaudêncio", "5555 5555", "101"));
		assertEquals(true, agendaTeste1.cadastraContato("José", "Félix", "7777 7777", "1"));
		
	}

	@Test
	void testExibirContato() {
		 
		assertEquals("Matheus Forlán - 4455 6677", agendaTeste1.exibirContato(65));
		assertEquals("POSIÇÃO INVÁLIDA!", agendaTeste1.exibirContato(41));
		agendaTeste1.cadastraContato("Maria", "José", "4444 4444", "41");
		assertEquals("Maria José - 4444 4444", agendaTeste1.exibirContato(41));
		agendaTeste1.cadastraContato("João", "de Deus", "6969 6969", "41");
		assertEquals("João de Deus - 6969 6969", agendaTeste1.exibirContato(41));
		assertEquals("POSIÇÃO INVÁLIDA!", agendaTeste1.exibirContato(0));
		assertEquals("POSIÇÃO INVÁLIDA!", agendaTeste1.exibirContato(101));
		
		
	}

	@Test
	void testListarContatos() {
		
		assertEquals(" 65 - Matheus Forlán" + "\n" +
				 "74 - Matias Fernandes" + "\n", agendaTeste1.listarContatos());
		agendaTeste1.cadastraContato("João", "Das Dores", "2222 3333", "1");
		assertEquals(" 1 - João Das Dores" + "\n"
				+ "65 - Matheus Forlán" + "\n" +
				 "74 - Matias Fernandes" + "\n", agendaTeste1.listarContatos());
		assertEquals(" ", agendaTeste3.listarContatos());
		
		
	}

	@Test
	void testEqualsObject() {
		
		
		assertTrue(agendaTeste1.equals(agendaTeste2));
        assertFalse(agendaTeste1.equals(agendaTeste3));
        assertFalse(agendaTeste1.equals(agendaTeste4));
        
        
	}

}
