package LogicLayer;

import java.time.LocalDate;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import DLL.ControllerComentario;
import DLL.ControllerProducto;
import DLL.ControllerVenta;
import DLL.ControllerStock;
import LogicLayer.detalle_venta;


public class Vendedor extends Empleado {
	
	private int idVendedor;
	private Venta venta;
	private int ventasTotales;
	private static LinkedList<Venta> historialVentas;
	
	private static ControllerComentario comentarioController =
	        new ControllerComentario();
	
	private static ControllerProducto controller =
	        new ControllerProducto();

	
	
	
	public Vendedor(String nombre, String apellido, String mail, String contrasenia, int dni, double sueldoBase,
			LocalDate fechaContratacion, int faltas, int ventasTotales) {
		super(nombre, apellido, mail, contrasenia, dni, sueldoBase, fechaContratacion, faltas);
		this.ventasTotales = ventasTotales;
	}
	

public Vendedor(int idVendedor, int ventasTotales) {
		super();
		this.idVendedor = idVendedor;
		this.ventasTotales = ventasTotales;
	}

	public static ControllerProducto getController() {
	return controller;
}



public static void setController(ControllerProducto controller) {
	Vendedor.controller = controller;
}



	public int getVentasTotales() {
		return ventasTotales;
	}
	public void setVentasTotales(int ventasTotales) {
		this.ventasTotales = ventasTotales;
	}
	public static LinkedList<Venta> getHistorialVentas() {
	    return historialVentas;
	}

	public static void setHistorialVentas(LinkedList<Venta> historialVentas) {
	    Vendedor.historialVentas = historialVentas;
	}
	
	
	@Override
	public void Menu() {
		
		String[] opciones2 = {
				"Stock","Venta","Perfil Laboral","Historial de ventas","Salir"	
			};
			int opcion;
			do {
				opcion = JOptionPane.showOptionDialog(null, "Bienvenido Vendedor", "Menu de Vendedor", 0, 0, null, opciones2, opciones2);
				if(opcion == -1) {
				    opcion = 4; // Salir
				}

				switch (opcion) {
				case 0:
					
					String[] menustock = {
						    "Ver Productos",
						    "Agregar Producto",
						    "Agregar Stock",
						    "Modificar producto",
						    "Eliminar producto",
						    "Salir"
						};
						int opcionstock;
						do {
							opcionstock = JOptionPane.showOptionDialog(null, "Menu de Stock", "Stock", 0, 0, null, menustock, menustock);
							if(opcionstock == -1) {
							    opcionstock = 4;
							}
							switch (opcionstock) {
							
							case 0: // ver productos

							    LinkedList<Producto> productos =
							            controller.mostrarProductos();

							    if(productos.isEmpty()) {

							        JOptionPane.showMessageDialog(
							                null,
							                "No hay productos registrados"
							        );

							    } else {

							        String lista = "";

							        for(Producto p : productos) {

							        	ControllerStock controllerStock =
							        	        new ControllerStock();

							        	lista +=
							        	        "ID: "
							        	        + p.getIdproducto()
							        	        + "\nNombre: "
							        	        + p.getNombre()
							        	        + "\nPrecio: $"
							        	        + p.getPrecio()
							        	        + "\nStock: "
							        	        + controllerStock.obtenerStockActual(
							        	                p.getIdproducto()
							        	        )
							        	        + "\n- - - - - - -\n";
							        }

							        JOptionPane.showMessageDialog(
							                null,
							                lista
							        );
							    }

							    break;
							
							case 1:
							

							    String nombre = JOptionPane.showInputDialog(
							            "Ingrese el nombre del producto"
							    );

							    if(nombre == null) {
							        break;
							    }

							    String precioTexto = JOptionPane.showInputDialog(
							            "Ingrese el precio"
							    );

							    if(precioTexto == null) {
							        break;
							    }

							    double precio = Double.parseDouble(
							            precioTexto
							    );

							    String cantidadTexto = JOptionPane.showInputDialog(
							            "Ingrese stock inicial"
							    );

							    if(cantidadTexto == null) {
							        break;
							    }

							    int cantidad = Integer.parseInt(
							            cantidadTexto
							    );

							    Producto producto = new Producto(
							            0,
							            nombre,
							            precio
							    );

							    ControllerProducto controllerProducto =
							            new ControllerProducto();

							    int idGenerado =
							            controllerProducto.agregarProducto(
							                    producto
							            );

							    producto.setIdproducto(
							            idGenerado
							    );
							    
							    ControllerStock controllerStock =
							            new ControllerStock();

							    controllerStock.registrarMovimiento(

							        new Stock(
							            producto,
							            cantidad,
							            LocalDate.now(),
							            "INGRESO"
							        )
							    );
							
								break; //fin de agregar producto
								
							case 2:// agregar stock
								
								
						

							    Producto productoStock =
							            controller.BuscarProducto();

							    if(productoStock == null) {
							        break;
							    }

							    String cantidadStockTexto =
							            JOptionPane.showInputDialog(
							                    "Ingrese la cantidad a agregar"
							            );

							    if(cantidadStockTexto == null) {
							        break;
							    }

							    int cantidadStock =
							            Integer.parseInt(
							                    cantidadStockTexto
							            );

							    ControllerStock controllerIngreso =
							            new ControllerStock();

							    controllerIngreso.registrarMovimiento(

							        new Stock(
							            productoStock,
							            cantidadStock,
							            LocalDate.now(),
							            "AGREGACION"
							        )
							    );

							    JOptionPane.showMessageDialog(
							            null,
							            "Stock agregado correctamente"
							    );							  
								
								break;// fin de agregar stock
							case 3:// modificar producto
								

							    Producto elegidoM =
							            controller.BuscarProducto();
							    
							    if(elegidoM == null) {
							        break;
							    }

							    if(elegidoM != null) {
							    	
							    	String nuevoNombre = JOptionPane.showInputDialog(
							    	        "Ingrese el nuevo nombre",
							    	        elegidoM.getNombre()
							    	);

							    	if(nuevoNombre == null) {
							    	    break;
							    	}

							    	String nuevoprecioTexto = JOptionPane.showInputDialog(
							    	        "Ingrese el nuevo precio",
							    	        elegidoM.getPrecio()
							    	);

							    	if(nuevoprecioTexto == null) {
							    	    break;
							    	}

							    	double nuevoPrecio =
							    	        Double.parseDouble(nuevoprecioTexto);


							        elegidoM.setNombre(nuevoNombre);
							        elegidoM.setPrecio(nuevoPrecio);

							        controller.modificarProducto(elegidoM);
							    }

							  
								
								break;// fin de modificar producto
								
								
							case 4:

								Producto elegidoE =
						        controller.BuscarProducto();
								

								if(elegidoE == null) {
								    break;
								}

						int confir = JOptionPane.showConfirmDialog(
						        null,
						        "¿Está seguro de eliminar: "
						        + elegidoE.getNombre() + "?"
						);

						if(confir == JOptionPane.YES_OPTION) {

						    controller.eliminarProducto(elegidoE);
						}								
								break;// fin de eliminar producto
							
							}
							}while(opcionstock!=5);//FIN DEL menu stock
					break;
					
			
					
				case 1: 

				    Venta venta = new Venta();
				    
				    venta.setIdVendedor(
				            this.getIdEmpleado()
				    );


				    int seguir = 0;

				    do {

				        Producto producto =
				                controller.BuscarProducto();
				        
				        if(producto == null) {
				            break;
				        }

				        String cantidadTexto =
				                JOptionPane.showInputDialog(
				                        "Ingrese cantidad"
				                );

				        if(cantidadTexto == null) {
				            break;
				        }

				        int cantidad =
				                Integer.parseInt(cantidadTexto);
				        
				        ControllerStock controllerStock =
				                new ControllerStock();				        

				        if(!controllerStock.hayStock(
				                producto.getIdproducto(),
				                cantidad
				        )) {

				            JOptionPane.showMessageDialog(
				                    null,
				                    "No hay stock suficiente"
				            );

				            break;
				        }

				        detalle_venta detalle =
				                new detalle_venta(
				                        producto,
				                        cantidad
				                );

				        venta.agregarDetalle(detalle);
				        
				        ControllerStock registroStock =
				                new ControllerStock();

				        registroStock.registrarMovimiento(

				            new Stock(
				                producto,
				                cantidad,
				                LocalDate.now(),
				                "VENTA"
				            )
				        );

				        seguir = JOptionPane.showConfirmDialog(
				                null,
				                "¿Agregar otra prenda?"
				        );

				    }  while(seguir == JOptionPane.YES_OPTION);
				    
				    

				    if(venta.getDetalles().isEmpty()) {

				    	JOptionPane.showMessageDialog(
				    			null,
				    			"Venta cancelada"
				    			);

				    	break;
				    }
				    
				    
				    String resumen = "";

				    for(detalle_venta d : venta.getDetalles()) {

				        resumen +=
				                d.getProducto().getNombre()
				                + " x "
				                + d.getCantidad()
				                + " = $"
				                + d.getSubtotal()
				                + "\n";
				    }

				    resumen +=
				            "\nTOTAL: $" +
				            venta.calcularTotal();

				    JOptionPane.showMessageDialog(
				            null,
				            resumen
				    );

				    ControllerVenta controllerVenta =
				            new ControllerVenta();

				    controllerVenta.generarVenta(venta);

				    JOptionPane.showMessageDialog(
				            null,
				            "Venta registrada correctamente"
				    );
				    

				   
					
					
					
					break;  //fin de venta
					
				case 2:
					
					String[] menupersonal = {
							"Ver Perfil Laboral","Solicitar vacaciones/permisos","Comentar","Salir"	
						};
						int opcionpersonal;
						do {
							opcionpersonal = JOptionPane.showOptionDialog(null, "Menu de Perfil Laborar", "Perfil Laboral", 0, 0, null, menupersonal, menupersonal);
							if(opcionpersonal == -1) {
							    opcionpersonal = 3;
							}
							
							switch (opcionpersonal) {
							case 0:
								
								//ver perfil laboral
							
								break;
							case 1:
								
								//solicitar vacaciones o permisos
								 SolicitarPermiso();
								
								break;
							case 2: 
								
								String comentario=Validador.ValidarString("Escriba un comentario sobre el clima laboral");
											LocalDate fechaComentario= LocalDate.now();
											String[] sentimientos = {"Positivo","Neutro","Negativo"};

											String sentimiento = (String)JOptionPane.showInputDialog(
											        null,"Seleccione su sentimiento","Comentario Anónimo",
											        JOptionPane.QUESTION_MESSAGE,
											        null,sentimientos,sentimientos[0]
											);
										if(sentimiento != null) {
												comentarioController.agregarComentarios(
														new ComentarioAnonimo(comentario,fechaComentario,sentimiento));
											}
								
								break;// FIN DEL CASE 2 menu personal
							}
							}while(opcionpersonal!=3);//FIN DEL menu personal
					
					break; // 
				case 3:

					ControllerVenta controllerHistorial =
			        new ControllerVenta();

				    LinkedList<Venta> ventas =

				    		controllerHistorial.mostrarVentas(
				                    this.getIdEmpleado()
				            );

				    if(ventas.isEmpty()) {

				        JOptionPane.showMessageDialog(
				                null,
				                "No hay ventas registradas"
				        );

				    } else {

				        String historial = "";

				        for(Venta v : ventas) {

				            historial +=
				                    "ID Venta: "
				                    + v.getIdVenta()
				                    + "\nFecha: "
				                    + v.getFecha()
				                    + "\nTotal: $"
				                    + v.getTotal()
				                    + "\n\n";
				        }

				        JOptionPane.showMessageDialog(
				                null,
				                historial
				        );
				    }

				    break;
				}
				}while(opcion!=4);//FIN DEL MENU PRINCIPAL
	}		
	}
	
	
	
	
