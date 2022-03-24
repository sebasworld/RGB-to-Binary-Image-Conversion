public interface ImageFetch 
{	
	String ReadFile(); // metoda pentru citirea de la tastatura a numelui imaginii
	void ReadFromFile(String s) throws InterruptedException; // metoda pentru citirea imaginii din fisier
	
}
