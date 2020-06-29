package saga;

public class Compra {
	
	private String data;
	private double preco;
	private String nomeProduto;
	private String descricao;
	
	
	public Compra( String data, String nomeProduto, String descricao, double preco) {
	
		this.data = data;
		this.preco = preco;
		this.nomeProduto = nomeProduto;
		this.descricao = descricao;
	}


	public double getPreco() {
		return preco;
	}


	@Override
	public String toString() {
		return this.nomeProduto + " - " + this.data;
	}
	

	
	

	

}
