package LogicLayer;

public class Actores <U extends Usuario>{
	
		private U usuario;

		public Actores(U usuario) {
			super();
			this.usuario = usuario;
		}

		public U getUsuario() {
			return usuario;
		}

		public void setUsuario(U usuario) {
			this.usuario = usuario;
		}

		@Override
		public String toString() {
			return "Actores [usuario=" + usuario + "]";
		}

		
}
