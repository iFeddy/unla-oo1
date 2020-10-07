# Orientación a Objetos I - Trabajo Práctico Integrador

Sistema de laboratorio para un Comercio: “Almacen Granate”, debe permitir resolver la siguiente funcionalidad:
+ Comprar digitalmente un carrito
+ Gestionar turnos de retiro de la compra
+ Gestionar entrega a domicilio
+ Gestionar ofertas

## Comenzando 🚀

El sistema debe implementar la siguiente funcionalidad:

Validar identificador:
*DNI: el ente nacional para validación de DNI es el ReNaPer para este TP de laboratorio solo
validar que el ingreso sea numérico.
*CUIT: según el Algoritmo: verifica un CUIT de la Guía 6 (Métodos Estáticos y Excepciones)

Casos de Uso:

~~1)  validarIdentificadorUnico (long identificador) : boolean //valida DNI o CUIT según la
    sub-clase 2/3~~
2)  traerHoraRetiro (LocalDate fecha): LocalTime
3)  generarTurnosLibres (LocalDate fecha) : Turno //retorna una lista de objetos Turno libres
4)  traerTurnosOcupados(LocalDate fecha):Turno //retorna una lista de objetos Turno dados
5)  generarAgenda (LocalDate fecha) : Turno //retorna una lista de objetos Turno indicando
    si está ocupado o libre.
~~6)  agregarDiaRetiro(int diaSemana, LocalTime horaDesde, LocalTime horaHasta, int
    intervalo):boolean~~
~~7)  validarCodBarras(String codBarras):boolean //Se valida por el sistema EAN -13
    http://www.alimentosargentinos.gob.ar/contenido/revista/pdfs/07/07_03_codigo.htm~~
~~8)  agregar(Articulo articulo, int cantidad):boolean~~
~~9)  calcularSubTotalItem():double~~
~~10) calcularTotalCarrito() : doble~~
11) calcularDescuentoDia (int diaDescuento, double porcentajeDescuentoDia):double
~~12) calcularDescuentoEfectivo (double porcentajeDescuentoEfectivo): double~~
13) calcularDescuentoCarrito (int diaDescuento, double porcentajeDescuento, double
    porcentajeDescuentoEfectivo) : //determina cual es el descuento mayor
~~14) setDescuento(double descuento): //es optativo definirlo protected si solo se setea por las
    reglas de negocio de descuento~~
15) totalAPagarCarrito() : double
16) setCosto(Ubicacion ubicacion, double costoFijo, double costoPorKm):
~~17) traerUbicacion() : Ubicacion~~

## Construido con 🛠️

* IDE: Eclipse IDE for Enterprise Java Developers https://www.eclipse.org/
* UML: dia 0.97+git live.gnome.org/Dia
* TP Grupal: 4 integrantes
* Evaluación: La evaluación de TP es personal se consideran los aportes de cada integrante al
* trabajo según cada informe y las defensas de cada uno de los integrantes en clase.
* Defensas: En clase por grupos se exponen los avances del proyecto.

## Autores ✒️

Las siguientes personas contribuyeron con la generacion , codifiacion y documentacion del Trabajo. 

* **Perez, Federico** - *Trabajo Inicial* - [FedericoPerez](https://github.com/ifeddy)
* **Piñeyro, Dario Nestor** - *Documentación* - [darioPiñeyro](#fulanito-de-tal)
* **Sejas, Diego Alejandro** - *Documentación* - [DiegoSejas](#fulanito-de-tal)