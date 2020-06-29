package saga;

public class ProdutoID {
	
	private String nomeProduto;
	private String descricao;
	
	public ProdutoID(String nomeProduto, String descricao) {
		
		this.nomeProduto = nomeProduto;
		this.descricao = descricao;
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
		ProdutoID other = (ProdutoID) obj;
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

	public String getNomeProduto() { 
		return nomeProduto;
	}

	public String getDescricao() {
		return descricao;
	}
	

	
}
