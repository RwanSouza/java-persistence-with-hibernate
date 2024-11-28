package com.helloworld;

import java.util.List;
import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HelloWorld {
	public static void main(String[] args) {

		EntityManagerFactory entt = Persistence.createEntityManagerFactory("Hibernate-PU");
		EntityManager enttManger = entt.createEntityManager();

		Message message = new Message("Hello World");

		enttManger.getTransaction().begin();
		enttManger.persist(message);
		enttManger.getTransaction().commit();

		List<Message> messages = enttManger.createQuery("from Message m order by m.text asc").getResultList();

		System.out.println(messages.size() + " message(s) found: ");

		for (Message loadedMsg  :messages) {
			System.out.println(loadedMsg.getText());
		}
		
		enttManger.getTransaction().begin();
		
		Message find = enttManger.find(Message.class, 1);
		
		find.setText("Greetings Earthling");
		find.setNextMessage(new Message("Take me to your leader (please)"));
		
		enttManger.getTransaction().commit();
		enttManger.close();
		entt.close();
	}
}
