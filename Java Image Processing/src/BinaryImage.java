import java.awt.Color;
import java.awt.image.BufferedImage;
public class BinaryImage {	//aceasta este clasa folosita doar pentru conversia imaginii in binar.

	private ReadImage inImg; // imaginea ce va fi convertita , declarata de tipul ReadImage
	private double binaryHeight; // lungimea rezultatului
	private double binaryWidth; // latimea rezultatului
	private BufferedImage binaryImage; // imaginea rezultata dupa conversie

	
	BinaryImage() throws InterruptedException // constructor fara parametri care apeleaza constructorul ReadImage
	{
		inImg = new ReadImage();
	}

	BufferedImage ConvertToBinary() throws InterruptedException // metoda ce va realiza conversia in binary
	{
		long startTime = System.nanoTime();

		String filePath = inImg.ReadFile(); // citirea se face prin metoda ReadFile() din clasa ReadImage
		inImg.ReadFromFile(filePath); // se citeste din fisier imaginea
		binaryImage = inImg.img; // pixelii vor fi resetati
		binaryHeight = inImg.getHeight(); // lungimea rezultatului va fi aceeasi
		binaryWidth = inImg.getWidth();// latimea rezultatului va fi aceeasi

		for (int i = 0; i < binaryHeight; i++) {
			for (int j = 0; j < binaryWidth; j++) {

				Color c = new Color(inImg.img.getRGB(j, i)); // descompunem in RGB fiecare culoare a imaginii
				int red = (int) (c.getRed());
				int green = (int) (c.getGreen());
				int blue = (int) (c.getBlue());
				
				int threshold = 127; //threshold-ul folosit pt comparatie, de obicei jumatate din maximul de 255 
				
				if((red + green + blue) / 3 < threshold)	//conversia are loc din grayscale in binary,
															//adica folosim media celor 3 culori in comparatie
															// pentru a face mai usor transformarea din gri in alb-negru
				{
					red = 0;
					green = 0;  // full white
					blue = 0;
				}
				else
				{	
					red = 255;
					green = 255; // full black
					blue = 255;
				}
				
				Color newColor = new Color(red, green, blue); // este preluata noua culoare de full white/full black

				
				binaryImage.setRGB(j, i, newColor.getRGB()); // pixelul respectiv preia valoarea noua
			}
		}

		long endTime = System.nanoTime();
		double totalTime = endTime - startTime; // se calculeaza timpul de executie
		System.out.println("Execution time for Binary COnversion: " + totalTime / 1000000000 + " secunde");

		return binaryImage;
	}

}
