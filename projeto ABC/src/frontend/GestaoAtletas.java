/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.Atleta;
import backend.Escalao;
import backend.ListaUtilizadores;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cataf
 */
public class GestaoAtletas extends javax.swing.JFrame {    
    private DefaultTableModel modelAtletas;
    private ListaUtilizadores lista_geral= new ListaUtilizadores();
    /**
     * Creates new form GestaoAtletas
     */
    public GestaoAtletas() {
        initComponents();
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);   
        modelAtletas = (DefaultTableModel) tabelaAtletas.getModel();       
        preencheTabela();
        
        //aparecer texto ao passar cursor em cima
        iconAtletas.setToolTipText("Atletas");       
        UIManager.put("ToolTip.background", Color.WHITE);
        UIManager.put("ToolTip.foreground", Color.BLACK);
        UIManager.put("ToolTip.font", new Font("SansSerif", Font.BOLD, 14));
        
        //aparecer texto ao passar cursor em cima
        iconCalendario.setToolTipText("Calendário");       
        UIManager.put("ToolTip.background", Color.WHITE);
        UIManager.put("ToolTip.foreground", Color.BLACK);
        UIManager.put("ToolTip.font", new Font("SansSerif", Font.BOLD, 14));
        
        //aparecer texto ao passar cursor em cima
        iconGestaoTeC.setToolTipText("Treinadores e Colaboradores");       
        UIManager.put("ToolTip.background", Color.WHITE);
        UIManager.put("ToolTip.foreground", Color.BLACK);
        UIManager.put("ToolTip.font", new Font("SansSerif", Font.BOLD, 14));
        
        //aparecer texto ao passar cursor em cima
        iconPagar.setToolTipText("Registar pagamento de quota");       
        UIManager.put("ToolTip.background", Color.WHITE);
        UIManager.put("ToolTip.foreground", Color.BLACK);
        UIManager.put("ToolTip.font", new Font("SansSerif", Font.BOLD, 14));
        
        //aparecer texto ao passar cursor em cima
        iconSair.setToolTipText("Sair");       
        UIManager.put("ToolTip.background", Color.WHITE);
        UIManager.put("ToolTip.foreground", Color.BLACK);
        UIManager.put("ToolTip.font", new Font("SansSerif", Font.BOLD, 14));
    }

    private void preencheTabela() {
        modelAtletas.setRowCount(0); //especifica o nr de linhas na tabela
        for (int index = 0; index < lista_geral.listagemAtletas().size(); index++) {
            Atleta a = lista_geral.listagemAtletas().get(index); 
            if(lista_geral.getEquipaAtleta(a)==null){
                String resul="Sem equipa";
                modelAtletas.addRow(new Object[]{a.getCipa(), a.getNome(),resul, a.getContactoTlm(), a.getDataNasc()});
            }else{
                ArrayList<Escalao> equipas = lista_geral.getEquipaAtleta(a);
                ArrayList<String> nome_eq= new ArrayList(); 
                String nome;
                for(int i=0; i<equipas.size(); i++){
                    Escalao e = equipas.get(i);
                    nome=e.getNome();
                    nome_eq.add(nome);                  
                }
                String resul = String.join(",", nome_eq);
                modelAtletas.addRow(new Object[]{a.getCipa(), a.getNome(),resul, a.getContactoTlm(), a.getDataNasc()});
            }
            
        }
        tabelaAtletas.setModel(modelAtletas);
    }
    
    private void procurar(){
        String user =txtProcura.getText();
        ArrayList <Atleta> listaAtletas = new ArrayList<>();
        listaAtletas = lista_geral.listagemAtletas();
        
        boolean encontrou =false;
        
        for (Atleta a : listaAtletas){
            if(a.getCipa().equals(user)){
                DadosAtleta da = new DadosAtleta(a);
                da.setVisible(true);
                txtProcura.setText("");
                encontrou=true;
            }     
        }
        
        if(encontrou==false){
            JOptionPane.showMessageDialog(this, "Este atleta não existe!");
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
        jPanel2 = new javax.swing.JPanel();
        iconAtletas = new javax.swing.JLabel();
        iconCalendario = new javax.swing.JLabel();
        iconSair = new javax.swing.JLabel();
        iconGestaoTeC = new javax.swing.JLabel();
        iconPagar = new javax.swing.JLabel();
        registarAtletaBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAtletas = new javax.swing.JTable();
        txtProcura = new javax.swing.JTextField();
        pesquisaBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        atualizarBtn = new javax.swing.JButton();
        atualizarBtn1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(48, 44, 44));

        jPanel2.setBackground(new java.awt.Color(255, 236, 52));

        iconAtletas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pngwing.com (2).png"))); // NOI18N
        iconAtletas.setText("jLabel1");

        iconCalendario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/calendario.png"))); // NOI18N
        iconCalendario.setText("jLabel2");
        iconCalendario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconCalendarioMouseClicked(evt);
            }
        });

        iconSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/voltar.png"))); // NOI18N
        iconSair.setText("jLabel3");
        iconSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconSairMouseClicked(evt);
            }
        });

        iconGestaoTeC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/coach.png"))); // NOI18N
        iconGestaoTeC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconGestaoTeCMouseClicked(evt);
            }
        });

        iconPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon_quotas.png"))); // NOI18N
        iconPagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconPagarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(iconPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(iconGestaoTeC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(iconAtletas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(iconCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(iconSair, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(iconAtletas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iconCalendario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iconGestaoTeC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iconPagar)
                .addGap(259, 259, 259)
                .addComponent(iconSair)
                .addGap(19, 19, 19))
        );

        registarAtletaBtn.setBackground(new java.awt.Color(255, 236, 52));
        registarAtletaBtn.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        registarAtletaBtn.setText("Registar Atleta");
        registarAtletaBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registarAtletaBtnMouseClicked(evt);
            }
        });
        registarAtletaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registarAtletaBtnActionPerformed(evt);
            }
        });

        tabelaAtletas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CIPA", "NOME", "EQUIPA", "CONTACTO", "DATA NASCIMENTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaAtletas);

        txtProcura.setBackground(new java.awt.Color(204, 204, 204));
        txtProcura.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtProcura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProcuraActionPerformed(evt);
            }
        });

        pesquisaBtn.setBackground(new java.awt.Color(255, 236, 52));
        pesquisaBtn.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        pesquisaBtn.setText("Pesquisar");
        pesquisaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisaBtnActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("GESTÃO DE ATLETAS");

        atualizarBtn.setBackground(new java.awt.Color(255, 236, 52));
        atualizarBtn.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        atualizarBtn.setText("Atualizar");
        atualizarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarBtnActionPerformed(evt);
            }
        });

        atualizarBtn1.setBackground(new java.awt.Color(255, 236, 52));
        atualizarBtn1.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        atualizarBtn1.setText("Gestão Escalões");
        atualizarBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtProcura, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pesquisaBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(registarAtletaBtn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(atualizarBtn1)
                        .addGap(18, 18, 18)
                        .addComponent(atualizarBtn)))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(atualizarBtn)
                    .addComponent(atualizarBtn1))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProcura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisaBtn)
                    .addComponent(registarAtletaBtn))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registarAtletaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registarAtletaBtnActionPerformed
        
    }//GEN-LAST:event_registarAtletaBtnActionPerformed

    private void pesquisaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisaBtnActionPerformed
        if(txtProcura.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Introduza o atleta que deseja visualizar!"); 
        }else{
            procurar();
        }     
    }//GEN-LAST:event_pesquisaBtnActionPerformed

    private void iconSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconSairMouseClicked
        /*PaginaInicial pg = new PaginaInicial();               
        pg.setVisible(true); */
        dispose();
    }//GEN-LAST:event_iconSairMouseClicked

    private void iconCalendarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconCalendarioMouseClicked
        dispose();
        Calendario c = new Calendario();
        c.setVisible(true);
    }//GEN-LAST:event_iconCalendarioMouseClicked

    private void registarAtletaBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registarAtletaBtnMouseClicked
        RegistarAtleta ra = new RegistarAtleta();
        ra.setVisible(true);
    }//GEN-LAST:event_registarAtletaBtnMouseClicked

    private void atualizarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarBtnActionPerformed
        preencheTabela();
    }//GEN-LAST:event_atualizarBtnActionPerformed

    private void atualizarBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarBtn1ActionPerformed
        GestaoEscaloes ge = new GestaoEscaloes();
        ge.setVisible(true);
    }//GEN-LAST:event_atualizarBtn1ActionPerformed

    private void iconGestaoTeCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconGestaoTeCMouseClicked
        dispose();
        GestaoTreinadoresColaboradores gtc = new GestaoTreinadoresColaboradores();
        gtc.setVisible(true);
    }//GEN-LAST:event_iconGestaoTeCMouseClicked

    private void iconPagarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconPagarMouseClicked
        dispose();
        RegistarQuota rq = new RegistarQuota();
        rq.setVisible(true);
    }//GEN-LAST:event_iconPagarMouseClicked

    private void txtProcuraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProcuraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProcuraActionPerformed

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
            java.util.logging.Logger.getLogger(GestaoAtletas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestaoAtletas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestaoAtletas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestaoAtletas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestaoAtletas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizarBtn;
    private javax.swing.JButton atualizarBtn1;
    private javax.swing.JLabel iconAtletas;
    private javax.swing.JLabel iconCalendario;
    private javax.swing.JLabel iconGestaoTeC;
    private javax.swing.JLabel iconPagar;
    private javax.swing.JLabel iconSair;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pesquisaBtn;
    private javax.swing.JButton registarAtletaBtn;
    private javax.swing.JTable tabelaAtletas;
    private javax.swing.JTextField txtProcura;
    // End of variables declaration//GEN-END:variables
}
