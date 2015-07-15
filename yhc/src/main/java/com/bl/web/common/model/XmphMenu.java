package com.bl.web.common.model;

public class XmphMenu {

	private Integer menuId;
	private String parentMenuNm;
	private String menuUri;
	private String menuTagNm;
	private String dispYn;
	private String delYn;
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getParentMenuNm() {
		return parentMenuNm;
	}
	public void setParentMenuNm(String parentMenuNm) {
		this.parentMenuNm = parentMenuNm;
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
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
}
