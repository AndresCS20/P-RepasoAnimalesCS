package animal;

import java.util.Scanner;
import java.util.Arrays;

public class Principal {
	public static Scanner scString = new Scanner(System.in);
	public static Scanner scInt = new Scanner(System.in);
	
	public static Vaca vaca0=new Vaca("Romera", 230.5, 3, true, "Leche");
	public static Vaca vaca1=new Vaca("Facunda", 205.2, 3, true, "Carne");
	public static Vaca vaca2=new Vaca("Fina", 245.4, 4, true, "Leche");
	public static Vaca vacas[]= {vaca0,vaca1,vaca2};
	
	public static Cerdo cerdo0=new Cerdo("Petro", 90.2, 2, true, "Rosado");
	public static Cerdo cerdos[]= {cerdo0};
	
	public static Oveja oveja0=new Oveja("Mota", 40.0,3, true, "Rizado");
	public static Oveja oveja1=new Oveja("Coral", 50.0,4, true, "Liso");
	public static Oveja oveja2=new Oveja("Cebra", 37.6,1, true, "Rizado");
	public static Oveja ovejas[]= {oveja0,oveja1,oveja2};
	
	public static Animal animales[]= {vaca0,vaca1,vaca2,cerdo0,oveja0,oveja1,oveja2};

	public static void main(String[] args) {
		
		String texto=null;
		int opcion=0;
		double decimal=0;
		int edad=0;
		double pesoanterior=0;
		double pesonuevo=0;
		while (true) {
			do {
			opcion=0;
			System.out.println("MENU PRINCIPAL");
			System.out.println("1.-Listado de animales");
			System.out.println("2.-Mostrar tipo de animal");
			System.out.println("3.-Sumar anyo a un animal");
			System.out.println("4.-Cambiar peso animal");
			System.out.println("5.-Marcar animal como muerto");
			System.out.println("6.-Adquirir nuevo cerdo");
			System.out.println("7.-Listado de animales completo");
			System.out.println("8.-Obtencion de leche");
			System.out.println("9.-Venta de Leche");
			System.out.println("10.-TERMINAR PROGRAMA");

			System.out.println("Introduce un numero (1-10).");
			opcion = introducirNumeroEntero(opcion);
			
			switch (opcion-1) {
			case 0:
				listadoAnimales();
				break;
			case 1:
				opcion = mostrarTipoAnimal(opcion);
				break;
			case 2:
				opcion = sumarAnyoAnimal(opcion);
				break;
			case 3:
				opcion = cambiarPesoAnimal(opcion, decimal);
				break;
			case 4:
				opcion = marcarAnimalMuerto(opcion);
				break;
			case 5:
				adquirirCerdo(opcion, decimal);
				break;
			case 6:
				texto=null;				
				if (Animal.getNumAnimales()>0) {

				System.out.println("[7] LISTADO DE ANIMALES COMPLETO");
				for (int i = 0; i < animales.length; i++) {
					if (animales[i].isEstado()) {
					System.out.println(animales[i]);
					}
				}
		}
				else System.err.println("ERROR: No hay ningún animal vivo.");
					System.out.println("Pulse intro para volver al MENU PRINCIPAL");
					texto = scString.nextLine();
				break;
			case 7:
				System.out.println("HAS ELEGIDO LA OPCIÓN 8");
				break;
			case 8:
				System.out.println("HAS ELEGIDO LA OPCIÓN 9");
				break;
			case 9:
				break;
			default:
				System.err.println("ERROR: Numero Introducido no corresponde con ninguna de las opciones disponibles.");
				break;
			}
			
			}while (opcion<0 || opcion>10);		
			
			if (opcion==10) {
				
				System.out.println("\n|X|Has elegido terminar el programa...");
				break;
				
				}

		}
		
		
		
	}

	private static void adquirirCerdo(int opcion, double decimal) {
		String texto;
		int edad;
		double pesonuevo;
		System.out.println("[6] ADQUIRIR NUEVO CERDO");
		if (!cerdos[0].isEstado()) {
			texto="";
			do {
			System.out.println("Introduce un nombre");
			texto=scString.nextLine();}
			while (texto=="");
			cerdos[0].setNombre(texto);
			
			pesonuevo=0;
			do {
				System.out.println("Introduce el peso");
				pesonuevo = introducirNumeroDecimal(decimal);
			}while(pesonuevo<0);
			
			cerdos[0].setPeso(pesonuevo);
			
			do {
				System.out.println("Introduce la Edad");
				edad = introducirNumeroEntero(opcion);
			}while(edad<0);
			cerdos[0].setEdad(edad);
			cerdos[0].setEstado(true);
			
			texto="";
			do {
				System.out.println("Introduce el color del pelo");
			texto=scString.nextLine();}
			while (texto=="");
			cerdos[0].setColorPelaje(texto);

		}
		else System.err.println("ERROR: Ya hay un cerdo vivo.");
		System.out.println("Pulse intro para volver al MENU PRINCIPAL");
		texto = scString.nextLine();
	}

	private static int marcarAnimalMuerto(int opcion) {
		String texto;
		System.out.println("[5] MARCAR ANIMAL COMO MUERTO");
		if (Animal.getNumAnimales()>0) {

		
		for (int i=0; i<animales.length; i++) {
			
			if (animales[i].isEstado()) {
				System.out.println((i+1)+".-"+animales[i].getNombre());
			}
			
		}
		
		while (true) {
			
			do {
			System.out.println("Elija el animal");
			opcion = introducirNumeroEntero(opcion);
			}while(opcion<1 || opcion>animales.length);
			
			if (animales[opcion - 1].isEstado()) {
				break;
			}
		}
		
		System.out.println("El animal "+animales[opcion-1].getNombre()+" ha muerto.");
		animales[opcion-1].setEstado(false);
		Animal.numAnimales--;
		System.out.println("Quedan "+Animal.getNumAnimales() + " animales vivos");
		}
		else System.err.println("ERROR: No hay ningún animal vivo.");
		System.out.println("Pulse intro para volver al MENU PRINCIPAL");
		texto = scString.nextLine();
		return opcion;
	}

	private static int cambiarPesoAnimal(int opcion, double decimal) {
		String texto;
		double pesoanterior;
		double pesonuevo;
		if (Animal.getNumAnimales()>0) {				
		System.out.println("[4] CAMBIAR PESO ANIMAL");		

		for (int i=0; i<animales.length; i++) {
			
			if (animales[i].isEstado()) {
				System.out.println((i+1)+".-"+animales[i].getNombre() + " peso: "+animales[i].getPeso());
			}
			
		}
		
		while (true) {
			
			do {
			System.out.println("Elija el animal");
			opcion = introducirNumeroEntero(opcion);
			}while(opcion<1 || opcion>animales.length);
			
			if (animales[opcion - 1].isEstado()) {
				break;
			}
		}
		
		pesoanterior=animales[opcion-1].getPeso();

			do {
			System.out.println("Nuevo peso?");
			pesonuevo = introducirNumeroDecimal(decimal);
			}while(pesonuevo<0);
			
			animales[opcion-1].setPeso(pesonuevo);

		if (pesonuevo>pesoanterior) {
			System.out.println(animales[opcion-1].getNombre()+" ha ganado "+(pesonuevo-pesoanterior)+" Kg");	
		}
		
		if (pesonuevo<pesoanterior) {
			System.out.println(animales[opcion-1].getNombre()+" ha perdido "+(pesoanterior-pesonuevo)+" Kg");	
		}
}
		else System.err.println("ERROR: No hay ningún animal vivo.");
		System.out.println("Pulse intro para volver al MENU PRINCIPAL");
		texto = scString.nextLine();
		return opcion;
	}

	private static int sumarAnyoAnimal(int opcion) {
		String texto;
		if (Animal.getNumAnimales()>0) {
		System.out.println("[3] SUMAR ANYO A UN ANIMAL");

		for (int i=0; i<animales.length; i++) {
			
			if (animales[i].isEstado()) {
				System.out.println((i+1)+".-"+animales[i].getNombre() + " edad: "+animales[i].getEdad());
			}
			
		}
		
		while (true) {
			
			do {
			System.out.println("Elija el animal");
			opcion = introducirNumeroEntero(opcion);
			}while(opcion<1 || opcion>animales.length);
			
			if (animales[opcion - 1].isEstado()) {
				break;
			}
		}
		
		animales[opcion-1].setEdad(animales[opcion-1].getEdad()+1);
		
		System.out.println(animales[opcion-1].getNombre()+" ahora tiene "+animales[opcion-1].getEdad()+" anyos");
}
		else System.err.println("ERROR: No hay ningún animal vivo.");
		System.out.println("Pulse intro para volver al MENU PRINCIPAL");
		texto = scString.nextLine();
		return opcion;
	}

	private static int mostrarTipoAnimal(int opcion) {
		String texto;
		texto=null;
		if (Animal.getNumAnimales()>0) {
		System.out.println("[2] MOSTRAR TIPO DE ANIMAL");
		for (int i=0; i<animales.length; i++) {
			if (animales[i].isEstado()) {
			System.out.println((i+1)+".-"+animales[i].getNombre());
				}
		}
		while (true) {
			
			do {
			System.out.println("Elija el animal");
			opcion = introducirNumeroEntero(opcion);
			}while(opcion<1 || opcion>animales.length);
			
			if (animales[opcion - 1].isEstado()) {
				break;
			}
		}
		
		if (animales[opcion - 1] instanceof Vaca) {
			System.out.println(animales[opcion - 1].getNombre() + " es una vaca");
		}
		if (animales[opcion - 1] instanceof Cerdo) {
			System.out.println(animales[opcion - 1].getNombre() + " es una cerdo");
		}
		if (animales[opcion - 1] instanceof Oveja) {
			System.out.println(animales[opcion - 1].getNombre() + " es una oveja");
		}
		}
		else System.err.println("ERROR: No hay ningún animal vivo.");
			System.out.println("Pulse intro para volver al MENU PRINCIPAL");
			texto = scString.nextLine();
		return opcion;
	}

	private static void listadoAnimales() {
		String texto;
		texto=null;				
		if (Animal.getNumAnimales()>0) {

		System.out.println("[1] LISTADO DE ANIMALES");
		for (int i = 0; i < animales.length; i++) {
			if (animales[i].isEstado()) {
			System.out.println(animales[i]);
			}
		}
}
		else System.err.println("ERROR: No hay ningún animal vivo.");
			System.out.println("Pulse intro para volver al MENU PRINCIPAL");
			texto = scString.nextLine();
	}

	private static int introducirNumeroEntero(int opcion) {
		String texto;
		try {
			texto = scString.nextLine();
			opcion = Integer.valueOf(texto);
		} catch (NumberFormatException e) {
			System.err.println("ERROR: No has introducido un numero");
		}
		return opcion;
	}
	
	private static double introducirNumeroDecimal(double decimal) {
		String texto;
		try {
			texto = scString.nextLine();
			decimal = Double.valueOf(texto);
		} catch (NumberFormatException e) {
			System.err.println("ERROR: No has introducido un numero");
		}
		return decimal;
	}
	
}
