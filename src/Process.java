import java.util.Random;

public class Process {

    private static long idAdd = 0;
    private Long id;
    private String name;
    private int timeExecution;
    private String message;
    
    private Random random = new Random();

    public Process() {

        this.timeExecution = random.nextInt(20) + 1;
        this.id = idAdd++;
        this.name = "Processo " + this.id;
        this.message = "Oi sou o processo com o id " + this.id;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimeExecution() {
        return timeExecution;
    }

    public void setTimeExecution(int timeExecution) {
        this.timeExecution = timeExecution;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Process [id=" + id + ", name=" + name + ", timeExecution=" + timeExecution + ", message=" + message
                + "]";
    }

}