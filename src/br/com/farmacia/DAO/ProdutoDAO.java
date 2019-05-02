package br.com.farmacia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produto;
import br.com.farmacia.factory.ConexaoFactory;

public class ProdutoDAO {
	public void salvar(Produto p) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO produtos ");
		sql.append("(descricao,quantidade,preco,fornecedores_codigo) ");
		sql.append("VALUES (?,?,?,?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, p.getDescricao());
		comando.setLong(2, p.getQuantidade());
		comando.setDouble(3, p.getPreco());
		comando.setLong(4, p.getFornecedores().getCodigo());
		comando.executeUpdate();

	}

	public ArrayList<Produto> listar() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p.codigo ,p.descricao,p.quantidade,p.preco,f.codigo,f.descricao ");
		sql.append("FROM produtos p ");
		sql.append("INNER JOIN fornecedores f ON f.codigo = p.fornecedores_codigo");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resut = comando.executeQuery();

		ArrayList<Produto> lista = new ArrayList<Produto>();

		while (resut.next()) {
			Fornecedores f = new Fornecedores();
			f.setCodigo(resut.getLong("f.codigo"));
			f.setDescricao(resut.getString("f.descricao"));

			Produto pro = new Produto();
			pro.setCodigo(resut.getLong("p.codigo"));
			pro.setDescricao(resut.getString("p.descricao"));
			pro.setQuantidade(resut.getLong("p.quantidade"));
			pro.setPreco(resut.getDouble("p.preco"));
			pro.setFornecedores(f);

			lista.add(pro);
		}
		return lista;

	}

	public void excluir(Produto p) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM produtos ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, p.getCodigo());
		comando.executeUpdate();
	}

	public void editar(Produto p) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE produtos ");
		sql.append("SET descricao = ?, quantidade = ?, preco = ?, fornecedores_codigo = ? ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, p.getDescricao());
		comando.setLong(2, p.getQuantidade());
		comando.setDouble(3, p.getPreco());
		comando.setLong(4, p.getFornecedores().getCodigo());
		comando.setLong(5, p.getCodigo());
		
		comando.executeUpdate();
	}
}
