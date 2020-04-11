package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import died.guia06.util.Registro;

/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */
public class Curso {

	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	
	private Registro log;
	
	public Curso() {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	
	public Curso(Integer id, String nombre, Integer cicloLectivo, Integer creditos, Integer creditosRequeridos,Integer cupo) {
		this();
		this.id=id;
		this.nombre=nombre;
		this.cicloLectivo=cicloLectivo;
		this.creditos=creditos;
		this.creditosRequeridos=creditosRequeridos;
		this.cupo=cupo;
	}
	
	public Curso(String nombre, Integer cicloLectivo, Integer creditos, Integer creditosRequeridos,Integer cupo) {
		this();
		Random r= new Random();
		this.id= r.nextInt(100000);
		this.nombre=nombre;
		this.cicloLectivo=cicloLectivo;
		this.creditos=creditos;
		this.creditosRequeridos=creditosRequeridos;
		this.cupo=cupo;
	}
	
	
	@Override
	public String toString() {
		return nombre+ " " + cicloLectivo;
	}

	public boolean cicloEs(int a) {
		return(this.cicloLectivo == a);
	}
	
	
	/**
	 * Este método, verifica si el alumno se puede inscribir y si es así lo agrega al curso,
	 * agrega el curso a la lista de cursos en los que está inscripto el alumno y retorna verdadero.
	 * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
	 * de cursos en los que el alumno está inscripto.
	 * 
	 * Para poder inscribirse un alumno debe
	 * 		a) tener como minimo los creditos necesarios
	 *      b) tener cupo disponibles
	 *      c) puede estar inscripto en simultáneo a no más de 3 cursos del mismo ciclo lectivo.
	 * @param a
	 * @return
	 */
	public Boolean inscribir(Alumno a) {
		if(this.cupo>inscriptos.size() && a.creditosObtenidos()>= creditosRequeridos && a.cursandoEnCiclo(this.cicloLectivo)<4) {
			try {
				log.registrar(this, "inscribir ",a.toString());
				inscriptos.add(a);
				a.inscripcionAceptada(this);
				return true;
			}
			catch(IOException laExcep) {
				System.out.println("Hubo un error al intentar registrar la inscripcion, intente nuevamente");
				return false;
			}
		}
		else return false;
	}
	
	
	/**
	 * imprime los inscriptos en orden alfabetico
	 */
	public void imprimirInscriptos(Ordenamiento orden) {
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
			switch(orden) {
			case ALFABETICO:
				Collections.sort(inscriptos);
				break;
			case LIBRETA:
				ComparadorLibreta comp= new ComparadorLibreta();
				Collections.sort(inscriptos, comp);
				break;
			case CREDITOS:
				ComparadorCreditos compa= new ComparadorCreditos();
				Collections.sort(inscriptos, compa);
				break;	
			}
			for(Alumno alu : inscriptos) {
				System.out.println(alu.toString());
			}
		}
		catch(IOException ex) {
			System.out.println("Hubo un error al intentar registrar el pedido, intente nuevamente");
		}
	}

	public int dameCreditos() {
		return this.creditos;
	}
	
	public void setCreditos(Integer c) {
		this.creditos=c;
	}

	public List<Alumno> getInscriptos() {
		return inscriptos;
	}

	public void setInscriptos(List<Alumno> inscriptos) {
		this.inscriptos = inscriptos;
	}

	
	

}
