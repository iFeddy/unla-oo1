package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Comercio extends Actor {
	private String nombreComercio;
	private long cuit;
	private double costoFijo;
	private double costoPorKm;
	private int diasDescuento;
	private int porcentajeDescuentoDia;
	private int porcentajeDescuentoEfectivo;
	private List<DiaRetiro> lstDiaRetiro;
	private List<Articulo> lstArticulo;
	private List<Carrito> lstCarrito;

	public Comercio(int id, Contacto contacto, String nombreComercio, long cuit, double costoFijo, double costoPorKm,
			int diasDescuento, int porcentajeDescuentoDia, int porcentajeDescuentoEfectivo,
			List<DiaRetiro> lstDiaRetiro, List<Articulo> lstArticulo, List<Carrito> lstCarrito) throws Exception {
		super(id, contacto);
		this.nombreComercio = nombreComercio;
		this.setCuit(cuit);
		this.costoFijo = costoFijo;
		this.costoPorKm = costoPorKm;
		this.diasDescuento = diasDescuento;
		this.porcentajeDescuentoDia = porcentajeDescuentoDia;
		this.porcentajeDescuentoEfectivo = porcentajeDescuentoEfectivo;
		this.lstDiaRetiro = new ArrayList<DiaRetiro>();
		this.lstArticulo = new ArrayList<Articulo>();
		this.setLstCarrito(new ArrayList<Carrito>());
	}
	public Comercio(int id, String nombreComercio, long cuit, double costoFijo, double costoPorKm,
			int diasDescuento, int porcentajeDescuentoDia, int porcentajeDescuentoEfectivo) throws Exception {
		super(id);
		this.nombreComercio = nombreComercio;
		this.setCuit(cuit);
		this.costoFijo = costoFijo;
		this.costoPorKm = costoPorKm;
		this.diasDescuento = diasDescuento;
		this.porcentajeDescuentoDia = porcentajeDescuentoDia;
		this.porcentajeDescuentoEfectivo = porcentajeDescuentoEfectivo;		
		this.lstDiaRetiro = new ArrayList<DiaRetiro>();
		this.lstArticulo = new ArrayList<Articulo>();
		this.setLstCarrito(new ArrayList<Carrito>());
	}

	public Comercio() {
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

	public void setCuit(long cuit) throws Exception {
		if (this.validarIdentificadorUnico(cuit)) {
			this.cuit = cuit;
		} else {
			throw new Exception("Error: El CUIT no es correcto");
		}
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

	// VALIDAR CUIT
	public boolean validarIdentificadorUnico(long identificador) {
		String cuit = Long.toString(identificador);
		cuit = cuit.replaceAll("[^\\d]", "");
		if (cuit.length() != 11) {
			return false;
		}
		String[] cuitArray = cuit.split("");
		Integer[] serie = { 5, 4, 3, 2, 7, 6, 5, 4, 3, 2 };

		Integer aux = 0;
		// Recorremos las matrices de forma simultanea, sumando los productos de la
		// serie por el número en la misma posición
		for (int i = 0; i < 10; i++) {
			aux += Integer.valueOf(cuitArray[i]) * serie[i];
		}
		// Hacemos como se especifica: 11 menos el resto de la división de la suma de
		// productos anterior por 11
		aux = 11 - (aux % 11);
		// Si el resultado anterior es 11 el código es 0
		if (aux == 11) {
			aux = 0;
			// o si el resultado anterior es 10 el código es 9
		} else if (aux == 10) {
			aux = 9;
		}
		return Objects.equals(Integer.valueOf(cuitArray[10]), aux);
	}

	@Override
	public String toString() {
		return "Comercio: " + nombreComercio + "\nCUIT: " + cuit + "\nCosto Fijo: " + costoFijo + "\nCosto PorKm : "
				+ costoPorKm + "\nDia de Descuento: " + diasDescuento + "\n% Descuento Dia: " + porcentajeDescuentoDia
				+ "\n% Descuento Efectivo:" + porcentajeDescuentoEfectivo + "\nDia Retiro: " + lstDiaRetiro
				+ "\nArticulos: " + lstArticulo + "\nCarritos: " + lstCarrito + "";
	}

/******************  ARTICULOS  *******************************/
	
	// TRAER ARTICULOS POR ID
	public Articulo traerArticulo(int id) {
		Articulo articulo = null;
		int i = 0;
		while (articulo == null && i < lstArticulo.size()) {
			Articulo art = lstArticulo.get(i);
			if (art.getId() == id) {
				articulo = art;
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
				System.out.println("Codigo de Barras : " + art.getCodBarras());
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
		if (articulos == null || lstArticulo.size() == 0) {
			System.out.println("No existen Articulos coincidientes con el String ingresado!");
		}
		System.out.println("Buscando Productos... con String : " + parteNombre);
		return articulos;
	}

	// AGREGAR ARTICULO
	public boolean agregarArticulo(String nombre, String codBarras, double precio) throws Exception {
		int id = 1;
		Articulo articulo1 = new Articulo();
		if (!(articulo1.isValidBarCodeEAN(codBarras))) {
			throw new Exception("Codigo de Barras Articulo invalido! ");
		}
		else if (this.traerArticulocodBarras(codBarras) != null) {
				throw new Exception("Articulo existente , con el mismo codigo de Barras ");
			}
			else if (lstArticulo.size() > 0) {			
				Articulo ultimoId = lstArticulo.get(lstArticulo.size() - 1);
				id = (ultimoId.getId() + 1); 
			}
		return lstArticulo.add(new Articulo(id, nombre, codBarras, precio));
	}

	// MODIFICAR ARTICULO
	public boolean modificarArticulo(int id ,String nombre ,String codigoBarras, double precio) throws Exception{		
		boolean modificada = false;	
		int i = 0;
		Articulo articulo1 = new Articulo();		
		if(!(articulo1.isValidBarCodeEAN(codigoBarras))){
			throw new Exception("Codigo de Barras del Articulo invalido! ");
		}
		else if(this.traerArticulo(id)== null){
			throw new Exception("ID del Articulo Inexistente! ");
			}
			else{
				while (nombre != null && i < lstArticulo.size()) {
					Articulo art = lstArticulo.get(i);
					if(art.getId() == id){
						art.setNombre(nombre);
						art.setPrecio(precio);						
						modificada = true; 
					}					 
					i++;
				}		
				System.out.println("Modificando nombre del Articulo por: " + nombre +", y precio actualizado a: $"+precio);
		}
		return modificada;
	}

	// ELIMINAR ARTICULO
	public boolean eliminarArticulo(int id) throws Exception{
		boolean eliminado = false;
		int i= 0;
		if(this.traerArticulo(id)== null){
			throw new Exception("ID de Articulo Inexistente! ");
		}
		while (lstArticulo != null && i < lstArticulo.size()) {
			Articulo art = lstArticulo.get(i);
			if(art.getId() == id){
				lstArticulo.remove(i);
				 eliminado = true; 
			}					 
				 i++;
		 }		
		System.out.println("ID: " + id );
		return eliminado;
	}

	
/******************  CARRITOS *******************************/
	
	// TRAER CARRITO POR ID
	public Carrito traerCarrito(int id) {
		Carrito carrito = null;
		int i = 0;
		while (carrito == null && i < lstCarrito.size()) {
			Carrito c = lstCarrito.get(i);
			if (c.getId() == id) {
				carrito = c;
			}
			i++;
		}
		return carrito;
	}

	// AGREGAR CARRITO
	public boolean agregarCarrito(LocalDate fecha, boolean cerrado, double descuento, Cliente cliente,
	List<ItemCarrito> lstItemCarrito, Entrega entrega) throws Exception {
		int id = 1;
		Entrega entrega1 = null;

		if (lstCarrito.size() > 0) {
			Carrito ultimoId = lstCarrito.get(lstCarrito.size() - 1);
			id = ultimoId.getId() + 1;
		}
		
		return lstCarrito.add(new Carrito(id, fecha, cerrado, descuento, cliente, lstItemCarrito, entrega1));
	}

}
