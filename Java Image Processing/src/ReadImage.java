import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
//aceasta clasa va realiza citirea fisierului
public class ReadImage extends ImageDimensions implements ImageFetch { 
	
	BufferedImage img; // obiectul imagine in sine
	
	// constructorul fara parametrii apeleaza constructorul din clasa Image
	public ReadImage() throws InterruptedException {
		super();
	}
	
	public ReadImage(double w, double h, BufferedImage im) throws InterruptedException // constructor cu parametri
	{
		long startTime = System.nanoTime(); // timpul de inceput pentru executia metodei
		width = w;
		height = h;
		img = im;

		long endTime = System.nanoTime();
		double totalTime = endTime - startTime; // timpul de stop pentru executia metodei
		System.out.println("Execution time for Image - constructor cu parametri: " + totalTime / 1000000000 + " secunde");
	}

	@Override
	public void printWidth() { // fiecare metoda din clasa parinte Image va fi suprascrisa
		System.out.println("Picture width is: " + width);
	}

	@Override
	public double getWidth() {
		return width;
	}

	@Override
	public void setWidth(double w) {
		width = w;
	}

	@Override
	void printHeight() {
		System.out.println("Picture height is: " + height);
	}

	@Override
	double getHeight() {
		return height;
	}

	@Override
	public void setHeight(double h) {
		height = h;
	}

	public String ReadFile() // citirea de la tastatura a numelui fisierului
	{

		long startTime = System.nanoTime();

		String inputFilePath = null; // numele fisierului de intrare

		try {
			//se pregateste citirea numelui fisierului de la tastatura
			InputStreamReader inp_stream_read = new InputStreamReader(System.in);
			
			// numele fisierului este preluat din buffer printr-un obiect de tip BufferedReader
			BufferedReader br = new BufferedReader(inp_stream_read);
			System.out.println("Write the name of the input file(.bmp):"); // fisierul in care se gaseste imaginea cu extensie .bmp
																							
			inputFilePath = (br.readLine()).toString(); // numele fisierului este preluat in buffer si convertit in tip
														// de date string

			while (!inputFilePath.endsWith(".bmp")) //verificarea extensiei numelui fisierului.
			{
				System.out.println("The file does not have a .bmp extension!"); 
			// daca nu are extensia dorita, se repeta citirea pana cand numele introdus este corect
				inputFilePath = (br.readLine()).toString();
			}
		}

		catch (IOException e) // nu se poate realiza citirea in mod corect
		{
			System.out.println("File can't be found.");
		}

		long endTime = System.nanoTime();
		double totalTime = endTime - startTime; // calculul timpului de executie
		System.out.println("Execution time for reading the input file adress: " + totalTime / 1000000000 + " secunde");

		return inputFilePath; // se va returna numele fisierului
	}
	
	public void ReadFromFile(String s) throws InterruptedException // citirea imaginii din fisier
	{
		long startTime = System.nanoTime();

		try {
			File input = new File(s); // se creaza un obiect de tip file ce va fi prelucrat
			img = ImageIO.read(input); //citirea din fisier
			height = img.getHeight(); // se pastreaza lungimea
			width = img.getWidth(); // se pastreaza latimea
			
		}

		catch (IOException e) // exceptie exemplu: nu se gaseste niciun fisier cu numele dat
		{
			System.out.println("File can not  be found.");
			System.exit(0);
		}

		long endTime = System.nanoTime();
		double totalTime = endTime - startTime; // calculul timpului de executie
		System.out.println("Execution time for Image constructor: " + totalTime / 1000000000 + " secunde");

	}

}
