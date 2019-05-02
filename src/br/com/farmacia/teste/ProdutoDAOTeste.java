package br.com.farmacia.teste;


import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;
import br.com.farmacia.DAO.ProdutoDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produto;



   public class ProdutoDAOTeste {
	   
	   @Test
	   @Ignore
	   public void salvar()throws SQLException {
		   Produto p = new Produto();
		   p.setDescricao("Remédio A");
		   p.setPreco(99.99);
		   p.setQuantidade(99L);
	 
		   Fornecedores f = new Fornecedores();
		   f.setCodigo(1L);
		   p.setFornecedores(f);
	 
		   ProdutoDAO pdao= new ProdutoDAO();
	
		   pdao.salvar(p);
	 
	}
	
	   @Test
	   //@Ignore
	   public void 	listar()throws SQLException {
		   ProdutoDAO pdao= new ProdutoDAO();
		   ArrayList<Produto> list = pdao.listar();
		   
		   for(Produto p : list) {
			   System.out.println("Código do Produto: " + p.getCodigo());
			   System.out.println("Descrição do Produto: "+ p.getDescricao());
			   System.out.println("Valor do Produto: " + p.getPreco());
			   System.out.println("Quantidade: " + p.getQuantidade());
			   System.out.println("Codigo do Fornecedor: " + p.getFornecedores().getCodigo());
			   System.out.println("Descrição do Fornecedor: " + p.getFornecedores().getDescricao());
			   System.out.println("");
		   }
	   }
	   
	   @Test
	   @Ignore
	   public void 	excluir()throws SQLException {
		   Produto p = new Produto();
		   p.setCodigo(1L);
		   
		   ProdutoDAO pdao= new ProdutoDAO();
		   pdao.excluir(p);
		   
	   }
	   
	   @Test
	   @Ignore
	   public void 	editar()throws SQLException {
		   Produto p = new Produto();
		   p.setCodigo(3L);
		   p.setDescricao("Remédio B");
		   p.setPreco(155.99);
		   p.setQuantidade(7L);
	 
		   Fornecedores f = new Fornecedores();
		   f.setCodigo(7L);
		   p.setFornecedores(f);
		   
		   ProdutoDAO pdao= new ProdutoDAO();
		   pdao.editar(p);
	   }
}
