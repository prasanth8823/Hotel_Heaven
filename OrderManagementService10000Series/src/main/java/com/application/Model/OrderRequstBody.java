package com.application.Model;

import java.util.List;

public class OrderRequstBody {

	private int hoteId;
	private int userId;
	private List<Menu> menu;

	public int getHoteId() {
		return hoteId;
	}

	public void setHoteId(int hoteId) {
		this.hoteId = hoteId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Menu> getMenu() {
		return menu;
	}

	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}
	
	
}
