package animal;

public class Animal {

	//----Atributos----//
	
	private String nombre="";
	private double peso=0.0;
	private int edad=0;
	private boolean estado=false; // True Vivo && Falso Muerto
	public static int numAnimales=7;

	//----Metodos----//

		@Override
		public String toString() {
			return nombre + ": peso:" + peso + ", edad:" + edad;
		}	
		
		
	
	//----Constructores----//
	
	public Animal(String nombre, double peso, int edad, boolean estado) {
		super();
		this.nombre = nombre;
		this.peso = peso;
		this.edad = edad;
		this.estado = estado;
	}	
	
	public Animal() {
		super();
	}		
	//----Setters && Getters----//
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public static int getNumAnimales() {
		return numAnimales;
	}

	public static void setNumAnimales(int numAnimales) {
		Animal.numAnimales = numAnimales;
	}
	
	

}
