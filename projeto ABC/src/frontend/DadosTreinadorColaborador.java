/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.Colaborador;
import backend.ListaUtilizadores;
import backend.Treinador;
import javax.swing.JOptionPane;
import backend.Utilizador;

/**
 *
 * @author 
 */
public class DadosTreinadorColaborador extends javax.swing.JFrame {
    private ListaUtilizadores lista_geral= new ListaUtilizadores();
    private Utilizador u;
    /**
     * Creates new form RegistarTreinador
     */
    public DadosTreinadorColaborador(Utilizador u) {
        this.u=u;
        initComponents();
        
        //Mostra a centralização da janela
        this.setLocationRelativeTo(null);
        
        //preencher caixas
        if(u instanceof Treinador){
           txtContacto.setText(String.valueOf(((Treinador) u).getContactoTlm()));
           txtCipa.setText(String.valueOf(((Treinador) u).getCipa()));
           txtNome.setText(((Treinador) u).getNome());
           txtPass.setText(u.getPassword());  
        }
        if(u instanceof Colaborador){
           txtContacto.setText(String.valueOf(((Colaborador) u).getContactoTlm()));
           txtCipa.setText(String.valueOf(((Colaborador) u).getCipa()));
           txtNome.setText(((Colaborador) u).getNome());
           txtPass.setText(u.getPassword()); 
        }        
    }
    
    private void guardar(){
        if(u instanceof Treinador){
            lista_geral.removerTreinador((Treinador) u);
            
        if (txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza o nome!");            
            txtNome.requestFocus();
            return;
        }else{
            Treinador t = (Treinador) u;
            t.setNome(txtNome.getText());
        }
        
        if (txtCipa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza o cipa!");            
            txtCipa.requestFocus();
            return;
        }else{
            Treinador t = (Treinador) u;
            t.setCipa(txtCipa.getText());
        }
        
        if (txtContacto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Introduza o contacto!");            
                txtContacto.requestFocus();
                return;
            }else{
                Treinador t = (Treinador) u;
                t.setContactoTlm(Integer.parseInt(txtContacto.getText()));           
            }

        if (txtPass.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza uma palavra passe!");            
            txtPass.requestFocus();
            return;
        }else{
            Treinador j = (Treinador) u;
            j.setPassword(txtPass.getText());
        }
            
            lista_geral.adicionarTreinador((Treinador) u);
            JOptionPane.showMessageDialog(this, "Dados alterados com sucesso!"); 
            
            //se for colaborador
        }else if(u instanceof Colaborador){
            Colaborador j = (Colaborador) u;
            lista_geral.removerColaborador((Colaborador) j);
            //Colaborador j = (Colaborador) u;
            if (txtNome.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Introduza o nome!");            
                txtNome.requestFocus();
                return;
            }else{
                //Colaborador t = (Colaborador) u;
                j.setNome(txtNome.getText());
            }
            
            if (txtContacto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Introduza o contacto!");            
                txtContacto.requestFocus();
                return;
            }else{
                //Colaborador t = (Colaborador) u;
                j.setContactoTlm(Integer.parseInt(txtContacto.getText()));           
            }
        
        if (txtCipa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza o cipa!");            
            txtCipa.requestFocus();
            return;
        }else{
           // Colaborador t = (Colaborador) u;
            j.setCipa(txtCipa.getText());
        }

        if (txtPass.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza uma palavra passe!");            
            txtPass.requestFocus();
            return;
        }else{
            //Colaborador j = (Colaborador) u;
            j.setPassword(txtPass.getText());
        }
            
            lista_geral.adicionarColaborador( j);
            JOptionPane.showMessageDialog(this, "Dados alterados com sucesso!");
        }
        
        /*
        if(u instanceof Treinador){
            lista_geral.adicionarTreinador((Treinador) u);
            JOptionPane.showMessageDialog(this, "Dados alterados com sucesso!"); 
        }else if(u instanceof Colaborador){
            lista_geral.adicionarColaborador((Colaborador) u);
            JOptionPane.showMessageDialog(this, "Dados alterados com sucesso!");
        }*/
    }
    
    private void alterarTreinador(){
        Treinador t = (Treinador) u;      
        if (txtNome.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Introduza o nome!");            
                txtNome.requestFocus();
                return;
            }else{
                t.setNome(txtNome.getText());
            }
            
            if (txtContacto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Introduza o contacto!");            
                txtContacto.requestFocus();
                return;
            }else{
                t.setContactoTlm(Integer.parseInt(txtContacto.getText()));           
            }
        
        if (txtCipa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza o cipa!");            
            txtCipa.requestFocus();
            return;
        }else{
            t.setCipa(txtCipa.getText());
        }

        if (txtPass.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza uma palavra passe!");            
            txtPass.requestFocus();
            return;
        }else{
            t.setPassword(txtPass.getText());
        }
        if(t.getEquipa()==null){
            lista_geral.alterarTreinadorSemEscalao(t);
        }else if(t.getEquipa()!=null){
            lista_geral.alterarTreinadorComEscalao(t);
        }  
        JOptionPane.showMessageDialog(this, "Dados alterados com sucesso!");
        
    }
    
    private void alterarColaborador(){
        Colaborador c = (Colaborador) u;
        lista_geral.removerColaborador((Colaborador) u);
        
        if (txtNome.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Introduza o nome!");            
                txtNome.requestFocus();
                return;
            }else{
                c.setNome(txtNome.getText());
            }
            
            if (txtContacto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Introduza o contacto!");            
                txtContacto.requestFocus();
                return;
            }else{
                c.setContactoTlm(Integer.parseInt(txtContacto.getText()));           
            }
        
        if (txtCipa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza o cipa!");            
            txtCipa.requestFocus();
            return;
        }else{
            c.setCipa(txtCipa.getText());
        }

        if (txtPass.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza uma palavra passe!");            
            txtPass.requestFocus();
            return;
        }else{
            c.setPassword(txtPass.getText());
        }
        lista_geral.adicionarColaborador(c);
        JOptionPane.showMessageDialog(this, "Dados alterados com sucesso!");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtContacto = new javax.swing.JTextField();
        alterarTreinadorBtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCipa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        checkVerPass = new javax.swing.JCheckBox();
        removerTreinadorBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(398, 520));

        jPanel2.setBackground(new java.awt.Color(255, 236, 52));
        jPanel2.setPreferredSize(new java.awt.Dimension(398, 520));
        jPanel2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel2AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jPanel3.setBackground(new java.awt.Color(48, 44, 44));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DADOS DO UTILIZADOR");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(21, 21, 21))
        );

        txtContacto.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactoActionPerformed(evt);
            }
        });

        alterarTreinadorBtn.setBackground(new java.awt.Color(255, 236, 52));
        alterarTreinadorBtn.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        alterarTreinadorBtn.setText("ALTERAR DADOS");
        alterarTreinadorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarTreinadorBtnActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 236, 52));
        jButton2.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jButton2.setText("CANCELAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel1.setText("Contacto:");

        txtNome.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        txtCipa.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtCipa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCipaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel6.setText("Nome:");

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel7.setText("Cipa:");

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel8.setText("Password:");

        txtPass.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });

        checkVerPass.setBackground(new java.awt.Color(255, 236, 52));
        checkVerPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkVerPassActionPerformed(evt);
            }
        });

        removerTreinadorBtn.setBackground(new java.awt.Color(255, 236, 52));
        removerTreinadorBtn.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        removerTreinadorBtn.setText("REMOVER UTILIZADOR");
        removerTreinadorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerTreinadorBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtContacto, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCipa)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 12, Short.MAX_VALUE)
                                        .addComponent(alterarTreinadorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(removerTreinadorBtn))
                                    .addComponent(txtPass, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(7, 7, 7)
                                .addComponent(checkVerPass)))
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCipa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(4, 4, 4)
                .addComponent(txtNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkVerPass))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alterarTreinadorBtn)
                    .addComponent(removerTreinadorBtn))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContactoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void alterarTreinadorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarTreinadorBtnActionPerformed
        //guardar();
        if(u instanceof Treinador){
            alterarTreinador(); 
        }else if(u instanceof Colaborador){
            alterarColaborador();
        }        

        dispose();
    }//GEN-LAST:event_alterarTreinadorBtnActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void jPanel2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel2AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2AncestorAdded

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

    private void removerTreinadorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerTreinadorBtnActionPerformed
        if(u instanceof Treinador){
            lista_geral.removerTreinador((Treinador) u); 
        }else if(u instanceof Colaborador){
            lista_geral.removerColaborador((Colaborador) u);
        }
        JOptionPane.showMessageDialog(this, "Treinador removido com sucesso!");
        dispose();
        
    }//GEN-LAST:event_removerTreinadorBtnActionPerformed

    private void checkVerPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkVerPassActionPerformed
        if(checkVerPass.isSelected()){
            txtPass.setEchoChar((char)0);
        }else{
            txtPass.setEchoChar('•');
        }
    }//GEN-LAST:event_checkVerPassActionPerformed

    private void txtCipaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCipaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCipaActionPerformed

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
            java.util.logging.Logger.getLogger(RegistarAtleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistarAtleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistarAtleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistarAtleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistarAtleta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterarTreinadorBtn;
    private javax.swing.JCheckBox checkVerPass;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton removerTreinadorBtn;
    private javax.swing.JTextField txtCipa;
    private javax.swing.JTextField txtContacto;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtPass;
    // End of variables declaration//GEN-END:variables
}
