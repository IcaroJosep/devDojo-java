
// ProducerService.java
package service;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProducerService {
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/anime_store";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "icaro";
    
    public void producerServicesUpdate(int id, String newName) {
        CachedRowSet cachedRowSet = null;
        Connection connection = null;
        
        try {
            // Criar conexão manual para controlar o autocommit
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            connection.setAutoCommit(false); // Desabilitar autocommit
            
            // Criar o CachedRowSet
            RowSetFactory factory = RowSetProvider.newFactory();
            cachedRowSet = factory.createCachedRowSet();
            
            // Configurar conexão
            cachedRowSet.setUrl(DB_URL);
            cachedRowSet.setUsername(DB_USER);
            cachedRowSet.setPassword(DB_PASSWORD);
            
            // Definir a query para buscar o producer por ID
            cachedRowSet.setCommand("SELECT id, name FROM producer WHERE id = ?");
            cachedRowSet.setInt(1, id);
            
            // Executar a query e popular o CachedRowSet
            cachedRowSet.execute();
            
            // Verificar se o producer existe
            if (cachedRowSet.next()) {
                System.out.println("Producer encontrado: ID=" + cachedRowSet.getInt("id") + 
                                 ", Nome atual=" + cachedRowSet.getString("name"));
                
                // Atualizar o nome
                cachedRowSet.updateString("name", newName);
                cachedRowSet.updateRow();
                
                System.out.println("Nome atualizado para: " + newName);
                
                // Sincronizar as mudanças com o banco de dados usando a conexão manual
                cachedRowSet.acceptChanges(connection);
                
                System.out.println("Atualização salva no banco de dados com sucesso!");
                
            } else {
                System.out.println("Producer com ID " + id + " não encontrado!");
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar producer: " + e.getMessage());
            e.printStackTrace();
            
            // Fazer rollback em caso de erro
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    System.err.println("Erro ao fazer rollback: " + rollbackEx.getMessage());
                }
            }
        } finally {
            // Fechar recursos
            if (cachedRowSet != null) {
                try {
                    cachedRowSet.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar CachedRowSet: " + e.getMessage());
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        }
    }
    
    // Método auxiliar para listar todos os producers
    public void listAllProducers() {
        CachedRowSet cachedRowSet = null;
        
        try {
            RowSetFactory factory = RowSetProvider.newFactory();
            cachedRowSet = factory.createCachedRowSet();
            
            cachedRowSet.setUrl(DB_URL);
            cachedRowSet.setUsername(DB_USER);
            cachedRowSet.setPassword(DB_PASSWORD);
            
            cachedRowSet.setCommand("SELECT id, name FROM producer ORDER BY id");
            cachedRowSet.execute();
            
            System.out.println("=== Lista de Producers ===");
            while (cachedRowSet.next()) {
                System.out.println("ID: " + cachedRowSet.getInt("id") + 
                                 ", Nome: " + cachedRowSet.getString("name"));
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao listar producers: " + e.getMessage());
        } finally {
            if (cachedRowSet != null) {
                try {
                    cachedRowSet.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar CachedRowSet: " + e.getMessage());
                }
            }
        }
    }
}