package saga;

import easyaccept.EasyAccept;

public class FacadeSaga {
	
	private ControllerClientes controllerClientes;
	private ControllerFornecedores controllerFornecedores;
	private ControllerContas controllerContas;
	
	public FacadeSaga(){
		
		this.controllerClientes = new ControllerClientes();
		this.controllerFornecedores = new ControllerFornecedores(); 
		this.controllerContas = new ControllerContas(this.controllerClientes, this.controllerFornecedores);
		
	}
		
	public String  adicionaCliente( String  cpf, String  nome, String  local,String email) {
			
			return this.controllerClientes.cadastrarCliente(cpf, nome, local, email);
			
		}
	
	public String exibeCliente (String cpf) {
		
		return this.controllerClientes.exibeCliente(cpf);
		
	}
	
	public String exibeClientes() {
		
		return this.controllerClientes.exibeClientes();
		
	}
	
	public void editaCliente(String cpf, String atributo, String novoValor) {
		
		this.controllerClientes.editaCliente(cpf, atributo, novoValor);
		
	}
	
	public void removeCliente(String cpf) { 
		
		this.controllerClientes.removeCliente(cpf);  
		
	}
	/**
	 * 
	 *  ######################## FIM DO US1 ##########################
	 */
	
	public String adicionaFornecedor( String nome, String email, String telefone ) {
		
		return this.controllerFornecedores.adicionaFornecedor(nome, email, telefone);
	}
	
	public String exibeFornecedor(String nome) {
		
		return this.controllerFornecedores.exibeFornecedor(nome);
		
	}
	
	public String exibeFornecedores() {
		
		return this.controllerFornecedores.exibeFornecedores();
		
	}
	
	public void editaFornecedor ( String nome, String valorAtual, String novoValor) {
		
		 this.controllerFornecedores.editaFornecedor(nome, valorAtual,novoValor);
		
	}
	
	public void removeFornecedor( String nome) {
		
		 this.controllerFornecedores.removeFornecedor(nome);
	
	}
	
	/** ######################### FIM DO US2 ################## /**
	 * 
	 */
	public void adicionaProduto( String fornecedor, String nome, String descricao, double preco) {
		
		this.controllerFornecedores.adicionaProduto(fornecedor, nome, descricao, preco);
		
	}
	
	public  String exibeProduto( String nome, String nomeProduto, String descricao) {
		
		return this.controllerFornecedores.exibeProduto(nome, nomeProduto, descricao);
	}
	
	public String exibeProdutosFornecedor(String nome) {
		return this.controllerFornecedores.exibeProdutosFornecedor(nome);
	}
	
	
	public String exibeProdutos() {
		
		return this.controllerFornecedores.exibeProdutos();
	}
	
	public void removeProduto(String nomeProduto, String descricao, String fornecedor) {
		this.controllerFornecedores.removeProduto( nomeProduto, descricao, fornecedor);
	}
	
	public void editaProduto ( String nomeProduto, String descricao, String fornecedor,
			double novoPreco) {
		
		this.controllerFornecedores.editaProduto( nomeProduto, descricao, fornecedor, novoPreco);
		
	}
	
	public void adicionaCompra(String cpf, String fornecedor, String data, String nomeProduto, String descricao) {
		this.controllerContas.adicionaCompra(cpf,fornecedor,data,nomeProduto, descricao);
	}
	
	public String getDebito(String cpf, String fornecedor) {
		return this.controllerContas.getDebito(cpf,fornecedor);
	}
	
	public String exibeContas(String cpf, String fornecedor) {
		
		return this.controllerContas.exibeContas(cpf,fornecedor);
	}
	
	public String exibeContasClientes(String cpf) {
		
		return this.controllerContas.exibeContasClientes(cpf);
	}
	
	public void adicionaCombo(String fornecedor, String nomeCombo, String descricaoCombo, double fator,
			String produtos) {
		
		this.controllerFornecedores.adicionaCombo(fornecedor,nomeCombo, descricaoCombo, fator, produtos);
		
	}
	
	public void editaCombo(String nomeCombo, String descricaoCombo, String fornecedor, double novoFator) {
		this.controllerFornecedores.editaCombo(nomeCombo, descricaoCombo, fornecedor, novoFator);
	}
	
	public void realizaPagamento (String cpf, String fornecedor) {
		this.controllerContas.realizaPagamento(cpf,fornecedor);
	}
	
	public static void main (String[] args) {
		
		args = new String[] {"saga.FacadeSaga", "testesAceitacao/use_case_1.txt","testesAceitacao/use_case_2.txt"
				,"testesAceitacao/use_case_3.txt", "testesAceitacao/use_case_4.txt", "testesAceitacao/use_case_5.txt",
				"testesAceitacao/use_case_6.txt", "testesAceitacao/use_case_7.txt","testesAceitacao/use_case_8.txt"};
		EasyAccept.main(args);
	}

}
