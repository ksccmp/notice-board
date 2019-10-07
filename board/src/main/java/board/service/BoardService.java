package board.service;

import java.util.List;

import board.dto.Board;

public interface BoardService {
	public static final int LIMIT = 5;
	public List<Board> getBoards(int start);
	public void addBoard(Board board);
	public int BoardCount();
	public Board getBoard(int num);
	public void changeBoard(int num, String title, String contents);
	public void deleteBoard(int num);
}
