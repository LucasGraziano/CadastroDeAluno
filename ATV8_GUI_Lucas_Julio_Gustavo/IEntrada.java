import Model.Aluno;
/**
 * Interface da entrada.
 * 
 * @author Lucas Graziano | Julio Cesar | Gustavo Scacchetti
 * @version 01/06/2022
 */

public interface IEntrada {
    public String lerNome(); 

    public int lerIdade(); 

    public String lerRa();

    public String lerCurso();

    public float lerNota(); 

    public Aluno criarAluno();
}
