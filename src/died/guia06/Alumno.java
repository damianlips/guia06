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
	
	@Override
	public String toString() {
		return nombre;
	}
	public Integer getNroLibreta() {
		return nroLibreta;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Curso> getCursando() {
		return cursando;
	}
	public void setCursando(List<Curso> cursando) {
		this.cursando = cursando;
	}
	public List<Curso> getAprobados() {
		return aprobados;
	}
	public void setAprobados(List<Curso> aprobados) {
		this.aprobados = aprobados;
	}
	public int creditosObtenidos() {
		int creditos=0;
		if(aprobados!=null)
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
	
	public int cursandoEnCiclo(int ano) {
		int sum=0;
		for(Curso c : cursando) {
			if(c.cicloEs(ano)) sum++;
		}
		return sum;
	}
	
	
	
	
	

}
