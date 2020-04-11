package died.guia06;

public class App {

	public static void main(String[] args) {
		Curso c, c2, c3, c4, c5, c6;
		Alumno a, a2, a3, a4;
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
		
		//No va a inscribir porque el alumno no tiene creditos suficientes(retornara false)
		System.out.println(a.toString() + " se pudo inscribir a " +c.toString() + "?: " +c.inscribir(a));
		
		
		System.out.println(a.toString() + " se pudo inscribir a " +c4.toString() + "?: " +c4.inscribir(a));
		//a.aprobar(c4);
		//System.out.println(a.toString() + " aprobo "+ c4.toString());
		
		System.out.println(a.toString() + " se pudo inscribir a " +c5.toString() + "?: " +c5.inscribir(a));
		//System.out.println(a.toString() + " se pudo inscribir a " +c3.toString() + "?: " +c3.inscribir(a));
		System.out.println(a.toString() + " se pudo inscribir a " +c2.toString() + "?: " +c2.inscribir(a));
		//System.out.println(a.toString() + " se pudo inscribir a " +c6.toString() + "?: " +c6.inscribir(a));
		
		//No va a inscribir porque el alumno esta inscripto a otras 3 materias
		System.out.println(a.toString() + " se pudo inscribir a " +c.toString() + "?: " +c.inscribir(a));
		
		a.aprobar(c4);
		System.out.println(a.toString() + " aprobo "+ c4.toString());
		
		//Ahora si se puede inscribir porque aprobo una de las 3 materias y libero el lugar
		System.out.println(a.toString() + " se pudo inscribir a " +c.toString() + "?: " +c.inscribir(a));
		
		//Llenamos cupo de died
		System.out.println(a3.toString() + " se pudo inscribir a " +c4.toString() + "?: " +c4.inscribir(a3));
		a3.aprobar(c4);
		System.out.println(a3.toString() + " aprobo "+ c4.toString());
		System.out.println(a3.toString() + " se pudo inscribir a " +c.toString() + "?: " +c.inscribir(a3));
		
		System.out.println(a2.toString() + " se pudo inscribir a " +c4.toString() + "?: " +c4.inscribir(a2));
		a2.aprobar(c4);
		System.out.println(a2.toString() + " aprobo "+ c4.toString());
		System.out.println(a2.toString() + " se pudo inscribir a " +c.toString() + "?: " +c.inscribir(a2));
		
		System.out.println(a4.toString() + " se pudo inscribir a " +c4.toString() + "?: " +c4.inscribir(a4));
		a4.aprobar(c4);
		System.out.println(a4.toString() + " aprobo "+ c4.toString());
		//No va a inscribir porque el cupo esta lleno
		System.out.println(a4.toString() + " se pudo inscribir a " +c.toString() + "?: " +c.inscribir(a4));
	
		
		System.out.println("Ordenando alfabeticamente los registrados en " + c4.toString());
		c4.imprimirInscriptos(Ordenamiento.ALFABETICO);
		
		
		System.out.println("Ordenando por libreta los registrados en " + c4.toString());
		c4.imprimirInscriptos(Ordenamiento.LIBRETA);
		
		a.aprobar(c);
		System.out.println(a.toString() + " aprobo "+ c.toString());
		
		System.out.println("Ordenando por creditos los registrados en " + c4.toString());
		c4.imprimirInscriptos(Ordenamiento.CREDITOS);
		
		
		
		
		
	}
}
