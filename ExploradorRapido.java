/**
 * Explorador rápido que executa tarefas com alta velocidade e eficiência.
 * Implementa Runnable para execução em thread separada.
 */
public class ExploradorRapido extends Explorador{
    
    // * Construtor do explorador cuidadoso.
    public ExploradorRapido(String explorador, String tipo, String tarefa)
    {
        super(explorador, tipo, tarefa);
        super.prioridade = Thread.MAX_PRIORITY;
    }

    public int getPrioridade()
    {
        return super.prioridade;
    }
    
    /**
     * Implementação específica da execução de tarefa para exploradores cuidadosos.
     * Exploradores cuidadosos executam tarefas com mais cautela e precisão.
     * @throws TarefaInvalidaException Se a tarefa for nula ou vazia
     */
    @Override
    public void executarTarefa() throws TarefaInvalidaException {
        if(super.getTarefa() == null || super.getTarefa().trim().isEmpty())
        {
            throw new TarefaInvalidaException("Error: Tarefa invalida para " + super.explorador);
        }
        super.setStatus("Inciando Exploracao...");

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Tarefa de " + super.explorador + " foi interropida");
            Thread.currentThread().interrupt();
        }
    }
    
    /**
     * Método run() executado quando a thread é iniciada.
     * Trata exceções e chama executarTarefa().
     */
    @Override
    public void run() {
        try{
            executarTarefa();
        }
        catch(TarefaInvalidaException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

