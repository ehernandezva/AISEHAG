package pruebasUnitarias;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import es.codeurjc.ais.tictactoe.Board;
import es.codeurjc.ais.tictactoe.TicTacToeGame.Cell;

public class PruebaUnitariaGanarTest {

	@Test
	public void PrimerJugadorGana() {
		Board tablero = new Board();
		
		Cell posicion4 = tablero.getCell(4);
		posicion4.setActive(true);
		posicion4.setValue("Jugador 1");
		
		Cell posicion2 = tablero.getCell(2);
		posicion2.setActive(true);
		posicion2.setValue("Jugador 2");
		
		Cell posicion8 = tablero.getCell(8);
		posicion8.setActive(true);
		posicion8.setValue("Jugador 1");
		
		Cell posicion7 = tablero.getCell(7);
		posicion7.setActive(true);
		posicion7.setValue("Jugador 2");
		
		Cell posicion0 = tablero.getCell(0);
		posicion0.setActive(true);
		posicion0.setValue("Jugador 1");
		
		int[] sol = {0,4,8};
		int[] res = tablero.getCellsIfWinner("Jugador 1");
		assertThat(sol).isEqualTo(res);
	}

}
