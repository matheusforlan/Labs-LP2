package saga;

import java.util.ArrayList;
import java.util.List;

public class Conta {
	
	private ArrayList<Compra> listaCompras;
	
	
	public Conta() {
		
		this.listaCompras = new ArrayList<Compra>();		
	}

	public void adicionaCompra(String data, String nomeProduto, String descricao, double preco) {
		Compra compra = new Compra(data, nomeProduto, descricao, preco);
		this.listaCompras.add(compra);
	
	}

	public String getDebito() {
		double debito = 0;
		for(Compra compra: this.listaCompras) {
			debito += compra.getPreco();
		}
		
		String stringDebito = String.format("%.2f", debito);
		
		return stringDebito.replace(",", ".");
	}

	public String exibeContas( String nomeFornecedor) {
	
	String conta = String.format("%s | ", nomeFornecedor);
	
	for (Compra compra: this.listaCompras) {
		
		conta += compra.toString() + " | ";
	}
	
	
		conta = conta.substring(0, conta.length()-3);
		return conta.replace("/", "-");
	}
	
}
