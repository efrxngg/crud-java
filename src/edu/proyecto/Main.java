package edu.proyecto;

//Lista
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
//HashMap
import java.util.HashMap;
//HashSet
import java.util.HashSet;
//Iterator
import java.util.Iterator;
//LinkedList
import java.util.LinkedList;
import java.util.List;
//Lambda
import java.util.function.Consumer;
interface StringFunction{String run(String str);}

public class Main {
	
	public static void print(Object it) {
		System.out.println(it);
	}
	
	public static void main(String[] args) {
		
//		ejemplo_lista();
//		ejemplo_linkedList();
//		ejemplo_HashSet();
//		ejemplo_HashMap();
//		ejemplo_iterator();
//		ejemplo_lambda();
	}

	
	public static void ejemplo_lista() {
		List<String> nombres = new ArrayList<String>();
		nombres.add("Efren");
		nombres.add("User_2");
		nombres.add("AUser_3");
		
		print(nombres.size());
		
		Collections.sort(nombres);
		print(nombres);
		
		print(nombres);
		print(nombres.get(0));
		
		nombres.set(2, "Test");
		print(nombres);
		
		nombres.remove(1);
		print(nombres);
		
		nombres.clear();
		print(nombres);
	}	
	
	public static void ejemplo_linkedList() {
//		Es lo mismo que la lista solo que con mas metodos de manipulacion de datos
		LinkedList<String> apellidos = new LinkedList<String>();
		apellidos.add("Galarza");
		apellidos.add("Test");
		apellidos.add("Test 2");
		
		print(apellidos);
		apellidos.addFirst("Hola");
		print(apellidos);
	}
	
	public static void ejemplo_HashSet() {
		HashSet<String> cedulas = new HashSet<>();
		cedulas.add("0954943114");
		cedulas.add("0954943112");
		print(cedulas);
		print(cedulas.contains("0954943114"));
		cedulas.remove("0954943114");
		print(cedulas.size());
		
		
	}

	public static void ejemplo_HashMap() {
		HashMap<Integer, String> usuarios = new HashMap<>();
		usuarios.put(1, "Efren");
		usuarios.put(2, "test");
		usuarios.put(3, "tsetn");
		usuarios.put(4, "fsadn");
		print(usuarios.size());
		print(usuarios.get(1));
		usuarios.remove(usuarios.size() - 1);
		
		print("keys");
		for(Integer i : usuarios.keySet()) {
			print(i);
		}
		print("values");
		for(String i : usuarios.values()) {
			print(i);
		}
	}

	public static void ejemplo_iterator() {
		List<String> ejemplo = Arrays.asList("Efren", "User_1", "User_2");
		Iterator<String> iterador = ejemplo.iterator();
		print(iterador.next());
		
		while(iterador.hasNext()) {
			print(iterador.next());
		}
		
		
	}
	
	
	public static void ejemplo_lambda() {
		List<Integer> contenedor = Arrays.asList(1, 2, 3, 4, 5);
		contenedor.forEach((item)->{
			print(item);
		});
		
		Consumer<Integer> metodo = (n) -> {print(n);};
		contenedor.forEach(metodo);
		
//		Ejemplo lambda con interfas
		StringFunction exclain = (s)-> s + "!";
		printFormatted("Hola", exclain);
		
	}
	
	public static void printFormatted(String str, StringFunction format) {
		String result = format.run(str);
		print(result);
	}

	
}











