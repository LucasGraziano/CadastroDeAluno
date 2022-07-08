/**
 * Interface da persistência em arquivo
 * 
 * @author Lucas Graziano | Julio Cesar | Gustavo Scacchetti
 * @version 01/06/2022
 */

public interface IPersistencia
{
    public void gravarArquivo(Cadastro cad);

    public void lerArquivo(Cadastro cad);
}
