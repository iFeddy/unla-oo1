package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
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
		this.lstDiaRetiro = lstDiaRetiro;
		this.lstArticulo = lstArticulo;
		this.lstCarrito = lstCarrito;
		//this.lstDiaRetiro = new ArrayList<DiaRetiro>();
		//this.lstArticulo = new ArrayList<Articulo>();
		//this.setLstCarrito(new ArrayList<Carrito>());
	}

	// Constructor sobrecargado
	public Comercio(int id, Contacto contacto, String nombreComercio, long cuit, double costoFijo, double costoPorKm,
			int diasDescuento, int porcentajeDescuentoDia, int porcentajeDescuentoEfectivo) throws Exception {
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
		//this.lstCarrito = new ArrayList<Carrito>();	
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
		System.out.println("ID         NOMBRE                      COD.BARRAS              PRECIO ");
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
	public void addLstCarrito(Carrito carrito) {
		lstCarrito.add(carrito);
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
		// serie por el numero en la misma posicion
		for (int i = 0; i < 10; i++) {
			aux += Integer.valueOf(cuitArray[i]) * serie[i];
		}
		// Hacemos como se especifica: 11 menos el resto de la division de la suma de
		// productos anterior por 11
		aux = 11 - (aux % 11);
		// Si el resultado anterior es 11 el codigo es 0
		if (aux == 11) {
			aux = 0;
			// o si el resultado anterior es 10 el codigo es 9
		} else if (aux == 10) {
			aux = 9;
		}
		return Objects.equals(Integer.valueOf(cuitArray[10]), aux);
	}

	@Override
	public String toString() {
		return "Contacto  " + super.contacto + " \nInformaci\u00f3n  \nNombre: " + nombreComercio + "\nCuit: " + cuit
				+ "\nCosto Fijo de envio: " + "$" + costoFijo + "\nCosto Por Km: " + "$" + costoPorKm
				+ "\nDia de Descuento: " + Funciones.diaSemana(diasDescuento) + " - Porcentaje de descuento : "
				+ porcentajeDescuentoDia + "%" + "\nPorcentaje de descuento en Efectivo: " + porcentajeDescuentoEfectivo
				+ "%" + "\n" + "\nDias de Retiro: " + lstDiaRetiro + "\n" + "\nArticulos: " + lstArticulo + "\n"
				+ "\nCarritos: " + lstCarrito + "";
	}

/****************** ARTICULOS *******************************/

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
		} else if (this.traerArticulocodBarras(codBarras) != null) {
			throw new Exception("Articulo existente , con el mismo codigo de Barras ");
		} else if (lstArticulo.size() > 0) {
			Articulo ultimoId = lstArticulo.get(lstArticulo.size() - 1);
			id = (ultimoId.getId() + 1);
		}
		return lstArticulo.add(new Articulo(id, nombre, codBarras, precio));
	}

	// MODIFICAR ARTICULO
	public boolean modificarArticulo(int id, String nombre, String codigoBarras, double precio) throws Exception {
		boolean modificada = false;
		int i = 0;
		Articulo articulo1 = new Articulo();
		if (!(articulo1.isValidBarCodeEAN(codigoBarras))) {
			throw new Exception("Codigo de Barras del Articulo invalido! ");
		} else if (this.traerArticulo(id) == null) {
			throw new Exception("ID del Articulo Inexistente! ");
		} else {
			while (nombre != null && i < lstArticulo.size()) {
				Articulo art = lstArticulo.get(i);
				if (art.getId() == id) {
					art.setNombre(nombre);
					art.setPrecio(precio);
					modificada = true;
				}
				i++;
			}
			System.out
					.println("Modificando nombre del Articulo por: " + nombre + ", y precio actualizado a: $" + precio);
		}
		return modificada;
	}

	// ELIMINAR ARTICULO
	public boolean eliminarArticulo(int id) throws Exception {
		boolean eliminado = false;
		int i = 0;
		if (this.traerArticulo(id) == null) {
			throw new Exception("ID de Articulo Inexistente! ");
		}
		while (lstArticulo != null && i < lstArticulo.size()) {
			Articulo art = lstArticulo.get(i);
			if (art.getId() == id) {
				lstArticulo.remove(i);
				eliminado = true;
			}
			i++;
		}
		System.out.println("ID: " + id);
		return eliminado;
	}

/************************ CARRITOS *******************************/

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
	public boolean agregarCarrito(LocalDate fecha,LocalTime hora, boolean cerrado, double descuento, Cliente cliente,List<ItemCarrito> lstItemCarrito) throws Exception {
		int id = 1;
		if (lstCarrito.size() > 0) {
			Carrito ultimoId = lstCarrito.get(lstCarrito.size() - 1);
			id = ultimoId.getId() + 1;
		}
		return lstCarrito.add(new Carrito(id, fecha, hora,cerrado, descuento, cliente, lstItemCarrito));
	}

/******************** DIA RETIRO *******************************/
	// TRAER DIA RETIRO POR ID
	public DiaRetiro traerDiaRetiroId(int id) {
		DiaRetiro auxDiaretiro = null;
		int i = 0;
		while (auxDiaretiro == null && i < lstDiaRetiro.size()) {
			DiaRetiro diaRetiro = lstDiaRetiro.get(i);
			if (diaRetiro.getId() == id) {
				auxDiaretiro = diaRetiro;
			}
			i++;
		}
		return auxDiaretiro;
	}

	// TRAER DIA RETIRO POR DIA SEMANA
	public DiaRetiro traerDiaRetiro(int diaSemana) {
		DiaRetiro auxDiaretiro = null;
		int i = 0;
		while (auxDiaretiro == null && i < lstDiaRetiro.size()) {
			DiaRetiro diaRetiro = lstDiaRetiro.get(i);
			if (diaRetiro.getDiaSemana() == diaSemana) {
				auxDiaretiro = diaRetiro;
			}
			i++;
		}
		return auxDiaretiro;
	}

	// AGREGAR DIA RETIRO
	public boolean agregarDiaRetiro(int diaSemana, LocalTime HoraDesde, LocalTime HoraHasta, int intervalo)
			throws Exception {
		int id = 1;
		if (this.traerDiaRetiro(diaSemana) != null) {
			throw new Exception("Ya existe un dia de Retiro igual al ingresado ");
		} else if (lstDiaRetiro.size() > 0) {
			DiaRetiro ultimoId = lstDiaRetiro.get(lstDiaRetiro.size() - 1);
			id = (ultimoId.getId() + 1);
		}
		return lstDiaRetiro.add(new DiaRetiro(id, diaSemana, HoraDesde, HoraHasta, intervalo));
	}

	public LocalTime traerHoraRetiro(LocalDate fecha) throws Exception {
		int indiceLista = buscarIndiceDiaRetiro(fecha);
		LocalTime hora = lstDiaRetiro.get(indiceLista).getHoraDesde();
		while(buscarOcupado(fecha,hora)==true) {	
				hora = hora.plusMinutes(lstDiaRetiro.get(indiceLista).getIntervalo());
		}
		if(hora==lstDiaRetiro.get(indiceLista).getHoraHasta()){
			throw new Exception("El horario excede la hora de retiro ");
		}
				
		return hora;
	}
	
	public List<Turno> generarAgenda(LocalDate fecha) throws Exception {// retorna una lista de objetos Turno indicando si esta ocupado o libre
		List<Turno> agenda = new ArrayList<Turno>();
		int indiceLista = buscarIndiceDiaRetiro(fecha);
		LocalTime hora = lstDiaRetiro.get(indiceLista).getHoraDesde();
		while (hora.isBefore(lstDiaRetiro.get(indiceLista).getHoraHasta())) {
			agenda.add(new Turno(fecha, hora,buscarOcupado(fecha,hora))); 
			// agrego a la lista agenda
			hora = hora.plusMinutes(lstDiaRetiro.get(indiceLista).getIntervalo());
		}
	return agenda;
	}
	private int buscarIndiceDiaRetiro(LocalDate fecha) throws Exception {
		int indiceLista = -1;
		int i = 0;
		while((i < lstDiaRetiro.size())&&(indiceLista==-1)) {
			if (fecha.getDayOfWeek().getValue() == lstDiaRetiro.get(i).getDiaSemana()) {// si coincide con diaSemana
				indiceLista = i;
			}
			i++;
		}
		if (indiceLista == -1)
			throw new Exception("En la fecha ingresada no se realizan entregas: " + fecha);

		return indiceLista;
	}

	// TURNOS
	public List<Turno> generarTurnosLibres(LocalDate fecha) throws Exception {
		List<Turno> agenda = new ArrayList<Turno>();
		int index = buscarPosicionDiaRetiro(fecha);
		LocalTime hora = lstDiaRetiro.get(index).getHoraDesde();		
		//Mientras la hora sea antes
		while (hora.isBefore(lstDiaRetiro.get(index).getHoraHasta())) {
			if (!buscarOcupado(fecha,hora)) {
				//Agregar Turno Vacio
				agenda.add(new Turno(fecha, hora, false));
			}
			//Buscar que no este ocupado el turno	
			hora = hora.plusMinutes(lstDiaRetiro.get(index).getIntervalo());
			
		}
		return agenda;
	}
	
	public List<Turno> traerTurnosOcupados(LocalDate fecha) throws Exception {// retorna una lista de objetos Turno
		List<Turno> agenda = new ArrayList<Turno>();
		int indiceLista = buscarIndiceDiaRetiro(fecha);
		LocalTime hora = lstDiaRetiro.get(indiceLista).getHoraDesde();

		while (hora.isBefore(lstDiaRetiro.get(indiceLista).getHoraHasta())) {// mientras hora sea antes de horaHasta
			if (buscarOcupado(fecha,hora)) {// si el turno SI esta ocupado
				agenda.add(new Turno(fecha, hora, true));// guardo ocupado y lo agrego a la agenda
			}
			hora = hora.plusMinutes(lstDiaRetiro.get(indiceLista).getIntervalo());// sumamos el intervalo
		}
		return agenda;
	}

	private int buscarPosicionDiaRetiro(LocalDate fecha) throws Exception {
		int index = -1;
		int i = 0;
		while(i < lstDiaRetiro.size() && index == -1) {
			if (fecha.getDayOfWeek().getValue() == lstDiaRetiro.get(i).getDiaSemana()) {
				index = i;
			}
			i++;
		}
		if (index == -1){
			throw new Exception("[Error] No se realizan entregas en la fecha ingresada");
		}		

		return index;
	}

	private boolean buscarOcupado(LocalDate fecha,LocalTime hora) {
		boolean ocupado = false;
		int i = 0;
		if (lstCarrito != null) {
			while((i < lstCarrito.size())&&(!ocupado)) {// busquemos si el turno esta asignado a una entrega
				Entrega entrega = lstCarrito.get(i).getEntrega();
				if (entrega instanceof RetiroLocal) {// si la entrega es retiro local
					if (hora == (((RetiroLocal) entrega).getHoraEntrega())&&(fecha==((RetiroLocal) entrega).getFecha()))
						ocupado = true;
				}
				i++;
			}
		}
		return ocupado;
	}
	
}
