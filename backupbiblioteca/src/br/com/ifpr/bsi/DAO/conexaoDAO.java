/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpr.bsi.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author dougr
 */
public class conexaoDAO {
     public  Connection getConexao() {
         Connection conn = null;
         try {
             String url = "jdbc:mysql://localhost:3306/bd_biblioteca?useTimezone=true&serverTimezone=UTC";
             String username = "root";
             String password = "root";
             conn = DriverManager.getConnection(url,username,password);
          
         } catch (SQLException erro) {
             JOptionPane.showMessageDialog(null, "ConexaoDAO" + erro.getMessage());
         }
         return conn;
    }
     /*  public static void main(String[] args) {
        try{
           getConexao();
           System.out.println("Conexao realizada com sucesso.");
        }catch (SQLException e){
            System.out.println("Conexao nao realizada, verificar log.");
            e.printStackTrace();
        }    
    }
*/
}
