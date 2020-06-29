package saga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Fornecedor implements Comparable<Fornecedor>{
	private String nome;
	private String email;
	private String telefone;
	private Map <ProdutoID, Produto> mapaProdutos;
	private Map <Cliente, Conta > mapaContas;
	
	
	Fornecedor(String nome, String email, String telefone){
		
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.mapaProdutos = new HashMap< ProdutoID, Produto> ();
		this.mapaContas = new HashMap <Cliente, Conta>();
		
	}

	@Override
	public String toString() {
		return this.getNome() + " - " + this.getEmail() + " - " + this.getTelefone();
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void adicionaProduto(String nomeProduto, String descricao, double preco) {
		
		if(preco < 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}
		
		if (existeProduto(nomeProduto, descricao)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		} else {
			
			ProdutoSimples produtoSimples = new ProdutoSimples(nomeProduto, descricao, preco);
			ProdutoID produtoID = new ProdutoID(nomeProduto, descricao);
			this.mapaProdutos.put(produtoID, produtoSimples);
		}
		
		
	}
	
	public boolean existeProduto(String nomeProduto, String descricao) {
		
		ProdutoID produtoID = new ProdutoID(nomeProduto, descricao);
		if ( this.mapaProdutos.containsKey(produtoID)) {
			return true;
		}
		
		return false;
	}
	
	public Produto pegaProduto(String nomeProduto, String descricao) {
		
		ProdutoID produtoID = new ProdutoID(nomeProduto, descricao);
		return this.mapaProdutos.get(produtoID);
		
	}

	public String exibeProduto(String nomeProduto, String descricao) {
		
		if(existeProduto(nomeProduto, descricao)) {
			return pegaProduto(nomeProduto, descricao).toString();
			
		}
		
		throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
		
	}

	public String exibeProdutosFornecedor() {
		String listar = "";
		
		List <Produto > listaProdutos= new ArrayList();
		listaProdutos.addAll(this.mapaProdutos.values());
		
		if (listaProdutos.size() != 0) {
			Collections.sort(listaProdutos);
			
			for (Produto produto: listaProdutos) {
				listar+= this.nome + " - " + produto.toString() + " | ";
			}
			
			
			listar = listar.substring(0, listar.length()-3);
			
			return listar;
		}
		else {
			return this.nome + " -";
		}
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void removeProduto(String nomeProduto, String descricao) {
		
		if(existeProduto(nomeProduto, descricao)) {
			ProdutoID produtoID = new ProdutoID(nomeProduto, descricao);
			this.mapaProdutos.remove(produtoID);
			
		} else {
		
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");	
		}
	}
	

	public void editaProduto(String nomeProduto, String descricao, double novoPreco) {
		
		if(existeProduto(nomeProduto, descricao)) {
			pegaProduto(nomeProduto, descricao).setPreco(novoPreco);
			
		} else {
		
			throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
		}
	}

	public Map<ProdutoID, Produto> getMapaProdutos() {
		return mapaProdutos;
	}

	@Override
	public int compareTo(Fornecedor outroFornecedor) {
	
		return this.nome.compareTo(outroFornecedor.getNome());
	}

	public void adicionaCompra(Cliente cliente, String data, String nomeProduto, String descricao) {
		
		if(existeProduto(nomeProduto, descricao)) {
			ProdutoID produtoID = new ProdutoID(nomeProduto, descricao);
			double preco = this.mapaProdutos.get(produtoID).getPreco();
		
			if(this.mapaContas.containsKey(cliente)) {
				this.mapaContas.get(cliente).adicionaCompra(data,nomeProduto, descricao, preco);
				
			} else {
				Conta conta = new Conta();
				conta.adicionaCompra(data, nomeProduto, descricao, preco);
				this.mapaContas.put(cliente, conta);
			}
		} else {
			throw new IllegalArgumentException("Erro ao cadastrar compra: produto nao existe.");
		}
		
		
	}

	public String getDebito(Cliente cliente) {
		
		if (this.mapaContas.containsKey(cliente)) {
			return this.mapaContas.get(cliente).getDebito();
		}
		 throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
	}

	public String exibeContas(Cliente cliente, String fornecedor) {
		
		if(this.mapaContas.containsKey(cliente)) {
			return "Cliente: "+ cliente.getNome()+ " | " + this.mapaContas.get(cliente).exibeContas( this.getNome());
		} else {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");
		}
		
		
	}

	public String exibeContasClientes(Cliente cliente) {
		
		if(this.mapaContas.containsKey(cliente)) {
			return this.mapaContas.get(cliente).exibeContas(this.getNome());
		}
		
		return null;
	}

	public void adicionaCombo(String nomeCombo, String descricaoCombo, double fator, String produtos) {
		
		
		
		String[] produtosSeparados = produtos.split(", ");
		String[] nomeDescricao1 = produtosSeparados[0].split(" - ");
		String[] nomeDescricao2 = produtosSeparados[1].split(" - ");
		
		if(!(existeProduto(nomeDescricao1[0], nomeDescricao1[1]) || existeProduto(nomeDescricao2[0],nomeDescricao2[1]))) {
			throw new IllegalArgumentException("Erro no cadastro de combo: produto nao existe.");
		}
		Produto produto1 = pegaProduto(nomeDescricao1[0],nomeDescricao1[1]);
		Produto produto2 = pegaProduto(nomeDescricao2[0], nomeDescricao2[1]);
		
		 if (produto1 instanceof ProdutoCombo || produto2 instanceof ProdutoCombo) {
			throw new IllegalArgumentException("Erro no cadastro de combo: um combo nao pode possuir combos na lista de produtos.");
		 }
		 
		 if (this.mapaProdutos.containsKey(new ProdutoID(nomeCombo,descricaoCombo))){
			 
			 throw new IllegalArgumentException("Erro no cadastro de combo: combo ja existe.");
			 
		 }
		ProdutoCombo produtoCombo = new ProdutoCombo(nomeCombo, descricaoCombo, fator, produtos, produto1.getPreco()
				, produto2.getPreco());
		
		ProdutoID produtoID = new ProdutoID(nomeCombo, descricaoCombo);
		
		this.mapaProdutos.put(produtoID, produtoCombo);
		
		
	}

	public void editaCombo(String nomeCombo, String descricaoCombo, double novoFator) {
		
		if(existeProduto(nomeCombo, descricaoCombo)) {
			pegaProduto(nomeCombo, descricaoCombo).setPreco(novoFator);
		} else {
			throw new IllegalArgumentException("Erro na edicao de combo: produto nao existe.");
		}
		
	}

	public void realizaPagamento(Cliente cliente) {
		
		if (this.mapaContas.containsKey(cliente)) {
			this.mapaContas.remove(cliente);
		}
		else {
			throw new IllegalArgumentException("Erro no pagamento de conta: nao ha debito do cliente associado a este fornecedor.");
		}
		
	}

	
}