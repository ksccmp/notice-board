package board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import board.dao.BoardDAO;
import board.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDAO dao;
	
	@Transactional(readOnly=false)
	public void addBoard(Board board) {
		dao.insert(board);
	};
	
	@Transactional
	public List<Board> getBoards(int start) {
		List<Board> boards = dao.searchAll(start, LIMIT);
		return boards;
	}
	
	public int BoardCount() {
		return dao.size();
	}
	
	@Transactional
	public Board getBoard(int num) {
		Board board = dao.search(num);
		return board;
	}
	
	@Transactional
	public void changeBoard(int num, String title, String contents) {
		dao.update(num, title, contents);
	}
	
	@Transactional
	public void deleteBoard(int num) {
		dao.delete(num);
	}
}
