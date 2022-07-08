import Model.Aluno;
import java.io.*;
/**
 * Implementa o cadastro de aluno com Array.
 * 
 * @author Lucas Graziano | Julio Cesar | Gustavo Scacchetti
 * @version 01/06/2022
 */
public class Array implements ILista
{
    int qtd;
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    public Aluno cadAlunos[];

    public Array(int qtd)
    {
        // Cria array com tamanho = qtd
        cadAlunos = new Aluno[qtd];
        this.qtd = qtd;
        setQtd(qtd);
        // Inicia cadastrocom null
        iniciarCadastro();
    }

    public void setQtd(int qtd){
        this.qtd = qtd;
    }

    public int getQtd(){
        return this.qtd;
    }

    /**
     * faz a inserção do aluno quando exite uma posiçao livre
     * 
     * @param  Aluno
     */ 
    public void inserir(Aluno aluno){
        for (int i = 0; i < cadAlunos.length; i++) { // percorre array
            if (cadAlunos[i] == null){ // se existir espaco livre (null), insere aluno
                cadAlunos[i] = aluno;
            }
        }
    }

    /**
     * faz a remocao atraves da String inserida pelo usuário
     * 
     * @param  String ra - ra para ser removido
     * @return aluno removido
     */
    public Aluno remover(String ra){
        for (int i = 0; i < cadAlunos.length; i++) {
            if (cadAlunos[i] != null && cadAlunos[i].getRa().equals(ra)){
                Aluno alunoRemovido = cadAlunos[i];
                cadAlunos[i] = null;
                return alunoRemovido;
            }
        }
        return null;
    }

    /**
     * Método removerInicio
     *
     */
    public Aluno removerInicio(){
        int i = 0;

        if (cadAlunos[i] != null){
            Aluno alunoRemovido = cadAlunos[i];
            cadAlunos[i] = null;
            return alunoRemovido;
        }

        return null;
    }

    /**
     * Método removerFim
     *
     */
    public Aluno removerFim(){
        int i = cadAlunos.length - 1;

        while (cadAlunos[i] == null){
            i--;
        }

        if (cadAlunos[i] != null){
            Aluno alunoRemovido = cadAlunos[i];
            cadAlunos[i] = null;
            return alunoRemovido;
        }

        return null;
    }

    /**
     * Método listar
     *
     */
    public void listar(){
        for (int i = 0; i < cadAlunos.length; i++) {
            if (cadAlunos[i] != null){
                System.out.println(cadAlunos[i]);
            }
        }    
    }

    /**
     * Método iniciarCadastro
     * 
     * Inicia todas as posições do array com null
     *
     */
    private void iniciarCadastro(){
        for (int i = 0; i < cadAlunos.length; i++) {
            cadAlunos[i] = null;
        }
    }

    public void gravar(PrintWriter pw){
        for (int i = 0; i < cadAlunos.length; i++) {
            if (cadAlunos[i] != null){
                pw.print(cadAlunos[i].getDados());
                pw.println();
                //System.out.println(cadAlunos[i]);
            }
        }
    }

    /**
     * Método estaVazia
     * 
     * Verifica se o array está vazio
     *
     */
    public boolean estaVazia(){
        int i = 0;

        while (cadAlunos[i] == null){
            i++;
        }
        if (i == cadAlunos.length - 1){
            return true;
        }

        return false;
    }
}
