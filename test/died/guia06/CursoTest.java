package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CursoTest {
	Curso c, c2, c3, c4, c5, c6;
	Alumno a, a2, a3, a4;
	
	@BeforeEach
	public void init() {
		a= new Alumno("Damian Lipschitz", 25320);
		a2= new Alumno("Federico Quijada", 25319);
		a3= new Alumno("Juan Cabana", 25321);
		a4= new Alumno("Adriano Abero", 25322);
		c= new Curso("DIED", 2020, 50, 50, 3);
		c2= new Curso("AEDD", 2020, 25, 0, 40);
		c3= new Curso("Sistemas Operativos", 2020, 10, 0, 40);
		c4= new Curso("Paradigmas de la Programacion", 2020, 50, 0, 40);
		c5= new Curso("Sistemas de Representacion", 2020, 5, 0, 40);
		c6= new Curso("Ingles", 2020, 5, 0, 40);
	}
	
	
	
	@Test
	void testNoInscribirSinCreditos() {
		boolean inscripto= (c.inscribir(a)) , noInscripto=(!inscripto && !c.getInscriptos().contains(a));
		assertTrue(noInscripto);	
	}
	
	@Test
	void inscribirSimple() {
		boolean inscripto= c4.inscribir(a);
		int cursadas= a.cursandoEnCiclo(2020); 
		assertTrue(inscripto);	
		assertEquals(1, cursadas);
	}
	
	
	@Test
	void testNoInscribirConDemasiadasMaterias() {
		c4.inscribir(a);
		a.aprobar(c4);
		c5.inscribir(a);
		c3.inscribir(a);
		c2.inscribir(a);
		c6.inscribir(a);
		boolean inscripto= (c.inscribir(a)) , noInscripto=(!inscripto && !c.getInscriptos().contains(a));
		assertTrue(noInscripto);	
	}
	
	@Test
	void testInscribir() {
		c4.inscribir(a);
		a.aprobar(c4);
		c5.inscribir(a);
		c3.inscribir(a);
		
		c4.inscribir(a3);
		a3.aprobar(c4);
		c5.inscribir(a3);
		c3.inscribir(a3);
		
		c4.inscribir(a2);
		a2.aprobar(c4);
		c5.inscribir(a2);
		c3.inscribir(a2);
		boolean inscripto= (c.inscribir(a) && c.inscribir(a2) && c.inscribir(a3) ) &&
				(c.getInscriptos().contains(a)) &&
				(c.getInscriptos().contains(a2))&&
				(c.getInscriptos().contains(a3));
		assertTrue(inscripto);	
	}
	
	@Test
	void testNoInscribirConCupo() {
		c4.inscribir(a);
		a.aprobar(c4);
		c5.inscribir(a);
		c3.inscribir(a);
		c.inscribir(a);
		
		c4.inscribir(a3);
		a3.aprobar(c4);
		c5.inscribir(a3);
		c3.inscribir(a3);
		c.inscribir(a3);
		
		c4.inscribir(a2);
		a2.aprobar(c4);
		c5.inscribir(a2);
		c3.inscribir(a2);
		c.inscribir(a2);
		
		c4.inscribir(a4);
		a4.aprobar(c4);
		c5.inscribir(a4);
		c3.inscribir(a4);
		
		boolean inscripto= (c.inscribir(a4)) , noInscripto=(!inscripto && !c.getInscriptos().contains(a4));
		assertTrue(noInscripto);	
	}
	
	@Test
	void testOrdenarXNombre() {
		List<Alumno> inscriptos = new ArrayList<Alumno>();
		inscriptos.add(a4);
		inscriptos.add(a);
		inscriptos.add(a2);
		inscriptos.add(a3);
		c6.inscribir(a);
		c6.inscribir(a2);
		c6.inscribir(a3);
		c6.inscribir(a4);	
		c6.imprimirInscriptos(Ordenamiento.ALFABETICO);
		assertEquals(c6.getInscriptos(), inscriptos);
		
	}
	
	@Test
	void testOrdenarXLibreta() {
		List<Alumno> inscriptos = new ArrayList<Alumno>();
		inscriptos.add(a2);
		inscriptos.add(a);
		inscriptos.add(a3);
		inscriptos.add(a4);
		c6.inscribir(a);
		c6.inscribir(a2);
		c6.inscribir(a3);
		c6.inscribir(a4);	
		c6.imprimirInscriptos(Ordenamiento.LIBRETA);
		assertEquals(c6.getInscriptos(), inscriptos);
		
	}
	
	@Test
	void testOrdenarXCredito() {
		List<Alumno> inscriptos = new ArrayList<Alumno>();
		inscriptos.add(a);
		inscriptos.add(a2);
		inscriptos.add(a3);
		inscriptos.add(a4);
		
		c5.inscribir(a);
		c5.inscribir(a2);
		c5.inscribir(a3);
		
		a.aprobar(c5);
		a2.aprobar(c5);
		a3.aprobar(c5);
		
		c3.inscribir(a);
		c3.inscribir(a2);
		
		a.aprobar(c3);
		a2.aprobar(c3);
		
		c4.inscribir(a);

		a.aprobar(c4);
		
		c6.inscribir(a);
		c6.inscribir(a2);
		c6.inscribir(a3);
		c6.inscribir(a4);	
		c6.imprimirInscriptos(Ordenamiento.CREDITOS);
		assertEquals(c6.getInscriptos(), inscriptos);
		
	}
	

}
