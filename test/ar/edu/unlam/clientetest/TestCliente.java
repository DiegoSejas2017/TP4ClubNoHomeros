package ar.edu.unlam.clientetest;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.unlam.club.Bar;
import ar.edu.unlam.club.Cliente;
import ar.edu.unlam.club.ClienteComparador;



public class TestCliente {
	@Test
	public void testQueUnBarSeCreeVacio(){
	
		Bar miBar = new Bar();
		
		Integer valorEsperado = 0;
		Integer valorObtenido = miBar.getMiSetDeClientes().size();
		
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void testQueSeAbraElBar(){ 
		
		Bar miBar = new Bar();
		
		miBar.abrirBar();
		
		Assert.assertTrue(miBar.getEstado());
	}
	
	@Test
	public void testQueSeCierreElBar() throws Exception{ 
		
		Bar miBar = new Bar();
		
		miBar.cerrarBar();
		
		Assert.assertFalse(miBar.getEstado());
	}
	
	@Test (expected = Exception.class)
	public void testQueNoSeCierreElBarConClientesDentro() throws Exception{
		
		Bar miBar = new Bar();
		Cliente cliente1 = new Cliente();
		
		cliente1.setNombre("Diego");
		cliente1.setEdad(24);
		
		miBar.agregarCliente(cliente1);
		miBar.cerrarBar();		
	}
	
	@Test
	public void testQueSeAgreguenClientesAlBar() throws Exception{
		
		Bar miBar = new Bar();
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		Cliente cliente3 = new Cliente();
		
		cliente1.setNombre("Juan");
		cliente1.setEdad(18);
		
		cliente2.setNombre("Ana");
		cliente2.setEdad(29);
		
		cliente3.setNombre("Silvia");
		cliente3.setEdad(40);
		
		miBar.agregarCliente(cliente1);
		miBar.agregarCliente(cliente2);
		miBar.agregarCliente(cliente3);
		
		Integer valorEsperado = 3;
		Integer valorObtenido = miBar.getMiSetDeClientes().size();
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test (expected = Exception.class)
	public void testQueNoAdmitaElIngresoDeClientesConMismoNombre() throws Exception{
		
		Bar miBar = new Bar();
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		Cliente cliente3 = new Cliente();
		Cliente cliente4 = new Cliente();
		Cliente cliente5 = new Cliente();
		
		cliente1.setNombre("Diego");
		cliente1.setEdad(23);
		
		cliente4.setNombre("Diego");
		cliente4.setEdad(22);
		
		cliente2.setNombre("Juan");
		cliente2.setEdad(43);
		
		cliente3.setNombre("Pedro");
		cliente3.setEdad(18);
		
		cliente5.setNombre("Pedro");
		cliente5.setEdad(43);
		
		miBar.agregarCliente(cliente1);
		miBar.agregarCliente(cliente2);
		miBar.agregarCliente(cliente3);
		miBar.agregarCliente(cliente4);
		miBar.agregarCliente(cliente5);

		
		Integer valorEsperado = 3;
		Integer valorObtenido = miBar.getMiSetDeClientes().size();
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void testMostrarLosClientesOrdenadosAlfabeticamente() throws Exception{

		Bar miBar = new Bar();

		ClienteComparador miOrdenador = new ClienteComparador();
		miBar.setMiSetDeClientes(new TreeSet<Cliente>(miOrdenador));
		
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		Cliente cliente3 = new Cliente();
		
		cliente1.setNombre("Diego");
		cliente1.setEdad(53);
		
		cliente2.setNombre("Ana");
		cliente2.setEdad(30);
		
		cliente3.setNombre("Juan");
		cliente3.setEdad(28);
		
		miBar.agregarCliente(cliente1);
		miBar.agregarCliente(cliente2);
		miBar.agregarCliente(cliente3);
		
		miBar.mostrarCliente();
		
		Assert.assertTrue(miBar.getMiSetDeClientes().first().getNombre().equals("Ana"));
		Assert.assertTrue(miBar.getMiSetDeClientes().last().getNombre().equals("Juan"));
	}
	
	@Test (expected = Exception.class)
	public void testQueNoAdmitaDuplicadosYOrdeneAlfabeticamente() throws Exception {
		
		Bar miBar = new Bar();
		ClienteComparador miOrdenador = new ClienteComparador();
		miBar.setMiSetDeClientes(new TreeSet<Cliente>(miOrdenador));
		
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		Cliente cliente3 = new Cliente();
		Cliente cliente4 = new Cliente();
		
		cliente1.setNombre("Diego");
		cliente1.setEdad(28);
		
		cliente2.setNombre("Diego");
		cliente2.setEdad(21);
				
		cliente3.setNombre("Fabiana");
		cliente3.setEdad(44);
			
		cliente4.setNombre("Sofia");
		cliente4.setEdad(21);
		
		
		miBar.agregarCliente(cliente1);
		miBar.agregarCliente(cliente2);
		miBar.agregarCliente(cliente3);
		miBar.agregarCliente(cliente4);
		
		miBar.mostrarCliente();
		
		Integer esperado = 3;
		Integer obtenido = miBar.getMiSetDeClientes().size();
		Assert.assertEquals(esperado,obtenido);
		
		Assert.assertTrue(miBar.getMiSetDeClientes().first().getNombre().equals("Diego"));
		Assert.assertTrue(miBar.getMiSetDeClientes().last().getNombre().equals("Sofia"));
	
	
		
	}

	@Test
	public void testQueLosClientesPuedanCompararseUnoDentroYOtroFueraDelBar() throws Exception{
		
		Bar miBar = new Bar();
		
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		Cliente cliente3 = new Cliente();
		Cliente cliente4 = new Cliente();
		
		cliente1.setNombre("Diego");
		cliente1.setEdad(40);
		cliente2.setNombre("Diego");
		cliente2.setEdad(40);
		
		miBar.agregarCliente(cliente1);
		
		Assert.assertTrue(cliente1.equals(cliente2));
		Assert.assertEquals(1,miBar.getMiSetDeClientes().size());
	
	}
	
	@Test
	public void testQueLosClientesSePuedanOrdenarPorEdad() throws Exception{
		
		Bar miBar = new Bar();
		
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		Cliente cliente3 = new Cliente();
		
		cliente1.setEdad(23);
		cliente2.setEdad(20);
		cliente3.setEdad(40);
		
		miBar.agregarCliente(cliente1);
		miBar.agregarCliente(cliente2);
		miBar.agregarCliente(cliente3);
		
		miBar.mostrarCliente();
		
		Assert.assertTrue(miBar.getMiSetDeClientes().first().getEdad().equals(20));
		Assert.assertTrue(miBar.getMiSetDeClientes().last().getEdad().equals(40));

	}

}
