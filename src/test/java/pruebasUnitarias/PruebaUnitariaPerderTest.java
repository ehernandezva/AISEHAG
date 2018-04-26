package pruebasUnitarias;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import es.codeurjc.ais.tictactoe.Board;
import es.codeurjc.ais.tictactoe.TicTacToeGame.Cell;

public class PruebaUnitariaPerderTest {
	/**
	 * Se ha cambiado la clase TicTacToeGame para que la clase Cell sea publica y
	 * tenga getters y setters. Se ha hecho así para que la prueba del tablero
	 * sea unitaria. 
	 */
	
	@Test
	public void PrimerJugadorPierde() {
		Board tablero = new Board();
		
		Cell posicion0 = tablero.getCell(0);
		posicion0.setActive(true);
		posicion0.setValue("Jugador 1");
		
		Cell posicion6 = tablero.getCell(6);
		posicion6.setActive(true);
		posicion6.setValue("Jugador 2");
		
		Cell posicion3 = tablero.getCell(3);
		posicion3.setActive(true);
		posicion3.setValue("Jugador 1");
		
		Cell posicion7 = tablero.getCell(7);
		posicion7.setActive(true);
		posicion7.setValue("Jugador 2");
		
		Cell posicion4 = tablero.getCell(4);
		posicion4.setActive(true);
		posicion4.setValue("Jugador 1");
		
		Cell posicion8 = tablero.getCell(8);
		posicion8.setActive(true);
		posicion8.setValue("Jugador 2");
		
		int[] sol = {6,7,8};
		int[] res = tablero.getCellsIfWinner("Jugador 2");
		assertThat(sol).isEqualTo(res);
	}
}
