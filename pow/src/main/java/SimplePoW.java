import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class SimplePoW implements Subject{

	private List<Worker> workers = new ArrayList<>();
	private List<Observer> observers = new ArrayList<>();
	public int difficulty;
	public int threadCount;
	public String message;
	public static volatile boolean isMining;

	public void startMining() {
		String result = "";
		isMining = true;
		for (int i = 0; i < threadCount; i++) {
			workers.add(new Worker(difficulty, message, this));
			workers.get(i).start();
		}

        while (isMining) {
        }

		for (Worker worker : workers){
			if (!worker.getResult().isEmpty()){
				result = worker.getResult();
			}
		}
		notifyObserver(result);
	}

	public void stopMining() {
		isMining = false;
	}

	public static String mine(String message, int difficulty) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		SecureRandom rnd = new SecureRandom();
		String target = "0".repeat(Math.max(0, difficulty));

		while (true) {
			if (!isMining){
				return "";
			}
			long nonce = rnd.nextLong();
			System.out.println(nonce);
			String input = message + nonce;
			byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));
			String hashHex = bytesToHex(hashBytes);
			if (hashHex.startsWith(target)) {
				return nonce + ":" + hashHex;
			}
			if (nonce == Long.MAX_VALUE)
				throw new RuntimeException("Nonce exhausted");
		}
	}

	public static boolean verify(String message, long nonce, int difficulty)
			throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		String input = message + nonce;
		byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));
		String hashHex = bytesToHex(hashBytes);
		String target = "0".repeat(Math.max(0, difficulty));
		return hashHex.startsWith(target);
	}

	private static String bytesToHex(byte[] bytes) {
		StringBuilder sb = new StringBuilder(bytes.length * 2);
		for (byte b : bytes)
			sb.append(String.format("%02x", b));
		return sb.toString();
	}

	@Override
	public void attach(Observer o) {
		observers.add(o);
	}

	@Override
	public void detach(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObserver(String result) {
		for (Observer observer: observers){
			observer.update(result);
		}
	}
}
