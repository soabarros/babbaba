package br.com.fiap.jdbc.dao;


	import br.com.fiap.jdbc.factory.ConnectionFactory;
	import br.com.fiap.jdbc.model.AreaAtuacao;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

	public class AreaAtuacaoDAO {

	    // Método para inserir uma nova área de atuação
	    public void inserir(AreaAtuacao area) {
	        String sql = "INSERT INTO area_atuacao (nome) VALUES (?)";
	        try (Connection conn = ConnectionFactory.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setString(1, area.getNome());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Método para atualizar uma área de atuação existente
	    public void atualizar(AreaAtuacao area) {
	        String sql = "UPDATE area_atuacao SET nome = ? WHERE idarea = ?";
	        try (Connection conn = ConnectionFactory.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setString(1, area.getNome());
	            stmt.setInt(2, area.getIdarea());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Método para deletar uma área de atuação pelo ID
	    public void deletar(int idarea) {
	        String sql = "DELETE FROM area_atuacao WHERE idarea = ?";
	        try (Connection conn = ConnectionFactory.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setInt(1, idarea);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Método para buscar uma área de atuação pelo ID
	    public AreaAtuacao buscarPorId(int idarea) {
	        String sql = "SELECT * FROM area_atuacao WHERE idarea = ?";
	        AreaAtuacao area = null;
	        try (Connection conn = ConnectionFactory.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setInt(1, idarea);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                area = new AreaAtuacao(rs.getInt("idarea"), rs.getString("nome"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return area;
	    }

	    // Método para listar todas as áreas de atuação
	    public List<AreaAtuacao> listarTodas() {
	        String sql = "SELECT * FROM area_atuacao";
	        List<AreaAtuacao> areas = new ArrayList<>();
	        try (Connection conn = ConnectionFactory.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                AreaAtuacao area = new AreaAtuacao(rs.getInt("idarea"), rs.getString("nome"));
	                areas.add(area);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return areas;
	    }
	}

