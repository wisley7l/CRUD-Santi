package views;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import santi.*;
import views.*;

public class TelaListarAlunos extends javax.swing.JInternalFrame {

    public TelaListarAlunos() {
        initComponents();
        // cria a conexão com o banco de dados
        ConectBDListDeleteAluno listaBD = new ConectBDListDeleteAluno();
        // cria  um array de aluno vazio
        ArrayList<Aluno> listaA = new ArrayList<>();
        // recebe os alunos da busca feita pelo SQL com a função listAlunos()
        listaA = listaBD.listAlunos();
        
        // cria um modelo de Tabela e recebe o modelo ja criado na interface 
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        System.out.println("LISTA INICIALIZADA!"); // log de inicialização da lista
        // percorre o array de alunos criado 
        for (int i = 0; i < listaA.size(); i++) {
            // cria um vetor de String para armazenar a cada possição desse array 
            // as colunas de cada objeto de aluno do array de aluno.
            String linha [] = {
                listaA.get(i).getCpf(),
                listaA.get(i).getNome(),
                listaA.get(i).getRua(),
                "" +listaA.get(i).getNum(), // converte int em String
                listaA.get(i).getCompl(),
                listaA.get(i).getMatricula(),
                listaA.get(i).getCurso()
            };
            model.addRow(linha);  // add a linha na tabela 
          
          // função utilizada para criar os botoes de editar e excluir 
          // seguindo as referencias da pesquisa para realizar essa função.
          ButtonColumn buttonEditar = new ButtonColumn(jTable1, 7,"EDITAR");   
          
          ButtonColumn buttonExcluir = new ButtonColumn(jTable1, 8,"X"); 
          
            
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOME", "CPF", "RUA", "Nº", "COMPLEMENTO", "MATRICULA", "CURSO", "edit", "drop"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
//        função para captura o click do mouse nos botoes de editar e excluir

         int i = jTable1.getSelectedRow(); // captura linha do click do mouse
         int j = jTable1.getSelectedColumn(); // caputura coluna do click do mouse
         
         // caputra informações do Aluno segundo a linha definida por i no click do mouse
         String cpf = jTable1.getValueAt(i, 1).toString(); 
         String nome = jTable1.getValueAt(i, 0).toString();
         String rua = jTable1.getValueAt(i, 2).toString();
         String n = jTable1.getValueAt(i, 3).toString();
         String compl = jTable1.getValueAt(i, 4).toString();
         String matricula = jTable1.getValueAt(i, 5).toString();
         String curso = jTable1.getValueAt(i, 6).toString();
         int num = Integer.parseInt(n); // converte a String do numero em INT
         
         // verifica se o click foi no botão editar ou excluir 
         if(j == 7 ){ // coluna 7 se refere ao bontão editar
             System.out.println("EDIT"); // log 
             setVisible(false); // fecha a lista 
             TelaUpdateAlunos up = new TelaUpdateAlunos(); // cria um objeto para tela de updadte aluno
             Aluno aluno = new Aluno(nome, cpf,  rua,  num,  compl,matricula,curso); // cria um obejto de aluno com os parametro caputurados no click
             up.recebeAluno(this, aluno);// envia para tela de UPDATE o aluno capturado no click
             Menu.areadetrabalho.removeAll(); // remove as telas abertas anteriormente
             Menu.areadetrabalho.add(up); // chama o menu para abrir a tela de UPdate
             up.setVisible(true); // habilita visibilidade da tela de UPDATE

                     
         }else if(j == 8){ // coluna 8 corresponde click no botão excluir
            System.out.println("EXLUIR"); // log
            
            Object[] options = { "Confirmar", "Cancelar" }; // opções para confirmação
            // pergunta ao usuário se ele tem certeza se deseja excluir esse aluno selecionado
            int op = JOptionPane.showOptionDialog(null, "Tem certeza que deseja excluir o Aluno " + nome + " CPF: " + cpf, 
                    "ATENÇÃO", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            // se a opção for sim, a funçaõ retorna o valor ZERO
            if(op == 0){
                // chama a função do banco de dados para excluir
                ConectBDListDeleteAluno deleteItem = new ConectBDListDeleteAluno();
                int r = deleteItem.excluirAluno(cpf);
                if (r == 1){ // se o aluno tiver sido excluido com sucesso.
                    System.out.println("SUCESSO"); // log
                    setVisible(false); // fecha a lista
                    TelaListarAlunos tn = new TelaListarAlunos(); // cria nova lista
                    Menu.areadetrabalho.removeAll(); // remove as telas abertas anteriormente
                    Menu.areadetrabalho.add(tn); // chama o menu para abrir a tela de UPdate
                    tn.setVisible(true);
                }else{
                    System.out.println("ERRO"); // LOG de erro ao deletar
                }    
            } // fim do if de op
         }// fim do if j = Excluir     
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    

}
