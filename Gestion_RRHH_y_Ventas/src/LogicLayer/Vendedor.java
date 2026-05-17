package LogicLayer;

import java.time.LocalDate;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Vendedor extends Empleado {
	
	private double comision;
	private int ventasTotales;
	private static LinkedList<Venta> historialVenta;
	
	
	
	public Vendedor(String nombre, String apellido, String mail, String contrasenia, int dni, double sueldoBase,
			LocalDate fechaContratacion, int faltas, double comision, int ventasTotales) {
		super(nombre, apellido, mail, contrasenia, dni, sueldoBase, fechaContratacion, faltas);
		this.comision = comision;
		this.ventasTotales = ventasTotales;
	}
	public double getComision() {
		return comision;
	}
	public void setComision(double comision) {
		this.comision = comision;
	}
	public int getVentasTotales() {
		return ventasTotales;
	}
	public void setVentasTotales(int ventasTotales) {
		this.ventasTotales = ventasTotales;
	}
	public static LinkedList<Venta> getHistorialVenta() {
		return historialVenta;
	}
	public static void setHistorialVenta(LinkedList<Venta> historialVenta) {
		Vendedor.historialVenta = historialVenta;
	}
	
	@Override
	public void Menu() {
		String[] opcioneses = {
				"Ver informacion personal","Solicitar vacaciones/permisos","Comentar","Vender","Salir"
//				"Productos disponibles","Ingreso/Egreso del producto","Configurar stock","Historial prendas","Historial ventas","Salir"	
			};
		int opciones;
		do {
			opciones = JOptionPane.showOptionDialog(null, "Bienvenido Vendedor", "Vendedor", 0, 0, null, opcioneses, opcioneses);
			switch (opciones) {
			case 0:
				JOptionPane.showMessageDialog(null, "Datos personales\nFaltas\nSueldo\nBonos\nRendimiento");
				break;
			case 1:
				JOptionPane.showMessageDialog(null, "Se solicita vacaciones o permisos");
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Escribe un comentario y califica su emocion del 1 al 10");
				break;
			case 3:
				String vender[]= {"Ver productos","Ingreso del producto","Registrar venta",
			"Ver historial de ventas","Ver historial de productos","Volver"};
				int elegir;
				do {
					elegir=JOptionPane.showOptionDialog(null, "Elige la accion que quiere realizar","Vendedor", 
							0, 0, null, vender, vender[0]);
					switch (elegir) {
					case 0:
						JOptionPane.showMessageDialog(null, "Se ven todos los productos");
						break;
					case 1:
						JOptionPane.showMessageDialog(null, "Agregar productos");
						break;
					case 2:
						JOptionPane.showMessageDialog(null, "Realizar una venta donde se descuenta la cantidad "
								+ "y genera un comprobante");
						break;
					case 3:
						JOptionPane.showMessageDialog(null, "Se ve el historia de ventas que hizo el vendedor");
						break;
					case 4:
						JOptionPane.showMessageDialog(null, "Se ve el historial de todos los productos vendidos");
						break;

					
					}
				} while (elegir!=5);
			}// FIN DEL SWITCH
			}while(opciones!=4);
		
	}// FIN DEL MENU

	
}// FIN DE LA CLASE
