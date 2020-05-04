package com.catalina.messaging;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class consumer {
	
	private final static String Queue_Name = "Catalina";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(Queue_Name, false, false, false, null);
		System.out.println("Waiting for messages:");
		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(),"UTF-8");
			System.out.println("Meesage Received :- " + " " +message);
		};
		channel.basicConsume(Queue_Name,true,deliverCallback,consumerTag -> {});
		
		
		
		
		
	}

}
