package saga;




import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
/**
 * Classe que controla e cadastra os clientes e além de suas  operações
 * @author Matheus Bezerra Andrade - 119110409
 *
 */
public class ControllerClientes  {
	/**
	 * Mapa de clientes que é identifcicado pelo seu cpf.
	 */
	private   HashMap <String, Cliente> mapaClientes;
	
	/**
	 * Constroi o mapa de clientes
	 */
	public ControllerClientes() {
		
		this.mapaClientes = new HashMap<> ();
		
	}
	
	/**
	 * Metdo que cadastra os clientes no mapa, se esse cliente já nao estiver cadastrado.
	 * 
	 * @param cpf cpf do cliente que é o seu ID 
	 * @param nome nome do cliente 
	 * @param email email do cliente
	 * @param local e local do tarbalho
	 * @return retorna o cpf se for bem sucedido
	 */
	public String  cadastrarCliente(String cpf, String nome, String email, String local) {
		
		ForlanUtil.verificaStringNull(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		ForlanUtil.verificaStringNull(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		ForlanUtil.verificaStringNull(local, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		ForlanUtil.veririficaStringVazia(local, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		ForlanUtil.verificaStringNull(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		
		if (this.mapaClientes.containsKey(cpf)) {
			
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
			
		}
		if (cpf.length() !=  11) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
		}
	
		Cliente cliente = new Cliente( cpf, nome, local, email);
		mapaClientes.put(cpf, cliente);
		return cpf;
		
	}
	/**
	 * Método que exibe os dados de um determinado cliente
	 * @param cpf cpf do cliente que o dientifca
	 * @return represetacao em string dos dados do cliente
	 */
	public String exibeCliente(String cpf) {
		
		ForlanUtil.verificaStringNull(cpf, "Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(cpf, "Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
		
		if ( mapaClientes.containsKey(cpf)) {
			return mapaClientes.get(cpf).toString();
			
		} 
	
		
		throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		
	}

/**
 * exibe todos os clientes cadastrados no sistema
 * @return representaçao em string de todos os clietntes e seus respectivos dados
 */
	public String exibeClientes() {
		
		List<Cliente>listaClientes = new ArrayList();
		listaClientes.addAll(this.mapaClientes.values());
		Collections.sort(listaClientes);
		 
		
		String listar = "";
		
		for (Cliente cliente: listaClientes) {
			
			listar += cliente.toString() + " | ";
		}
		
		listar = listar.substring(0, listar.length()-3);
		return listar;
	}


	/**
	 * Edita algum atributo do cliente, dependendo do que ele passa como parametro
	 * @param cpf cpf do cliente
	 * @param atributo atributo que será alterado
	 * @param novoValor novo valor que será alterado
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		ForlanUtil.verificaStringNull(atributo, "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(atributo, "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		ForlanUtil.verificaStringNull(novoValor, "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(novoValor, "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		ForlanUtil.verificaStringNull(cpf, "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(cpf, "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
		
		if("cpf".equals(atributo)) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser editado.");
		}
		
		else if (this.mapaClientes.containsKey(cpf)) {
			
			if ("nome".equals(atributo)) {
				this.mapaClientes.get(cpf).setNome(novoValor);
			}
			else if ( "email".equals(atributo)) {
				this.mapaClientes.get(cpf).setEmail(novoValor);
				
			} else if ("localizacao".equals(atributo)) {
				
				this.mapaClientes.get(cpf).setLocal(novoValor);
			} else {
				
				throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");	
			}
				
		}
		else {
			throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
		}
			
	}
	/**
	 * método que remove um cliente do sistema
	 * @param cpf cpf do cliente
	 */
	public void removeCliente(String cpf) {
		
		ForlanUtil.verificaStringNull(cpf, "Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
		ForlanUtil.veririficaStringVazia(cpf, "Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
		
		
		
		if ( this.mapaClientes.containsKey(cpf)) {
			this.mapaClientes.remove(cpf);
		} else {
			throw new IllegalArgumentException("Erro na remocao do cliente: cliente nao existe.");
		}
		 	
	}

/**
 * método que retorna um mapa de cliente s que será usado em outra classe
 * @return um Hashmap de clientes
 */
	public  HashMap<String, Cliente> getMapaClientes() {
		return mapaClientes;
	}
	
	public   Cliente getCliente(String cpf) {
		 
			return mapaClientes.get(cpf);
			
	}

	

}
