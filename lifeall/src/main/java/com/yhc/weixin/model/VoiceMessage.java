package com.yhc.weixin.model;

/**
 * 语音 
 */
public class VoiceMessage extends Message {

	public VoiceMessage(String touser) {
		super(touser,"voice");
	}

	public Voice voice;

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

	public static class Voice {
		private String media_id;

		public String getMedia_id() {
			return media_id;
		}

		public void setMedia_id(String mediaId) {
			media_id = mediaId;
		}
	}

}
