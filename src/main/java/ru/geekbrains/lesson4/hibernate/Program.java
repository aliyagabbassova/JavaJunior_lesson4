package ru.geekbrains.lesson4.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.geekbrains.lesson4.homework4.Course;
import ru.geekbrains.lesson4.homework4.SchoolDB;

public class Program {
    public static void main(String[] args) {
        // Создание фабрики сессий
        SessionFactory sessionFactory =  new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(SchoolDB.class)
                .buildSessionFactory();


        try  (Session session = sessionFactory.getCurrentSession()){
//            // Начало транзакции
            session.beginTransaction();
            // Создание объекта
            SchoolDB school = SchoolDB.create();
            // Сохранение объекта в базе данных
            session.save(school);
//            System.out.println("Object student save successfully");
            System.out.println("Object schoolDB save successfully");
            // Чтение объекта из базы данных
            SchoolDB retrievedStudent = session.get(SchoolDB.class, school.getId());
            System.out.println("Object schoolDB retrieved successfully");
            System.out.println("Retrieved schoolDB object: " + retrievedStudent);
            // Обновление объекта
            retrievedStudent.updateID();
            retrievedStudent.updateTitle();
            session.update(retrievedStudent);
            System.out.println("Object schoolDB update successfully");
            // Удаление объекта
            session.delete(retrievedStudent);
            System.out.println("Object schoolDB delete successfully");
//            // Коммит транзакции
//            session.getTransaction().commit();
//            System.out.println("Transaction commit successfully");

        }
    }
}


