package animal;

public class Oveja extends Animal {

	//----Atributos----//
	
	private String tipoPelo="";
	public static int numCerdos=1;

	
	//----Metodos----//
	
	public void listarOveja() {
		System.out.println("oveja: " + this.getNombre() + " " + this.getPeso() + " kg " 
	+ this.getEdad() + " anyos  uso:" + this.tipoPelo);
	}
	
	//----Constructores----//
	
	public Oveja(String nombre, double peso, int edad, boolean estado, String tipoPelo) {
		super(nombre, peso, edad, estado);
		this.tipoPelo = tipoPelo;
	}	
	
	//----Setters && Getters----//

	public String getTipoPelo() {
		return tipoPelo;
	}

	public void setTipoPelo(String tipoPelo) {
		this.tipoPelo = tipoPelo;
	}
	public static int getNumCerdos() {
		return numCerdos;
	}
	public static void setNumCerdos(int numCerdos) {
		Oveja.numCerdos = numCerdos;
	}	
	
}
