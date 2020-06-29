package saga;

public class ProdutoCombo implements Produto {
	
	private String nomeCombo;
	private String descricaoCombo;
	private double fator;
	private String produtos;
	private double preco1;
	private double preco2;
	

	public ProdutoCombo(String nomeCombo, String descricaoCombo, double fator, String produtos, double preco1,
			double preco2) {
		this.nomeCombo = nomeCombo;
		this.descricaoCombo = descricaoCombo;
		this.fator = fator;
		this.produtos = produtos;
		this.preco1 = preco1;
		this.preco2 = preco2;
		
		
	}


	@Override
	public int compareTo(Produto outroProduto) {
		
		return this.nomeCombo.compareTo(outroProduto.getNome());
	}


	@Override
	public double getPreco() {
		double desconto = (this.preco1 + this.preco2)*this.fator;
		
		return this.preco1 + this.preco2 - desconto;
	}


	@Override
	public void setPreco(double novoValor) {
		this.fator = novoValor;
		
	}
	

	public String getDescricaoCombo() {
		return descricaoCombo;
	}


	@Override
	public String getNome() {
	
		return this.nomeCombo;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s - R$%.2f", this.getNome(), this.getDescricaoCombo(), this.getPreco());
	
	}
}
