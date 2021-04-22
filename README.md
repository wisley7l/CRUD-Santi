# CRUD-Santi

Código  de CRUD para teste da Santi Soluções Tecnológicas. Desenvolvido no dia 21 de Abril de 2021 e este README no dia 22 de Abril de 2021. 

 O projeto em questão foi desenvolvido da IDE *Netbeans* versão *8.2*

 As telas foram criadas utilizando a interface do *Netbeans*.

 o banco de dados utilizado foi o *SQL SERVER 2019* - Interface do  *MS SQL Server Management Studio 18*

# Biblioteca de Conexão

A biblioteca para conexão entre o JAVA e O banco de dados SQL Server é a **Microsoft JDBC Driver 6.0 for SQL Server**

# Pacotes

Pacotes com nome **santi** se referece as classe de Pessoa, Aluno, ConectBDListDeleteAluno e CriaAtualizaAluno.

## Classe Pessoa
### Atributos da classe
```
public class pessoa {
    private String nome; // nome completo da pessoa
    private String cpf; // cpf
    private String rua;
    private int num;
   private String compl;
```

## Classe Aluno
### Atributos da classe
```
public class Aluno extends pessoa{ // classe aluno Herda da classe pessoa
    private String matricula;
    private String curso;
```

## Classe ConectBDListDeleteAluno

Responsável pela criação da conexão com o banco de dados, as funções desenvolvidas nessa classe são baseadas nas orientações da biblioteca de conexão.


* **createAluno**
```
public int createAluno(Aluno a)
```
Função na qual aciona o SQL para criação da linha aluno na Tabela aluno no banco de dados

* **updateAluno**
```
public int updateAluno(Aluno a)
```
Função na qual aciona o SQL para atualização da linha aluno na Tabela aluno no banco de dados conforme a condição passada pelo cpf do aluno.


Já o pacote **view** se refere as telas da interface criada.

# Dificuldades

* Houve algumas dificuldades na criação da lista, mas após algumas pesquisas foram sanadas.

* Adicionar os botões para editar e excluir também geraram algumas dificuldade de implementação, sanadas conforme a dica da forum: https://www.guj.com.br/t/como-incluir-uma-coluna-com-imagens-em-uma-jtable/41394/2

* Dificuldade para se chamar a tela de Update dentro da tela de lista, nesse caso encontrou-se exemplos no YouTube.
