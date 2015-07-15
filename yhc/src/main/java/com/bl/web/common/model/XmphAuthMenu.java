package com.bl.web.common.model;

public class XmphAuthMenu extends XmphAuth {
	private int amId;
	private int authId;
	private int menuId;
	
	// auth bean attrbuite
	private String authDelYn;
	
	// menu bean attrbuite
	private String parentMenuNm;
	private String menuNm;
	private String menuUri;
	private String menuTagNm;
	private String dispYn;
	private String menuDelYn;

	public int getAmId() {
		return amId;
	}

	public void setAmId(int amId) {
		this.amId = amId;
	}

	public int getAuthId() {
		return authId;
	}

	public void setAuthId(int authId) {
		this.authId = authId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getAuthDelYn() {
		return authDelYn;
	}

	public void setAuthDelYn(String authDelYn) {
		this.authDelYn = authDelYn;
	}

	public String getParentMenuNm() {
		return parentMenuNm;
	}

	public void setParentMenuNm(String parentMenuNm) {
		this.parentMenuNm = parentMenuNm;
	}

	public String getMenuNm() {
		return menuNm;
	}

	public void setMenuNm(String menuNm) {
		this.menuNm = menuNm;
	}

	public String getMenuUri() {
		return menuUri;
	}

	public void setMenuUri(String menuUri) {
		this.menuUri = menuUri;
	}

	public String getMenuTagNm() {
		return menuTagNm;
	}

	public void setMenuTagNm(String menuTagNm) {
		this.menuTagNm = menuTagNm;
	}

	public String getDispYn() {
		return dispYn;
	}

	public void setDispYn(String dispYn) {
		this.dispYn = dispYn;
	}

	public String getMenuDelYn() {
		return menuDelYn;
	}

	public void setMenuDelYn(String menuDelYn) {
		this.menuDelYn = menuDelYn;
	}

}
