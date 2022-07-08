import java.io.*;
import Model.Aluno;
import javax.swing.JOptionPane;
/**
 * Write a description of class ArquivoBinario here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArquivoBinario
{
    public File file = null;
    public String arquivo = null;
    public boolean repetir = false;
    public String sn = "S";
    Aluno a;
    /**
     * Constructor for objects of class ArquivoBinario
     */
    public ArquivoBinario()
    {

    }

    public void gravarObj(Cadastro cad){
        Object objeto = null;
        do {
            arquivo = JOptionPane.showInputDialog("Arquivo: ");
            file = new File(arquivo);
            if (file.exists()) {
                sn = JOptionPane.showInputDialog("Arquivo: " + arquivo + " ja existe, pode sobrescreve-lo?(s/n): ");
            }

        } while(sn.toUpperCase().charAt(0) == 'N');
        ObjectOutputStream output = null;
        try {
            output = new ObjectOutputStream(new FileOutputStream(file));
            objeto = (Object) cad; //cast
            output.writeObject(objeto);  // escreve o objeto no arquivo
        } catch(Exception e){
            System.out.println(e.toString());
        } finally {
            try {
                output.close();
            } catch(Exception ex) {
                // Nao faz nada!
            }
        }
    }

    /**
     * Method lerObj
     *
     * @param nomeArq nome do arquivo a ser lido
     * @return Object o objeto lido
     */
    public Object lerObj(Cadastro cad){
        
        // Faz leitura do nome do arquivo
        do {
            repetir = false;
            arquivo = JOptionPane.showInputDialog("Arquivo: ");
            file = new File(arquivo);
            if (!file.exists()) { // Verifica se o qruivo existe
                String sn = JOptionPane.showInputDialog("Arquivo:" + arquivo + " inexistente, deseja tentar de novo?(s/n): ");
                if (sn.toUpperCase().charAt(0) == 'S') {
                    repetir = true;
                } else {
                    System.exit(0);
                }
            }
        } while(repetir);
        
        Object objeto = null; //classe pai
        ObjectInputStream input = null;
        try {
            input = new ObjectInputStream(new FileInputStream(file));
            objeto = (Object)input.readObject();  // le o objeto do arquivo
            cad = (Cadastro) objeto;    //passa o conteúdo do objeto para cadastro
        }
        catch(Exception e){ //caso tenha algum erro, ele entra aqui
            System.out.println(e.toString());
        } finally {
            try {
                input.close();
            } catch(Exception ex) {
                // Nao faz nada!
            }
        }
        return objeto;
    }
}
