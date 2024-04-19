package com.example.repository;

import com.example.domain.Task;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class TaskRepository {
  private final SessionFactory sessionFactory;

    public List<Task> getAllTasks(){
        Session session = sessionFactory.getCurrentSession();
        Query<Task> allFromTask = session.createQuery(" FROM Task", Task.class);
        return allFromTask.getResultList();
    }
    public void saveTask(Task task){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(task);
    }
    public Optional<Task> getById(Long id){
        Session session = sessionFactory.getCurrentSession();
       return Optional.ofNullable(session.get(Task.class, id));
    }
    public  void delete (Long id){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT t FROM Task t WHERE id = :id");
        query.setParameter("id", id);
        Object task = query.uniqueResult();
        session.delete(task);

    }
}
