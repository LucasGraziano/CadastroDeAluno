import Model.Aluno;
import java.io.*;
/**
 * Cadastro de alunos (generalizado).
 * 
 * @author Lucas Graziano | Julio Cesar | Gustavo Scacchetti
 * @version 01/06/2022
 */

public class Cadastro implements java.io.Serializable{
    // Atributos
    //private Aluno cadAlunos[]; // armazenador
    Armazenador Ar = new Armazenador();

    /**
     * Construtor para objetos da classe Cadastro
     * @param qtd quantidade de alunos (maximo)
     */
    public Cadastro() {

    }

    // inserir alunos
    /**
     * Método inserir - insere aluno
     *
     * 
     */
    public void inserir(Aluno aluno){
        Ar.inserir(aluno);
    }

    // remover alunos
    /**
     * Método remover - remove aluno
     *
     *
     */
    public void remover(String ra){
        Ar.remover(ra);
    }

    // listar alunos
    /**
     * Método listar - lista os alunos
     *
     */
    public void listar(){
        Ar.listar(); 
    }

    /**
     * Método iniciarCadastro
     * 
     * Inicia todas as posições do array com null
     *
     */
    /*
    private void iniciarCadastro(){
    for (int i = 0; i < cadAlunos.length; i++) {
    cadAlunos[i] = null;
    }
    }
     */
    public void gravar(PrintWriter pw){
        Ar.gravar(pw);
    }

}
