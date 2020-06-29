package lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControleAlunosTest {
	
	ControleAlunos controleAlunos;
	
	
	
	@BeforeEach
	 void setup() {
	
	this.controleAlunos = new ControleAlunos();
	this.controleAlunos.cadastrarAluno("65","Matheus Forlan","cc");
	this.controleAlunos.cadastrarAluno("75", "José", "elétrica");
	
	}
	

	@Test
	void testCadastrarAlunoMatriculaInvalida() {
		assertThrows(IllegalArgumentException.class, ()-> this.controleAlunos.cadastrarAluno(" ","Tomas Shelby","cc"));
        assertThrows(NullPointerException.class, ()-> new Aluno(null,"Tommas Shelby","cc"));
	}
	@Test
    void testcadastrarAlunoNomeInvalido() {
        assertThrows(IllegalArgumentException.class, ()-> this.controleAlunos.cadastrarAluno("6895"," ","cc"));
        assertThrows(NullPointerException.class, ()-> new Aluno("6895 ",null, " mecanica" ) );
      
    }
	
	@Test
    void cadastrarAlunoCursoInvalido() {
        assertThrows(IllegalArgumentException.class, ()-> this.controleAlunos.cadastrarAluno("6969 ", "Bruna","  "));
        assertThrows(NullPointerException.class, ()-> new Aluno("1313 "," João ",null));
    }
	
	 @Test
	    void cadastrarAlunoValido() {
	       
		 assertEquals("CADASTRO REALIZADO!", this.controleAlunos.cadastrarAluno("444", "Matheus Forlán", "Libras"));
		 assertEquals("MATRÍCULA JÁ CADASTRADA!",this.controleAlunos.cadastrarAluno("444","José ","cc"));
	 
	 }
	 

	@Test
	void testConsultarAluno() {
		assertEquals("65 - Matheus Forlan - cc", this.controleAlunos.consultarAluno("65"));
        assertNotEquals("75 - José - eletrica", this.controleAlunos.consultarAluno("79"));
        
        assertEquals("ALUNO NÃO CADASTRADO", this.controleAlunos.consultarAluno("13"));
	}

	@Test
	void testCadastrarGrupo() {
		assertThrows(IllegalArgumentException.class, ()-> this.controleAlunos.cadastrarGrupo(""));
        assertThrows(NullPointerException.class, ()-> this.controleAlunos.cadastrarGrupo(null));
        
        assertEquals("CADASTRO REALIZADO!", this.controleAlunos.cadastrarGrupo("Listas"));
        assertEquals("GRUPO JÁ CADASTRADO!", this.controleAlunos.cadastrarGrupo("Listas"));
        assertEquals("GRUPO JÁ CADASTRADO!", this.controleAlunos.cadastrarGrupo("LISTAs"));
        assertEquals("CADASTRO REALIZADO!", this.controleAlunos.cadastrarGrupo("BarNilson"));
        
	}

	@Test
	void testAlocarAluno() {
		 this.controleAlunos.cadastrarGrupo("BarNilson");
	       
	       
	       assertEquals("ALUNO ALOCADO!", this.controleAlunos.alocarAluno("65" ,"BarNilson"));
	       assertEquals("GRUPO NÃO CADASTRADO.",this.controleAlunos.alocarAluno("12","Foro de SP"));
	       assertEquals("ALUNO NÃO CADASTRADO.", this.controleAlunos.alocarAluno("1623","BarNilson"));

	}

	@Test
	void testImprimirGrupo() {
		assertEquals("Grupo não cadastrado", this.controleAlunos.imprimirGrupo("kkk"));
		this.controleAlunos.cadastrarGrupo("kkk");
		this.controleAlunos.alocarAluno("65", "kkk");
		this.controleAlunos.alocarAluno("75", "KKK");
		assertEquals("* 65 - Matheus Forlan - libras \n"
				+ "* 75 - José - elétrica \n", this.controleAlunos.imprimirGrupo("kkk"));
		
	}

	@Test
	void testCadastrarAlunoQueRespondeu() {
		  assertEquals("ALUNO REGISTRADO!",this.controleAlunos.cadastrarAlunoQueRespondeu("65"));
	       assertEquals("ALUNO NÃO CADASTRADO!", this.controleAlunos.cadastrarAlunoQueRespondeu("13"));
	        assertEquals("ALUNO REGISTRADO!",this.controleAlunos.cadastrarAlunoQueRespondeu("75"));

	}

	@Test
	void testImprimirAlunosQueResponderam() {
		
		 this.controleAlunos.cadastrarAlunoQueRespondeu("65");
		 assertEquals("1. 65 - Matheus Forlan - cc /n" , this.controleAlunos.imprimirAlunosQueResponderam());
		 
	}
}
