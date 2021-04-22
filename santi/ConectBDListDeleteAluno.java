package santi;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

// classe de conexão com Banco de dados SQLSERVER
public class ConectBDListDeleteAluno {
    public String msg;
    public Connection conn;
    public Statement stmt;
    public ResultSet rs;
   
    public ConectBDListDeleteAluno(){
        // parametros conforme orientações da biblioteca de conexão suegeriu
        
        String conect = "jdbc:sqlserver://localhost:1433;"+"databaseName=santi;";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            this.conn = DriverManager.getConnection(conect,"sa","bento1234");
            System.out.println("Conectado com Sucesso!"); // log de conexão

        } catch (SQLException ex) {
            System.out.println("Error "+ ex.getMessage());
            this.msg = ex.getMessage();
        }catch(Exception e){
            System.out.println("Não foi posssivel conectar ao Banco " + e);
            this.msg = "erro : " + e; // log de falha de conexão
        }
    }
    
    // função para fechar conexão com Banco de dados
     public void fechaConexao(){
        if (this.rs != null) try { this.rs.close(); } catch(Exception e) {}
        if (this.stmt != null) try { this.stmt.close(); } catch(Exception e) {}
	if (this.conn != null) try { this.conn.close(); } catch(Exception e) {}
        System.out.println("Conexão Finalizada!");  // log de finalização de conexão
    }
     
     
public ArrayList<Aluno> listAlunos(){
    
    // arrey de alunos cadastrados no banco de dados
    ArrayList<Aluno> listaA = new ArrayList<>();
    	
    try {
          
       	String SQL = "SELECT cpf,nome,rua,num,compl,matricula,curso FROM aluno";
        this.stmt = this.conn.createStatement();
        this.rs = this.stmt.executeQuery(SQL);
            
        // percorre a colunas da busca realizada segundo o codigo SQL
        // e armazena nas respectivas variavéis 
        // em seguida cria o objeto aluno contento aos valores capturados na busca
        // e adciona o aluno na lista de alunos
        while (this.rs.next()) {
            // use .trim() para eliminar espaços vazio vindos da busca SQL
            String nome = this.rs.getString(1).trim();
            String cpf = this.rs.getString(2);            
            String rua = this.rs.getString(3).trim();
            int num = this.rs.getInt(4);
            // testa e complemento é null 
            String compl = "";
            if(this.rs.getString(5) == null){
                compl = "";  
            }else{
                compl = this.rs.getString(5).trim();
            }
            //
            String matricula = this.rs.getString(6).trim();
            String curso = this.rs.getString(7).trim();
            Aluno a = new Aluno( nome, cpf,rua,num,  compl,  matricula, curso);
            listaA.add(a);            
            }
        }
	catch (Exception e) {
		e.printStackTrace();
	}
        this.fechaConexao();
        
        // retorna a lista de alunos para a função que o chama.
        return listaA;	
    } 

public int excluirAluno(String cpf){
    
    try{ 
        String SQL = "  DELETE TOP(1) FROM aluno WHERE cpf = " + cpf;
        this.stmt = this.conn.createStatement();
        this.rs = this.stmt.executeQuery(SQL);
                
        // retona 1 para informa a função que o chama que foi deletado com sucesso.
        return 1;
    }
                    
        catch (SQLException ex) {
            System.out.println("Error "+ ex.getMessage());
            fechaConexao();
            // retorno 1 pois execução de DELETE no SQL não gera resposta
            // e o JAVA captura como erro
            return  1;
        }
        catch (Exception e) {
            e.printStackTrace();
            fechaConexao();
            return  0;
        }
        
    
}
   
}
