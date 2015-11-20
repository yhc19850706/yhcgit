
package com.yhc.common.param;

import com.yhc.common.annotation.NotEmpty;

public class AdvertiserParam {

	@NotEmpty
	private String	advertiserName;

	private String	description;

	public String getAdvertiserName() {
		return advertiserName;
	}

	public void setAdvertiserName(String advertiserName) {
		this.advertiserName = advertiserName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
