package saga;



import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
 * Classe que representa o controle de Fornecedores, a qual é responsável pelo armazenamento dos fornecedores e pela criação
 * de produtos.
 * @author Matheus Bezerra Andrade - 119110409
 */
public class ControllerFornecedores {
	/*
	 *  Atributo que represente o mapa de fornecedores.
	 */
	private HashMap <String, Fornecedor> mapaFornecedores;
	
	/**
	 * Connstrói um mapa de Fornecedores sem nenhum parâmetro.
	 */
	public ControllerFornecedores(){
		 
		this.mapaFornecedores = new HashMap<>();
		
	}
	/**
	 * Método que adiciona o fornecedor no mapa de fornecedores, se ele já não estiver lá.
	 * @param nome nome do fornecedor.
	 * @param email email do fornecedor
	 * @param telefone  telefone do fornecedor
	 * @return Retorna o nome do fornecedor.
	 */
	public String adicionaFornecedor( String nome, String email, String telefone) {
		
		ForlanUtil.verificaStringNull(nome, "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(nome, "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		ForlanUtil.verificaStringNull(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		ForlanUtil.verificaStringNull(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		
		if (this.mapaFornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		} else {
			Fornecedor fornecedor = new Fornecedor( nome, email, telefone);
			this.mapaFornecedores.put(nome, fornecedor);   
			return nome;
				
		}
		
	}
	/**
	 * Representação em String dos dados do fornecedor.
	 * @param nome nome do fornecedor
	 * @return Representação em string dos dados do fornecedor
	 */
	public String exibeFornecedor(String nome) {
		
		ForlanUtil.verificaStringNull(nome, "Erro na exibicao do fornecedor: nome nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(nome, "Erro na exibicao do fornecedor: nome nao pode ser vazio ou nulo.");
		
		
		if (this.mapaFornecedores.containsKey(nome)) {
			return this.mapaFornecedores.get(nome).toString();
		}
		else {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
			
		}
		}
	/**
	 * Exibe todos os fornecedores que estão no mapa.
	 * @return Uma lista com todos os fornecedores no formato de String.
	 */
	public String exibeFornecedores() {
	
		List<Fornecedor> listaFornecedores = new ArrayList();
		listaFornecedores.addAll(this.mapaFornecedores.values());
		Collections.sort(listaFornecedores);
		
		String listar = "";
		
		for (Fornecedor fornecedor: listaFornecedores) {
			listar += fornecedor.toString() + " | ";
		}
		
		listar = listar.substring(0,listar.length()-3);
		
		return listar;
	}
	/**
	 * Edita os dados do fornecedor, alterando o atributo como parâmetro que será o valor alterado.
	 * @param nome nome do fornecedor
	 * @param atributo atributo para ser alterado
	 * @param novoValor novo Valor que será modificado.
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		ForlanUtil.verificaStringNull(atributo, "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(atributo, "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		ForlanUtil.verificaStringNull(novoValor, "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(novoValor, "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		ForlanUtil.verificaStringNull(nome, "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(nome, "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
		
		
		if (this.mapaFornecedores.containsKey(nome)) {
			
			if (atributo.equals("nome")) {
				throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
			}
			
			if (atributo.equals("email")){
				this.mapaFornecedores.get(nome).setEmail(novoValor);
			} else if (atributo.equals("telefone")){
				this.mapaFornecedores.get(nome).setTelefone(novoValor);
			} else {
				
				throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
			}
		} else {  
			
			throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
		}
		
	}
	/**
	 * Remove um fornecedor do mapa de fornecedores.
	 * @param nome nome do fornecedor, o qual é o identificador único do mapa.
	 */
	public void removeFornecedor(String nome) {
		
		ForlanUtil.verificaStringNull(nome, "Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(nome, "Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
		
		
		if (this.mapaFornecedores.containsKey(nome)) {
			this.mapaFornecedores.remove(nome);
		} 
		
		else {
		 
			throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
		}	
	
    }
	/**
	 *  Adiciona um determinado produto, se ele já não existir, naquele fornecedor. É um produto que aquele
	 *  fornecedor tem. O identificador único do Produto será o nome e a sua descriçao.
	 * @param fornecedor nome do fornecedor
	 * @param nome nome do produto
	 * @param descricao descricao do produto
	 * @param preco preco do produto
	 */
	public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		
		ForlanUtil.verificaStringNull(fornecedor, "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(fornecedor, "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		ForlanUtil.verificaStringNull(nome, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(nome, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		ForlanUtil.verificaStringNull(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		ForlanUtil.veririficaStringVazia(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		
		if (this.mapaFornecedores.containsKey(fornecedor)) {
			this.mapaFornecedores.get(fornecedor).adicionaProduto(nome, descricao, preco);
			
		
		}  else {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
		}
		
	}
	/**
	 * Exibe um determinado produto de um determinado fornecedor se existir.
	 * @param nome nome do produto
	 * @param descricao descricao do produto
	 * @param fornecedor nome do fornecedor
	 * @return representacao em string dos dados daquele produto, se ele existir naquele forneceodr.
	 */
	public String exibeProduto( String nome, String descricao, String fornecedor) {
		
		ForlanUtil.verificaStringNull(nome, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(nome, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		ForlanUtil.verificaStringNull(fornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(fornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		ForlanUtil.verificaStringNull(descricao, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		ForlanUtil.veririficaStringVazia(descricao, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		
		
		
		if (this.mapaFornecedores.containsKey(fornecedor)) {
			return this.mapaFornecedores.get(fornecedor).exibeProduto(nome, descricao);
			
		} else {
		throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}
		
		
	}
/**
 * 	método que exibe todos produtos de um determinado fornecedor.
 * @param fornecedor nome do fornecedor que é o ID do mapa.
 * @return uma representação em string da lisa de todos os produtos daquele determinado fornecedor.
 */
	public String exibeProdutosFornecedor(String fornecedor) {
		
		ForlanUtil.verificaStringNull(fornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(fornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		if(this.mapaFornecedores.containsKey(fornecedor)) {
			return this.mapaFornecedores.get(fornecedor).exibeProdutosFornecedor();
		} else {
			
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}
	}
/**
 * Exibe todos os produtos de todos os fornecedores cadastrados
 * @return representação em string dos produtos de todos os fornecedores.
 */
	public String exibeProdutos() {
		
		List<Fornecedor> listaFornecedores = new ArrayList();
		listaFornecedores.addAll(this.mapaFornecedores.values());
		Collections.sort(listaFornecedores);
		
		String listar = "";
		for (Fornecedor fornecedor: listaFornecedores) {
			
			listar += fornecedor.exibeProdutosFornecedor() + " | ";
		}
		
		listar =  listar.substring(0, listar.length()-3);
		
		return listar;
	}
	/**
	 * Método que remove um determinado produto de um dterminado fornecedor.
	 * @param nomeProduto nome do produto
	 * @param descricao descricao do produto
	 * @param fornecedor  nome do fornecedor
	 */
	public void removeProduto( String nomeProduto, String descricao, String fornecedor) {
		
		ForlanUtil.verificaStringNull(nomeProduto, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(nomeProduto, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		ForlanUtil.verificaStringNull(descricao, "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		ForlanUtil.veririficaStringVazia(descricao, "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		ForlanUtil.verificaStringNull(fornecedor, "Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(fornecedor, "Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		
		if (this.mapaFornecedores.containsKey(fornecedor)) {
			this.mapaFornecedores.get(fornecedor).removeProduto(nomeProduto, descricao);
		}
		else {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
		}
	}
	/**
	 * Edita o preco de um produto de um determinado fornecedor
	 * @param nomeProduto nome do produto
	 * @param descricao descricao do produto 
	 * @param fornecedor nome do fornecedor
	 * @param novoPreco novo preço daquele produto
	 */
	public void editaProduto( String nomeProduto, String descricao, String fornecedor,
			double novoPreco) {
		
		ForlanUtil.verificaStringNull(nomeProduto, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(nomeProduto, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		ForlanUtil.verificaStringNull(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		ForlanUtil.veririficaStringVazia(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		ForlanUtil.verificaStringNull(fornecedor, "Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(fornecedor, "Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		
		if(novoPreco < 0) {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		}
		else if(this.mapaFornecedores.containsKey(fornecedor)) {
			this.mapaFornecedores.get(fornecedor).editaProduto(nomeProduto, descricao, novoPreco);
		}
		else {
		throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
		}
		
	}
	/**
	 * Metodo que pega o mapa de fornecedores que será utilizado em outra classe
	 * @return um HashMap de fornecedores
	 */
	public HashMap<String, Fornecedor> getMapaFornecedores() {
		return mapaFornecedores;
	}
	/**
	 * Adiciona um combo nos produtos, um combo é a união de dois produtos simples. Um combo não pode ser feito por
	 * outro combo. Ele tem um fator que irá diminuir o preço final do combo.
	 * @param fornecedor nome do fornecedor
	 * @param nomeCombo nome do combo
	 * @param descricaoCombo descricao do combo
	 * 	 * @param fator  fator que é um valor menor que 1 e maior que 0, e que será o desconto do combo
	 * @param produtos string dos dois produtos que formarão  o combo
	 */
	public void adicionaCombo(String fornecedor, String nomeCombo, String descricaoCombo, double fator,
			String produtos) {
		
		ForlanUtil.verificaStringNull(nomeCombo, "Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(nomeCombo, "Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
		ForlanUtil.verificaStringNull(descricaoCombo, "Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
		ForlanUtil.veririficaStringVazia(descricaoCombo, "Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
		ForlanUtil.verificaStringNull(fornecedor, "Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(fornecedor, "Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
		ForlanUtil.verificaStringNull(produtos, "Erro no cadastro de combo: combo deve ter produtos.");
		ForlanUtil.veririficaStringVazia(produtos, "Erro no cadastro de combo: combo deve ter produtos.");
		
		if (!this.mapaFornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao existe.");
		}
		if ( fator <= 0 || fator >= 1) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");
		}
		
		this.mapaFornecedores.get(fornecedor).adicionaCombo(nomeCombo, descricaoCombo, fator, produtos);
		
		
	}
/**
 * Método que edita o fator do combo e  posteriori o seu preço.
 * @param nomeCombo noem do combo
 * @param descricaoCombo descricao do combo
 * @param fornecedor nome do fornecedor
 * @param novoFator novo fator que alterará o cálculo do preco do combo
 */
	public void editaCombo(String nomeCombo, String descricaoCombo, String fornecedor, double novoFator) {
		
		ForlanUtil.verificaStringNull(nomeCombo, "Erro na edicao de combo: nome nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(nomeCombo, "Erro na edicao de combo: nome nao pode ser vazio ou nulo.");
		ForlanUtil.verificaStringNull(descricaoCombo, "Erro na edicao de combo: descricao nao pode ser vazia ou nula.");
		ForlanUtil.veririficaStringVazia(descricaoCombo, "Erro na edicao de combo: descricao nao pode ser vazia ou nula.");
		ForlanUtil.verificaStringNull(fornecedor, "Erro na edicao de combo: fornecedor nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(fornecedor, "Erro na edicao de combo: fornecedor nao pode ser vazio ou nulo.");
		
		if (!this.mapaFornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de combo: fornecedor nao existe.");
		}
		
		if ( novoFator <= 0 || novoFator >= 1) {
			throw new IllegalArgumentException("Erro na edicao de combo: fator invalido.");
		}
		
		this.mapaFornecedores.get(fornecedor).editaCombo(nomeCombo, descricaoCombo, novoFator);
		
	}	
	
}