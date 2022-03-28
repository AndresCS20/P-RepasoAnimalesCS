package animal;

public class Vaca extends Animal {

	//----Atributos----//
	
	private String uso="";
	public static int numVacas=3;

	
	//----Metodos----//
	@Override
	public String toString() {
		return "vaca: " + this.getNombre() + " " + this.getPeso() + " kg " 
				+ this.getEdad() + " anyos  uso: " + this.uso;
	}	
	
	
	//----Constructores----//
	
	public Vaca(String nombre, double peso, int edad, boolean estado, String uso) {
		super(nombre, peso, edad, estado);
		this.uso = uso;
	}		
	
	//----Setters && Getters----//
	
	public String getUso() {
		return uso;
	}

	public void setUso(String uso) {
		this.uso = uso;
	}
	public static int getNumVacas() {
		return numVacas;
	}
	public static void setNumVacas(int numVacas) {
		Vaca.numVacas = numVacas;
	}	
}
