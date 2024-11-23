package com.hibernate.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;


public class EntityManagerTest {

    protected static EntityManagerFactory entityManagerFactory;

    protected EntityManager  entityManager;

    @BeforeAll
    public static void setUpBeforeAll() {
        entityManagerFactory = Persistence.createEntityManagerFactory("Hibernate-PU");
    }

    @AfterAll
    public static void tearDownAfterAll() {
        entityManagerFactory.close();
    }

    @BeforeEach
    public void setUp() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterEach
    public void tearDown() {
        entityManager.close();
    }

    public <T> void persist(T t) {
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
    }
}
