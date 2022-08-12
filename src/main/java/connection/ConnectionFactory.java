package connection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import testes.Leitor;

public class ConnectionFactory {
    
    /*PADRÃO*/
    private static final String DRIVER = "org.firebirdsql.jdbc.FBDriver";
    private static String URL       = "jdbc:firebirdsql://localhost/C:/U-Comecer/database/database.fdb?encoding=WIN1252";
    private static String USER    = "SYSDBA";
    private static String PASS    = "admin";
    
    
    public static Connection get(){
        try {
            Class.forName(DRIVER);
            
            //setDataConnection();
            return DriverManager.getConnection(URL, USER, PASS);
            
        } catch (ClassNotFoundException | SQLException ex) {
            //Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao conectar com o banco de dados, "+ex);
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados, "+ex);
            throw new RuntimeException(" Falha ao conectar com o banco de dados. Erro: ", ex);
        }
    }
    
    public static void close(Connection c){
            try {
                if(c != null){
                    c.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static void close(Connection c, PreparedStatement stmt){
           close(c);
            
            try {
                if(stmt != null){
                    stmt.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
    
    public static void close(Connection c, PreparedStatement stmt, ResultSet rs){
           close(c, stmt);
            
            try {
                if(rs != null){
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
    
    
//    private static void setDataConnection(){
//        Path path;
//        path = Paths.get("conexao.txt");
//        
//        
//        List<String> linhasArquivo = null;
//        try {
//            linhasArquivo = Files.readAllLines(path);
//        } catch (IOException ex) {
//            Logger.getLogger(Leitor.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, "Arquivo de conexão não encontrado na pasta raiz");
//        }
//        
//        URL  = "jdbc:mysql://"+linhasArquivo.get(0)+":3306/"+linhasArquivo.get(1);
//        System.out.println(URL);
//        USER = linhasArquivo.get(2);
//        System.out.println(USER);
//        PASS = (linhasArquivo.size() <= 3) ? "" : linhasArquivo.get(3);
//        System.out.println(PASS);
//        
//    }
    
}
