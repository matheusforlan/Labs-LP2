package lab3;
import java.util.Arrays;
/**
 *  Representação de uma agenda de contatos. A partir dela, poderemos ter acesso aos 
 *  atributos e métodos do contatos individualmente.
 * @author Matheus Bezerra Andrade
 *
 */
public class Agenda {
    /**
     * É a Agenda propriamente dita, a qual é um array de contatos.
     */
    private Contato[] agenda;
    
    /**
     * Constrói uma agenda de contatos.
     * Só há 100 posições disponíveis para colocar os contatos, iniciando em 1 e terminando em 100, 
     * por isso o array de contatos tem tamanho 100.
     */
    public Agenda() {
      this.agenda = new Contato[100];
    }
    /**
     * Cadastra o contato na posição que foi passada como parâmetro, se essa posição estiver disponível,
     * ou seja, esteja entre a posição 1 e 100. Se não estiver entre 1 e 100, o método retorna falso e volta
     * para o menu, se estiver entre as posições, o número é cadastrado normalmente. Se já houver um 
     * contato cadastrado na posição determinada, esse contato será substituído pelo novo.
     * @param nome Nome do contato.
     * @param sobrenome O sobrenome do contato.
     * @param telefone O número do telefone do contato.
     * @param posicao A posição em que o contato será adicionado.
     * @return Um valor booleano indicando se o cadastro foi realizado ou não.
     */
    
    public boolean cadastraContato(String nome, String sobrenome, String telefone,String posicao) {
      if ( Integer.parseInt(posicao) > 100 || Integer.parseInt(posicao) < 1) {
          return false;
      }
      for (int i = 0;  i < this.agenda.length;  i++) {
          if ((i + 1) == Integer.parseInt(posicao)) {
              agenda[i] = new Contato(nome, sobrenome, telefone);
              return true;
          }
      }
     return false;
     }
    /**
     * Exibe o nome completo e o telefone do contato a partir da posição que foi passada como parâmetro.
     * Se não houver nenhum  contato cadastrado ou a posição que foi passada não estiver entre 1 e 100,
     * o método retornará uma String dizendo que a posição é inválida e volta para o menu principal.
     * @param posicao a posição do contato na agenda que quer ser exibido.
     * @return Uma String com o nome completo e o número do telefone.
     */
    public String exibirContato(int posicao) {
       for (int i=0 ; i < agenda.length ; i++) {
           if ((i+1) == posicao) {
               if (agenda[i] == null){
                   return "POSIÇÃO INVÁLIDA!";
               } else {
                   return agenda[i].toString() + " - " +  agenda[i].getTelefone();
               }
           }
       }
       return "POSIÇÃO INVÁLIDA!";
   }
    /**
     * Exibe a lista completa de todos os contatos cadastrados. Se a posição do contato for diferente
     * de nulo, o contato será listado com a sua posição na agenda e seu nome completo.
     * Se não houver nenhum contato cadastrado, o método só retorna uma linha em branco e volta para
     * o menu principal.
     * @return Uma String que representa a lista completa de contatos.
     */
    public String listarContatos() {
       String lista = " ";
       for (int i = 0; i < agenda.length; i++) {
           if((agenda[i] != null)) {
               lista += i+1  + " - " + agenda[i].toString() + "\n";
           }
       }
       return lista;
   }
    /**
     * Indica o número hash do objeto.
     * @return um valor inteiro que é o número hash do objeto.
     */
    
    @Override
   public int hashCode() {
       final int prime = 31;
       int result = 1;
       result = prime * result + Arrays.hashCode(agenda);
       return result;
   }
    /**
     * Testa se duas agendas são iguais. Elas só serão iguais se tiverem  os mesmos contatos cadastrados
     *  nas mesmas posições.
     *  @return um valor em booleano indicando se são iguais ou não.
     */ 
    @Override
   public boolean equals(Object obj) {
       if (this == obj)
           return true;
       if (obj == null)
           return false;
       if (getClass() != obj.getClass())
           return false;
       Agenda other = (Agenda) obj;
       if (!Arrays.equals(agenda, other.agenda))
           return false;
       return true;
   }
}
