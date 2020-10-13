package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
	private int id;
	private LocalDate fecha;
	private LocalTime hora;
	private boolean cerrado;
	private double descuento;
	private Cliente cliente;
	private List<ItemCarrito> lstItemCarrito;
	private Entrega entrega;

	public Carrito(int id, LocalDate fecha,LocalTime hora, boolean cerrado, double descuento, Cliente cliente, List<ItemCarrito> lstItemCarrito, Entrega entrega) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.cerrado = cerrado;
		this.descuento = descuento;
		this.cliente = cliente;
		this.lstItemCarrito= new ArrayList<ItemCarrito>();
		//this.entrega = entrega;
		this.setEntrega(entrega);
	}
	
	//Constructor sobrecargado sin Entrega entrega
	public Carrito(int id, LocalDate fecha, LocalTime hora, boolean cerrado, double descuento, Cliente cliente,List<ItemCarrito> lstItemCarrito) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.cerrado = cerrado;
		this.descuento = descuento;
		this.cliente = cliente;
		this.lstItemCarrito = lstItemCarrito;
	}
	
	public Carrito(){
		this.lstItemCarrito = new ArrayList<ItemCarrito>();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public boolean isCerrado() {
		return cerrado;
	}

	public void setCerrado(boolean cerrado) {
		this.cerrado = cerrado;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemCarrito> getLstItemCarrito() {
		return lstItemCarrito;
	}

	public void setLstItemCarrito(List<ItemCarrito> lstItemCarrito) {
		this.lstItemCarrito = lstItemCarrito;
	}

	public Entrega getEntrega() {
		return entrega;
	}

	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}

	@Override
	public String toString() {
		return "Carrito ID: " + id + " \t   Fecha: " + Funciones.fechaCadena(fecha) + " " + hora +"\nCliente: " + cliente + "" + "\nItemCarrito:\n" + lstItemCarrito 
				+ entrega + "";
	}
	
	public boolean equals(Carrito carrito) {
		return (id==carrito.getId());
	}

	/**************************** ITEMS CARRITO *******************************/

	// TRAER ITEMCARRITO POR ARTICULO
	public ItemCarrito traerItemPorArticulo(Articulo articulo) {
		ItemCarrito itemcarrito = null;
		int i = 0;
		while (itemcarrito == null && i < lstItemCarrito.size()) {
			ItemCarrito c = lstItemCarrito.get(i);
			if (c.getArticulo().equals(articulo)) {
				itemcarrito = c;
			}
			i++;
		}
		return itemcarrito;
	}

	// AGREGAR ITEM
	public boolean agregarItem(Articulo articulo, int cantidad) throws Exception {

		// Si traerArticulo(id) devuelve null
		if (articulo == null) {
			throw new Exception("[Error] Articulo Inexistente!");
		}

		// Si el carrito no esta vacio
		if (lstItemCarrito.size() > 0) {
			// Si el Carrito Tiene items
			for (int i = 0; i < lstItemCarrito.size(); i++) {
				ItemCarrito itemCarrito = lstItemCarrito.get(i);
				Articulo articuloCarrito = itemCarrito.getArticulo();
				// Si encuentra el Articulo en la Lista actualiza la Cantidad
				if (articuloCarrito.equals(articulo)) {
					int itemCarritoCantidad = itemCarrito.getCantidad();
					itemCarrito.setCantidad(itemCarritoCantidad + cantidad);
					return true;
				}
			}
		}
		// Si no Actualizo lo crea
		ItemCarrito item = new ItemCarrito(articulo, cantidad);
		lstItemCarrito.add(item);

		return true;
	}

	// MOSTRAR ITEM
	public List<ItemCarrito> mostrarItem(Carrito carrito) {
		List<ItemCarrito> mostrar = new ArrayList<ItemCarrito>();		
		for (ItemCarrito p : carrito.getLstItemCarrito()) {
			mostrar.add(p);
		}
		return mostrar;
	}

	public boolean eliminarItem(Articulo articulo, int cantidad) throws Exception {
		boolean eliminado = false;
		// Si traerArticulo(id) devuelve null
		
		if (articulo == null) {
			throw new Exception("[Error] Articulo Inexistente!");
		}

		if (lstItemCarrito.size() > 0) {
			for (int i = 0; i < lstItemCarrito.size(); i++) {
				ItemCarrito itemCarrito = lstItemCarrito.get(i);
				Articulo articuloCarrito = itemCarrito.getArticulo();
				// Si encuentra el Articulo en la Lista le resta la cantidad
				if (articuloCarrito.equals(articulo)) {
					int itemCarritoCantidad = itemCarrito.getCantidad();
					// Si tiene mas de los que quiere borrar
					if (itemCarritoCantidad > cantidad) {
						itemCarrito.setCantidad(itemCarritoCantidad - cantidad);
					} else {
						// Si tiene = o menos de los que quiere borrar
						lstItemCarrito.remove(i);
					}
					eliminado = true;
				}
			}
		}
		return eliminado;
	}


	// CALCULA TOTAL DEL CARRITO SIN ENVIO
	public double calcularTotalCarrito() {
		double total = 0;
		for (ItemCarrito p : this.getLstItemCarrito()) {
			Articulo articulo = p.getArticulo();
			total = total + (articulo.getPrecio() * p.getCantidad());
		}
		return total;
	}

	// CALCULAR SUBTOTAL DEL ITEM
	public double calcularSubTotalItem(Articulo articulo) {
		double itemPrecio = articulo.getPrecio();
		double subtotal = 0;
		for (ItemCarrito p : this.getLstItemCarrito()) {
			Articulo articuloLista = p.getArticulo();
			if (articuloLista.equals(articulo)) {
				subtotal = itemPrecio * p.getCantidad();
			}
		}
		return subtotal;
	}

	// Calcular Descuento segun dia
	public double calcularDescuentoDia(int diaDescuento, double porcentaje) {
		double descuento = 0;
		double total = this.calcularTotalCarrito();
		if (fecha.getDayOfWeek().getValue() == diaDescuento) {
			descuento = (total * porcentaje) / 100;
		}
		return descuento;
	}

	// Calcular Descuento Efectivo
	public double calcularDescuentoEfectivo(double porcentajeDescuentoEfectivo) {
		double descuento = 0;
		double total = this.calcularTotalCarrito();

		descuento = (total * porcentajeDescuentoEfectivo) / 100;

		return descuento;
	}
	
	//Determino cual descuento es mas efectivo, si por dia o efectivo
	public double calcularDescuentoCarrito(int diaDescuento,double porcentajeDescuentoDia, double porcentajeDescuentoEfectivo) {
		double efectivo= calcularDescuentoEfectivo(porcentajeDescuentoEfectivo);
		double dia= calcularDescuentoDia(diaDescuento,porcentajeDescuentoDia);
		double descuentoMayor=0.0;
		if(efectivo>dia) {
			descuentoMayor=efectivo;
		}
		else {
			descuentoMayor=dia;
		}
		setDescuento(descuentoMayor);
		return getDescuento();
	}
	
	//Dia de Descuento string
	public String descuentoCarritoString(int diaDescuento,double porcentajeDescuentoDia, double porcentajeDescuentoEfectivo) {
		String descuento = "" ;
		double efectivo= calcularDescuentoEfectivo(porcentajeDescuentoEfectivo);
		double dia= calcularDescuentoDia(diaDescuento,porcentajeDescuentoDia);
		if(efectivo>dia) {
			descuento = "Efectivo";
		}
		else {
		descuento = "Del Dia";
		}
		return descuento;
	}
	
	//Total a pagar pero ya con el descuento
		public double totalAPagarCarrito() {
			return calcularTotalCarrito() - descuento;
		}
}
