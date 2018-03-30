package com.iflow.model;

public class Mail {

	private String receiver;
	private String subject;
	private String message;
	
	public void setReceiver(String receiver)
	{
		this.receiver = receiver;
	}
	public void setSubject(String subject)
	{
		this.subject = subject;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	public String getMessage()
	{
		return message;
	}
	public String getSubject()
	{
		return subject;
		
	}
	public String getReceiver()
	{
		return receiver;
	}
}
