package saga;

public class ProdutoSimples implements Produto{

	private String nomeProduto;
	private String descricao;
	private double preco;
	private ProdutoID produtoID;
	
	public ProdutoSimples (String nomeProduto, String descricao, double preco) {
		
		this.nomeProduto = nomeProduto;
		this.descricao = descricao;
		this.preco = preco;
				
	}

	@Override
	public String toString() {
		return String.format("%s - %s - R$%.2f", this.getNome(), this.getDescricao(), this.getPreco());
	
	}
	@Override
	public String getNome() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public double getPreco() {
		return preco;
	}
	@Override
	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nomeProduto == null) ? 0 : nomeProduto.hashCode());
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
		ProdutoSimples other = (ProdutoSimples) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nomeProduto == null) {
			if (other.nomeProduto != null)
				return false;
		} else if (!nomeProduto.equals(other.nomeProduto))
			return false;
		return true;
	}

	@Override
	public int compareTo(Produto outroProduto) {
		
		return this.nomeProduto.compareTo(outroProduto.getNome());
	}
		
}
