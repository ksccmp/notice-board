package board.dto;

import java.util.Date;

public class Board {
	private int num;
	private String id, title, contents;
	private Date regdate;
	public Board() {}
	
	public Board(int num, String id, String title, String contents, Date regdate) {
		this.num = num;
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.regdate = regdate;
	}
	
	public Board(String id, String title, String contents, Date regdate) {
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.regdate = regdate;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String toString() {
		return "Board [num=" + num + ", id=" + id + ", title=" + title + ", contents=" + contents + ", regdate="
				+ regdate + "]";
	}
}
