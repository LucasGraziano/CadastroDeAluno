import Model.Aluno;
/**
 * Interface das Listas (Array e Lista Ligada)
 * 
 * @author Lucas Graziano | Julio Cesar | Gustavo Scacchetti
 * @version 01/06/2022
 */

public interface ILista 
{
    public boolean estaVazia();

    public void inserir(Aluno aluno);

    public Aluno removerInicio();
    
    public Aluno remover(String ra);

    public Aluno removerFim();

    public void listar();
}
