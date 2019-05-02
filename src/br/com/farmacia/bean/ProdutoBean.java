package br.com.farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.farmacia.DAO.FornecedoresDAO;
import br.com.farmacia.DAO.ProdutoDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produto;
import br.com.farmacia.util.JSFUtil;

@ManagedBean(name = "MBProdutos")
@ViewScoped
public class ProdutoBean {
	private Produto produtos;

	public Produto getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto produtos) {
		this.produtos = produtos;
	}

	private ArrayList<Fornecedores> comboFornecedores;
	public ArrayList<Fornecedores> getComboFornecedores() {
		return comboFornecedores;
	}

	public void setComboFornecedores(ArrayList<Fornecedores> comboFornecedores) {
		this.comboFornecedores = comboFornecedores;
	}
    
	private ArrayList<Produto> itens;
	public ArrayList<Produto> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Produto> itens) {
		this.itens = itens;
	}

	public ArrayList<Produto> getItensFiltrados() {
		return itensFiltrados;
	}

	private ArrayList<Produto> itensFiltrados;
	public void setItensFiltrados(ArrayList<Produto> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {

		try {
			ProdutoDAO fdao = new ProdutoDAO();
			itens = fdao.listar();

		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			System.out.println("ERRO !!!!");
			e.printStackTrace();
		}
	}
	
	public void prepararNovo() {
		
		
		try {
			produtos = new Produto();		
		    FornecedoresDAO dao= new FornecedoresDAO();
			comboFornecedores = dao.listar();
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	
	public void novo() {

		try {
			ProdutoDAO pdao = new ProdutoDAO();
			pdao.salvar(produtos);

			itens = pdao.listar();
		

			JSFUtil.adicionarMensagemSucesso("Produto salvo com sucesso!");

		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			System.out.println("ERRO AO SALVAR !!!!");
			e.printStackTrace();
		}

	}
	public void excluir() {

		try {
			ProdutoDAO pdao = new ProdutoDAO();
			pdao.excluir(produtos);

		    itens = pdao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Produto excluido com sucesso!");

		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			System.out.println("ERRO AO SALVAR !!!!");
			e.printStackTrace();
		}
	}
	
	public void editar() {

		try {
			ProdutoDAO pdao = new ProdutoDAO();
			pdao.editar(produtos);

		    itens = pdao.listar();
			

			JSFUtil.adicionarMensagemSucesso("Produto editado com sucesso!");

		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			System.out.println("ERRO AO SALVAR !!!!");
			e.printStackTrace();
		}
	}
	
public void prepararEditar() {
		
		
		try {
			produtos = new Produto();		
		    FornecedoresDAO dao= new FornecedoresDAO();
			comboFornecedores = dao.listar();
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}

}
