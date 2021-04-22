
package santi;

import javax.swing.JOptionPane;



// Declaração de pessoa para cadastros

public class pessoa {
    private String nome; // nome completo da pessoa
    private String cpf; // cpf 
    private String rua; 
    private int num;
    private String compl; 

// contrutor da class
public pessoa (String nome1, String cpf1, String rua1, int num1, String compl1){
    // o valores  atribuitos por referncia no construtor são adiconados no objeto quando criado
    this.nome = nome1;
    this.cpf = cpf1;
    this.rua = rua1;
    this.num = num1;
    this.compl =compl1;        
}

public String getNome(){
    return this.nome;   
}
public String getCpf(){      
    return this.cpf;   
}

public String getRua(){        
    return this.rua;   
}

public int getNum(){        
    return this.num;
}
public String getCompl(){
    return this.compl;
}

}

