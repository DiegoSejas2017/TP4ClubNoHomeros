package ar.edu.unlam.club;

import java.util.TreeSet;

public class Bar extends Cliente{
		private TreeSet<Cliente> miSetDeClientes ;	 	
		private Boolean Estado;
		public Boolean getEstado() {
			return Estado;
		}

		public void setEstado(Boolean estado) {
			Estado = estado;
		}
	 	
		public Bar(){
			this.miSetDeClientes = new TreeSet<Cliente>();
			this.Estado = false;
			
		}
		
		public void abrirBar(){
			this.Estado = true;
		}
		
		public void cerrarBar() throws Exception{
			if( miSetDeClientes.size()>=1){
					throw new Exception("No se puede cerrar el bar con clientes adentro");
			}else{
				this.Estado = false;
			}
		}
		
		public void agregarCliente(Cliente objCliente) throws Exception{
			
			if(miSetDeClientes.contains(objCliente)){
					throw new Exception("El Cliente : " + objCliente.getNombre() + " ya esta dentro del bar.");				
			}
			else{
				this.miSetDeClientes.add(objCliente);
			}
		}

		public void mostrarCliente (){
			System.out.println(miSetDeClientes);
		}
		
		public TreeSet<Cliente> getMiSetDeClientes() {
			return miSetDeClientes;
		}

		public void setMiSetDeClientes(TreeSet<Cliente> miSetDeClientes) {
			this.miSetDeClientes = miSetDeClientes;
		}
}
