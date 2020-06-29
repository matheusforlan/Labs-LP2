package lab4;
	/**
	 * Classe que é responsável por lançar exceções se as entradas forem nulas ou vazias.
	 * @author Matheus Andrade
	 *
	 */
public class ForlanUtil {
	/**
	 *  Verifica se a entrada foi nula e lança uuma exceção com uma mensagem se for.
	 * @param valor valor que será testado
	 * @param mensagem mensagem que será enviada
	 */
	
	public static void verificaStringVazia(String valor, String mensagem) {
		if(valor.trim().isEmpty()) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	/**
	 * Verifica se a entrada foi vazia e lança uuma exceção com uma mensagem se for.
	 * 
	 * @param valor valor que será testado
	 * @param mensagem mensagem que será enviada
	 */
	public static void veririficaStringNull(String valor, String mensagem) {
		if(valor == null) {
			throw new NullPointerException(mensagem);
		}
	}

}