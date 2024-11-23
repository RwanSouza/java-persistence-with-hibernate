package com.helloworld;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HelloWorld {
    public static void main(String[] args) {

        EntityManagerFactory entt = Persistence.createEntityManagerFactory("Hibernate-PU");
        EntityManager enttManger = entt.createEntityManager();

        enttManger.close();
        entt.close();

    }
}
