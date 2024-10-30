package controllers;

import config.DatabaseConnection;
import controllers.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioController {
    private Connection conn;
    
    public void criarTabela() {
        String sql = "create table if not exists usuarios ("
                   + "id integer primary key autoincrement,"
                   + "nome text not null,"
                   + "email text not null unique,"
                   + "senha text not null"
                   + ");";
    }
    
    public void adicionarUsuario(String nome, String email, String senha){
        String sql = "insert into usuarios (nome, email, senha) values (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, nome);
            pstmt.setString(2, email);
            pstmt.setString(3, senha);
            pstmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public List<String> listarUsuarios(){
        List<String> usuarios = new ArrayList<>();
        String sql = "select * from usuarios";
        try(Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                String usuario = "ID: " + rs.getInt("id") + ", Nome: " + rs.getString("nome") + ", Email: " + rs.getString("email");
                usuarios.add(usuario);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return usuarios;
    }
    
    public void registrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Usuario buscarUsuarioPorId(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        Usuario usuario = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                usuario = new Usuario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha")
                );
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return usuario;
    }

    public void atualizarUsuario(Usuario usuario){
        String sql = "UPDATE usuarios SET nome = ?, email = ?, senha = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setInt(4, usuario.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarUsuario(int id){
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (var connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean autenticarUsuario(String email, String senha){
        return false;
    }
}
