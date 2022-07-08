import Model.Aluno;
import java.io.*;
/**
 * Generalização dos cadastros.
 * 
 * @author Lucas Graziano | Julio Cesar | Gustavo Scacchetti
 * @version 01/06/2022
 */

public class Armazenador implements java.io.Serializable
{

    //public Aluno a;

    //Array list = new Array(10);
    ListaLigada list = new ListaLigada();
    ListaDuplamenteLigada dl = new ListaDuplamenteLigada();
    /**
     * Construtor para objetos da classe Cadastro
     */
    public Armazenador()
    {

    }

    public void inserir(Aluno aluno){
        //list.inserir(aluno);
        dl.inserir(aluno);
    }

    public void remover(String ra){
        //list.remover(ra);
        //list.removerInicio();
        //list.removerFim();
        dl.remover(ra);
    }

    public void listar(){
        //list.listar();
        dl.listar();
    }

    public void gravar(PrintWriter pw){
        //list.gravar(pw);
    }

}
