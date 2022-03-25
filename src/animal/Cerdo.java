package animal;

public class Cerdo extends Animal {

	//----Atributos----//
	
	private String colorPelaje="";
	public static int numCerdos=1;


	
	//----Metodos----//
	
	
	
	//----Constructores----//
	
	public Cerdo(String nombre, double peso, int edad, boolean estado, String colorPelaje) {
		super(nombre, peso, edad, estado);
		this.colorPelaje = colorPelaje;
	}	
	
	//----Setters && Getters----//
	
	public String getColorPelaje() {
		return colorPelaje;
	}

	public void setColorPelaje(String colorPelaje) {
		this.colorPelaje = colorPelaje;
	}
	public static int getNumCerdos() {
		return numCerdos;
	}
	public static void setNumCerdos(int numCerdos) {
		Cerdo.numCerdos = numCerdos;
	}
}
