package com.educandoweb.course.enitties.enums;

public enum OrderStatus {
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code; // cria-se code para enumerar as etapas do status
	
	private OrderStatus(int code) {
		this.code = code;
	}
    public int getCode(){
    	return code;
    }
    
    public static OrderStatus valueOf(int code) { // metodo vai retornar um código e transformalo em status ex = 1 = waiting_Payment
    	for(OrderStatus value : OrderStatus.values()  ) {
    		if(value.getCode() == code) {
    			return value;
    		}
    	}
		throw new IllegalArgumentException("Invalid Status Code");
    }
}
