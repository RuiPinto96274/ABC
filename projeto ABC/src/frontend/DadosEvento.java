/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.Escalao;
import backend.Evento;
import backend.ListaEscalao;
import backend.ListaEventos;
import backend.ListaPavilhao;
import backend.Pavilhao;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author cataf
 */
public class DadosEvento extends javax.swing.JFrame {
    private ListaPavilhao lista_pavilhao=new  ListaPavilhao();
    private ListaEscalao lista_geral_esc= new ListaEscalao();
    private ListaEventos lista_eventos=new ListaEventos();
    private Evento e;
    
    /**
     * Creates new form AdicionarEvento
     */
    public DadosEvento(Evento e) {
        this.e=e;
        initComponents();
        carregarPavilhoes();
        //Mostra a centralização da janela
        this.setLocationRelativeTo(null);
        
        //preencher caixas
        txtId.setText(e.getId_evento());
        txtNome.setText(e.getNome());
        txtDescricao.setText(e.getDescricao());
        if(e.getTipo().equals("T")){
            txtTipo.setText("Treino");
        }else if(e.getTipo().equals("J")){
            txtTipo.setText("Jogo");
        }
        
        txtEscalao.setText(e.getEscalao().getNome());
        txtDia.setDate(Date.from(e.getDia().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        //txtDia.setText(String.valueOf(e.getDia()));
        txtHora.setText(e.getHora());
    }
    
     
    private void carregarPavilhoes(){
        comboPavilhao.removeAllItems();
        for (Pavilhao pv : lista_pavilhao.listagemPavilhoes()){
            String id =pv.getIdPavilhao();
            String nome=pv.getNome();
            String item=String.join("-", id, nome);
            comboPavilhao.addItem(item);   
        }
    }
    
    private void guardar() throws ListaEventos.EventoNaoExistenteException{  
  
        if (txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza o nome do evento!");            
            txtNome.requestFocus();
            return;
        }else{
            e.setNome(txtNome.getText());
        }
       
        //LocalDate dia = LocalDate.parse(txtDia.getText());
         
        LocalDate dia= txtDia.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        e.setDia(dia);
        
        if (txtHora.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza a hora do evento!");            
            txtHora.requestFocus();
            return;
        }else{
            e.setHora(txtHora.getText());
        }
       
        lista_eventos.alterarEvento(e);
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
        txtDescricao = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboPavilhao = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        alterarEventoBtn = new javax.swing.JButton();
        removerEventoBtn = new javax.swing.JButton();
        txtEscalao = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtDia = new com.toedter.calendar.JDateChooser();
        imagemFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(253, 244, 3));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDescricao.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescricaoActionPerformed(evt);
            }
        });
        jPanel2.add(txtDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 300, -1));

        txtHora.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jPanel2.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 300, -1));

        jButton2.setBackground(new java.awt.Color(255, 236, 52));
        jButton2.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jButton2.setText("CANCELAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 540, 201, -1));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel1.setText("Descricão:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 131, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel2.setText("Tipo do evento:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 175, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel3.setText("Escalão e Género:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 126, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel4.setText("Localização:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 112, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel6.setText("Hora (formato hh:mm):");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 150, -1));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("DADOS DO EVENTO");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        comboPavilhao.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        comboPavilhao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboPavilhao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPavilhaoActionPerformed(evt);
            }
        });
        jPanel2.add(comboPavilhao, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 300, -1));

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel8.setText("Dia:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 112, -1));

        txtNome.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        jPanel2.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 300, -1));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel5.setText("ID do evento:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 131, -1));

        alterarEventoBtn.setBackground(new java.awt.Color(255, 236, 52));
        alterarEventoBtn.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        alterarEventoBtn.setText("ALTERAR DADOS");
        alterarEventoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarEventoBtnActionPerformed(evt);
            }
        });
        jPanel2.add(alterarEventoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, -1, -1));

        removerEventoBtn.setBackground(new java.awt.Color(255, 236, 52));
        removerEventoBtn.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        removerEventoBtn.setText("REMOVER EVENTO");
        removerEventoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerEventoBtnActionPerformed(evt);
            }
        });
        jPanel2.add(removerEventoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 500, 140, -1));
        jPanel2.add(txtEscalao, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 300, -1));

        txtTipo.setEditable(false);
        jPanel2.add(txtTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 300, -1));

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel9.setText("Nome do evento:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 131, -1));

        txtId.setEditable(false);
        txtId.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        jPanel2.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 300, -1));
        jPanel2.add(txtDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 300, -1));

        imagemFundo.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        imagemFundo.setForeground(new java.awt.Color(255, 255, 255));
        imagemFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Sem Título-1.png"))); // NOI18N
        jPanel2.add(imagemFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 520));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescricaoActionPerformed

    private void comboPavilhaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPavilhaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPavilhaoActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void alterarEventoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarEventoBtnActionPerformed
        try {
            guardar();
        } catch (ListaEventos.EventoNaoExistenteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao alterar evento", JOptionPane.ERROR_MESSAGE);
        }
        dispose();
    }//GEN-LAST:event_alterarEventoBtnActionPerformed

    private void removerEventoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerEventoBtnActionPerformed
        lista_eventos.removerEvento(e);
        JOptionPane.showMessageDialog(this, "Evento removido com sucesso!");
        dispose();
    }//GEN-LAST:event_removerEventoBtnActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

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
            java.util.logging.Logger.getLogger(DadosEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DadosEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DadosEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DadosEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new DadosEvento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterarEventoBtn;
    private javax.swing.JComboBox<String> comboPavilhao;
    private javax.swing.JLabel imagemFundo;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton removerEventoBtn;
    private javax.swing.JTextField txtDescricao;
    private com.toedter.calendar.JDateChooser txtDia;
    private javax.swing.JTextField txtEscalao;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}