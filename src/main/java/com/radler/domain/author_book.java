package com.radler.domain;

public class author_book extends AbstractEntity{
	
	private int BOOK_ID;
	private int AUTHOR_ID;
	public int getBOOK_ID() {
		return BOOK_ID;
	}
	public void setBOOK_ID(int bOOK_ID) {
		BOOK_ID = bOOK_ID;
	}
	public int getAUTHOR_ID() {
		return AUTHOR_ID;
	}
	public void setAUTHOR_ID(int aUTHOR_ID) {
		AUTHOR_ID = aUTHOR_ID;
	}
	
	

}
