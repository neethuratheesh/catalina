package com.catalina.messaging;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer {
	
	private final static String Queue_Name = "Catalina";

	public static void main(String[] args) throws IOException, TimeoutException {
		// TODO Auto-generated method stub
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		try (Connection connection = factory.newConnection();
				Channel channel = connection.createChannel()){
			channel.queueDeclare(Queue_Name, false, false, false, null);
			String message = "Hello World";
			channel.basicPublish("",Queue_Name,null,message.getBytes());
			System.out.println("Sent Message!!" + message);
		}

	}

}
