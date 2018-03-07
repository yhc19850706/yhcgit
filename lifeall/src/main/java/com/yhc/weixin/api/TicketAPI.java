package com.yhc.weixin.api;

import com.yhc.weixin.model.Ticket;


/**
 * JSAPI ticket
 * @author LiYi
 *
 */
public class TicketAPI extends BaseAPI {

	/**
	 * 获取 jsapi_ticket
	 * @param access_token
	 * @return
	 */
	public Ticket ticketGetticket(String access_token){
		
		return super.restTemplate.postForObject(
				BASE_URI+"/cgi-bin/ticket/getticket?access_token={access_token}&type=jsapi",
				null,
				Ticket.class,
				access_token);

	}
}
