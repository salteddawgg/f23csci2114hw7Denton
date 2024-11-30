import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;


public final class denton_22 {
	
	public static void main(String[] args) {
		System.out.println(new denton_22().run());
	}
	
	public String run() {
        String[] names = loadNames("0022_names.txt");
		Arrays.sort(names);
		long sum = 0;
		for (int i = 0; i < names.length; i++) {
			int value = 0;
			for (int j = 0; j < names[i].length(); j++)
				value += names[i].charAt(j) - 'A' + 1;
			sum += value * (i + 1);
		}
		return Long.toString(sum);
	}
    private String[] loadNames(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            content = content.replace("\"", ""); 
            return content.split(","); 
        } catch (IOException e) {
            throw new RuntimeException("tf kinda data you feedin me homes: " + filePath, e);
        }
    }
}