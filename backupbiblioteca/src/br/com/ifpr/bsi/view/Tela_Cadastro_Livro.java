/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpr.bsi.view;

import br.com.ifpr.bsi.DAO.LivroDAO;
import br.com.ifpr.bsi.DTO.LivroDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Tela_Cadastro_Livro extends javax.swing.JFrame {

    private void Limpar_Campos (){
        LivroDTO l = new LivroDTO();
        jTFDescricao.setText("");
        jTFAutor.setText("");
        jTFEditora.setText("");
        jTFEdicao.setText("");
        jTFQuantidade.setText("");
        jTFId.setText("");
        jTFId1.setText("");
        Listar_Livros();
    }
    private void Carregar_Campos(){ 
        int setar = jTLivros.getSelectedRow();
        jTFId.setText(jTLivros.getModel().getValueAt(setar,0).toString());
        jTFDescricao.setText(jTLivros.getModel().getValueAt(setar,1).toString());
        jTFAutor.setText(jTLivros.getModel().getValueAt(setar,2).toString());
        jTFEditora.setText(jTLivros.getModel().getValueAt(setar,3).toString());
        jTFEdicao.setText(jTLivros.getModel().getValueAt(setar,4).toString());
        jTFQuantidade.setText(jTLivros.getModel().getValueAt(setar,5).toString());
    }
    private void Cadastrar (){
        String Descricao_livro,Autor_livro,Editora_livro;
        int Edicao_livro,Qtde_livro;
        Descricao_livro = jTFDescricao.getText();
        Autor_livro = jTFAutor.getText();
        Editora_livro = jTFEditora.getText();
        Edicao_livro = Integer.parseInt(jTFEdicao.getText());
        Qtde_livro = Integer.parseInt(jTFQuantidade.getText());
        
        LivroDTO l = new LivroDTO();
        l.setDescricao_livro(Descricao_livro);
        l.setAutor_livro(Autor_livro);
        l.setEditora_livro(Editora_livro);
        l.setEdicao_livro(Edicao_livro);
        l.setQtde_livro(Qtde_livro);
        
        LivroDAO ld = new LivroDAO();
        ld.Cadastrar_Livro(l);
        jLResultado.setText("Cadastrado com sucesso!.");
    }
    private void Alterar_Livro(){
        String Descricao_livro,Autor_livro,Editora_livro;
        int Edicao_livro,Qtde_livro,Id_livro;
        Id_livro = Integer.parseInt(jTFId.getText());
        Descricao_livro = jTFDescricao.getText();
        Autor_livro = jTFAutor.getText();
        Editora_livro = jTFEditora.getText();
        Edicao_livro = Integer.parseInt(jTFEdicao.getText());
        Qtde_livro = Integer.parseInt(jTFQuantidade.getText());
        
        LivroDTO l = new LivroDTO();
        l.setId_livro(Id_livro);
        l.setDescricao_livro(Descricao_livro);
        l.setAutor_livro(Autor_livro);
        l.setEditora_livro(Editora_livro);
        l.setEdicao_livro(Edicao_livro);
        l.setQtde_livro(Qtde_livro);
        
        LivroDAO ld = new LivroDAO();
        ld.Alterar_LivroDAO(l);
        jLResultado.setText("Alterado com sucesso!.");
    }
    private void Listar_Livros(){
        try {
            LivroDAO ld = new LivroDAO();
            DefaultTableModel model = (DefaultTableModel) jTLivros.getModel();
            model.setNumRows(0);
            ArrayList<LivroDTO> lista = ld.Listar_livroDAO();
            for(int i=0; i<lista.size();i++){
                model.addRow(new Object[]{
                    lista.get(i).getId_livro(),
                    lista.get(i).getDescricao_livro(),
                    lista.get(i).getAutor_livro(),
                    lista.get(i).getEditora_livro(),
                    lista.get(i).getEdicao_livro(),
                    lista.get(i).getQtde_livro(),
                    
                });
            }
                
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ListarLivrosView: " + erro);
        }
    }
    private void Buscar_Livro(){
        try {
            LivroDAO ld = new LivroDAO();
            DefaultTableModel model = (DefaultTableModel) jTLivros.getModel();
            model.setNumRows(0);
            String id_codigo = jTFId1.getText();
            ArrayList<LivroDTO> lista = ld.Pesquisar_livroDAO(id_codigo);
            for(int i=0; i<lista.size();i++){
                model.addRow(new Object[]{
                    lista.get(i).getId_livro(),
                    lista.get(i).getDescricao_livro(),
                    lista.get(i).getAutor_livro(),
                    lista.get(i).getEditora_livro(),
                    lista.get(i).getEdicao_livro(),
                    lista.get(i).getQtde_livro(),
                    
                });
            }
                
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "BuscarLivroView: " + erro);
        } 
        
        //int setar = jTLivros.getSelectedRow();
        //jTFId.setText(jTLivros.getModel().getValueAt(setar,0).toString());
        //jTFDescricao.setText(jTLivros.getModel().getValueAt(setar,1).toString());
        //jTFAutor.setText(jTLivros.getModel().getValueAt(setar,2).toString());
        //jTFEditora.setText(jTLivros.getModel().getValueAt(setar,3).toString());
       // jTFEdicao.setText(jTLivros.getModel().getValueAt(setar,4).toString());
        //jTFQuantidade.setText(jTLivros.getModel().getValueAt(setar,5).toString());
    }
    /**
     * Creates new form Tela_Cadastro_Livro
     */
    public Tela_Cadastro_Livro() {
        initComponents();
        jTFId.setEnabled(false);
        jLResultado.setEnabled(false);
        Listar_Livros();
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jBCadastrar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jTFEdicao = new javax.swing.JTextField();
        jTFAutor = new javax.swing.JTextField();
        jTFEditora = new javax.swing.JTextField();
        jTFQuantidade = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLDescricao = new javax.swing.JLabel();
        jLAutor = new javax.swing.JLabel();
        jLEditora = new javax.swing.JLabel();
        jLEdicao = new javax.swing.JLabel();
        jLQuantidade = new javax.swing.JLabel();
        jTFDescricao = new javax.swing.JTextField();
        jLResultado = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTLivros = new javax.swing.JTable();
        jLId = new javax.swing.JLabel();
        jTFId1 = new javax.swing.JTextField();
        jBPesquisar = new javax.swing.JButton();
        jBSelecionar = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jLId1 = new javax.swing.JLabel();
        jTFId = new javax.swing.JTextField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jBCadastrar.setText("Cadastrar");
        jBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarActionPerformed(evt);
            }
        });

        jBCancelar.setText("Limpar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jTFEdicao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTFAutor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFAutorActionPerformed(evt);
            }
        });

        jTFEditora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFEditoraActionPerformed(evt);
            }
        });

        jTFQuantidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFQuantidadeActionPerformed(evt);
            }
        });

        jLDescricao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLDescricao.setText("Descricao:");

        jLAutor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLAutor.setText("Autor:");

        jLEditora.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLEditora.setText("Editora:");

        jLEdicao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLEdicao.setText("Edicao:");

        jLQuantidade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLQuantidade.setText("Quantidade:");

        jTFDescricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Descrição", "Autor", "Editora", "Edição", "Qtde"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTLivros);
        if (jTLivros.getColumnModel().getColumnCount() > 0) {
            jTLivros.getColumnModel().getColumn(0).setMinWidth(40);
            jTLivros.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTLivros.getColumnModel().getColumn(0).setMaxWidth(40);
            jTLivros.getColumnModel().getColumn(4).setMinWidth(120);
            jTLivros.getColumnModel().getColumn(4).setPreferredWidth(120);
            jTLivros.getColumnModel().getColumn(4).setMaxWidth(120);
            jTLivros.getColumnModel().getColumn(5).setMinWidth(40);
            jTLivros.getColumnModel().getColumn(5).setPreferredWidth(40);
            jTLivros.getColumnModel().getColumn(5).setMaxWidth(40);
        }

        jLId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLId.setText("ID:");

        jTFId1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFId1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFId1ActionPerformed(evt);
            }
        });

        jBPesquisar.setText("Pesquisar");
        jBPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPesquisarActionPerformed(evt);
            }
        });

        jBSelecionar.setText("Selecionar");
        jBSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSelecionarActionPerformed(evt);
            }
        });

        jBAlterar.setText("Alterar");
        jBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarActionPerformed(evt);
            }
        });

        jLId1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLId1.setText("ID:");

        jTFId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46)
                                        .addComponent(jLId)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTFId1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(107, 107, 107))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLDescricao)
                            .addComponent(jTFDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(jLAutor)
                            .addComponent(jTFAutor)
                            .addComponent(jLEditora)
                            .addComponent(jLEdicao)
                            .addComponent(jLId1)
                            .addComponent(jTFId))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLQuantidade))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLId1)
                .addGap(0, 0, 0)
                .addComponent(jTFId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLDescricao)
                .addGap(0, 0, 0)
                .addComponent(jTFDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLAutor)
                .addGap(0, 0, 0)
                .addComponent(jTFAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLEditora)
                .addGap(0, 0, 0)
                .addComponent(jTFEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLEdicao)
                .addGap(0, 0, 0)
                .addComponent(jTFEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBSelecionar)
                            .addComponent(jBAlterar)
                            .addComponent(jBCadastrar)
                            .addComponent(jBCancelar)
                            .addComponent(jTFId1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLId)
                            .addComponent(jBPesquisar))
                        .addGap(39, 39, 39))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLQuantidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        Limpar_Campos();
        // TODO add your handling code here:
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jTFAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFAutorActionPerformed

    private void jBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarActionPerformed
        Cadastrar();
        Limpar_Campos();
        Listar_Livros();
    }//GEN-LAST:event_jBCadastrarActionPerformed

    private void jTFEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFEditoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFEditoraActionPerformed

    private void jTFQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFQuantidadeActionPerformed

    private void jTFId1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFId1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFId1ActionPerformed

    private void jBPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarActionPerformed
        Buscar_Livro();
        Limpar_Campos();
        // TODO add your handling code here:
    }//GEN-LAST:event_jBPesquisarActionPerformed

    private void jBSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSelecionarActionPerformed
        Carregar_Campos();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jBSelecionarActionPerformed

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        Alterar_Livro();
        Listar_Livros();
        Limpar_Campos();
        // TODO add your handling code here:
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jTFIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFIdActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_Cadastro_Livro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Cadastro_Livro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Cadastro_Livro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Cadastro_Livro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Cadastro_Livro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBCadastrar;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBPesquisar;
    private javax.swing.JButton jBSelecionar;
    private javax.swing.JLabel jLAutor;
    private javax.swing.JLabel jLDescricao;
    private javax.swing.JLabel jLEdicao;
    private javax.swing.JLabel jLEditora;
    private javax.swing.JLabel jLId;
    private javax.swing.JLabel jLId1;
    private javax.swing.JLabel jLQuantidade;
    private javax.swing.JLabel jLResultado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFAutor;
    private javax.swing.JTextField jTFDescricao;
    private javax.swing.JTextField jTFEdicao;
    private javax.swing.JTextField jTFEditora;
    private javax.swing.JTextField jTFId;
    private javax.swing.JTextField jTFId1;
    private javax.swing.JTextField jTFQuantidade;
    private javax.swing.JTable jTLivros;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
