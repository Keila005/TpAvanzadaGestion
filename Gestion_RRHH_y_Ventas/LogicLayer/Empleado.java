package LogicLayer;

import java.time.LocalDate;
import javax.swing.JOptionPane;

public class Empleado extends Usuario {
	
	private int idEmpleado;
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
	
	public Empleado(String nombre, String apellido, String mail, String contrasenia, int idEmpleado, int dni,
			double sueldoBase) {
		super(nombre, apellido, mail, contrasenia);
		this.idEmpleado = idEmpleado;
		this.dni = dni;
		this.sueldoBase = sueldoBase;
	}

	public Empleado(String nombre, String apellido, String mail, String contrasenia, int idEmpleado, int dni,
			double sueldoBase, LocalDate fechaContratacion, int faltas) {
		super(nombre, apellido, mail, contrasenia);
		this.idEmpleado = idEmpleado;
		this.dni = dni;
		this.sueldoBase = sueldoBase;
		this.fechaContratacion = fechaContratacion;
		this.faltas = faltas;
	}
	
	
	

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
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
	
	@Override
	public String toString() {
	    return this.getNombre()+ " " + this.getApellido();
	}
	public void SolicitarPermiso() {
    String[] tipos = {"Vacaciones", "Permiso", "Licencia medica"};
    String tipo = (String) JOptionPane.showInputDialog(null, "Tipo de solicitud:", "Solicitud", 
                    JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);
    if (tipo == null) return;
    
    LocalDate hoy = LocalDate.now();
    
    int dia = 0, mes = 0, anio = 0;
    boolean fechaValida = false;
    
    while (!fechaValida) {
        try {
            dia = Integer.parseInt(JOptionPane.showInputDialog("Día de inicio:"));
            mes = Integer.parseInt(JOptionPane.showInputDialog("Mes de inicio:"));
            anio = Integer.parseInt(JOptionPane.showInputDialog("Año de inicio:"));
            
            LocalDate fechaInicio = LocalDate.of(anio, mes, dia);
            
            if (fechaInicio.isBefore(hoy)) {
                JOptionPane.showMessageDialog(null, "La fecha no puede ser anterior a hoy");
            } else {
                fechaValida = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fecha inválida");
        }
    }
    
    String fechaInicio = anio + "-" + String.format("%02d", mes) + "-" + String.format("%02d", dia);
    
    int diaFin = 0, mesFin = 0, anioFin = 0;
    boolean fechaFinValida = false;
    
    while (!fechaFinValida) {
        try {
            diaFin = Integer.parseInt(JOptionPane.showInputDialog("Día de fin:"));
            mesFin = Integer.parseInt(JOptionPane.showInputDialog("Mes de fin:"));
            anioFin = Integer.parseInt(JOptionPane.showInputDialog("Año de fin:"));
            
            LocalDate fechaFinLocal = LocalDate.of(anioFin, mesFin, diaFin);
            LocalDate fechaInicioLocal = LocalDate.of(anio, mes, dia);
            
            if (fechaFinLocal.isBefore(fechaInicioLocal)) {
                JOptionPane.showMessageDialog(null, "La fecha fin no puede ser anterior a la fecha inicio");
            } else {
                fechaFinValida = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fecha inválida");
        }
    }
    
    String fechaFin = anioFin + "-" + String.format("%02d", mesFin) + "-" + String.format("%02d", diaFin);
    
    DLL.ControllerSolicitud cs = new DLL.ControllerSolicitud();
    cs.guardarSolicitud(this.getIdUsuario(), tipo, fechaInicio, fechaFin);
    
    JOptionPane.showMessageDialog(null, "Registrado");	
    }	
	
	
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
	public void verAusencias() {
	    DLL.ControllerAsistencia asis = new DLL.ControllerAsistencia();
	    int idEmpleado = asis.getIdEmpleadoByUsuario(this.getIdUsuario());
	    
	    try {
	        java.sql.ResultSet rs = asis.getAusenciasPorEmpleado(idEmpleado);
	        
	        if (rs == null || !rs.isBeforeFirst()) {
	            JOptionPane.showMessageDialog(null, "No tiene ausencias registradas");
	            return;
	        }
	        
	        String mensaje = "=== MIS AUSENCIAS ===\n\n";
	        while (rs.next()) {
	            mensaje += "Fecha: " + rs.getString("fecha") + "\n";
	        }
	        
	        JOptionPane.showMessageDialog(null, mensaje, "Ausencias", JOptionPane.INFORMATION_MESSAGE);
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Error");
	    }
	}
	@Override
	public  void Menu() {
	}
	
	
	
}
