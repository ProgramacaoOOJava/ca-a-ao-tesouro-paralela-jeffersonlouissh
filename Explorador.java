/**
 * Classe abstrata que representa um explorador na Caça ao Tesouro Paralela.
 * Define a estrutura básica para diferentes tipos de exploradores.
 */
public abstract class Explorador implements Runnable{
    
    // * Construtor que inicializa todos os atributos do explorador.
    String explorador;
    String tipo;
    String tarefa;
    String status;
    int prioridade;

    public Explorador(String explorador, String tipo, String tarefa)
    {
        this.explorador = explorador;
        this.tipo = tipo;
        setTarefa(tarefa);
    }

    public void setTarefa(String tarefa)
    {
        this.tarefa = tarefa;
    }

    public String getTarefa()
    {
        return tarefa;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public abstract int getPrioridade();
    
    /**
     * Método abstrato que deve ser implementado pelas subclasses.
     * Define como cada tipo de explorador executa sua tarefa.
     * @throws TarefaInvalidaException Se a tarefa for inválida
     */
    public abstract void executarTarefa() throws TarefaInvalidaException;

    public abstract void run();
    
    /**
     * Exibe o status completo do explorador com formatação clara.
     */
    public void exibirStatus() {
        if(tarefa == null || tarefa.trim().isEmpty())
        {
            System.out.println("\nError: Tarefa invalida para " + explorador);
        }else{
            System.err.println("\n\tExplorador: " + explorador
                + "\n\tTipo: " + tipo
                + "\n\tPrioridade: " + prioridade
                + "\n\tTarefa: " + tarefa
                + "\n\tStatus: " + status);
        }
    }
    
    // Getters para acesso aos atributos encapsulados


}

