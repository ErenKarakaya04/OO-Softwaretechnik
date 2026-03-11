import java.security.NoSuchAlgorithmException;

public class Worker extends Thread{
    private int difficulty;
    private String message;
    private SimplePoW process;
    private String result = "";

    public Worker(int difficulty, String message, SimplePoW process){
        this.message = message;
        this.difficulty = difficulty;
        this.process = process;
    }
    @Override
    public void run(){
            try {
                result = SimplePoW.mine(message, difficulty);
                process.stopMining();
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
    }

    public String getResult(){
        return result;
    }
}
