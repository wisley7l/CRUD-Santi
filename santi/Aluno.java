/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santi;

import javax.swing.JOptionPane;


public class Aluno extends pessoa{ // classe aluno Herda da classe pessoa
   
    private String matricula;
    private String curso;

    // construtor da classe Aluno
    public Aluno(String nome1, String cpf1, String rua1, int num1, String compl1,String matricula1,String curso1){
    super(nome1, cpf1, rua1, num1, compl1);
    this.matricula = matricula1;
    this.curso = curso1;
}

    
    public String getMatricula(){
    return this.matricula;
}
    
    public String getCurso(){
    return this.curso;  
}
    
    @Override
    
    public String getNome(){
    return super.getNome();  
}
    @Override
    public String getCpf(){
    return super.getCpf();
    }
    
    @Override
    public String getRua(){
    return super.getRua();
}

    @Override
    public int getNum(){
    return super.getNum();
}
    
    @Override
    public String getCompl(){
    return super.getCompl();
    }
   // função para exibir no log dados do aluno 
public void exibir(){
    JOptionPane.showMessageDialog(null, 
            "Nome: " + super.getNome()+ "\n"+
            "CPF: " + super.getCpf()+ "\n"+
            "Rua: " + super.getRua()+ "\n"+
            "Nº: " + super.getNum()+ "\n"+
            "Complemento: " + super.getCompl()+ "\n"+
            "Matricula: " + getMatricula()+"\n"+
            "Curso: " + getCurso()
            );
}
    
        
}
