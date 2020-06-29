package saga;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControllerFornecedoresTest {
	
	private ControllerFornecedores controllerFornecedores;
	
	@BeforeEach
	void setup() {
	
		this.controllerFornecedores = new ControllerFornecedores();
	}
	@Test
	void testadicionaFornecedor() {
		
		assertEquals("Kaká", this.controllerFornecedores.adicionaFornecedor("Kaká", "kaka@gmail.com", "1010"));
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerFornecedores.adicionaFornecedor("Kaká", "kk@gmail.com", "5457"));
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerFornecedores.adicionaFornecedor("", "kk@gmail.com","5457"));
		assertThrows( NullPointerException.class, ()-> 
		this.controllerFornecedores.adicionaFornecedor(null, "kk@gmail.com","5457"));
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerFornecedores.adicionaFornecedor("Kiko", "", "5457"));
		assertThrows( NullPointerException.class, ()->  
		this.controllerFornecedores.adicionaFornecedor("Kiko", null, "5457"));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerFornecedores.adicionaFornecedor("Kiko", "kk@gmail.com",""));
		assertThrows( NullPointerException.class, ()-> 
		this.controllerFornecedores.adicionaFornecedor("Kiko", "kk@gmail.com",null));
	}

	@Test
	void testexibeFornecedor() {
		this.controllerFornecedores.adicionaFornecedor("Kaká", "kaka@gmail.com", "1010");
		assertEquals("Kaká - kaka@gmail.com - 1010", this.controllerFornecedores.exibeFornecedor("Kaká"));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerFornecedores.exibeFornecedor("jubileu"));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerFornecedores.exibeFornecedor(""));
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerFornecedores.exibeFornecedor(null));
	}

	@Test
	void testEditaFornecedor() {
		
		this.controllerFornecedores.adicionaFornecedor("Kaká", "kaka@gmail.com", "1010");
		
		this.controllerFornecedores.editaFornecedor("Kaká", "email", "kk@gmail.com");
		assertEquals("kk@gmail.com", this.controllerFornecedores.getMapaFornecedores().get("Kaká").getEmail());
		this.controllerFornecedores.editaFornecedor("Kaká", "telefone", "6575");
		assertEquals("6575", this.controllerFornecedores.getMapaFornecedores().get("Kaká").getTelefone());
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerFornecedores.editaFornecedor("Imperador", "email", 
				"didico@gmail.com"));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerFornecedores.editaFornecedor("", "email", 
				"kaka@gmail.com"));
		

		assertThrows( NullPointerException.class, ()-> 
		this.controllerFornecedores.editaFornecedor(null, "email", 
				"kaka@gmail.com"));
		

		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerFornecedores.editaFornecedor("Kaká", "", 
				"kaka@gmail.com"));
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerFornecedores.editaFornecedor("Kaká", null, 
				"kaka@gmail.com"));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerFornecedores.editaFornecedor("Kaká", "email", 
				""));
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerFornecedores.editaFornecedor("Kaká", "email", 
				null));
	}

	@Test
	void testRemoveFornecedor() {
		
		this.controllerFornecedores.adicionaFornecedor("kaká", "kaka@gmail.com", "1010");
		this.controllerFornecedores.removeFornecedor("kaká");
		assertTrue( false == this.controllerFornecedores.getMapaFornecedores().containsKey("kaká"));
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerFornecedores.removeFornecedor("kaká"));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerFornecedores.removeFornecedor(""));
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerFornecedores.removeFornecedor(null));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerFornecedores.removeFornecedor("jubileu"));
		
		
		
		
	}

	@Test
	void testAdicionaProduto() {
		
		this.controllerFornecedores.adicionaFornecedor("Kaká", "kaka@gmail.com", "1010");
		this.controllerFornecedores.adicionaProduto("Kaká", "Peixe", "Assado", 15.00);
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerFornecedores.adicionaProduto("Sam Wilson", "Cebola", "faz chorar...", 0.70));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerFornecedores.adicionaProduto("", "Cebola", "faz chorar...", 0.70));
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerFornecedores.adicionaProduto(null, "Cebola", "faz chorar...", 0.70));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerFornecedores.adicionaProduto("Kaká", "", "faz chorar...", 0.70));
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerFornecedores.adicionaProduto("Kaká", null , "faz chorar...", 0.70));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerFornecedores.adicionaProduto("Kaká", "Cebola", "", 0.70));
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerFornecedores.adicionaProduto("Kaká", "Cebola" , null, 0.70));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerFornecedores.adicionaProduto("Kaká", "Cebola", "faz chorar...", -2 ));
		
		
	}

	@Test
	void testExibeProduto() {
		
		this.controllerFornecedores.adicionaFornecedor("Kaká", "kaka@gmail.com", "1010");
		this.controllerFornecedores.adicionaProduto("Kaká", "Peixe", "Assado", 15.00);
		assertEquals("Peixe - Assado - R$15,00", this.controllerFornecedores.
				exibeProduto( "Peixe", "Assado" ,"Kaká"));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerFornecedores.removeProduto( "Peixe", "Assado", "Jubileu"));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerFornecedores.removeProduto( "", "Assado", "Kaká"));
		
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerFornecedores.removeProduto( null, "Assado", "Kaká"));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerFornecedores.removeProduto("Peixe", "", "Kaká"));
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerFornecedores.removeProduto( "Peixe", null, "Kaká"));
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerFornecedores.removeProduto( "Peixe", "Assado", null));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerFornecedores.removeProduto("Peixe", "Assado", ""));

		
	}
 

	@Test
	void testRemoveProduto() {
		
		this.controllerFornecedores.adicionaFornecedor("Kaká", "kaka@gmail.com", "1010");
		this.controllerFornecedores.adicionaProduto("Kaká", "Peixe", "Assado", 15.00);
		
		this.controllerFornecedores.removeProduto( "Peixe", "Assado", "Kaká");
		assertTrue (false == this.controllerFornecedores.getMapaFornecedores().
				get("Kaká").getMapaProdutos().containsKey(new ProdutoID("Peixe", "Assado")));
	
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerFornecedores.removeProduto("Peixe", "Assado", ""));
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerFornecedores.removeProduto("Peixe", "Assado", null));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerFornecedores.removeProduto("Peixe", "", "Kaká"));
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerFornecedores.removeProduto("Peixe", null , "Kaká"));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerFornecedores.removeProduto("", "Assado", "Kaká"));
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerFornecedores.removeProduto(null, "Assado", "Kaká"));
		
		
	}

	@Test
	void testEditaProduto() {
		this.controllerFornecedores.adicionaFornecedor("Kaká", "kaka@gmail.com", "1010");
		this.controllerFornecedores.adicionaProduto("Kaká", "Peixe", "Assado", 15.00);
		
		this.controllerFornecedores.editaProduto( "Peixe", "Assado", "Kaká", 17.75);
		assertEquals ("Peixe - Assado - R$17,75", this.controllerFornecedores.exibeProduto("Peixe", "Assado", "Kaká"));
	
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerFornecedores.editaProduto("", "Assado", "Kaká", 12.50));
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerFornecedores.editaProduto(null, "Assado", "Kaká", 12.50));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerFornecedores.editaProduto("Peixe", "", "Kaká", 12.50));
		 
		assertThrows( NullPointerException.class, ()-> 
		this.controllerFornecedores.editaProduto("Peixe", null, "Kaká", 12.50));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerFornecedores.editaProduto("Peixe", "Assado", "", 12.50));
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerFornecedores.editaProduto("Peixe", "Assado", null , 12.50));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerFornecedores.editaProduto("Peixe", "Assado", "Kaká", -1.78));
		
	}

}
