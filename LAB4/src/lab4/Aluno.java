package lab4;

/**
 * Classe que representa um aluno. Todo aluno tem uma matrícula, nome e curso. Ele será identificado
 * por esta matrícula.
 * @author Matheus Andrade
 *
 */
public class Aluno {
	/**
	 * É a matrícula do aluno. que é uma representação em String que pode ter qualquer formato.
	 */
	private String matricula;
	/**
	 * Representação em String do nome do aluno
	 */
	private String nome;
	/**
	 * Representação do nome do curso que o aluno faz.
	 */
	private String curso;
	
	/**
	 * Constrói um aluno a partir da sua matrícula, seu nome e seu curso.
	 * Se houver uma matrícula, um nome ou um curso, nulo ou vazio como parâmetro, o programa lança uma 
	 * exceção e encerra o programa.
	 * @param matricula a matricula do aluno
	 * @param nome nome do aluno 
	 * @param curso curso que o aluno faz.
	 */
	
	public Aluno(String matricula, String nome, String curso) {
		ForlanUtil.verificaStringVazia(matricula, "Nao pode matricula vazia");
		ForlanUtil.veririficaStringNull(matricula, "Nao pode matricula nula");
		
		ForlanUtil.verificaStringVazia(nome, "Nao pode nome vazio");
		ForlanUtil.veririficaStringNull(nome, "Nao pode nome nulo");
		
		ForlanUtil.verificaStringVazia(curso, "Nao pode curso vazio");
		ForlanUtil.veririficaStringNull(curso, "Nao pode curso nulo");
		
		
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}
			
	/**
	 * Retorna a String que representa o aluno. no formato: MATRICULA - NOME - CURSO.
	 * @return a representação em String de um aluno.
	 */
	@Override
	public String toString() {
		return  this.matricula + " - " + this.nome + " - " + this.curso;
	}
	
	/**
	 * Indica o número hash do objeto.
	 * @return um valor inteiro que é o  número hash do objeto.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}
	/**
	 * Testa se os dois objetos são iguais, nesse caso, se a matrícula é igual.
	 * @return um valor em booleano se são iguais ou não
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}	
	
}