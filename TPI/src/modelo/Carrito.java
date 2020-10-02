package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
	private int id;
	private LocalDate fecha;
	private boolean cerrado;
	private double descuento;
	private Cliente cliente;
	private List<ItemCarrito>lstItemCarrito;
	private Entrega entrega;
	
	public Carrito(int id, LocalDate fecha, boolean cerrado, double descuento,
			Cliente cliente, List<ItemCarrito> lstItemCarrito, Entrega entrega) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.cerrado = cerrado;
		this.descuento = descuento;
		this.cliente = cliente;
		this.lstItemCarrito = lstItemCarrito;
		this.entrega = entrega;
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
		return "Carrito ID : " + id + ", Fecha : " + fecha + ", Cerrado : "
				+ cerrado + ", Descuento : " + descuento + ", \nCliente : " + cliente
				+ ", \nItemCarrito : \n" + lstItemCarrito + ", \nEntrega : " + entrega
				+ ", ";
	}
	
/****************************  ITEMS CARRITO *******************************/
	
 	// TRAER ITEMCARRITO POR ARTICULO 	
 	public ItemCarrito traerItemPorArticulo(Articulo articulo){
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
 	public boolean agregarItem(Articulo articulo, int cantidad)throws Exception{
 		ItemCarrito itemcarrito = null;
		boolean itemAgregado = false;
		int i = 0;
		Carrito carrito1 = new Carrito();
		if (carrito1.traerItemPorArticulo(articulo)!= null) {
			throw new Exception("Articulo a agregar Inexistente! ");
		} else		 		 		 	
		while (itemcarrito == null && i < lstItemCarrito.size()) {
			ItemCarrito item = lstItemCarrito.get(i);
			Articulo articuloLista = item.getArticulo();
			if (articulo.equals(articuloLista)) {
				itemcarrito = item;
				itemAgregado = true;
				int nuevaCantidad = lstItemCarrito.get(i).getCantidad()+cantidad;
				lstItemCarrito.get(i).setCantidad(nuevaCantidad);
			}
			i++;			
		}
		if (!itemAgregado) {					
			lstItemCarrito.add(new ItemCarrito(articulo,cantidad));			
		}		
		return itemAgregado;		
	}
 	
 	// MMOSTRAR ITEM
 	public List<ItemCarrito> mostrarItem(Carrito carrito){
 		List<ItemCarrito> mostrar = new ArrayList<ItemCarrito>();
 		for(ItemCarrito p : carrito.getLstItemCarrito()){
 			mostrar.add(p);
 		}
 		return mostrar;
 	}
 	
	 // ELIMINAR ITEM
	 // Traer x art
 	public boolean eliminarItem(Articulo articulo, int cantidad)throws Exception{
 		ItemCarrito itemcarrito = null;
		boolean itemEliminado = false;
		int i = 0;
		Carrito carrito1 = new Carrito();
		if (carrito1.traerItemPorArticulo(articulo)!= null) {
			throw new Exception("Articulo a agregar Inexistente! ");
		} else	
		while (itemcarrito == null && i < lstItemCarrito.size()) {
			ItemCarrito item = lstItemCarrito.get(i);
			Articulo articuloLista = item.getArticulo();
			if (articulo.equals(articuloLista)) {
				itemcarrito = item;
				itemEliminado = true;
				int nuevaCantidad = lstItemCarrito.get(i).getCantidad()-cantidad;// resta cantidad a eliminar
				lstItemCarrito.get(i).setCantidad(nuevaCantidad);				//guarda la nueva cantidad
				if(lstItemCarrito.get(i).getCantidad()== 0){			//si cantidad es la misma
					lstItemCarrito.remove(i);							//borra el item de la lista
					System.out.println("Item del carrito eliminado , ya que la cantidad a eliminar es la misma");
				}	
			}
			i++;
		}
			if (!itemEliminado) {
				throw new Exception("Item no encontrado ni eliminado");
				}
			return itemEliminado;
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
	public double calcularSubTotalItem(Articulo articulo){
		double itemPrecio = articulo.getPrecio();
		double subtotal = 0;
		for(ItemCarrito p : this.getLstItemCarrito()){
			Articulo articuloLista = p.getArticulo();
			if(articuloLista.equals(articulo)){
				subtotal = itemPrecio * p.getCantidad();
			}
		}
		return subtotal;
	}
	
	//Calcular Descuento según día
	public double calcularDescuentoDia(int diaDescuento, double porcentaje){
		double descuento = 0;
		double total = this.calcularTotalCarrito();
		if(fecha.getDayOfWeek().getValue() == diaDescuento){
			descuento = (total * porcentaje)/100;
		}
		return descuento;
	}

	//Calcular Descuento Efectivo
	public double calcularDescuentoDia(double porcentajeDescuentoEfectivo){
		double descuento = 0;
		double total = this.calcularTotalCarrito();

		descuento = (total * porcentajeDescuentoEfectivo)/100;

		return descuento;
	}
}

