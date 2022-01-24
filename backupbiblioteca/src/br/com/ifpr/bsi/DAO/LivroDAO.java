
package br.com.ifpr.bsi.DAO;
import br.com.ifpr.bsi.DTO.LivroDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LivroDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<LivroDTO> lista = new ArrayList<>();
    
    public void Cadastrar_Livro(LivroDTO l) {
        String sql = "insert into Livro (DescricaoLivro,EditoraLivro,AutorLivro,EdicaoLivro,QtdeLivro) values(?,?,?,?,?)";
        conn = new conexaoDAO().getConexao();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,l.getDescricao_livro());
            pstm.setString(2,l.getAutor_livro());
            pstm.setString(3, l.getEditora_livro());
            pstm.setInt(4, l.getEdicao_livro());
            pstm.setInt(5, l.getQtde_livro());            
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"LivroDAO Cadastrar" + erro);
        }
    }
    public void Alterar_LivroDAO(LivroDTO l){
        String sql = "update livro set DescricaoLivro = ?, AutorLivro = ?, EditoraLivro = ?, EdicaoLivro = ?, QtdeLivro = ? where Id_livro = ?";
        conn = new conexaoDAO().getConexao();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,l.getDescricao_livro());
            pstm.setString(2,l.getAutor_livro());
            pstm.setString(3, l.getEditora_livro());
            pstm.setInt(4, l.getEdicao_livro());
            pstm.setInt(5, l.getQtde_livro());
            pstm.setInt(6,l.getId_livro());
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"AlterarLivroDAO" + erro);
        }        
    }
            
    public ArrayList<LivroDTO>Listar_livroDAO(){
            String sql = "select * from livro";
            conn = new conexaoDAO().getConexao();
            try {
                pstm = conn.prepareStatement(sql);
                rs = pstm.executeQuery();
                while(rs.next()){
                    LivroDTO l = new LivroDTO();
                    l.setId_livro(rs.getInt("Id_livro"));
                    l.setDescricao_livro(rs.getString("DescricaoLivro"));
                    l.setAutor_livro(rs.getString("AutorLivro"));
                    l.setEditora_livro(rs.getString("EditoraLivro"));
                    l.setEdicao_livro(rs.getInt("EdicaoLivro"));
                    l.setQtde_livro(rs.getInt("QtdeLivro"));
                    lista.add(l);
                    
                }
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null,"LivroDAO Listar" + erro);   
            }
            return lista;
        }
    public ArrayList<LivroDTO>Pesquisar_livroDAO(String id_codigo){
        String sql1 = "select * from livro where Id_livro=?";
        ArrayList<LivroDTO> lista = new ArrayList<LivroDTO>();        
        conn = new conexaoDAO().getConexao();
            try {
                pstm = conn.prepareStatement(sql1);
                pstm.setString(1,id_codigo);      
                rs = pstm.executeQuery();
                while(rs.next()){                                     
                    LivroDTO l = new LivroDTO();
                    l.setId_livro(rs.getInt("Id_livro"));
                    l.setDescricao_livro(rs.getString("DescricaoLivro"));
                    l.setAutor_livro(rs.getString("AutorLivro"));
                    l.setEditora_livro(rs.getString("EditoraLivro"));
                    l.setEdicao_livro(rs.getInt("EdicaoLivro"));
                    l.setQtde_livro(rs.getInt("QtdeLivro"));
                    lista.add(l);
                }
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null,"LivroDAO Pesquisar" + erro);   
            }
            return lista;        
    }  
}
