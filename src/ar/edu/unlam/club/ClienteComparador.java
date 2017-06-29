package ar.edu.unlam.club;

import java.util.Comparator;

public class ClienteComparador implements Comparator<Cliente>{

	@Override
	public int compare(Cliente unCliente, Cliente otroCliente) {
		
		return unCliente.getNombre().toUpperCase().compareTo(otroCliente.getNombre().toUpperCase());
	}

}
