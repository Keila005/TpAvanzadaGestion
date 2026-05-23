package LogicLayer;

import java.util.Arrays;

public class Evaluacion360 {
	private Operativo evaluador;
    private Operativo evaluado;
    private int[] respuestas;
    private int puntajeTotal;
    private String comentario;

    
    public Evaluacion360( Operativo evaluador,Operativo evaluado,int[] respuestas,String comentario
    ) {

        this.evaluador = evaluador;
        this.evaluado = evaluado;
        this.respuestas = respuestas;
        this.puntajeTotal= calcularPuntaje(respuestas);
        this.comentario = comentario;
    }

    private int calcularPuntaje(int[] respuestas) {

        puntajeTotal = 0;

        for(int r : respuestas) {

            puntajeTotal += r;
        }
        return puntajeTotal;
    }

	public Operativo getEvaluador() {
		return evaluador;
	}

	public void setEvaluador(Operativo evaluador) {
		this.evaluador = evaluador;
	}

	public Operativo getEvaluado() {
		return evaluado;
	}

	public void setEvaluado(Operativo evaluado) {
		this.evaluado = evaluado;
	}

	public int[] getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(int[] respuestas) {
		this.respuestas = respuestas;
	}

	public int getPuntajeTotal() {
		return puntajeTotal;
	}

	public void setPuntajeTotal(int puntajeTotal) {
		this.puntajeTotal = puntajeTotal;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return "Evaluacion360 [evaluador=" + evaluador + ", evaluado=" + evaluado + ", respuestas="
				+ Arrays.toString(respuestas) + ", puntajeTotal=" + puntajeTotal + ", comentarios=" + comentario + "]";
	}

    
    
}
