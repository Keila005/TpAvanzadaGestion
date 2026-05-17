package LogicLayer;
import LogicLayer.Actores;
import javax.swing.JOptionPane;

public class Administrador extends Usuario{
	 private int idAdmin;
	 private String areaEncargado;
	 
	
	public Administrador(String nombre, String apellido, String mail, String contrasenia, int idAdmin,
			String areaEncargado) {
		super(nombre, apellido, mail, contrasenia);
		this.idAdmin = idAdmin;
		this.areaEncargado = areaEncargado;
	}
	public int getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}
	
	public String getAreaEncargado() {
		return areaEncargado;
	}
	public void setAreaEncargado(String areaEncargado) {
		this.areaEncargado = areaEncargado;
	}
	
	
	
	@Override
	public String toString() {
		return "Administrador [idAdmin=" + idAdmin + ", areaEncargado=" + areaEncargado
				+ "]";
	}
	@Override
	public void Menu() {
		String[] opciones = {
				"Gestionar empleados","Registrar proyectos","Ver estadisticas del rendimiento","Solicitudes","Horas extras","Salir"	
			};
			int opcion;
			do {
				opcion = JOptionPane.showOptionDialog(null, "Bienvenido administrador", "", 0, 0, null, opciones, opciones);
				switch (opcion) {
				case 0:
					JOptionPane.showMessageDialog(null, "Ver datos del empleado\nEditar datos del empleado");
					break;
				case 1:
					JOptionPane.showMessageDialog(null, "Crear nuevo proyecto(se define nombre, asignacion de lider y fecha)\nVer proyecto existentes");
					break;
				case 2:
				    String reporte = "=== RENDIMIENTO ===\n";
				    for (Actores a : Usuario.getListusuarios()) {
				        Usuario u = a.getUsuario();
				        if (u instanceof Operativo) {
				            Operativo op = (Operativo) u;
				            reporte += op.getNombre() + " - Rendimiento: " + op.getRendimiento() + "\n";
				        }
				        if (u instanceof Vendedor) {
				            Vendedor ven = (Vendedor) u;
				            reporte += ven.getNombre() + " - Ventas: " + ven.getVentasTotales() + "\n";
				        }
				    }
				    JOptionPane.showMessageDialog(null, reporte);
				    break;
				case 3:
					JOptionPane.showMessageDialog(null, "Aceptar\nRechazar");
					break;
				case 4:
				    String empleado = JOptionPane.showInputDialog("Nombre del empleado:");
				    if (empleado == null || empleado.trim().isEmpty()) {
				        JOptionPane.showMessageDialog(null, "Nombre no válido");
				        break;
				    }
				    
				    String horas = JOptionPane.showInputDialog("Cantidad de horas extra:");
				    if (horas == null || horas.trim().isEmpty()) {
				        JOptionPane.showMessageDialog(null, "Horas no válidas");
				        break;
				    }
				    
				    int horasInt;
				    try {
				        horasInt = Integer.parseInt(horas);
				        if (horasInt < 0) {
				            JOptionPane.showMessageDialog(null, "Las horas no pueden ser negativas");
				            break;
				        }
				        if (horasInt > 20) {
				            JOptionPane.showMessageDialog(null, "Máximo 20 horas extra por semana");
				            break;
				        }
				    } catch (NumberFormatException e) {
				        JOptionPane.showMessageDialog(null, "Ingrese un número válido");
				        break;
				    }
				    
				    JOptionPane.showMessageDialog(null, "Se registraron " + horasInt + " horas extra para " + empleado);
				    break;
				}
			}while(opcion!=5);
	}
	 
	
}
