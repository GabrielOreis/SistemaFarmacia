package br.com.farmacia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.factory.ConexaoFactory;

public class FornecedoresDAO {

	public void salvar(Fornecedores f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fornecedores ");
		sql.append("(descricao) ");
		sql.append("VALUES (?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.executeUpdate();

	}

	public void excluir(Fornecedores f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fornecedores ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());
		comando.executeUpdate();
	}

	public void editar(Fornecedores f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fornecedores ");
		sql.append("SET descricao = ? ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.setLong(2, f.getCodigo());
		comando.executeUpdate();
	}

	public Fornecedores buscaPorCodigo(Fornecedores f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fornecedores ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1,f.getCodigo());

		ResultSet resut = comando.executeQuery();

		Fornecedores retorno =  new Fornecedores();

		if (resut.next()) {
			
			retorno.setCodigo(resut.getLong("codigo"));
			retorno.setDescricao(resut.getString("descricao"));
		}
		
		return retorno;

	}
	
	public ArrayList<Fornecedores>listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fornecedores ");
		sql.append("ORDER BY codigo ASC");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		ResultSet resut = comando.executeQuery();

		ArrayList<Fornecedores>lista = new ArrayList<Fornecedores>();

		while(resut.next()) {
			Fornecedores f = new Fornecedores();
			
			f.setCodigo(resut.getLong("codigo"));
			f.setDescricao(resut.getString("descricao"));			
			
			lista.add(f);
		}
		return lista;
	}
	
	public ArrayList<Fornecedores>buscarPorDescricao(Fornecedores f) throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fornecedores ");
		sql.append("WHERE descricao LIKE  ? ");
		sql.append("ORDER BY codigo ASC");
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, "%"+f.getDescricao()+"%");
		
		ResultSet resut = comando.executeQuery();

		ArrayList<Fornecedores>lista = new ArrayList<Fornecedores>();

		while(resut.next()) {
			Fornecedores item = new Fornecedores();
			
			item.setCodigo(resut.getLong("codigo"));
			item.setDescricao(resut.getString("descricao"));			
			
			lista.add(item);
		}
		return lista;
		
	}

	public static void main(String[] args) {
		/*
		  Fonecedores f1 = new Fonecedores(); f1.setDescricao("");
		 
		  Fonecedores f2 = new Fonecedores(); f2.setDescricao("Descriçaõ 3");
		  Fonecedores f3 = new Fonecedores(); f3.setDescricao("Descriçaõ 4");
		  Fonecedores f4 = new Fonecedores(); f4.setDescricao("Descriçaõ 5");
		  Fonecedores f5 = new Fonecedores(); f5.setDescricao("Descriçaõ 6");
		  Fonecedores f6 = new Fonecedores(); f6.setDescricao("Descriçaõ 7");
		  Fonecedores f7 = new Fonecedores(); f7.setDescricao("Descriçaõ 8");
		  Fonecedores f8 = new Fonecedores(); f8.setDescricao("Descriçaõ 9");
		  FornecedoresDAO fdao = new FornecedoresDAO();
		  
		  try { 
			  fdao.salvar(f1); fdao.salvar(f2);
			  fdao.salvar(f3);
			  fdao.salvar(f4);
			  fdao.salvar(f5);
			  fdao.salvar(f6);
			  fdao.salvar(f7);
			  fdao.salvar(f8);
			  
			  System.out.println("Salvo com sucesso "); 
		 } catch (SQLException e) {
	         e.printStackTrace();
		  System.out.println("erro ao salvar"); }
		 */

		/*
		 * Fonecedores f1 = new Fonecedores(); f1.setCodigo(2);
		 * 
		 * FornecedoresDAO fdao = new FornecedoresDAO();
		 * 
		 * try { fdao.excluir(f1);
		 * 
		 * System.out.println("Excluido com sucesso "); } catch (SQLException e) { //
		 * TODO Auto-generated catch block e.printStackTrace();
		 * System.out.println("erro ao salvar"); }
		 */

		/*
		 * Fonecedores f1 = new Fonecedores(); f1.setCodigo(1);
		 * f1.setDescricao("Gabriel Oliveira");
		 * 
		 * FornecedoresDAO fdao = new FornecedoresDAO();
		 * 
		 * try { fdao.editar(f1);
		 * 
		 * System.out.println("Edição com sucesso "); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace();
		 * System.out.println("erro !!!"); }
		 */

		/*Fonecedores f1 = new Fonecedores();
		f1.setCodigo(3);
		
		

		FornecedoresDAO fdao = new FornecedoresDAO();

		try {
			Fonecedores f11 =fdao.buscaPorCodigo(f1);
			

			System.out.println("Resultado "+ f11);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("erro !!!");
		}*/  
		

		/*FornecedoresDAO fdao = new FornecedoresDAO();

		try {
			ArrayList<Fonecedores> lista = fdao.listar();
			for(Fonecedores f :lista) {
				System.out.println("Resultado : "+ f);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("erro !!!");
		}*/
		
		/*Fonecedores f1 = new Fonecedores(); 
		f1.setDescricao("des");
		
		FornecedoresDAO fdao = new FornecedoresDAO();
		try {
			ArrayList<Fonecedores> lista = fdao.buscarPorDescricao(f1);
			for(Fonecedores f :lista) {
				System.out.println("Resultado : "+ f);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("erro !!!");
		}*/
	}
}
