package lab3;
import java.util.Scanner;
/**
 * Laboratporio de Programação 2 - LAB 3
 * @author Matheus Bezerra Andrade - 119110409
 *
 */
public class AgendaDeContatos {
       public static void main (String args[]) {
           Agenda agenda = new Agenda();
           
           boolean acao = true;
           while (acao == true) {
               Scanner sc = new Scanner(System.in);
               System.out.println("(C) Cadastrar Contato \n"
                       + "(L) Listar contatos \n"
                       + "(E) Exibir Contato \n"
                       + "(S) Sair \n" );
               System.out.print("Opção> ");
               String opcao = sc.nextLine();
               if (opcao.equals("C") || opcao.equals("c") ) {
                          System.out.print("Posição: ");
                          String posicao = sc.nextLine();
                           System.out.print("Nome: ");
                          String nome = sc.nextLine();
                           System.out.print("Sobrenome: ");
                          String sobrenome = sc.nextLine();
                           System.out.print("Telefone: ");
                           String  telefone = sc.nextLine();
                           boolean cadastro = agenda.cadastraContato( nome,  sobrenome,  telefone,  posicao);
                             if (cadastro == true) {
                                  System.out.println("CADASTRO REALIZADO!");
                              } else {
                                  System.out.println("POSIÇÃO INVÁLIDA!");
                                  }
                 } else if (opcao.equals("E") || opcao.equals("e")) {
                      System.out.print("Contato> ");
                       int posicao = sc.nextInt();
                      String exibir = agenda.exibirContato( posicao);
                      System.out.println(exibir);
                  } else if (opcao.equals("L") || opcao.equals("l")) {
                               
                       String listar = agenda.listarContatos();
                       System.out.println(listar);
                                           }
                else if ( opcao.equals("S") || opcao.equals("s")) {
                  acao = false;
                   } else {
                       
                   System.out.println("OPÇÃO INVÁLIDA");
               }
               }
       }
}
