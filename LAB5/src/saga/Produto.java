package saga;

public interface Produto extends Comparable <Produto>{
	
	double getPreco();
	
	void setPreco(double novoValor);
	
	String getNome();
}
