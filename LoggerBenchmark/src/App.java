import java.time.Duration;
import java.time.LocalTime;

public class App {

    private static final Integer REPEAT = 100000;
    private static final String MENSAGEM = "processamento de string";
    private static final String EXCECAO = "nao foi possivel processar a mensagem";
    private static final Integer NUMERO = 989;

    public static void main(String[] args) throws Exception {
        new App();
    }

    public App() throws InterruptedException{
        System.out.println("# StringBuilder");
        doUsingStringBuilder();
        doUsingConcat();
        doUsingFormat();

        System.out.println("# Concat");
        doUsingConcat();
        doUsingStringBuilder();
        doUsingFormat();

        System.out.println("# Format");
        doUsingFormat();
        doUsingConcat();
        doUsingStringBuilder();
    }

    protected void doUsingFormat(){
        LocalTime start = LocalTime.now();
        for (int i = 0; i < REPEAT; i++){
            LOGGER.debug(String.format("Erro: %s - linha %d  - excecao: %s", MENSAGEM, NUMERO, EXCECAO));
        }
        LocalTime finish = LocalTime.now();

        System.out.println("[FORMAT] Tempo: " + Duration.between(start, finish).toMillis());
    }

    protected void doUsingConcat(){
        LocalTime start = LocalTime.now();
        for (int i = 0; i < REPEAT; i++){
            LOGGER.debug("Erro: " + MENSAGEM + " - linha: " + NUMERO + " - excecao: " + EXCECAO);
        }
        LocalTime finish = LocalTime.now();

        System.out.println("[CONCAT] Tempo: " + Duration.between(start, finish).toMillis());
    }

    protected void doUsingStringBuilder(){
        LocalTime start = LocalTime.now();
        for (int i = 0; i < REPEAT; i++){
            StringBuilder sb = new StringBuilder();
            LOGGER.debug(sb.append("Erro: ").append(MENSAGEM)
            .append(" - linha ").append(NUMERO).
            append(" - excecao: ").append(EXCECAO).toString());
        }
        LocalTime finish = LocalTime.now();

        System.out.println("[STRINGBUILDER] Tempo: " + Duration.between(start, finish).toMillis());
    }
}