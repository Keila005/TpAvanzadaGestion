package LogicLayer;

public enum Roles {
	 LIDER_PROYECTO(new String[]{"Visualizar Kanban","Crear tareas","Registrar reunion","Evaluar compañero","Volver"}), 
	 MIEMBRO_PROYECTO(new String[]{"Visualizar Kanban","Ver reuniones","Evaluar compañero","Volver"});

		private String[] opciones;
		
		private Roles(String[] opciones) {
			this.opciones = opciones;
		}
		public String[] getOpciones() {
			return opciones;
		}
		public void setOpciones(String[] opciones) {
			this.opciones = opciones;
		}
}
