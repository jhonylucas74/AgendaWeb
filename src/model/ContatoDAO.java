package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;

public class ContatoDAO {

	private Connection connection;

	public ContatoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public Contato getContato(Long id) {

		try {

			Contato obj = new Contato();

			Statement stmt = null;
			stmt = connection.createStatement();
			ResultSet rs;

			rs = stmt.executeQuery("SELECT* FROM contatos WHERE" + " id = '"
					+ id + "' ;");

			while (rs.next()) {
				obj.setId(rs.getLong("id"));
				obj.setNome(rs.getString("nome"));
				obj.setEmail(rs.getString("email"));
				obj.setEndereco(rs.getString("endereco"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				obj.setDataNascimento(data);

			}

			rs.close();
			stmt.close();

			return obj;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Contato> getLista() {

		try {

			Statement stmt = null;
			List<Contato> contatos = new ArrayList<Contato>();

			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM contatos;");

			while (rs.next()) {
				Contato obj = new Contato();

				obj.setId(rs.getLong("id"));
				obj.setNome(rs.getString("nome"));
				obj.setEmail(rs.getString("email"));
				obj.setEndereco(rs.getString("endereco"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				obj.setDataNascimento(data);

				contatos.add(obj);
			}

			rs.close();
			stmt.close();

			return contatos;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void adiciona(Contato contato) {
		String sql = "insert into contatos "
				+ "(nome,email,endereco,dataNascimento)" + " values (?,?,?,?)";
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato
					.getDataNascimento().getTimeInMillis()));

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Contato contato) {
		String sql = "update contatos set nome=?, email=?, endereco=?,"
				+ "dataNascimento=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, (java.sql.Date) new Date(contato
					.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Contato contato) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete"
					+ "from contatos where id=?");
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
