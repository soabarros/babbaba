package br.com.fiap.jdbc.dao;

import br.com.fiap.jdbc.factory.ConnectionFactory;
import br.com.fiap.jdbc.model.Candidato;
import br.com.fiap.jdbc.model.Genero;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CandidatoDAO {

	// Método para inserir um novo candidato
	public void inserir(Candidato candidato) {
		String sql = "INSERT INTO candidato (tempoexperiencia, nome, telefone, emial, enderco, formacao, datanasc, idcandidato, idarea, genero) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, candidato.getTempoexperiencia());
			stmt.setString(2, candidato.getNome());
			stmt.setString(3, candidato.getTelefone());
			stmt.setString(4, candidato.getEmial());
			stmt.setString(5, candidato.getEnderco());
			stmt.setString(6, candidato.getFormacao());
			stmt.setDate(7, candidato.getDatanasc());
			stmt.setLong(8, candidato.getIdcandidato());
			stmt.setLong(9, candidato.getIdarea());
			stmt.setString(10, candidato.getGenero().toString());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Método para atualizar um candidato existente
	public void atualizar(Candidato candidato) {
		String sql = "UPDATE candidato SET tempoexperiencia = ?, nome = ?, telefone = ?, emial = ?, enderco = ?, formacao = ?, datanasc = ?, idarea = ?, genero = ? WHERE idcandidato = ?";
		try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, candidato.getTempoexperiencia());
			stmt.setString(2, candidato.getNome());
			stmt.setString(3, candidato.getTelefone());
			stmt.setString(4, candidato.getEmial());
			stmt.setString(5, candidato.getEnderco());
			stmt.setString(6, candidato.getFormacao());
			stmt.setDate(7, candidato.getDatanasc());
			stmt.setLong(8, candidato.getIdarea());
			stmt.setString(9, candidato.getGenero().toString());
			stmt.setLong(10, candidato.getIdcandidato());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Método para deletar um candidato pelo ID
	public void deletar(long idcandidato) {
		String sql = "DELETE FROM candidato WHERE idcandidato = ?";
		try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setLong(1, idcandidato);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Método para buscar um candidato pelo ID
	public Candidato buscarPorId(long idcandidato) {
		String sql = "SELECT * FROM candidato WHERE idcandidato = ?";
		Candidato candidato = null;
		try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setLong(1, idcandidato);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				candidato = new Candidato(rs.getInt("tempoexperiencia"), rs.getString("nome"), rs.getString("telefone"),
						rs.getString("emial"), rs.getString("enderco"), rs.getString("formacao"),
						rs.getDate("datanasc"), rs.getLong("idcandidato"), rs.getLong("idarea"),
						Genero.valueOf(rs.getString("genero")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return candidato;
	}

	// Método para listar todos os candidatos
	public List<Candidato> listarTodos() {
		String sql = "SELECT * FROM candidato";
		List<Candidato> candidatos = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Candidato candidato = new Candidato(rs.getInt("tempoexperiencia"), rs.getString("nome"),
						rs.getString("telefone"), rs.getString("emial"), rs.getString("enderco"),
						rs.getString("formacao"), rs.getDate("datanasc"), rs.getLong("idcandidato"),
						rs.getLong("idarea"), Genero.valueOf(rs.getString("genero")));
				candidatos.add(candidato);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return candidatos;
	}
}
