package com.example.repository;

import com.example.domain.Task;
import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Data
@Repository
public class TaskRepository {
    SessionFactory sessionFactory;

    public List<Task> getAllTasks(){
        Session session = sessionFactory.getCurrentSession();
        Query<Task> allFromTask = session.createQuery("FROM Task", Task.class);
        return allFromTask.getResultList();
    }
}
