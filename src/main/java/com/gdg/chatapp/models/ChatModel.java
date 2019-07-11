package com.gdg.chatapp.models;

public class ChatModel {

	String message;
	String fromPhoneNo; // received from phone
	String toPhoneNo; //    send to phone
	
	public ChatModel(String message, String fromPhoneNo, String toPhoneNo) {
		super();
		this.message = message;
		this.fromPhoneNo = fromPhoneNo;
		this.toPhoneNo = toPhoneNo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getFromPhoneNo() {
		return fromPhoneNo;
	}
	public void setFromPhoneNo(String fromPhoneNo) {
		this.fromPhoneNo = fromPhoneNo;
	}
	public String getToPhoneNo() {
		return toPhoneNo;
	}
	public void setToPhoneNo(String toPhoneNo) {
		this.toPhoneNo = toPhoneNo;
	}
	
}
