import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class yuyue {
	
	public static void main(String[] args) {
		new yuyue().run();
	}
	
	protected void run() {
		String currentState = "";
		String lastEvent = null;
		while (true) {
		}
	}
	
	private String receiveEvent() {
		System.out.flush();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			return br.readLine();
		} catch (IOException ioe) {
			System.out.println("Problem reading input");
			return "";
		}
	}
}
