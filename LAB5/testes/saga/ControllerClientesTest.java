package saga;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControllerClientesTest {
	
	private ControllerClientes controllerClientes;
	
	
	@BeforeEach
	void setup() {
		
		this.controllerClientes = new ControllerClientes();
		
	}

	@Test
	void testCadastrarCliente() {  
		
		assertEquals("11111111111" , this.controllerClientes.cadastrarCliente("11111111111", "Zé Pequeno", 
				 "ZePequeno@gmail.com","LSD"));
		
		assertEquals("22222222222" , this.controllerClientes.cadastrarCliente("22222222222", "Zé Ramalho", "ZeRamalho@gmail.com", "SPLAB"));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerClientes.cadastrarCliente("11111111111", "João", "Joao@gmail.com",  "LSD"));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerClientes.cadastrarCliente("55555555555", "", "Joao@gmail.com",  "LSD"));
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerClientes.cadastrarCliente("55555555555", null , "Joao@gmail.com",  "LSD"));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerClientes.cadastrarCliente("55555555555", "João", "",  "LSD"));
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerClientes.cadastrarCliente("55555555555", "João", null,  "LSD"));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerClientes.cadastrarCliente("55555555555", "João", "Joao@gmail.com",  ""));
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerClientes.cadastrarCliente("55555555555", "João", "Joao@gmail.com",  null));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerClientes.cadastrarCliente("55555", "João", "Joao@gmail.com",  "LSD"));
		
	}

	@Test
	void testExibeCliente() {
		this.controllerClientes.cadastrarCliente("11111111111", "Zé Pequeno"
				, "ZePequeno@gmail.com","LSD");
		
		assertEquals("Zé Pequeno - LSD - ZePequeno@gmail.com",
				this.controllerClientes.exibeCliente("11111111111").toString());
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerClientes.exibeCliente("00000000000").toString());
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerClientes.exibeCliente("").toString());
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerClientes.exibeCliente(null).toString());
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerClientes.exibeCliente("111111").toString());
		
		
	}
		

	@Test
	void testEditaCliente() {
		this.controllerClientes.cadastrarCliente("11111111111", "Zé Pequeno", 
				 "ZePequeno@gmail.com", "LSD");
		
		this.controllerClientes.editaCliente("11111111111", "nome", "João de Deus");
		assertEquals ("João de Deus - LSD - ZePequeno@gmail.com", this.controllerClientes.exibeCliente("11111111111").toString()
				);
		
		this.controllerClientes.editaCliente("11111111111", "email", "Jao@gmail.com");
		
		assertEquals("João de Deus - LSD - Jao@gmail.com", this.controllerClientes.exibeCliente("11111111111"));
		
		this.controllerClientes.editaCliente("11111111111", "localizacao", "SPLAB");
		
		assertEquals("João de Deus - SPLAB - Jao@gmail.com", this.controllerClientes.exibeCliente("11111111111"));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerClientes.editaCliente("00000000000", "nome", "Marlon")); 
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerClientes.editaCliente("", "nome", "Marlon")); 
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerClientes.editaCliente(null, "nome", "Marlon")); 
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerClientes.editaCliente("11111111111", "", "Marlon")); 
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerClientes.editaCliente("11111111111", null , "Marlon")); 
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerClientes.editaCliente("11111111111", "nome", "")); 
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerClientes.editaCliente("11111111111", "nome", null)); 
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerClientes.editaCliente("11111111111", "xablau", "Marlon")); 
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerClientes.editaCliente("11111", "nome", "Marlon")); 
		
		
		
	}

	@Test
	void testRemoveCliente() {
		this.controllerClientes.cadastrarCliente("11111111111", "Zé Pequeno", 
				 "ZePequeno@gmail.com", "LSD");
		assertTrue (true == this.controllerClientes.getMapaClientes().containsKey("11111111111"));
		this.controllerClientes.removeCliente("11111111111");
		assertTrue (false == this.controllerClientes.getMapaClientes().containsKey("11111111111"));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerClientes.removeCliente("11111111111"));
		
		this.controllerClientes.cadastrarCliente("22222222222", "Gabigol", 
				 "Gabigol@gmail.com", "LSD");
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerClientes.removeCliente(""));
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerClientes.removeCliente(null));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerClientes.removeCliente("2222222"));
		
	}
	

}
