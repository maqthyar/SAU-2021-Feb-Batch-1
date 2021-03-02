package com.accolite.domain;

public class RestaurantEvent
{

	private Integer orderId;
	private String orderName;
	private String orderTime;
	private String orderTableId;


	public Integer getOrderId()
	{
		return orderId;
	}

	public void setOrderId(Integer orderId)
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

	public String getOrderTableId()
	{
		return orderTableId;
	}

	public void setOrderTableId(String orderTableId)
	{
		this.orderTableId = orderTableId;
	}

	@Override
	public String toString()
	{
		return "RestaurantEvent{" +
				"orderId=" + orderId +
				", orderName='" + orderName + '\'' +
				", orderTime='" + orderTime + '\'' +
				", orderTableId='" + orderTableId + '\'' +
				'}';
	}
}
