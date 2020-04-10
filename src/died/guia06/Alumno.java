package died.guia06;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Alumno implements Comparable<Alumno> {

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;
	
	public Alumno(String nombre, Integer nroLibreta) {
		this.nombre=nombre;
		this.nroLibreta=nroLibreta;
		
	}
	public Alumno(String nombre) {
		this.nombre=nombre;
		Random r= new Random();
		this.nroLibreta= r.nextInt(100000);
	}
	public Alumno() {
		this(" ");
	}	

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int creditosObtenidos() {
		
		int creditos=0;
		for(Curso a: aprobados) {
			creditos+= a.dameCreditos();
		}
		return creditos;
	}

	public void aprobar(Curso c) {
		if(cursando!=null && cursando.contains(c)) {
			if(aprobados==null) aprobados= new ArrayList<Curso>();
			this.aprobados.add(c);
			this.cursando.remove(c);
		}
	}

	public void inscripcionAceptada(Curso c) {
		if(cursando==null) cursando= new ArrayList<Curso>();
		this.cursando.add(c);
	}
	
	@Override
	public boolean equals(Object o) {
		return (o instanceof Alumno && ((Alumno)o).nroLibreta == this.nroLibreta );
	}
	
	@Override 
	public int compareTo(Alumno a) {
		return(this.nombre.compareTo(a.nombre));
	}
	
	
	
	
	
	

}
