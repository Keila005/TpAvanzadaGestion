package LogicLayer;

import java.time.LocalDate;

public abstract class Empleado extends Usuario {
	
	private int dni;
	private double sueldoBase;
	private LocalDate fechaContratacion;
	private int faltas;
	
	public Empleado() {
		super();
	}

	public Empleado(String nombre, String apellido, String mail, String contrasenia, int dni, double sueldoBase,
			LocalDate fechaContratacion, int faltas) {
		super(nombre, apellido, mail, contrasenia);
		this.dni = dni;
		this.sueldoBase = sueldoBase;
		this.fechaContratacion = fechaContratacion;
		this.faltas = faltas;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public double getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public LocalDate getFechaContratacion() {
		return fechaContratacion;
	}

	public void setFechaContratacion(LocalDate fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}
	public void VerInformacion() {
//		+verDatos();
//		+verSueldo();
//		+verAsistencia();
	}
	public void SolicitarPermiso() {}
	
	public void verSueldo() {
		
		
	    DLL.ControllerSueldo sueldoController = new DLL.ControllerSueldo();
	    
	    int idEmpleado = sueldoController.getIdEmpleadoByUsuario(this.getIdUsuario());
	    
	    if (idEmpleado == -1) {
	        javax.swing.JOptionPane.showMessageDialog(null, "No se encontró información de sueldo");
	        return;
	    }
	    
	    String[] opciones = {"Ultima liquidacion", "Historial completo", "Volver"};
	    int seleccion = javax.swing.JOptionPane.showOptionDialog(
	        null,
	        "Hola " + this.getNombre() + " " + this.getApellido(),
	        "Mi Sueldo",
	        javax.swing.JOptionPane.DEFAULT_OPTION,
	        javax.swing.JOptionPane.INFORMATION_MESSAGE,
	        null,
	        opciones,
	        opciones[0]
	    );
	    
	    if (seleccion == 0) {
	        mostrarUltimaLiquidacion(idEmpleado, sueldoController);
	    } else if (seleccion == 1) {
	        mostrarHistorialSueldos(idEmpleado, sueldoController);
	    }
	}

	private void mostrarUltimaLiquidacion(int idEmpleado, DLL.ControllerSueldo sueldoController) {
	    try {
	        java.sql.ResultSet rs = sueldoController.getUltimaLiquidacion(idEmpleado);
	        
	        if (rs != null && rs.next()) {
	            String nombreCompleto = rs.getString("nombre") + " " + rs.getString("apellido");
	            double sueldoBase = rs.getDouble("sueldo_base");
	            double bonos = rs.getDouble("bonos");
	            double horasExtra = rs.getDouble("horas_extra");
	            double total = rs.getDouble("monto_total");
	            
	            String mensaje = "=== LIQUIDACION DE SUELDO ===\n\n" +
	                            "Empleado: " + nombreCompleto + "\n" +
	                            "DNI: " + rs.getString("dni") + "\n" +
	                            "--------------------------------\n" +
	                            "Sueldo Base: $" + sueldoBase + "\n" +
	                            "Bonos: $" + bonos + "\n" +
	                            "Horas Extra: $" + horasExtra + "\n" +
	                            "--------------------------------\n" +
	                            "TOTAL: $" + total;
	            
	            javax.swing.JOptionPane.showMessageDialog(null, mensaje, "Mi Sueldo", javax.swing.JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            javax.swing.JOptionPane.showMessageDialog(null, "No hay liquidaciones registradas");
	        }
	    } catch (Exception e) {
	    }
	}

	private void mostrarHistorialSueldos(int idEmpleado, DLL.ControllerSueldo sueldoController) {
	    try {
	        java.sql.ResultSet rs = sueldoController.getHistorialLiquidaciones(idEmpleado);
	        
	        if (rs == null) {
	            javax.swing.JOptionPane.showMessageDialog(null, "No hay historial");
	            return;
	        }
	        
	        String historial = "=== HISTORIAL DE SUELDOS ===\n\n";
	        int contador = 1;
	        
	        while (rs.next()) {
	            historial += contador + ". ID: " + rs.getInt("id_liquidacion");
	            historial += " | Base: $" + rs.getDouble("sueldo_base");
	            historial += " | Total: $" + rs.getDouble("monto_total") + "\n";
	            contador++;
	        }
	        
	        javax.swing.JOptionPane.showMessageDialog(null, historial, "Historial", javax.swing.JOptionPane.INFORMATION_MESSAGE);
	        
	    } catch (Exception e) {
	    }
	}

	@Override
	public abstract void Menu();
	
	
	
}
