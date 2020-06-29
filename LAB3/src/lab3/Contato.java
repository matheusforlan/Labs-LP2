package lab3;


/** Classe que representa um contato e armazena o nome, o sobrenome e  o número do telefone
 * do contato.
 * 
 * @author Matheus Bezerra Andrade
 *
 */
public class Contato {
	/**
	 * Representa o nome do contato.
	 */
   private String nome;
   /**
    * Representa o sobrenome do contato.
    */
  private String sobrenome;
  /**
   * Representa o número do telefone do contato.
   */
  private String telefone;
  
  
  /**
   * Constrói  um contato a partir do seu nome, sobrenome e número que são passados como parâmetro.
   * @param nome O nome do contato
   * @param sobrenome O sobrenome do Contato
   * @param telefone O número do telefone do contato.
   */
  public Contato(String nome, String sobrenome, String telefone) {
      super();
      this.nome = nome;
      this.sobrenome = sobrenome;
      this.telefone = telefone;
      }
  /**
   * Retorna a String do nome do contato.
   * @return a representação em String do nome do contato.
   */
  public String getNome() {
      return nome;
  }
  /**
   * Altera o atributo nome pelo o que é passado como parâmetro.
   * @param nome O nome do contato
   */
  public void setNome(String nome) {
      this.nome = nome;
  }
  /**
   * Retorna a String do sobrenome do contato.
   * @return a representação em String do sobrenome do contato.
   */
  public String getSobrenome() {
      return sobrenome;
  }
  /**
   *  Altera o atributo sobrenome pelo o que é passado como parâmetro.
   * @param sobrenome O sobrenome do contato.
   */
  public void setSobrenome(String sobrenome) {
      this.sobrenome = sobrenome;
  }
  /**
   * Retorna a string do telefone do contato.
   * @return a representação em String do número do telefone do contato.
   */
  public String getTelefone() {
      return telefone;
  }
  /**
   * Altera o atributo telefone pelo o que é passado como parâmetro.
   * @param telefone O número do telefone do contato.
   */
  public void setTelefone(String telefone) {
      this.telefone = telefone;
  }
  
 /**
  * Retorna a String que representa o nome completo do contato a representação tem a forma:
  * 
  *  "Nome Sobrenome"
  *  @return  A representação em String do nome completo do contato.
  */ 
  @Override
  public String toString() {
      return  this.nome + " " + this.sobrenome;
      
  }
  /**
   * Indica o número hash do objeto.
   * @return um valor inteiro que é o  número hash do objeto.
   */
  
   @Override
   public int hashCode() {
       final int prime = 31;
       int result = 1;
       result = prime * result + ((nome == null) ? 0 : nome.hashCode());
       result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
       return result;
   }
   
   
   /**
    * Testa se os dois objetos são iguais, nesse caso, se nome e sobrenome são iguais.
    * @return um valor em booleano se são iguais ou não.
    */
   @Override
   public boolean equals(Object obj) {
       if (this == obj)
           return true;
       if (obj == null)
           return false;
       if (getClass() != obj.getClass())
           return false;
       Contato other = (Contato) obj;
       if (nome == null) {
           if (other.nome != null)
               return false;
       } else if (!nome.equals(other.nome))
           return false;
       if (sobrenome == null) {
           if (other.sobrenome != null)
               return false;
       } else if (!sobrenome.equals(other.sobrenome))
           return false;
       return true;
   }
 }