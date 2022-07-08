import java.util.Random;
import Model.Aluno;
/**
 * classe: ListaDuplamenteLigada
 *     Implementa a TAD Lista Duplamente Ligada
 * 
 * @author Julio Arakaki
 * @version 20210527
 */
public class ListaDuplamenteLigada implements ILista {
    private NoD inicio; // ref para primeiro elemento
    private NoD fim;    // ref para ultimo elemento

    int qtdNos; // Quantidade de nos
    private Random r = new Random(System.currentTimeMillis());

    /**
     * Construtor da Lista
     */
    public ListaDuplamenteLigada() {   
        setInicio(null);
        setFim(null);
        setQtdNos(0);
    }

    // Setters e Getters
    /**
     * @return endereco do primeiro elemento da lista
     */
    public NoD getInicio() {
        return inicio;
    }

    /**
     * @param inicio endereco do primeiro elemento da lista
     */
    public void setInicio(NoD inicio) {
        this.inicio = inicio;
    }

    /**
     * @return endereco do ultimo elemento da lista
     */
    public NoD getFim() {
        return fim;
    }

    /**
     * @param fim endereco do ultimo elemento da lista
     */
    public void setFim(NoD fim) {
        this.fim = fim;
    }

    /**
     * Metodo getQtdNos
     *
     * @return qtidade de nos
     */
    public int getQtdNos(){
        return this.qtdNos;
    }

    /**
     * Metodo setQtdNos
     *
     * @param qtdNos atualiza qtde de nos
     */
    private void setQtdNos(int qtdNos){
        this.qtdNos = qtdNos;
    }

    /**
     * Verifica se a Lista esta vazia
     * 
     * @return true se estiver vazia e false caso contrario
     * 
     */
    public boolean estaVazia() {
        return (getInicio() == null && getFim() == null); 
    }

    /**
     * Insere um novo No no inicio da Lista
     *  
     */
    public void inserir(Aluno elem) {

        // Cria novo no
        NoD novoNo = new NoD(elem, r.nextLong()); 

        // Insere novo no na Lista (atualizando ponteiros)
        if( estaVazia() ) {   // se a lista estiver vazia
            setFim(novoNo);
        } else {
            getInicio().setAnterior(novoNo); // this.inicio.anterior = novoNo; 
        }
        novoNo.setProximo(getInicio());
        setInicio(novoNo);
        // Incrementa quantidade de nos
        setQtdNos(getQtdNos() + 1);
    }

    /**
     * Insere um novo No no finsl da Lista
     *  
     */
    public void inserirFim(Object elem)    {
        // Cria novo no
        NoD novoNo = new NoD(elem, r.nextLong());  

        // Insere novo no na Lista (atualizando ponteiros)
        if( estaVazia() ) { // se a lista estiver vazia
            setInicio(novoNo);
            //setFim(novoNo);
        } else {
            getFim().setProximo(novoNo); 
            novoNo.setAnterior(getFim());
        }
        setFim(novoNo);
        // Incrementa quantidade de nos
        setQtdNos(getQtdNos() + 1);
    }

    /**
     * Insere um novo No apos um No encontrado (pela chave)
     * 
     * @param chave codigo do elemento a ser encontrado
     * 
     * @param elem elemento a ser inserido
     * 
     * @return true se o o no foi inserido e false caso contrario
     * 
     */
    public boolean inserirApos(long chave, Object elem) {
        NoD noAtual = getInicio(); 

        // percorre a lista em busca do No
        while((Long)noAtual.getId() != chave) {
            noAtual = noAtual.getProximo(); 
            if(noAtual == null) { // nao encontrou posicao
                return false;  
            }
        }

        // Cria novo no
        NoD novoNo = new NoD(elem);

        // Insere novo no na Lista (atualizando ponteiros)
        if(noAtual == getFim()) {
            novoNo.setProximo(null); 
            setFim(novoNo); 
        }
        else {
            novoNo.setProximo(noAtual.getProximo());
            noAtual.getProximo().setAnterior(novoNo);
        }
        novoNo.setAnterior(noAtual);
        noAtual.setProximo(novoNo); 
        // Incrementa quantidade de nos
        setQtdNos(getQtdNos() + 1);

        return true; 
    }

    /**
     * Remove o primeiro No da Lista
     * 
     * @return No removido ou null se a Lista estiver vazia
     * 
     */
    public Aluno removerInicio() {
        NoD temp = null;
        Aluno obj;
        if(getInicio() != null) {
            temp = getInicio();
            if(getInicio().getProximo() == null) {
                setFim(null); 
            } else {
                getInicio().getProximo().setAnterior(null); 
            }
            setInicio(getInicio().getProximo());

            // isola o no removido (remove as referencias para proximo e anterior)
            temp.setProximo(null);
            temp.setAnterior(null);
        }
        // Decrementa qtidade de nos
        setQtdNos(getQtdNos() - 1);
        obj = (Aluno)temp.getConteudo(); // pega conteudo do no removido
        // retorna o no removido
        return (obj);
    }

    public Aluno remover(String ra){
        //inicializando variaveis
        NoD aux = getInicio();
        NoD prox;
        NoD ant;
        Aluno sup;
        Aluno obj = null;
        sup = (Aluno)aux.getConteudo();
        if(!estaVazia()){
            if((getInicio() == getFim()) && (sup.getRa().equals(ra))){
                aux = getInicio();
                setInicio(null);
                setFim(null);
            } else {
                if(sup.getRa().equals(ra)){
                    aux = getInicio();
                    setInicio(aux.getProximo());
                    prox = aux.getProximo();
                    aux.setProximo(prox);
                    prox.setAnterior(aux);//atualizando as posicoes e elminando a posicao com o ra inserido
                } else {
                    aux = aux.getProximo();
                    sup = (Aluno)aux.getConteudo();
                    while(aux.getProximo() != null && !sup.getRa().equals(ra)){
                        aux = aux.getProximo();//pega o proximo de aux
                        sup = (Aluno)aux.getConteudo();
                    }
                    if(sup.getRa().equals(ra)){
                        if(aux.getProximo() == null){
                            setFim(aux); // atualiza ponteiro fim
                            aux = fim; // guarda no a ser removido
                        }
                        prox = aux.getProximo();//pega o proximo de aux
                        ant = aux.getAnterior();//pega o anterior de aux
                        prox.setAnterior(ant); //atualizando as posicoes e elminando a posicao com o ra inserido
                        ant.setProximo(prox);
                    }
                }  
            }
            setQtdNos(getQtdNos() - 1);
            obj = (Aluno)aux.getConteudo(); // pega conteudo do no removido
        }
        return (obj);
    }

    /**
     * Remove o ultimo No da Lista
     * 
     * @return No removido ou null se a Lista estiver vazia
     * 
     */
    public Aluno removerFim() {
        NoD temp = null;
        Aluno obj;
        if(getFim() != null) {

            // Guarda o no
            temp = getFim();

            // Acerta todas as referencias (ponteiros)
            if(getInicio().getProximo() == null) {
                setInicio(null); 
            }
            else {
                getFim().getAnterior().setProximo(null);
            }
            setFim(getFim().getAnterior());

            // isola o no removido (remove as referencias para proximo e anterior)
            temp.setProximo(null);
            temp.setAnterior(null);
        }
        // Decrementa qtidade de nos
        setQtdNos(getQtdNos() - 1);
        obj = (Aluno)temp.getConteudo(); // pega conteudo do no removido
        
        // retorna o no removido
        return (obj);
    }

    /**
     * Remove um No de acordo com uma chave (inteiro)
     * 
     * 0param chave numero inteiro para buscar o no a ser removido
     * 
     * @return No removido ou null caso nao encontre
     * 
     */
    public NoD removerPelaChave(long chave) {
        NoD temp = null; // Ponteiro para percorrer a lista

        if(getInicio() != null) {

            temp = getInicio(); // comeca do nicio

            // Percorre ate encontrar o No, ou retorn null caso nao encontre
            while((Long)temp.getId() != chave) {
                temp = temp.getProximo(); 
                if(temp == null) {
                    return null;                 
                }
            }

            // Acerta todas as referencias (ponteiros)
            if(temp == getInicio()) { // se for inicio
                setInicio(temp.getProximo());
            } else {
                temp.getAnterior().setProximo(temp.getProximo());
            }

            if(temp == getFim()) { // se for fim
                setFim(temp.getAnterior());
            } else {
                temp.getProximo().setAnterior(temp.getAnterior());
            }

            // isola o no removido (remove as referencias para proximo e anterior)
            temp.setProximo(null);
            temp.setAnterior(null);
        }
        // Decrementa qtidade de nos
        setQtdNos(getQtdNos() - 1);

        // retorna o no removido        
        return temp;
    }

    /**
     * Retorna o conteudo da Lista como String (do inicio ate o fim)
     */
    public String toString() {
        String s = "[ ";
        NoD noAtual = getInicio();  // inicia do inicio
        while(noAtual != null) {    // enquanto nao for fim da lista,
            s = s + noAtual.toString() + " ";  // monta os dados como string
            noAtual = noAtual.getProximo();   // vai para o proximo
        }
        s = s + "]";

        return s;
    }

    /**
     * Retorna o conteudo da Lista como String (do fim ate o inicio)
     */
    public String toStringDoFim() {
        String s = "[ ";
        NoD noAtual = getFim();  // inicia no fim

        while(noAtual != null) { // enquanto nao for inicio da lista,
            s = s + noAtual.toString() + " "; // monta os dados como string
            noAtual = noAtual.getAnterior(); // vai para o anterior
        }

        s = s + "]";

        return s;
    }
    
    //listar Alunos
    public void listar(){
        NoD listar = getInicio(); //coloca um No comecando do inicio
        String valores = "[ ";
        if(!estaVazia()){ //verificacao se a lista nao está vazia
            while(listar != null){ //ira rodar ate acabar
                Aluno aux = (Aluno)listar.getConteudo();
                System.out.println(listar.getConteudo());

                listar = listar.getProximo();
            }
        }
    }
}  
