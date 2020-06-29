package lab4;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * Controle de alunos que irá controlar os mapas dos grupos e dos alunos.
 * A classe irá cuidar do cadastro dos grupos, dos alunos e dos alunos que responderam, além das 
 * suas respectivas exibições.
 * @author Matheus Andrade
 *
 */
public class ControleAlunos {
	/**
	 * Mapa do controle de alunos. 
	 */
	private HashMap <String, Aluno> mapaControleAlunos;
	/**
	 * Mapa do controle de grupos.
	 */
	private HashMap <String, Grupo> mapaControleGrupos;
	/**
	 * Lista dos alunos que responderam
	 */
	private ArrayList<Aluno> alunosQueResponderam;
	
	/**
	 * Constrói um controle de alunos. Inicializando os mapas e a lista.
	 */
	public ControleAlunos() {
		this.mapaControleAlunos = new HashMap<>();
		this.mapaControleGrupos = new HashMap <>();
		this.alunosQueResponderam = new ArrayList<>();
	}
	
	/**
	 * Testa se há um aluno matriculado com aquela matrícula ou não.
	 * @param matricula é a matricula que será procurada como a chave do mapa.
	 * @return true se houver aluno matriculado, false se não houver.
	 */
	private  boolean alunoMatriculado(String matricula) {
		return this.mapaControleAlunos.containsKey(matricula);
	}

	/**
	 * Cadastra o aluno, primeiro verificando se essa matrícula já foi cadastrada ou não,
	 * se não foi cadastrada ainda, o aluno é adicionado dentro do mapa e retorna true.
	 * Se essa matrícula já foi cadastrada, retorna false.
	 * @param matricula matricula do aluno
	 * @param nome nome do aluno 
	 * @param curso curso do aluno
	 * @return
	 */
	public boolean cadastrarAluno(String matricula, String nome, String curso) {
		if ( alunoMatriculado(matricula) == false) {
			Aluno aluno = new Aluno( matricula, nome,  curso);
			this.mapaControleAlunos.put(matricula, aluno);
			return true;
			
			
		}
		return false;
	}
	
	/**
	 * Consulta o aluno e verifica se a matricula passada como parametro existe ou não, se não existir 
	 * retorna que não há aluno, mas se existir retorna as informações daquele aluno.
	 * @param matricula matricula do aluno
	 * @return a representação em String do aluno ou se não existir, "Aluno não cadastrado".
	 */
	
	public String consultarAluno(String matricula) {
		if (alunoMatriculado(matricula)== true) {
			Aluno aluno =  this.mapaControleAlunos.get(matricula);
			return "Aluno: " + aluno.toString();
		}
		
		return "Aluno não cadastrado.";
	}
	
	/**
	 * 
	 * Testa se o grupo já existe ou não no mapa de grupos. Se já houver grupo, retorna true, se não, retorna
	 * false. Na comparação, coloca tudo para minúsculo para fazer a comparação, já que não há
	 * distinção entre minúsculas e maiúsculas.
	 * @param nomeGrupo nome do grupo que irá ser testado
	 * @return true se já houver grupo matriculado, false se não houver.
	 */
	private boolean grupoMatriculado(String nomeGrupo) {
		for ( String chaveGrupo: this.mapaControleGrupos.keySet()) {
			if (chaveGrupo.toLowerCase().equals(nomeGrupo.toLowerCase())){
				return true;
			}
		} 
		return false;
	}
	
	
	/**
	 * Cadastra os grupos no mapa de grupos. Primeiro faz o teste se o grupo já existe ou não,
	 * se não existir, o grupo é adicionado no mapa.
	 * @param nomeGrupo nome do grupo que irá ser adicionado
	 * @return true se o grupo for adicionado, false se não for.
	 */
	public boolean cadastrarGrupo(String nomeGrupo) {
		if (grupoMatriculado(nomeGrupo) == false) {
			Grupo grupo = new Grupo(nomeGrupo);
			this.mapaControleGrupos.put(nomeGrupo.toLowerCase(), grupo);
			return true;		
		}
		
	
		return false;
	}

	/**
	 * Aloca um aluno já matriculado em um grupo já existente. Primeiro testa se aquele aluno existe ou não
	 * e também se o grupo existe ou não.  Se um dos dois não existir retorna informando que tal entidade
	 * não está cadastrada, se existirem, o aluno é adicionado dentro do grupo.
	 * @param matricula matricula do aluno
	 * @param nomeGrupo nome do grupo
	 * @return String informando se o aluno foi alocado ou não.
	 */
	public String alocarAluno(String matricula, String nomeGrupo) {
		
		if (alunoMatriculado(matricula)  == false) {
			return "Aluno não cadastrado.";
		}
		
		
		else if (grupoMatriculado(nomeGrupo) == false) {
			return "Grupo não cadastrado";
		}
		
		
		
		Grupo grupo = this.mapaControleGrupos.get(nomeGrupo.toLowerCase());
		Aluno aluno = this.mapaControleAlunos.get(matricula);
	
		grupo.alocarAluno(aluno);
		
		return "ALUNO ALOCADO";
		
		
	}

	/**
	 * Primeiro testa se o grupo existe ou não. se existir, retorna uma representação em string de
	 * todos os alunos  que estão cadastrados naquele grupo.
	 * @param nomeGrupo nome do grupo
	 * @return representação da lista dos alunos presentes no grupo em String
	 */
	public String imprimirGrupo(String nomeGrupo) {
		
		if (grupoMatriculado(nomeGrupo) == false) {
			return "Grupo não cadastrado";
			
		}
		
		Grupo grupo = this.mapaControleGrupos.get(nomeGrupo.toLowerCase());
		String imprimir = grupo.toString();
		return imprimir;
		
	}

	/**
	 * Primeiro testa se o aluno que foi passado como parâmetro existe ou não, se existir
	 * o aluno é adicionado na lista dos alunos que responderam.
	 * @param matricula matricula do aluno
	 * @return representação em String informando se o aluno foi cadastrado ou não.
	 */
	public String cadastrarAlunoQueRespondeu(String matricula) {
		if (alunoMatriculado(matricula ) == false) {
			return "Aluno não cadastrado";
			
			
		}
			Aluno aluno = this.mapaControleAlunos.get(matricula);
			this.alunosQueResponderam.add(aluno);
			
			return "ALUNO REGISTRADO!";
	}

	/**
	 * Imprime a lista com o nome e a matrícula de todos os alunos que responderam.
	 * @return a lista dos alunos que responderam em String.
	 */
	public String imprimirAlunosQueResponderam() {
		String imprimir = "";
		for (int i = 0; i < this.alunosQueResponderam.size(); i++) {
			
			imprimir += i+1 + ". " + this.alunosQueResponderam.get(i).toString() + "\n";
			
		}
		return imprimir;
	}
	

	
}