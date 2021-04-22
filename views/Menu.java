package views;


public class Menu extends javax.swing.JFrame {


    public Menu() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        areadetrabalho = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btfechar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        btcadastroaluno = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        btlistaalunos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout areadetrabalhoLayout = new javax.swing.GroupLayout(areadetrabalho);
        areadetrabalho.setLayout(areadetrabalhoLayout);
        areadetrabalhoLayout.setHorizontalGroup(
            areadetrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 706, Short.MAX_VALUE)
        );
        areadetrabalhoLayout.setVerticalGroup(
            areadetrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );

        jMenu1.setText("Arquivo");

        btfechar.setText("Fechar");
        btfechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btfecharActionPerformed(evt);
            }
        });
        jMenu1.add(btfechar);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Cadastro");

        btcadastroaluno.setText("Aluno");
        btcadastroaluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcadastroalunoActionPerformed(evt);
            }
        });
        jMenu2.add(btcadastroaluno);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Listar");

        btlistaalunos.setText("Aluno");
        btlistaalunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlistaalunosActionPerformed(evt);
            }
        });
        jMenu3.add(btlistaalunos);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(areadetrabalho)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(areadetrabalho)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btfecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btfecharActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btfecharActionPerformed

    private void btcadastroalunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcadastroalunoActionPerformed
        // chama a tela de cadastro de alunos
        areadetrabalho.removeAll();
        TelaCadastroAluno telaCadastro = new TelaCadastroAluno();
        areadetrabalho.add(telaCadastro);
        telaCadastro.setVisible(true);
        
    }//GEN-LAST:event_btcadastroalunoActionPerformed

    private void btlistaalunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlistaalunosActionPerformed
        // chama a tela de lista alunos
        criaTelaLista();
        
    }//GEN-LAST:event_btlistaalunosActionPerformed
    public void criaTelaLista(){
        areadetrabalho.removeAll();
        TelaListarAlunos telaLista = new TelaListarAlunos();
        areadetrabalho.add(telaLista);
        telaLista.setVisible(true);
}
   
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane areadetrabalho;
    private javax.swing.JMenuItem btcadastroaluno;
    private javax.swing.JMenuItem btfechar;
    private javax.swing.JMenuItem btlistaalunos;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
