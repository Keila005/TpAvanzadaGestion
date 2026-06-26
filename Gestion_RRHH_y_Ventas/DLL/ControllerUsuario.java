package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import LogicLayer.*;


public class ControllerUsuario {

    private static Connection con = Conexion.getInstance().getConnection();

    public Usuario login(String mail, String contrasenia) {

        Usuario usuario = null;

        try {

            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM usuario WHERE email = ?"
            );
            DateTimeFormatter formato =
                    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String fechaHora =LocalDateTime.now().format(formato);
            
            stmt.setString(1, mail);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {

                int idUsuario = rs.getInt("id_usuario");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String pass = rs.getString("contrasenia");
                
                if(Hashing.verificar(contrasenia, pass)) {
                	 // VER SI ES ADMIN
                    PreparedStatement adminStmt = con.prepareStatement(
                        "SELECT * FROM admin_rrhh WHERE id_usuario = ?"
                    );

                    adminStmt.setInt(1, idUsuario);

                    ResultSet adminRs = adminStmt.executeQuery();

                    if(adminRs.next()) {

                        String sector = adminRs.getString("sector");

                       usuario = new Administrador(nombre,apellido,email,pass,idUsuario,sector);

                        return usuario;
                    }

                    // VER SI ES OPERATIVO
                    PreparedStatement operativoStmt = con.prepareStatement(
                        "SELECT * FROM operativo o"
                        + " INNER JOIN empleado e"
                        + " ON o.id_empleado = e.id_empleado"
                        + " WHERE e.id_usuario = ?");

                    operativoStmt.setInt(1, idUsuario);

                    ResultSet opRs = operativoStmt.executeQuery();

                    if(opRs.next()) {

                        String rolDB = opRs.getString("rol");

                        Roles rol;

                        if(rolDB.equalsIgnoreCase("Lider de Proyecto")) {
                            rol = Roles.LIDER_PROYECTO;
                        } else {
                            rol = Roles.MIEMBRO_PROYECTO;
                        }

                        int rendimiento = opRs.getInt("rendimiento");

                        usuario = new Operativo( nombre,apellido,email,pass,0, 0,null,0,
                            opRs.getInt("id_empleado"),rol,rendimiento,null,null, idUsuario);
                        ControllerTarea controllerTarea = new ControllerTarea();
                        
                        //DESPUES DE LOGIN HAY QUE GUARDAR EN LA LISTA SUS TAREAS
                        ((Operativo) usuario).setTareasAsignadas(
                        		controllerTarea.obtenerTareasEmpleado(opRs.getInt("id_empleado")));
                        
                        DLL.ControllerAsistencia asis = new DLL.ControllerAsistencia();
                        int idEmpleado = opRs.getInt("id_empleado");
                        if (!asis.yaRegistroEntradaHoy(idEmpleado)) {
                            asis.registrarEntrada(idEmpleado);
                            javax.swing.JOptionPane.showMessageDialog(null, "Entrada registrada a las " + fechaHora);
                        }

                        
                        return usuario;
                    }

                    // VER SI ES VENDEDOR

                    PreparedStatement vendedorStmt = con.prepareStatement(
                        "  SELECT * FROM vendedor v"
                        + " INNER JOIN empleado e"
                        + " ON v.id_empleado = e.id_empleado"
                        + " WHERE e.id_usuario = ?"
                    );

                    vendedorStmt.setInt(1, idUsuario);

                    ResultSet venRs = vendedorStmt.executeQuery();

                    if(venRs.next()) {

                        usuario = new Vendedor(
                            nombre,
                            apellido,
                            email,
                            pass,
                            0,
                            0,
                            null,
                            0,
                            venRs.getInt("ventas_totales")
                        );

                        usuario.setIdUsuario(idUsuario);

                        ((Vendedor) usuario).setIdEmpleado(
                                venRs.getInt("id_empleado")
                        );
                       


                        
                        return usuario;
                    }
                }
               

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuario;
    }
    
    public void mostrarUsuarios() {

        try {
            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM usuario");

            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {

                System.out.println(
                    "ID: " + rs.getInt("id_usuario")
                    + " | Nombre: " + rs.getString("nombre")
                    + " | Apellido: " + rs.getString("apellido")
                    + " | Email: " + rs.getString("email")
                    + " | Contraseña: " + rs.getString("contrasenia")
                );
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void crearOperativo(
            String nombre,
            String apellido,
            String mail,
            String contrasenia,
            int dni,
            double sueldoBase,
            String rol,
            byte[] perfil) {

        try {

            PreparedStatement usuarioStmt = con.prepareStatement(
                "INSERT INTO usuario(nombre, apellido, email, contrasenia) VALUES(?,?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS
            );

            usuarioStmt.setString(1, nombre);
            usuarioStmt.setString(2, apellido);
            usuarioStmt.setString(3, mail);
            usuarioStmt.setString(4, contrasenia);

            usuarioStmt.executeUpdate();

            ResultSet rs = usuarioStmt.getGeneratedKeys();

            int idUsuario = 0;

            if(rs.next()) {
                idUsuario = rs.getInt(1);
            }

            PreparedStatement empleadoStmt = con.prepareStatement(
                "INSERT INTO empleado(id_usuario, dni, sueldo_base, perfil) VALUES(?,?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS
            );

            empleadoStmt.setInt(1, idUsuario);
            empleadoStmt.setString(2, String.valueOf(dni));
            empleadoStmt.setDouble(3, sueldoBase);
            empleadoStmt.setBytes(4, perfil);

            empleadoStmt.executeUpdate();

            ResultSet rsEmpleado = empleadoStmt.getGeneratedKeys();

            int idEmpleado = 0;

            if(rsEmpleado.next()) {
                idEmpleado = rsEmpleado.getInt(1);
            }

            PreparedStatement operativoStmt = con.prepareStatement(
                "INSERT INTO operativo(id_empleado, rol, rendimiento) VALUES(?,?,?)"
            );

            operativoStmt.setInt(1, idEmpleado);
            operativoStmt.setString(2, rol);
            operativoStmt.setInt(3, 0);

            operativoStmt.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void crearVendedor(
            String nombre,
            String apellido,
            String mail,
            String contrasenia,
            int dni,
            double sueldoBase,
            byte[] perfil
           ) {

        try {

            PreparedStatement usuarioStmt = con.prepareStatement(
                "INSERT INTO usuario(nombre, apellido, email, contrasenia) VALUES(?,?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS
            );

            usuarioStmt.setString(1, nombre);
            usuarioStmt.setString(2, apellido);
            usuarioStmt.setString(3, mail);
            usuarioStmt.setString(4, contrasenia);

            usuarioStmt.executeUpdate();

            ResultSet rs = usuarioStmt.getGeneratedKeys();

            int idUsuario = 0;

            if(rs.next()) {
                idUsuario = rs.getInt(1);
            }

            PreparedStatement empleadoStmt = con.prepareStatement(
                "INSERT INTO empleado(id_usuario, dni, sueldo_base, perfil) VALUES(?,?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS
            );

            empleadoStmt.setInt(1, idUsuario);
            empleadoStmt.setString(2, String.valueOf(dni));
            empleadoStmt.setDouble(3, sueldoBase);
            empleadoStmt.setBytes(4, perfil);
            System.out.println("Tamaño del perfil: " + perfil.length + " bytes");

            empleadoStmt.executeUpdate();

            ResultSet rsEmpleado = empleadoStmt.getGeneratedKeys();

            int idEmpleado = 0;

            if(rsEmpleado.next()) {
                idEmpleado = rsEmpleado.getInt(1);
            }

            PreparedStatement vendedorStmt = con.prepareStatement(
                "INSERT INTO vendedor(id_empleado, ventas_totales) VALUES(?,?)"
            );

            vendedorStmt.setInt(1, idEmpleado);
            vendedorStmt.setInt(2, 0);

            vendedorStmt.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }

    public void modificarEmpleado(
            int idEmpleado,
            String nombre,
            String apellido,
            String nuevoMail,
            int nuevoDni,
            double nuevoSueldo,
            byte[] perfil
    ) {
        try {
            PreparedStatement stmt1 = con.prepareStatement(
                "UPDATE usuario u " +
                "JOIN empleado e ON u.id_usuario = e.id_usuario " +
                "SET u.email = ?, u.nombre = ?, u.apellido = ? " +
                "WHERE e.id_empleado = ?"
            );

            stmt1.setString(1, nuevoMail);
            stmt1.setString(2, nombre);
            stmt1.setString(3, apellido);
            stmt1.setInt(4, idEmpleado);

            stmt1.executeUpdate();
 
            PreparedStatement stmt2;

            if (perfil != null) {
                stmt2 = con.prepareStatement(
                    "UPDATE empleado SET dni = ?, sueldo_base = ?, perfil = ? WHERE id_empleado = ?"
                );
                stmt2.setInt(1, nuevoDni);
                stmt2.setDouble(2, nuevoSueldo);
                stmt2.setBytes(3, perfil);
                stmt2.setInt(4, idEmpleado);

            } else {
                stmt2 = con.prepareStatement(
                    "UPDATE empleado SET dni = ?, sueldo_base = ? WHERE id_empleado = ?"
                );
                stmt2.setInt(1, nuevoDni);
                stmt2.setDouble(2, nuevoSueldo);
                stmt2.setInt(3, idEmpleado);
            }

            stmt2.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
  
  
  public void eliminarEmpleado(int idEmpleado) {

	    try {

	        PreparedStatement buscarUsuario = con.prepareStatement(
	            "SELECT id_usuario FROM empleado WHERE id_empleado = ?"
	        );

	        buscarUsuario.setInt(1, idEmpleado);

	        ResultSet rs = buscarUsuario.executeQuery();

	        int idUsuario = 0;

	        if(rs.next()) {
	            idUsuario = rs.getInt("id_usuario");
	        }

	        PreparedStatement deleteOperativo = con.prepareStatement(
	            "DELETE FROM operativo WHERE id_empleado = ?"
	        );

	        deleteOperativo.setInt(1, idEmpleado);
	        deleteOperativo.executeUpdate();

	        PreparedStatement deleteVendedor = con.prepareStatement(
	            "DELETE FROM vendedor WHERE id_empleado = ?"
	        );

	        deleteVendedor.setInt(1, idEmpleado);
	        deleteVendedor.executeUpdate();

	        PreparedStatement deleteEmpleado = con.prepareStatement(
	            "DELETE FROM empleado WHERE id_empleado = ?"
	        );

	        deleteEmpleado.setInt(1, idEmpleado);
	        deleteEmpleado.executeUpdate();

	        PreparedStatement deleteUsuario = con.prepareStatement(
	            "DELETE FROM usuario WHERE id_usuario = ?"
	        );

	        deleteUsuario.setInt(1, idUsuario);
	        deleteUsuario.executeUpdate();

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}  
  
  public ResultSet getListaEmpleados() {

	    try {

	        PreparedStatement stmt = con.prepareStatement(

	            "SELECT e.id_empleado, "
	            + "u.nombre, "
	            + "u.apellido "
	            + "FROM empleado e "
	            + "INNER JOIN usuario u "
	            + "ON e.id_usuario = u.id_usuario"
	        );

	        return stmt.executeQuery();

	    } catch(Exception e) {

	        e.printStackTrace();
	    }

	    return null;
	}
  
    		
    
}