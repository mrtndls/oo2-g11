package test;

import static datos.EstadoReserva.CONFIRMADA;
import static datos.EstadoReserva.PENDIENTE;
import static datos.EstadoTurno.OCUPADO;
import static datos.EstadoTurno.VENCIDO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import datos.Persona;
import datos.ReservaTurno;
import datos.Servicio;
import datos.Turno;
import negocio.PersonaABM;
import negocio.ReservaTurnoABM;
import negocio.ServicioABM;
import negocio.TurnoABM;

public class test {
	public static void main(String[] args) {
		System.out.println("\n\t\t\t --- TEST OO2 --- \n");

		///////////////////////////////////////// 1 //////////////////////////
		System.out.println("\n --- Traer todos los objetos de cada una de las clases datos --- \n");
		System.out.println(PersonaABM.getInstancia().traerTodasLasPersonas());
		System.out.println(ServicioABM.getInstancia().traerTodosLosServicios());
		System.out.println(TurnoABM.getInstancia().traerTodosLosTurnos());
		System.out.println(ReservaTurnoABM.getInstancia().traerTodasLasReservaTurno());

		///////////////////////////////////////// 2 ////////////////////////////////
		System.out.println("\n --- ABM por lo menos para cuatro clases --- \n");
		System.out.println("\n - ALTA -");
		long idPersona = PersonaABM.getInstancia().agregarPersona(
				new Persona("nombre1", "apellido1", 11111111, "email1@gmil.com", "42431071", LocalDate.now(), null));
		System.out.println(PersonaABM.getInstancia().traerPersonaPorId(idPersona));

		long idServicio = ServicioABM.getInstancia().agregarServicio(
				new Servicio("VTV", "Revisicion tecnic", true, LocalDateTime.now(), LocalDateTime.now(), null));
		System.out.println(ServicioABM.getInstancia().traerServicioPorId(idServicio));

		Servicio servicio = ServicioABM.getInstancia().traerServicioPorId(idServicio);// Ejemplo

		Turno turno = new Turno();
		turno.setFecha(LocalDate.of(2025, 10, 10));
		turno.setHora(LocalTime.of(11, 11));
		turno.setCupoMaximo(3);
		turno.setEstado(OCUPADO);
		turno.setServicio(servicio); // << IMPORTANTE
		long idTurno = TurnoABM.getInstancia().agregarTurno(turno);
		System.out.println(TurnoABM.getInstancia().traerTurnoPorId(idTurno));

		Persona persona = PersonaABM.getInstancia().traerPersonaPorId(idPersona);
		ReservaTurno reservaTurno = new ReservaTurno();
		reservaTurno.setFechaReserva(LocalDateTime.of(LocalDate.of(2025, 4, 4), LocalTime.of(4, 4)));
		reservaTurno.setEstado(CONFIRMADA);
		reservaTurno.setPersona(persona); // << IMPORTANTE
		reservaTurno.setTurno(turno); // << IMPORTANTE // CLAVE: estás asignando el lado dueño
		// turno.getReservas().add(reservaTurno);
		long idReservaTurno = ReservaTurnoABM.getInstancia().agregarReservaTurno(reservaTurno);
		System.out.println(ReservaTurnoABM.getInstancia().traerReservaTurnoPorId(idReservaTurno));

		System.out.println("\n - MODIFICAR -");
		persona.setApellido("APELLIDO");
		servicio.setDescripcion("DESCRIPCION");
		turno.setEstado(VENCIDO);
		reservaTurno.setEstado(PENDIENTE);
		PersonaABM.getInstancia().actualizarPersona(persona);
		ServicioABM.getInstancia().actualizarServicio(servicio);
		TurnoABM.getInstancia().actualizarTurno(turno);
		ReservaTurnoABM.getInstancia().actualizarReservaTurno(reservaTurno);
		System.out.println(PersonaABM.getInstancia().traerPersonaPorId(idPersona).getApellido());
		System.out.println(ServicioABM.getInstancia().traerServicioPorId(idServicio).getDescripcion());
		System.out.println(TurnoABM.getInstancia().traerTurnoPorId(idTurno).getEstado());
		System.out.println(ReservaTurnoABM.getInstancia().traerReservaTurnoPorId(idReservaTurno).getEstado());

		System.out.println("\n - ELIMINAR fisic -");
		long idPersonaEliminar = PersonaABM.getInstancia().agregarPersona(new Persona("nombreEliminar",
				"apellidoEliminar", 6666666, "Eliminar@gmil.com", "66666", LocalDate.now(), null));
		Persona personaElimniar = PersonaABM.getInstancia().traerPersonaPorId(idPersonaEliminar);
		System.out.println("Person nuev para eliminar : " + personaElimniar);
		PersonaABM.getInstancia().eliminarPersona(personaElimniar);
		// Acá sí traés desde la base
		Persona personaEliminada = PersonaABM.getInstancia().traerPersonaPorId(idPersonaEliminar);
		System.out.println("¿Existe en BD?: " + personaEliminada); // debería imprimir "null"

		///////////////////////////////////////// 3 //////////////////////////////
		System.out.println("\n --- Mínimo cuatro consultas por algún atributo del tipo clase --- \n");
		Servicio servicioC = ServicioABM.getInstancia().traerServicioPorId(1L);
		Persona personaC = PersonaABM.getInstancia().traerPersonaPorId(1L);
		Turno turnoC = TurnoABM.getInstancia().traerTurnoPorId(1L);
		System.out.println(" - Trear Turno por Servicio : " + TurnoABM.getInstancia().traerPorServicio(servicioC));
		System.out.println(" - Trear ReservaTurno por Persona : "
				+ ReservaTurnoABM.getInstancia().traerReservasPorPersona(personaC));
		System.out.println(" - Trear ReservaTurno por Turno : " + ReservaTurnoABM.getInstancia().traerPorTurno(turnoC));
		System.out.println(
				" - Trear ReservaTurno por Estado : " + ReservaTurnoABM.getInstancia().traerPorEstado(PENDIENTE));
		///////////////////////////////////////// 4 /////////////////////////////////
		System.out.println("\n --- Mínimo cuatro consultas por algún atributo de la subclase --- \n");
		///////////////////////////////////////// 5 //////////////////////////////////
		System.out.println("\n --- Mínimo cuatro consultas por intervalo de fechas --- \n");
		System.out.println("\n --- Mínimo cuatro consultas por intervalo de fechas --- \n");

		System.out.println(" - Traer Turno entre fechas  "
				+ TurnoABM.getInstancia().traerTurnosEntreFechas(LocalDate.of(2025, 5, 1), LocalDate.of(2025, 12, 31)));

		System.out.println(" - Traer ReservaTurno por fecha reserva : "
				+ ReservaTurnoABM.getInstancia().traerReservasPorFechaReserva(LocalDateTime.of(2025, 4, 1, 0, 0),
						LocalDateTime.of(2025, 5, 11, 23, 59)));

		System.out.println(
				" - Traer Servicio por fecha creacion : " + ServicioABM.getInstancia().traerServiciosPorFechaCreacion(
						LocalDateTime.of(2025, 5, 1, 0, 0), LocalDateTime.of(2025, 5, 11, 23, 59)));

		///////////////////////////////////////// 6 /////////////////////////////////
		System.out.println("\n --- Mínimo cuatro consultas por una fecha y un atributo de clase --- \n");
		// 1. Traer Turno por Fecha y Cupo Máximo
		System.out.println(" - Traer Turno por Fecha y Cupo Máximo : "
				+ TurnoABM.getInstancia().traerTurnosPorFechaYCupoMaximo(LocalDate.of(2025, 5, 10), 3));

		// 2. Traer ReservaTurno por Fecha de Reserva y Persona
		System.out.println(" - Traer ReservaTurno por Fecha de Reserva y Persona : "
				+ ReservaTurnoABM.getInstancia().traerReservasPorFechaReservaYPersona(
						LocalDateTime.of(2025, 5, 10, 0, 0), LocalDateTime.of(2025, 5, 10, 23, 59), 1L)); // Persona con
																											// id 1L

		// 3. Traer Servicio por Fecha de Creación y Estado Activo
		System.out.println(" - Traer Servicio por Fecha de Creación y Estado Activo : "
				+ ServicioABM.getInstancia().traerServiciosPorFechaCreacionYActivo(LocalDateTime.of(2025, 5, 1, 0, 0),
						LocalDateTime.of(2025, 5, 10, 23, 59), true)); // Solo activos

		// 4. Traer Persona por Fecha de Nacimiento y DNI
		System.out.println(" - Traer Persona por Fecha de Nacimiento y DNI : "
				+ PersonaABM.getInstancia().traerPersonasPorFechaNacimientoYDni(LocalDate.of(1990, 5, 15), 388411670));
	}
}
