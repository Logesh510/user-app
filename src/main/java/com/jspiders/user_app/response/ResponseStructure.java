package com.jspiders.user_app.response;
//package as response but in real time Util

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class ResponseStructure<T> {

	private T Data; //Type Inference(T)
	private LocalDateTime timeStamp;
	private int statusCode;
	private String message;
}
