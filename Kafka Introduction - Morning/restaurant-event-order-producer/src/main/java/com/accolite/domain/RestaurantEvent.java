package com.accolite.domain;

public class RestaurantEvent
{

	private int orderId;
	private String orderName;
	private String orderTime;
	private String orderTableId;

	public String getOrderTableId()
	{
		return orderTableId;
	}

	public void setOrderTableId(String orderTableId)
	{
		this.orderTableId = orderTableId;
	}

	public int getOrderId()
	{
		return orderId;
	}

	public void setOrderId(int orderId)
	{
		this.orderId = orderId;
	}

	public String getOrderName()
	{
		return orderName;
	}

	public void setOrderName(String orderName)
	{
		this.orderName = orderName;
	}

	public String getOrderTime()
	{
		return orderTime;
	}

	public void setOrderTime(String orderTime)
	{
		this.orderTime = orderTime;
	}



	/*
	 * public LibraryEventType getLibraryEventType() { return libraryEventType; }
	 * 
	 * public void setLibraryEventType(LibraryEventType libraryEventType) {
	 * this.libraryEventType = libraryEventType; }
	 */

}
