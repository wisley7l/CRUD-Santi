package santi;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CriaAtualizaAluno {
   ConectBDListDeleteAluno banco  = new ConectBDListDeleteAluno(); // cria o obejeto de conexão como o banco de Dados
   
   // função captura String vazia e conver em null para enviar para o BD
    private String testaVazio(String s){
            if(s.equals("")){
                return null;        
            }else{
                return s;
            }           
        }

    public int createAluno(Aluno a){
    // função seguindo as orientações da biblioteca de conexão

        try {        
                PreparedStatement psmt = banco.conn.prepareStatement( "INSERT INTO  aluno (cpf,nome,rua,num,"
                + "compl,curso) "
                + "VALUES(?,?,?,?,?,?)");                       
                // passa o numero da coluna e o valor que deve ser gravado no BD
                // lembrando de usar a funcao setString para setar String e setInt para inteiros.
                psmt.setString(1, testaVazio(a.getCpf()));
                psmt.setString(2,testaVazio(a.getNome()) );
                psmt.setString(3, testaVazio(a.getRua()));
                psmt.setInt(4, a.getNum());
                psmt.setString(5, testaVazio(a.getCompl()));
                psmt.setString(6, testaVazio(a.getCurso()));
                psmt.execute();
                banco.fechaConexao();
                // retorna 1 para informar a função que chama que foi criado com sucesso.
                return 1;            
            }            
        catch (SQLException ex) {
                System.out.println("Error "+ ex.getMessage());// log de erro
                JOptionPane.showMessageDialog(null,"ERRO :( " + ex.getMessage());
                banco.fechaConexao();
                // informar a função que chama que houve erro.
                return  0;

        }
        catch (Exception e) {
                e.printStackTrace();
                banco.fechaConexao();
                // informar a função que chama que houve erro.
                return  0;
        }
    }

    // semelhante a função CREATE 
    // apena observação para WHERE que vai buscar o aluno cujo o cpf é informado pelo objeto aluno que é recebido por paramentro
    public int updateAluno(Aluno a){
        try {   
            PreparedStatement psmt = banco.conn.prepareStatement( "UPDATE aluno SET nome = ?,rua = ?,num = ?, compl = ?, curso = ? "
            + "WHERE cpf = " + a.getCpf()+";");                       

            // Somente salva as informações que podem ser alteradas, 
            psmt.setString(1,testaVazio(a.getNome()) );
            psmt.setString(2, testaVazio(a.getRua()));
            psmt.setInt(3, a.getNum());
            psmt.setString(4, testaVazio(a.getCompl()));
            psmt.setString(5, testaVazio(a.getCurso()));
            psmt.execute();
            banco.fechaConexao();
            // retorna 1 para informar a função que chama que foi criado com sucesso.
            return 1;            
        }            
        catch (SQLException ex) {
            System.out.println("Error "+ ex.getMessage());
            JOptionPane.showMessageDialog(null,"ERRO :( " + ex.getMessage());
            banco.fechaConexao();
            // informar a função que chama que houve erro.
            return  0;

        }
        catch (Exception e) {
            e.printStackTrace();
            banco.fechaConexao();
            // informar a função que chama que houve erro.
            return  0;
        }
    }
}
