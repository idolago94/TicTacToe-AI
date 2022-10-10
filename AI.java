import java.util.ArrayList;

public class AI {

	private int nodesWithoutPruning = 0;

	public Board play(Board board) {

		ArrayList<Board> possibleMoves = getPossibleMoves(board);

		Board newBoard = possibleMoves.get(0);
		int max = getMaxValue(newBoard);

		for (int i = 1; i < possibleMoves.size(); i++) {
			int boardMinValue = getMaxValue(possibleMoves.get(i));
			if (boardMinValue > max) {
				max = boardMinValue;
				newBoard = possibleMoves.get(i);
			}
		}

		return newBoard;

	}

	private ArrayList<Board> getPossibleMoves(Board board) {
		char player = getCurrentPlayerTurn(board, false);
		ArrayList<Board> possibleMoves = new ArrayList<>();
		for (int i = 0; i < board.getSize(); i++) {
			for (int j = 0; j < board.getSize(); j++) {
				if (board.get(i, j) == '_') {
					Board b = new Board(board);
					b.set(i, j, player);
					possibleMoves.add(b);
				}
			}
		}
		return possibleMoves;
	}

	public int getNodesWithoutPruning() {
		return nodesWithoutPruning;
	}

	private int getMinValue(Board board) {
		if (board.isTerminated() != 'T') {
			return board.score();
		}

		int min = (int) Double.POSITIVE_INFINITY;
		for (Board possibleMove : getPossibleMoves(board)) {

			min = Math.min(min, getMaxValue(possibleMove));
		}
		return min;
	}

	private int getMaxValue(Board board) {
		if (board.isTerminated() != 'T') {
			return board.score();
		}

		int max = (int) Double.NEGATIVE_INFINITY;
		for (Board possibleMove : getPossibleMoves(board)) {

			max = Math.max(max, getMinValue(possibleMove));
		}
		return max;
	}

	private char getCurrentPlayerTurn(Board board, boolean test) {
		int xCounter = 0;
		int oCounter = 0;
		char player;

		for (int i = 0; i < board.getSize(); i++) {
			for (int j = 0; j < board.getSize(); j++) {
				if (board.get(i, j) == 'X') {
					xCounter++;
				} else if (board.get(i, j) == 'O') {
					oCounter++;
				}
			}
		}

		if (test)
			System.out.println("x=" + xCounter + " o=" + oCounter);

		if (xCounter <= oCounter) {
			player = 'X';
		} else {
			player = 'O';
		}

		return player;
	}

}
