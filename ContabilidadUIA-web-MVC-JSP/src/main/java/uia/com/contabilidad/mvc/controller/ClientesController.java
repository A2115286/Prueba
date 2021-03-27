package main.java.uia.com.contabilidad.mvc.controller;


import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import main.java.uia.com.contabilidad.ContabilidadUIA;
import main.java.uia.com.presentacion.ClienteJSP;
import main.java.uia.com.presentacion.Singleton;


@Controller
public class ClientesController {
	

	 // Simply selects the home view to render by returning its name.
	
	private ContabilidadUIA dao = Singleton.getInstance();
	
	@RequestMapping(value = "/compras", method = RequestMethod.GET)
	public String cargaCompras(@RequestParam String clienteName, 
		      ModelMap model)
	{
		System.out.println("Clientes_Controller: Pagina Compras solicitada, locale = ");

		this.dao.getCompras(clienteName);;
		model.addAttribute("clientes", getListaClientes());
		model.addAttribute("clienteActual", this.dao.clienteId);
		model.addAttribute("compras", this.getListaCompras());
		model.addAttribute("cuentas", this.getListaCuentas());
		model.addAttribute("cheques", this.getListaCheques());
		return "verCheques";
	}


	@RequestMapping(value = "/cuentas", method = RequestMethod.GET)
	public String cargaCuentas(@RequestParam String clienteName, 
		      ModelMap model)
	{
		System.out.println("Clientes_Controller: Pagina Cuentas solicitada, locale = ");

		this.dao.getCuentas(clienteName);;
		System.out.println("-clienteController-despues de dao ");
		model.addAttribute("clientes", getListaClientes());
		model.addAttribute("clienteActual", this.dao.clienteId);
		model.addAttribute("compras", this.getListaCompras());
		model.addAttribute("cuentas", this.getListaCuentas());
		model.addAttribute("cheques", this.getListaCheques());
		return "verCuentas";
	}
	
	@RequestMapping(value = "/cheques", method = RequestMethod.GET)
	public String cargaCheques(@RequestParam String clienteName, 
		      ModelMap model)
	{
		System.out.println("Clientes_Controller: Pagina Cheques solicitada, locale = ");

		this.dao.getCheques(clienteName);;
		System.out.println("/cheques1");
		model.addAttribute("clientes", getListaClientes());
		System.out.println("/cheques2");
		model.addAttribute("clienteActual", this.dao.clienteId);
		System.out.println("/cheques3");
		model.addAttribute("compras", this.getListaCompras());
		System.out.println("/cheques4");
		model.addAttribute("cuentas", this.getListaCuentas());
		System.out.println("/cheques5");
		model.addAttribute("cheques", this.getListaCheques());
		System.out.println("/cheques6");
		return "verCheques";
	}
	

	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public String editarCliente(@RequestParam String clienteName, 
		      ModelMap model)
	{
		
		System.out.println("Clientes_Controller: Pagina Editar solicitada, locale = ");

		this.dao.getCompras(clienteName);;
		model.addAttribute("clientes", getListaClientes());
		model.addAttribute("clienteActual", this.dao.clienteId);
		model.addAttribute("compras", this.getListaCompras());
		model.addAttribute("cuentas", this.getListaCuentas());
		return "editar";
	}
	
	

	@ModelAttribute("listaCLientes")
	   public ArrayList<ClienteJSP> getListaClientes() {	
		System.out.println("ClientesController: getListaClientes");
		System.out.println("-");
	      return this.dao.getListaProveedores();
	   }
	
	@ModelAttribute("listaCompras")
	   public ArrayList<ClienteJSP> getListaCompras() {
		System.out.println("ClientesController: getListaCompras");
		System.out.println("-");
	      return this.dao.getListaCompras();		
	   }

	@ModelAttribute("listaCuentas")
	   public ArrayList<ClienteJSP> getListaCuentas() {
		System.out.println("ClientesController: getListaCuentas");
		System.out.println("-");
	      return this.dao.getListaCuentas();
	   }
	
	@ModelAttribute("listaCheques")
	   public ArrayList<ClienteJSP> getListaCheques() {
		System.out.println("ClientesController: getListaCheques");
		System.out.println("-");
	      return this.dao.getListaCheques();
	   }
	
}
