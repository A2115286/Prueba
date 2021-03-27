package main.java.uia.com.contabilidad;

import java.util.ArrayList;

import main.java.uia.com.contabilidad.clientes.InfoUIA;
import main.java.uia.com.contabilidad.gestor.DecoradorProveedores;
import main.java.uia.com.contabilidad.gestor.Gestor;
import main.java.uia.com.contabilidad.proveedores.Proveedor;
import main.java.uia.com.presentacion.ClienteJSP;

public class ContabilidadUIA {
		
	    public Gestor contabilidad =  null;
		public DecoradorProveedores gestorProveedores = null;		
		public ArrayList<ClienteJSP> listaProveedores = null;
		public ArrayList<ClienteJSP> listaCuentas = null;
		public ArrayList<ClienteJSP> listaCompras = null;
		public ArrayList<ClienteJSP> listaCheques = null;
		public Proveedor proveedor = null;
		public String clienteId="";

		public ContabilidadUIA()
		{
		 contabilidad = new Gestor("D:\\Ibero\\CUARTO\\ARQUITECTURA_SOFTWARE\\PRE-EXAMEN2\\repositorio_preexamen\\ContabilidadUIA-web-MVC-JSP\\ListaProveedores.json");		
		 gestorProveedores = new DecoradorProveedores(contabilidad, "proveedor");		 
		 gestorProveedores.Print();
		 listaProveedores = gestorProveedores.getLista();
		}
		
		
		public ArrayList<ClienteJSP> getListaProveedores(String clienteName) {
			System.out.println("Estoy en ContabilidadUIA GETLISTAPROVEEDORES 1");
			return listaProveedores;
		}

		public ArrayList<ClienteJSP> getListaProveedores() {
			System.out.println("Estoy en ContabilidadUIA GETLISTAPROVEEDORES 2");
			return listaProveedores;
		}


		public void setListaProveedores(ArrayList<ClienteJSP> listaProveedores) {
			System.out.println("Estoy en ContabilidadUIA sETLISTAPROVEEDORES 3");
			this.listaProveedores = listaProveedores;
		}


		public DecoradorProveedores getGestorProveedores() {
			System.out.println("Estoy en ContabilidadUIA GETgestorPROVEEDORES 4");
			return gestorProveedores;
		}

		public void setGestorProveedores(DecoradorProveedores gestorProveedores) {
			System.out.println("Estoy en ContabilidadUIA sETgestorPROVEEDORES 5");
			this.gestorProveedores = gestorProveedores;
		}


		public ClienteJSP getClienteById(String clienteId) {
			System.out.println("Estoy en ContabilidadUIA GETCLIENTEBYID 6");
			// TODO Auto-generated method stub
			return null;
		}


		public void borraCliente(String clienteId) {
			System.out.println("Estoy en ContabilidadUIA BORRACLIENTE 7");
			// TODO Auto-generated method stub
			
		}


		public ArrayList<ClienteJSP> getAllClientes() {
			System.out.println("Estoy en ContabilidadUIA GETALLCLIENTES 8");
			return null;
		}


		public void checkCliente(ClienteJSP cliente) {
			System.out.println("Estoy en ContabilidadUIA CHECKCLIENTE 9");
			// TODO Auto-generated method stub
			
		}


		public ArrayList<ClienteJSP> getCuentas(String clienteName) 
		{
			System.out.println("Estoy en ContabilidadUIA GETCUENTAS 10-A");
			this.listaCuentas = proveedor.getListaCuentas();
			System.out.println("Estoy en ContabilidadUIA GETCUENTAS 10-B");
			return this.listaCuentas;
		}


		public ArrayList<ClienteJSP> getCompras(String clienteId) {
			System.out.println("Estoy en ContabilidadUIA compras0");
			this.clienteId = clienteId;
			System.out.println("Estoy en ContabilidadUIA compras1");
			proveedor = (Proveedor) this.gestorProveedores.busca(clienteId);
			System.out.println("Estoy en ContabilidadUIA compras2");
			listaCompras = proveedor.getLista();
			System.out.println("Estoy en ContabilidadUIA compras3");
			this.getCuentas(clienteId);
			System.out.println("Estoy en ContabilidadUIA compras4");
			System.out.println  ("dao|getCompras");
			return listaCompras;
		}
		
		public ArrayList<ClienteJSP> getCheques(String clienteId) {
			System.out.println("Estoy en ContabilidadUIA cheques0");
			this.clienteId = clienteId;
			System.out.println("Estoy en ContabilidadUIA cheques1");
			proveedor = (Proveedor) this.gestorProveedores.busca(clienteId);
			System.out.println("Estoy en ContabilidadUIA cheques2");
			listaCheques = proveedor.getListaCheques();
			System.out.println("Estoy en ContabilidadUIA cheques3");
			this.getCuentas(clienteId);
			System.out.println("Estoy en ContabilidadUIA cheques4");
			System.out.println  ("dao|getCheques");
			return listaCheques;
		}

		public ArrayList<ClienteJSP> getListaCompras(String clienteId) {
			System.out.println  ("Estoy en ContabilidadUIA GETLISTACOMPRAS 12-A");
			this.clienteId = clienteId;
			System.out.println  ("Estoy en ContabilidadUIA GETLISTACOMPRAS 12-B");
			getCompras(this.clienteId);
			System.out.println  ("Estoy en ContabilidadUIA GETLISTACOMPRAS 12-C");
			return listaCompras;
		}

		public ArrayList<ClienteJSP> getListaCheques(String clienteId) {
			System.out.println  ("Estoy en ContabilidadUIA GETLISTACHEQUES 13-A");
			this.clienteId = clienteId;
			System.out.println  ("Estoy en ContabilidadUIA GETLISTACHEQUES 13-B");
			getCheques(this.clienteId);
			System.out.println  ("Estoy en ContabilidadUIA GETLISTACHEQUES 13-C");
			return listaCheques;
		}
		
		public ArrayList<ClienteJSP> getListaCompras() {
			System.out.println  ("Estoy en ContabilidadUIA GETLISTACOMPRAS 14");
			return listaCompras;
		}

		public ArrayList<ClienteJSP> getListaCuentas() {
			System.out.println  ("Estoy en ContabilidadUIA GETLISTACUENTAS 15");
			return listaCuentas;
		}
		
		
		public ArrayList<ClienteJSP> getListaCheques() {
			System.out.println  ("Estoy en ContabilidadUIA GETLISTACHEQUES 16");
			return listaCheques;
		}
}
