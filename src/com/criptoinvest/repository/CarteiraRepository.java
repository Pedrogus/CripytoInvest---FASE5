package com.criptoinvest.repository;

import com.criptoinvest.models.Carteira;
import com.criptoinvest.models.Usuario;
import com.criptoinvest.persistence.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarteiraRepository implements CarteiraRepositoryInterface {
    private List<Carteira> carteiras = new ArrayList<>();

    @Override
    public Optional<Carteira> buscarPorId(Long id) {
        return carteiras.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Carteira> buscarPorUsuario(Long usuarioId) {
        List<Carteira> resultado = new ArrayList<>();
        String sql = "SELECT id, usuario_id, saldo FROM carteira WHERE usuario_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, usuarioId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                long carteiraId = rs.getLong("id");
                double saldo = rs.getDouble("saldo");

                // Aqui você pode criar o objeto Usuario ou buscar via serviço
                Usuario usuario = new Usuario();
                usuario.setId(usuarioId);

                Carteira carteira = new Carteira(carteiraId, usuario, saldo);
                resultado.add(carteira);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultado;
    }


    @Override
    public Carteira salvar(Carteira carteira) {
       String sql = "INSERT INTO carteira (usuario_id, saldo) VALUES (?, ?)";
       try(Connection conn = DatabaseConnection.getConnection();
           PreparedStatement stmt = conn.prepareStatement(sql, new String[]{"id"}))
       {
           stmt.setLong(1, carteira.getUsuario().getId());
           stmt.setDouble(2, carteira.getSaldo());

           stmt.executeUpdate();

           ResultSet rs = stmt.getGeneratedKeys();
           if(rs.next()) {
               carteira.setId(rs.getLong(1));
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return carteira;
    }

    public void adicionarCarteira(Carteira carteira) {
        carteiras.add(carteira);
    }
}
