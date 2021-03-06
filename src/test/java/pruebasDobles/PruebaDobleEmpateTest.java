package pruebasDobles;


import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.mockito.Matchers.argThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.mockito.ArgumentCaptor;

import es.codeurjc.ais.tictactoe.Connection;
import es.codeurjc.ais.tictactoe.Player;
import es.codeurjc.ais.tictactoe.TicTacToeGame;
import es.codeurjc.ais.tictactoe.TicTacToeGame.EventType;
public class PruebaDobleEmpateTest {

	@Test
	public void partidaEmpatada() {
		//Crear clases y mocks
		TicTacToeGame partida = new TicTacToeGame();
		Connection conexionUno = mock(Connection.class);
		Connection conexionDos = mock(Connection.class);
		partida.addConnection(conexionUno);
		partida.addConnection(conexionDos);
		Player jugadorUno = new Player(1,"X","Jugador Uno");
		Player jugadorDos = new Player(2,"O","Jugador Dos");
				
		//Introducir jugadores
		reset(conexionUno);
		reset(conexionDos);
		partida.addPlayer(jugadorUno);
		partida.addPlayer(jugadorDos);
		verify(conexionUno,times(2)).sendEvent(eq(EventType.JOIN_GAME), argThat(hasItems(jugadorUno, jugadorDos))); 
		verify(conexionDos,times(2)).sendEvent(eq(EventType.JOIN_GAME), argThat(hasItems(jugadorUno, jugadorDos))); 
		
		
		//Marcar casilla 4 por jugador 1
		reset(conexionUno);
		reset(conexionDos);
		partida.mark(4);
		ArgumentCaptor<Player> argument = ArgumentCaptor.forClass(Player.class); 
		verify(conexionUno).sendEvent(eq(EventType.SET_TURN), argument.capture()); 
		Object turnoActual = argument.getValue();
		assertThat(turnoActual).isEqualTo(jugadorDos);
		verify(conexionDos).sendEvent(eq(EventType.SET_TURN), argument.capture());
		turnoActual = argument.getValue();
		assertThat(turnoActual).isEqualTo(jugadorDos);		
		
		//Marcar casilla 2 por jugador 2
		reset(conexionUno);
		reset(conexionDos);
		partida.mark(2);
		verify(conexionUno).sendEvent(eq(EventType.SET_TURN), argument.capture()); 
		turnoActual = argument.getValue();
		assertThat(turnoActual).isEqualTo(jugadorUno);
		verify(conexionDos).sendEvent(eq(EventType.SET_TURN), argument.capture());
		turnoActual = argument.getValue();
		assertThat(turnoActual).isEqualTo(jugadorUno);
		
		//Marcar casilla 8 por jugador 1
		reset(conexionUno);
		reset(conexionDos);
		partida.mark(8);
		verify(conexionUno).sendEvent(eq(EventType.SET_TURN), argument.capture()); 
		turnoActual = argument.getValue();
		assertThat(turnoActual).isEqualTo(jugadorDos);
		verify(conexionDos).sendEvent(eq(EventType.SET_TURN), argument.capture());
		turnoActual = argument.getValue();
		assertThat(turnoActual).isEqualTo(jugadorDos);
		
		//Marcar casilla 0 por jugador 2
		reset(conexionUno);
		reset(conexionDos);
		partida.mark(0);
		verify(conexionUno).sendEvent(eq(EventType.SET_TURN), argument.capture()); 
		turnoActual = argument.getValue();
		assertThat(turnoActual).isEqualTo(jugadorUno);
		verify(conexionDos).sendEvent(eq(EventType.SET_TURN), argument.capture());
		turnoActual = argument.getValue();
		assertThat(turnoActual).isEqualTo(jugadorUno);
		
		//Marcar casilla 1 por jugador 1
		reset(conexionUno);
		reset(conexionDos);
		partida.mark(1);
		verify(conexionUno).sendEvent(eq(EventType.SET_TURN), argument.capture()); 
		turnoActual = argument.getValue();
		assertThat(turnoActual).isEqualTo(jugadorDos);
		verify(conexionDos).sendEvent(eq(EventType.SET_TURN), argument.capture());
		turnoActual = argument.getValue();
		assertThat(turnoActual).isEqualTo(jugadorDos);
		
		//Marcar casilla 7 por jugador 2
		reset(conexionUno);
		reset(conexionDos);
		partida.mark(7);
		verify(conexionUno).sendEvent(eq(EventType.SET_TURN), argument.capture()); 
		turnoActual = argument.getValue();
		assertThat(turnoActual).isEqualTo(jugadorUno);
		verify(conexionDos).sendEvent(eq(EventType.SET_TURN), argument.capture());
		turnoActual = argument.getValue();
		assertThat(turnoActual).isEqualTo(jugadorUno);
		
		//Marcar casilla 5 por jugador 1
		reset(conexionUno);
		reset(conexionDos);
		partida.mark(5);
		verify(conexionUno).sendEvent(eq(EventType.SET_TURN), argument.capture()); 
		turnoActual = argument.getValue();
		assertThat(turnoActual).isEqualTo(jugadorDos);
		verify(conexionDos).sendEvent(eq(EventType.SET_TURN), argument.capture());
		turnoActual = argument.getValue();
		assertThat(turnoActual).isEqualTo(jugadorDos);
		
		//Marcar casilla 3 por jugador 2
		reset(conexionUno);
		reset(conexionDos);
		partida.mark(3);
		verify(conexionUno).sendEvent(eq(EventType.SET_TURN), argument.capture()); 
		turnoActual = argument.getValue();
		assertThat(turnoActual).isEqualTo(jugadorUno);
		verify(conexionDos).sendEvent(eq(EventType.SET_TURN), argument.capture());
		turnoActual = argument.getValue();
		assertThat(turnoActual).isEqualTo(jugadorUno);
		
		//Marcar casilla 6 por jugador 1
		reset(conexionUno);
		reset(conexionDos);
		partida.mark(6);
		
		//Comprobar que la partida se ha empatado
		ArgumentCaptor<Object> resultado = ArgumentCaptor.forClass(Object.class); 
		verify(conexionUno).sendEvent(eq(EventType.GAME_OVER), resultado.capture()); 
		Object event = resultado.getValue();
		assertThat(event).isEqualTo(null);
		verify(conexionDos).sendEvent(eq(EventType.GAME_OVER), resultado.capture());
		event = resultado.getValue();
		assertThat(event).isEqualTo(null);
	}

}
