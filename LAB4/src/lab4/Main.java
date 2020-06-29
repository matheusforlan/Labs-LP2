package lab4;

import java.util.Scanner;

public class Main {
	private static ControleAlunos controleAlunos = new ControleAlunos();
	private static Scanner sc = new Scanner(System.in);
	
	
	public static void main (String[] args) {
		Scanner sc1 = new Scanner(System.in);
		
		String entrada;
		
		do {
			exibirMenu();
			
			entrada = sc1.nextLine().toUpperCase();
			
			if( entrada.equals("C")) {
				
				System.out.println( cadastrarAluno());
				
		
			
			} else if ( entrada.equals("E")) {
				System.out.println(exibirAluno());
			}
				
			  else if (entrada.equals("N")) {
				 
				 System.out.println(cadastrarGrupo());
			  }
		 
			  else if (entrada.equals("A")) {
				 
				 System.out.println( alocarOrImprimir());
				 
			  } 
			  else if (entrada.equals("R")) {
				  System.out.println( cadastrarAlunosQueResponderam());
			  }
				 
			 
			  else if (entrada.equals("I")) {
				 
				 System.out.println( imprimirAlunosQueResponderam());
			  }
				 
			 
			
		} while (!(entrada.equals("O")));
						
		
	} 
	
	private static void exibirMenu() {
		System.out.println(
				"(C)adastrar Aluno\n" + 
				"(E)xibir Aluno\n" + 
				"(N)ovo Grupo\n" + 
				"(A)locar Aluno no Grupo e Imprimir Grupos\n" + 
				"(R)egistrar Aluno que Respondeu\n" + 
				"(I)mprimir Alunos que Responderam\n" + 
				"(O)ra, vamos fechar o programa!\n" + 
				"\n" + 
				"Opção>");
		
		
	}

	private static String  imprimirAlunosQueResponderam() {
		
		return controleAlunos.imprimirAlunosQueResponderam();
	}

	private static String cadastrarAlunosQueResponderam() {
		
		System.out.println("Matrícula: ");
		String matricula = sc.nextLine();
		
		ForlanUtil.verificaStringVazia(matricula, "Nao pode matricula vazia");
		ForlanUtil.veririficaStringNull(matricula, "Nao pode matricula nula");
		
		String cadastro = controleAlunos.cadastrarAlunoQueRespondeu(matricula);
		return cadastro;
	}

	private static String  alocarOrImprimir() {
		System.out.println("(A)locar Aluno ou (I)mprimir Grupo? ");
		String escolha = sc.nextLine().toUpperCase();
		if (escolha.equals("A")) {
			System.out.println("Matrícula: ");
			String matricula = sc.nextLine();
			
			ForlanUtil.verificaStringVazia(matricula, "Nao pode matricula vazia");
			ForlanUtil.veririficaStringNull(matricula, "Nao pode matricula nula");
			
			System.out.println("Grupo: ");
			String nomeGrupo = sc.nextLine();
			
			ForlanUtil.verificaStringVazia(nomeGrupo, "Nao pode nome de grupo vazio");
			ForlanUtil.veririficaStringNull(nomeGrupo, "Nao pode nome de grupo nulo");
			
			String alocado = controleAlunos.alocarAluno(matricula , nomeGrupo);
			
			return alocado;
			
			}  else if (escolha.equals("I")) {
				System.out.println("Grupo: ");
				String nomeGrupo =sc.nextLine();
				
				ForlanUtil.verificaStringVazia(nomeGrupo, "Nao pode matricula vazia");
				ForlanUtil.veririficaStringNull(nomeGrupo, "Nao pode matricula nula");
				
				String impressao = controleAlunos.imprimirGrupo(nomeGrupo);
				
				return impressao;
				
			}
		
		
		return "Opção inválida";
	}

	private static String cadastrarGrupo() {
		System.out.print("Grupo: ");
		String nomeGrupo = sc.nextLine();
		
		ForlanUtil.verificaStringVazia(nomeGrupo, "Nao pode nome de grupo  vazio");
		ForlanUtil.veririficaStringNull(nomeGrupo, "Nao pode nome de grupo nulo");
		
		
		boolean grupoCriado = controleAlunos.cadastrarGrupo( nomeGrupo);
		
		if (grupoCriado == true) {
			return "CADASTRO REALIZADO";
		} else {
			return "GRUPO JÁ CADASTRADO"; 
		}
	}

	public static String cadastrarAluno() {
		System.out.println("Matrícula: ");
		String matricula = sc.nextLine();
		
		ForlanUtil.verificaStringVazia(matricula, "Nao pode matricula vazia");
		ForlanUtil.veririficaStringNull(matricula, "Nao pode matricula nula");
		
		System.out.println("Nome: ");
		String nome = sc.nextLine();
		
		ForlanUtil.verificaStringVazia(nome, "Nao pode nome vazio");
		ForlanUtil.veririficaStringNull(nome, "Nao pode nome nulo");
		
		System.out.println("Curso: ");
		String curso = sc.nextLine();
		
		ForlanUtil.verificaStringVazia(curso, "Nao pode curso vazio");
		ForlanUtil.veririficaStringNull(curso, "Nao pode curso nulo");

		boolean cadastro = controleAlunos.cadastrarAluno(matricula, nome, curso);
		
		if (cadastro == true) {
			return "CADASTRO REALIZADO!";
		} 
			
		return "MATRÍCULA JÁ CADASTRADA!";
	}
	
	public static String exibirAluno() {
		System.out.println("Matrícula: ");
		String matricula = sc.nextLine();
		
		ForlanUtil.verificaStringVazia(matricula, "Nao pode matricula vazia");
		ForlanUtil.veririficaStringNull(matricula, "Nao pode matricula nula");
		
		String consultado = controleAlunos.consultarAluno(matricula);
		return "\n" + consultado + "\n";
			
		}
	
}