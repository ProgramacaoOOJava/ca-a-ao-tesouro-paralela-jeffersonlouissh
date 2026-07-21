import java.util.ArrayList;
import java.util.List;

/**
 * Classe principal que simula a Caça ao Tesouro Paralela.
 * Demonstra o uso de threads, prioridades, tipos (user e daemon) e exceções personalizadas
 * através de diferentes tipos de exploradores.
 */
public class CacaAoTesouroParalela {
    
    public static void main(String[] args) {
        System.out.println("=== CAÇA AO TESOURO PARALELA ===");
        System.out.println("Exploradores em ação: threads, prioridades e exceções em Java\n");
        
        // Lista para gerenciar as threads dos exploradores
        List<Explorador> exploradores = new ArrayList<>();
        // Criando exploradores cuidadosos
        exploradores.add(new ExploradorCuidadoso("Alice", "Cuidadoso", "Vasculhar a carverna"));
        exploradores.add(new ExploradorCuidadoso("Bob", "Cuidadoso", "Mapear a floresta"));
        // Criando exploradores rápidos
        exploradores.add(new ExploradorRapido("Gadriel", "Rapido", "Comandar o exercito"));
        exploradores.add(new ExploradorRapido("Arthur", "Rapido", "Defender a Vila"));
        // Criando um explorador com tarefa inválida para demonstrar exceção
        exploradores.add(new ExploradorRapido("alice", "Arthur", ""));
        
        // Encapsulando exploradores em threads
        List<Thread> threads = new ArrayList<>();
       
        for(int i = 0; i < exploradores.size(); i++)
        {
            Explorador explorador = exploradores.get(i);
            Thread thread;
            thread = new Thread(explorador, explorador.getTarefa());
            // Configurando prioridades das threads
            thread.setPriority(explorador.getPrioridade());

            if(i > 2) {
                // Configurando algumas threads como daemon (tarefas secundárias)
                thread.setDaemon(true);
            }
            // Adicionando threads à lista
            threads.add(thread);
            explorador.exibirStatus();
        }
    
        
        
        // Exibindo informações das threads antes da execução
        System.out.println("\n=== INFORMAÇÕES DAS THREADS ===");
        for(Thread thread : threads)
        {
            System.out.println("Thread: " + thread.getName()
                    + "| Prioridadr: " + thread.getPriority()
                    + "| Daemon: " + thread.isDaemon()
                    + "| Estado: " + thread.getState());
        }
        
        // Iniciando todas as threads
        System.out.println("\n=== INICIANDO EXPLORAÇÃO ===");
        for(Thread thread : threads)
        {
            thread.start();
            System.out.println("Thread: " + thread.getName() + " Iniciada - Estado: " + thread.getState());
        }
        
        // Aguardando conclusão das threads não-daemon
        System.out.println("\n=== AGUARDANDO CONCLUSÃO DOS EXPLORADORES ===");
        for(Thread thread : threads)
        {
            if(!thread.isDaemon()){
                try {
                    thread.join();
                    System.out.println("Thread " + thread.getName() + " Finalizada - Estado: " + thread.getState());
                } catch (InterruptedException e) {
                    System.err.println("Iterrupcao ao aguardar thread " + e.getMessage());
                }

            }
        }
        System.out.println("\n ==== ESTADO FINAL DAS THREADS ====");
        // Verificando estado final das threads
        for(Thread thread : threads)
        {
            System.out.println("Thread: " + thread.getName()
                    + "| Estado: " + thread.getState()
                    + "| Viva: " + thread.isAlive());
        }
        
        System.out.println("\n=== CAÇA AO TESOURO PARALELA FINALIZADA ===");
        System.out.println("Todos os exploradores principais completaram suas missões!");
    }
}

