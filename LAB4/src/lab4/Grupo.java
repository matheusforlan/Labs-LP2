package lab4;

import java.util.HashSet;
/**
 * Classe que representa um grupo. Todo grupo tem um nome e um mapa que guarda todos os alunos que são
 * adicionados nele. O grupo é identificado pelo seu nome.
 * @author Matheus Andrade
 *
 */
public class Grupo {
	/**
	 * String que representa o nome do grupo.
	 */
	
	private String nomeGrupo;
	/**
	 * Mapa dos alunos que estão naquele grupo.
	 */
	private HashSet <Aluno> conjuntoAlunos;
	
	/**
	 * Constrói um grupo a partir do seu nome. Se o parâmetro for nulo ou vazio, uma exceção é lançada
	 * e o programa irá parar.
	 * @param nomeGrupo nome do grupo
	 */
	public Grupo(String nomeGrupo) {
		ForlanUtil.verificaStringVazia(nomeGrupo, "Nao pode nome de grupo vazio");
		ForlanUtil.veririficaStringNull(nomeGrupo, "Nao pode nome de grupo nulo");
		
		
		this.nomeGrupo = nomeGrupo;
		this.conjuntoAlunos = new HashSet<>();
		
	}
	/**
	 * Adiciona o aluno que foi alocado nesse grupo no mapa de alunos do grupo.
	 * @param aluno Objeto aluno
	 */
	public void alocarAluno(Aluno aluno) {
		conjuntoAlunos.add(aluno);
		
	}

	/**
	 * Retorna a listagem dos alunos que estão naquele grupo em String com as informações do aluno.
	 */
	@Override
	public String toString() {
		String listar = "";
		
		for (Aluno aluno: this.conjuntoAlunos) {
			listar += "* " + aluno.toString() + "\n";
			
		}
		
		return listar;
	}
	
	/**
	 * Indica o número hash do objeto.
	 * @return um valor inteiro que é o  número hash do objeto.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeGrupo == null) ? 0 : nomeGrupo.hashCode());
		return result;
	}
	
	/**
	 * Testa se os dois objetos são iguais, nesse caso, se nome do grupo é igual..
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
		Grupo other = (Grupo) obj;
		if (nomeGrupo == null) {
			if (other.nomeGrupo != null)
				return false;
		} else if (!nomeGrupo.equals(other.nomeGrupo))
			return false;
		return true;
	}

	
	
}