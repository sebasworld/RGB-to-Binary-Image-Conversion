public abstract class ImageDimensions{ // in aceasta clasa are loc definirea de variabile ce corespund
								// dimensiunilor imaginii
	
	protected double width; // latimea imaginii
	protected double height; // lungimea imaginii

	public // functiile de afisare si metodele getter, setter pentru preluare si modificare
	abstract void printWidth();
	abstract void printHeight();
	abstract double getWidth();
	abstract void setWidth(double wdt);
	abstract double getHeight();
	abstract void setHeight(double hgt);
	
	ImageDimensions() {}; // constructorul fara parametrii folosit pt definirea de noi obiecte de acest tip
}