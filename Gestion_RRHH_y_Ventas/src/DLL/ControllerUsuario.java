package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import LogicLayer.*;


public class ControllerUsuario {

    private static Connection con = Conexion.getInstance().getConnection();

    public Usuario login(String mail, String contrasenia) {

        Usuario usuario = null;

        try {

            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM usuario WHERE email = ?"
            );

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

                        usuario = new Administrador(nombre,apellido,email,pass,idUsuario,sector
                        );

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
                            opRs.getInt("id_empleado"),rol,rendimiento,null,null);
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

                        usuario = new Vendedor(nombre,apellido,email,pass,0,0,null,0,                          
                            venRs.getInt("ventas_totales")
                        );

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
}