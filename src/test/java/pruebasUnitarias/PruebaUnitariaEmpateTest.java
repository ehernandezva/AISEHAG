package pruebasUnitarias;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import es.codeurjc.ais.tictactoe.Board;
import es.codeurjc.ais.tictactoe.TicTacToeGame.Cell;

public class PruebaUnitariaEmpateTest {

	@Test
	public void PartidaEmpatada() {
		Board tablero = new Board();
		
		Cell posicion4 = tablero.getCell(4);
		posicion4.setActive(true);
		posicion4.setValue("Jugador 1");
		
		Cell posicion2 = tablero.getCell(2);
		posicion2.setActive(true);
		posicion2.setValue("Jugador 2");
		
		Cell posicion0 = tablero.getCell(0);
		posicion0.setActive(true);
		posicion0.setValue("Jugador 1");
		
		Cell posicion8 = tablero.getCell(8);
		posicion8.setActive(true);
		posicion8.setValue("Jugador 2");
		
		Cell posicion5 = tablero.getCell(5);
		posicion5.setActive(true);
		posicion5.setValue("Jugador 1");
		
		Cell posicion3 = tablero.getCell(3);
		posicion3.setActive(true);
		posicion3.setValue("Jugador 2");
		
		Cell posicion1 = tablero.getCell(1);
		posicion1.setActive(true);
		posicion1.setValue("Jugador 1");
		
		Cell posicion7 = tablero.getCell(7);
		posicion7.setActive(true);
		posicion7.setValue("Jugador 2");
		
		Cell posicion6 = tablero.getCell(6);
		posicion6.setActive(true);
		posicion6.setValue("Jugador 1");
		
		boolean sol = true;
		boolean res = tablero.checkDraw();
		assertThat(sol).isEqualTo(res);
	}

}
