import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;

public class Main {

	static public void main(String args[]) throws InterruptedException, IOException {
		long startTime = System.nanoTime();
		
		String outputPath = null; // numele fisierului, declarat initial nul

		BinaryImage obj = new BinaryImage();//creeaza nou obiect de tip BinaryImage

		try {
			 //numele fisierului de iesire (in care este pastrata imaginea binara) este introdus de la tastatura
			//in acelasi mod ca fisierul de intrare
			InputStreamReader inp_stream_read = new InputStreamReader(System.in);
			
			BufferedReader buff_read = new BufferedReader(inp_stream_read);
			System.out.println("Write the name of the output file(.bmp):");
			outputPath = (buff_read.readLine()).toString();

			while (!outputPath.endsWith(".bmp")) {
				System.out.println("The file does not have a .bmp extension!");
				outputPath = (buff_read.readLine()).toString();
			}
		}

		catch (IOException e) {
			System.out.println("File can not be found.");
		}
		File output = new File(outputPath);
		
		ImageIO.write(obj.ConvertToBinary(), "bmp", output); // se apeleaza metoda de conversie si
		System.out.println("Conversion to binary succeeded."); //notificarea corespunzatoare
		
		long endTime = System.nanoTime();
		double totalTime = endTime - startTime; // aici este calculat timpul de executie al metodei main
		System.out.println("Execution time for Main: " + totalTime / 1000000000 + " sec");
	}
}
