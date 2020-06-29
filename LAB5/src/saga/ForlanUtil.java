package saga;

	public class ForlanUtil {
		
		public static void verificaStringNull(String valor, String mensagem) {
			if(valor == null) {

				throw new NullPointerException(mensagem);
			}
		}
		
		public static void veririficaStringVazia(String valor, String mensagem) {
			if(valor.trim().equals("")) {
			
				throw new IllegalArgumentException(mensagem);
			}
		}

}


