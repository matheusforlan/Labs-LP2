package saga;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ControllerContas {

	private ControllerClientes controllerClientes;
	private ControllerFornecedores controllerFornecedores;

	public ControllerContas(ControllerClientes controllerClientes, ControllerFornecedores controllerFornecedores) {
		this.controllerClientes = controllerClientes;
		this.controllerFornecedores = controllerFornecedores;

	}

	private void dataValida(String data) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate date = LocalDate.parse(data, formatter);
		} catch (DateTimeParseException e) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");
		}

	}

	public void adicionaCompra(String cpf, String fornecedor, String data, String nomeProduto, String descricao) {
		ForlanUtil.verificaStringNull(nomeProduto,
				"Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(nomeProduto,
				"Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		ForlanUtil.verificaStringNull(cpf, "Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(cpf, "Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");
		ForlanUtil.verificaStringNull(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		ForlanUtil.veririficaStringVazia(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		ForlanUtil.verificaStringNull(fornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(fornecedor,
				"Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		ForlanUtil.verificaStringNull(descricao,
				"Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
		ForlanUtil.veririficaStringVazia(descricao,
				"Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
		dataValida(data);

		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cpf invalido.");
		}

		if (this.controllerClientes.getMapaClientes().containsKey(cpf)) {
			if (this.controllerFornecedores.getMapaFornecedores().containsKey(fornecedor)) {
				Cliente cliente = this.controllerClientes.getCliente(cpf);

				this.controllerFornecedores.getMapaFornecedores().get(fornecedor).adicionaCompra(cliente, data,
						nomeProduto, descricao);
			} else {
				throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao existe.");
			}

		} else {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cliente nao existe.");
		}

	}

	public String getDebito(String cpf, String fornecedor) {

		ForlanUtil.verificaStringNull(fornecedor, "Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(fornecedor,
				"Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
		ForlanUtil.verificaStringNull(cpf, "Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(cpf, "Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");

		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cpf invalido.");
		}

		if (this.controllerFornecedores.getMapaFornecedores().containsKey(fornecedor)) {
			if (this.controllerClientes.getMapaClientes().containsKey(cpf)) {
				Cliente cliente = this.controllerClientes.getCliente(cpf);
				return this.controllerFornecedores.getMapaFornecedores().get(fornecedor).getDebito(cliente);
			} else {
				throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao existe.");
			}
		} else {
			throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao existe.");
		}

	}

	public String exibeContas(String cpf, String fornecedor) {

		ForlanUtil.verificaStringNull(fornecedor,
				"Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(fornecedor,
				"Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
		ForlanUtil.verificaStringNull(cpf, "Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(cpf, "Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");

		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cpf invalido.");
		}

		
		Cliente cliente = this.controllerClientes.getCliente(cpf);
		
		
		
		if (!this.controllerClientes.getMapaClientes().containsKey(cpf)) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao existe.");
		} else if (!this.controllerFornecedores.getMapaFornecedores().containsKey(fornecedor)) {
			
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: fornecedor nao existe.");	
		}
		else {
			return this.controllerFornecedores.getMapaFornecedores().get(fornecedor).exibeContas(cliente, fornecedor);
		}
		
		
	}

	public String exibeContasClientes(String cpf) { 
		
		ForlanUtil.verificaStringNull(cpf, "Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(cpf, "Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");

		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cpf invalido.");
		}
		
		if(!this.controllerClientes.getMapaClientes().containsKey(cpf)) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao existe.");
		}
		
		Cliente cliente = this.controllerClientes.getCliente(cpf);
		
		String contas = "Cliente: "+ cliente.getNome()+" | ";
		List<Fornecedor> listaFornecedores = new ArrayList();
		listaFornecedores.addAll(this.controllerFornecedores.getMapaFornecedores().values());
		Collections.sort(listaFornecedores);
		
		for(Fornecedor fornecedor: listaFornecedores) {
			if(fornecedor.exibeContasClientes(cliente) != null) {
				contas += fornecedor.exibeContasClientes(cliente)
						+ " | ";
			}
		}
		
		if (contas.equals("Cliente: "+ cliente.getNome()+" | ")) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao tem nenhuma conta.");
		}
		return contas.substring(0, contas.length()-3);

	}

	public void realizaPagamento(String cpf, String fornecedor) {
		
		ForlanUtil.verificaStringNull(cpf, "Erro no pagamento de conta: cpf nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(cpf, "Erro no pagamento de conta: cpf nao pode ser vazio ou nulo.");
		ForlanUtil.verificaStringNull(fornecedor, "Erro no pagamento de conta: fornecedor nao pode ser vazio ou nulo.");
		ForlanUtil.veririficaStringVazia(fornecedor, "Erro no pagamento de conta: fornecedor nao pode ser vazio ou nulo.");
		
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro no pagamento de conta: cpf invalido.");
		}
		
		if(!this.controllerClientes.getMapaClientes().containsKey(cpf)) {
			throw new IllegalArgumentException("Erro no pagamento de conta: cliente nao existe.");
		}
		if (!(this.controllerFornecedores.getMapaFornecedores().containsKey(fornecedor))) {
			throw new IllegalArgumentException("Erro no pagamento de conta: fornecedor nao existe.");
		}
		
		Cliente cliente = this.controllerClientes.getCliente(cpf);
		this.controllerFornecedores.getMapaFornecedores().get(fornecedor).realizaPagamento(cliente);
		
	}
}
