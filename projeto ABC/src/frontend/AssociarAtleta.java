/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.Atleta;
import backend.Escalao;
import backend.ListaEscalao;
import backend.ListaUtilizadores;
import backend.Treinador;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author cataf
 */
public class AssociarAtleta extends javax.swing.JFrame {
    private ListaUtilizadores lista_geral_users= new ListaUtilizadores();
    private ListaEscalao lista_geral_esc= new ListaEscalao();
    /**
     * Creates new form AssociarTreinador
     */
    public AssociarAtleta() {
        initComponents();
        //Mostra a centralização da janela
        this.setLocationRelativeTo(null);
        
        carregarListaEscaloes();
    }
    
    private void carregarListaEscaloes(){
        comboEscalao.removeAllItems();
        for (Escalao esc : lista_geral_esc.listagemEscalao()){
            String nome =esc.getNome();
            String id =esc.getId_equipa();
            String item=String.join("-", id, nome);
            comboEscalao.addItem(item);         
        }
    }
    
    private void associarAtleta() throws ListaUtilizadores.UtilizadorDuplicadoException, ListaUtilizadores.UtilizadorNaoExistenteException, ListaEscalao.EscalaoNaoExistenteException{
        if(txtCipa.getText().isEmpty() || comboEscalao.getSelectedItem()==null){
            JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios!");           
        }else{
            if (lista_geral_users.getAtleta(txtCipa.getText())==null){
                JOptionPane.showMessageDialog(this, "Não existe nenhum atleta com esse cipa!"); 
            }else{
                String item = String.valueOf(comboEscalao.getSelectedItem());
                String[] valores=item.split("-");
                String id=valores[0];           
                String cipa =(txtCipa.getText());
                Atleta atleta =lista_geral_users.getAtleta(cipa);                
                Escalao escalao=lista_geral_esc.getEscalao(id);
                ArrayList<Escalao> lista =lista_geral_users.getEquipaAtleta(atleta);
                boolean valor = true;  //se for falsa é porque ja esta inscrito e nao pode adicionar
                if(lista.isEmpty()==false){
                    for(Escalao es: lista){
                        if (es.getId_equipa().equals(escalao.getId_equipa())){
                            valor=false;
                        }
                    }               
                    if(valor==true){
                        lista_geral_users.associarEscalaoAtleta(atleta, escalao);
                        JOptionPane.showMessageDialog(this, "Associacao efetuada com sucesso!");
                        dispose();
                    }else{
                        JOptionPane.showMessageDialog(this, "Atleta já está inscrito nessa equipa!");
                    }
                }else{
                    lista_geral_users.associarEscalaoAtleta(atleta, escalao);
                        JOptionPane.showMessageDialog(this, "Associacao efetuada com sucesso!");
                        dispose();
                }                
                    
            }          
        } 
    }
    
    private void removerAtleta() throws ListaUtilizadores.UtilizadorNaoExistenteException, ListaEscalao.EscalaoNaoExistenteException{
        if(txtCipa.getText().isEmpty() || comboEscalao.getSelectedItem()==null){
            JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios!");           
        }else{
            if (lista_geral_users.getAtleta(txtCipa.getText())==null){
                JOptionPane.showMessageDialog(this, "Não existe nenhum atleta com esse cipa!"); 
            }else{
                String item = String.valueOf(comboEscalao.getSelectedItem());
                String[] valores=item.split("-");
                String id=valores[0];           
                String cipa =(txtCipa.getText());
                Atleta atleta =lista_geral_users.getAtleta(cipa);                
                Escalao escalao=lista_geral_esc.getEscalao(id);
                ArrayList<Escalao> lista =lista_geral_users.getEquipaAtleta(atleta);
                boolean valor = true;  //se for falsa é porque ja esta inscrito e pode remover
                if(lista.isEmpty()==false){
                    for(Escalao es: lista){
                        if (es.getId_equipa().equals(escalao.getId_equipa())){
                            valor=false;
                        }
                    }               
                    if(valor==true){
                        JOptionPane.showMessageDialog(this, "Atleta não está inscrito nessa equipa!");
                    }else{
                        lista_geral_users.removerEscalaoAtleta(atleta, escalao);
                        JOptionPane.showMessageDialog(this, "Atleta removido com sucesso!");
                        dispose();
                        
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Atleta nao tem nenhuma equipa associada!");
                    dispose();
                } 
                /*if(lista_geral_users.getEquipaAtleta(atleta).contains(escalao)){
                    lista_geral_users.removerEscalaoAtleta(atleta, escalao);
                    JOptionPane.showMessageDialog(this, "Atleta removido com sucesso!");
                    dispose();
                }else{                  
                    JOptionPane.showMessageDialog(this, "Atleta não está inscrito nessa equipa!");
                }   */            
            }          
        } 
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCipa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        comboEscalao = new javax.swing.JComboBox<>();
        btnConfirmar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 236, 52));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel1.setText("Cipa do Atleta:");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setText("Escalões:");

        comboEscalao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnConfirmar.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        btnConfirmar.setText("Adicionar a equipa");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnRemover.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        btnRemover.setText("Remover da equipa");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(48, 44, 44));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ASSOCIAR ATLETA A EQUIPA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(comboEscalao, 0, 351, Short.MAX_VALUE)
                            .addComponent(txtCipa)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCipa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboEscalao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(btnRemover))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        try {
            associarAtleta();
        } catch (ListaUtilizadores.UtilizadorDuplicadoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ListaUtilizadores.UtilizadorNaoExistenteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ListaEscalao.EscalaoNaoExistenteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        try { 
            removerAtleta();
        } catch (ListaUtilizadores.UtilizadorNaoExistenteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ListaEscalao.EscalaoNaoExistenteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

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
            java.util.logging.Logger.getLogger(AssociarAtleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AssociarAtleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AssociarAtleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AssociarAtleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AssociarAtleta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JComboBox<String> comboEscalao;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtCipa;
    // End of variables declaration//GEN-END:variables
}
