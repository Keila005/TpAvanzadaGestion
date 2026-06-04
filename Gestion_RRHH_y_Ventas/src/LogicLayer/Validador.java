package LogicLayer;

import javax.swing.JOptionPane;

public interface Validador {
		
	static boolean IngresarMail(String mail) {
		boolean flag;
		do {
			flag=true;
			if (mail.isEmpty()) {
				JOptionPane.showMessageDialog(null, "No puede estar vacio");
				flag=false;
			}
			if (!mail.endsWith("@gmail.com")) {
				JOptionPane.showMessageDialog(null, "El gmail debe terminar con @gmail.com");
				flag=false;
				break;
			}
		} while (flag==false);
		
		return flag;
	}
	
	static boolean IngresarNumero(String numero) {
		boolean flag;
		do {
			flag=true;
			if (numero.isEmpty()) {
				JOptionPane.showMessageDialog(null, "No puede estar vacio");
				flag=false;
				break;
			}
			
		for (int i = 0; i < numero.length();i++) {
			if (!Character.isDigit(numero.charAt(i))) {
				JOptionPane.showMessageDialog(null, "Debe ser números");
				flag = false;
				break;
			}
		}
		if (!flag) {
			break;
		}
		} while (flag==false);
	
		return flag;

}
	static String ValidarString(String mensaje) {
		
		String dato;
		
		do {
			dato = JOptionPane.showInputDialog(mensaje);
		} while (dato.isEmpty());
		
		return dato;
	}
	
	public static int ValidarInt(String mensaje) {

	    while(true) {

	        try {

	            String texto =
	                    JOptionPane.showInputDialog(
	                            mensaje
	                    );

	            if(texto == null) {
	                throw new RuntimeException(
	                        "Cancelado"
	                );
	            }

	            return Integer.parseInt(
	                    texto
	            );

	        } catch(NumberFormatException e) {

	            JOptionPane.showMessageDialog(
	                    null,
	                    "Debe ingresar un número entero"
	            );
	        }
	    }
	}
	
	
	
	public static double ValidarDouble(
	        String mensaje
	) {

	    while(true) {

	        try {

	            String texto =
	                    JOptionPane.showInputDialog(
	                            mensaje
	                    );

	            if(texto == null) {
	                throw new RuntimeException(
	                        "Cancelado"
	                );
	            }

	            return Double.parseDouble(
	                    texto
	            );

	        } catch(NumberFormatException e) {

	            JOptionPane.showMessageDialog(
	                    null,
	                    "Debe ingresar el precio correctamente"
	            );
	        }
	    }
	}
	
	
	

}
