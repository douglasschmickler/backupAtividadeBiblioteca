
package br.com.ifpr.bsi.DTO;

public class LivroDTO {
    private int id_livro;
    private String descricao_livro;
    private String editora_livro;
    private String autor_livro;
    private int edicao_livro;
    private int qtde_livro;

    public String getDescricao_livro() {
        return descricao_livro;
    }

    public void setDescricao_livro(String descricao_livro) {
        this.descricao_livro = descricao_livro;
    }

    public String getEditora_livro() {
        return editora_livro;
    }

    public void setEditora_livro(String editora_livro) {
        this.editora_livro = editora_livro;
    }

    public String getAutor_livro() {
        return autor_livro;
    }

    public void setAutor_livro(String autor_livro) {
        this.autor_livro = autor_livro;
    }

    public int getEdicao_livro() {
        return edicao_livro;
    }

    public void setEdicao_livro(int edicao_livro) {
        this.edicao_livro = edicao_livro;
    }

    public int getQtde_livro() {
        return qtde_livro;
    }

    public void setQtde_livro(int qtde_livro) {
        this.qtde_livro = qtde_livro;
    }

    public int getId_livro() {
        return id_livro;
    }

    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }

    public Object get(int setar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}