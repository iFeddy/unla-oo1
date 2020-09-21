package modelo;

import java.util.ArrayList;
import java.util.List;

public class Comercio {
	private String nombreComercio;
	private long cuit;
	private double costoFijo;
	private double costoPorKm;
	private int diasDescuento;
	private int porcentajeDescuentoDia;
	private int porcentajeDescuentoEfectivo;
	private List<DiaRetiro>lstDiaRetiro;
	private List<Articulo>lstArticulo;
	private List<Carrito>lstCarrito;
	
	public Comercio(String nombreComercio, long cuit, double costoFijo,
			double costoPorKm, int diasDescuento, int porcentajeDescuentoDia,
			int porcentajeDescuentoEfectivo, List<DiaRetiro> lstDiaRetiro,
			List<Articulo> lstArticulo, List<Carrito> lstCarrito) {
		super();
		this.nombreComercio = nombreComercio;
		this.cuit = cuit;
		this.costoFijo = costoFijo;
		this.costoPorKm = costoPorKm;
		this.diasDescuento = diasDescuento;
		this.porcentajeDescuentoDia = porcentajeDescuentoDia;
		this.porcentajeDescuentoEfectivo = porcentajeDescuentoEfectivo;
		this.lstDiaRetiro = new ArrayList<DiaRetiro>();
		this.lstArticulo = new ArrayList<Articulo>();
		this.lstCarrito = new ArrayList<Carrito>();
	}

	public Comercio(){
		this.lstArticulo = new ArrayList<Articulo>();
	}
	
	public String getNombreComercio() {
		return nombreComercio;
	}

	public void setNombreComercio(String nombreComercio) {
		this.nombreComercio = nombreComercio;
	}

	public long getCuit() {
		return cuit;
	}

	public void setCuit(long cuit) {
		this.cuit = cuit;
	}

	public double getCostoFijo() {
		return costoFijo;
	}

	public void setCostoFijo(double costoFijo) {
		this.costoFijo = costoFijo;
	}

	public double getCostoPorKm() {
		return costoPorKm;
	}

	public void setCostoPorKm(double costoPorKm) {
		this.costoPorKm = costoPorKm;
	}

	public int getDiasDescuento() {
		return diasDescuento;
	}

	public void setDiasDescuento(int diasDescuento) {
		this.diasDescuento = diasDescuento;
	}

	public int getPorcentajeDescuentoDia() {
		return porcentajeDescuentoDia;
	}

	public void setPorcentajeDescuentoDia(int porcentajeDescuentoDia) {
		this.porcentajeDescuentoDia = porcentajeDescuentoDia;
	}

	public int getPorcentajeDescuentoEfectivo() {
		return porcentajeDescuentoEfectivo;
	}

	public void setPorcentajeDescuentoEfectivo(int porcentajeDescuentoEfectivo) {
		this.porcentajeDescuentoEfectivo = porcentajeDescuentoEfectivo;
	}

	public List<DiaRetiro> getLstDiaRetiro() {
		return lstDiaRetiro;
	}

	public void setLstDiaRetiro(List<DiaRetiro> lstDiaRetiro) {
		this.lstDiaRetiro = lstDiaRetiro;
	}

	public List<Articulo> getLstArticulo() {
		return lstArticulo;
	}

	public void setLstArticulo(List<Articulo> lstArticulo) {
		this.lstArticulo = lstArticulo;
	}

	public List<Carrito> getLstCarrito() {
		return lstCarrito;
	}

	public void setLstCarrito(List<Carrito> lstCarrito) {
		this.lstCarrito = lstCarrito;
	}

	@Override
	public String toString() {
		return "Comercio [nombreComercio=" + nombreComercio + ", cuit=" + cuit
				+ ", costoFijo=" + costoFijo + ", costoPorKm=" + costoPorKm
				+ ", diasDescuento=" + diasDescuento
				+ ", porcentajeDescuentoDia=" + porcentajeDescuentoDia
				+ ", porcentajeDescuentoEfectivo="
				+ porcentajeDescuentoEfectivo + ", lstDiaRetiro="
				+ lstDiaRetiro + ", lstArticulo=" + lstArticulo
				+ ", lstCarrito=" + lstCarrito + "]";
	}
	
// ARTICULOS 
	// TRAER ARTICULOS POR CODIGO DE BARRAS
	public Articulo traerArticulo(int id) {
		Articulo articulo = null;
		int i = 0;
		while (articulo == null && i < lstArticulo.size()) {
			Articulo art = lstArticulo.get(i);
			if (art.getId() == id) {
				articulo = art;
				System.out.println("Trayendo Articulo... con ID : " + art.getId() + "," + art.getNombre());
			}
			i++;
		}

		return articulo;
	}
	
	// TRAER ARTICULO POR STRING EN EL NOMBRE
	public Articulo traerArticulocodBarras(String codBarras) {		
		Articulo articuloPorcodBarras = null;			
		int i = 0;
		while (articuloPorcodBarras == null && i < lstArticulo.size()) {
			Articulo art = lstArticulo.get(i);
			if (art.getCodBarras().equals(codBarras)) {
				articuloPorcodBarras = art;
				System.out.println("Codigo de Barras Articulo : " + art.getCodBarras());
			}
			i++;
		}		
		return articuloPorcodBarras;
	}
	
	// TRAER ARTICULO POR STRING EN EL NOMBRE
	public Articulo traerArticuloNombre(String nombre) {		
		Articulo articuloPorNombre = null;			
		int i = 0;
		while (articuloPorNombre == null && i < lstArticulo.size()) {
			Articulo art = lstArticulo.get(i);
			if (art.getNombre().equals(nombre)) {
				articuloPorNombre = art;
				System.out.println("Nombre de Articulo : " + art.getNombre());
			}
			i++;
		}		
		return articuloPorNombre;
	}

	// TRAER LISTA DE ARTICULOS POR STRING EN EL NOMBRE 
	public List<Articulo> traerArticulo(String parteNombre) {		
		List<Articulo> articulos = new ArrayList<Articulo>();	
		for (Articulo art : lstArticulo) {
			if (art.getNombre().contains(parteNombre)) {
				articulos.add(art);
			}
		}	
		if(articulos == null || lstArticulo.size() == 0){
			System.out.println("No existen Articulos coincidientes con el String ingresado!");
		}
			System.out.println("Buscando Productos... con String : " + parteNombre);
			return articulos;					
	}

	//AGREGAR ARTICULO
	public boolean agregarArticulo(String nombre,String codBarras, double precio)  throws Exception{
		int id= 0;
		Articulo articulo1 = new Articulo();		
		if(articulo1.isValidBarCodeEAN(codBarras) == false){
			throw new Exception("Codigo de Barras de algun Articulo es no Valido! ");
		}
		if(this.traerArticulocodBarras(codBarras)!= null){
			throw new Exception("Articulo existente , con el mismo codigo de Barras ");
		}
		if (lstArticulo == null || lstArticulo.size() == 0) {
			id = 1;
		} else {
			id = (lstArticulo.size()) + 1;
		}
		return lstArticulo.add(new Articulo(id, nombre,codBarras, precio));
	}

	// MODIFICAR ARTICULO
	public boolean modificarArticulo(int id ,String nombre ,String codigoBarras, double precio) throws Exception{		
			boolean modificada = false;	
			int i = 0;
			if(this.traerArticulo(id)== null){
				throw new Exception("ID de Articulo Inexiste! ");
			}
			if(this.traerArticuloNombre(nombre)!= null){
				throw new Exception("Nombre de Articulo existente! ");
			}else
				while (nombre != null && i < lstArticulo.size()) {
					Articulo art = lstArticulo.get(i);
					if(art.getId() == id){
						art.setNombre(nombre);
						art.setPrecio(precio);						
						 modificada = true; 
					}					 
						 i++;
				 }		
			System.out.println("Modificando nombre del Articulo por : " + nombre);
			return modificada;
		}

	
// CARRITOS
	// TRAER CARRITO POR ID 
	public Carrito traerCarrito(int id){
		Carrito carrito = null;
		int i = 0;
		while(carrito == null && i < lstCarrito.size()){
			Carrito c = lstCarrito.get(i); 
			if(c.getId() == id){
				carrito = c;
				System.out.println("Carrito buscado con ID..." + carrito.getId());				
			}
			i ++ ;
		}		
		return carrito;
	}

}
