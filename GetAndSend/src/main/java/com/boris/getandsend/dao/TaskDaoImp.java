package com.boris.getandsend.dao;

import com.boris.getandsend.entity.Task;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;

/**
 * Created by boris on 17.08.17.
 */
@Repository
public class TaskDaoImp implements TaskDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public String getTask(int number) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<String> criteria = builder.createQuery(String.class);
        Root<Task> taskRoot = criteria.from(Task.class);
        criteria.select(taskRoot.get("taskDetails").as(String.class));
        criteria.where(builder.equal(taskRoot.get("id"), number));
        String jsonString = session.createQuery(criteria).getSingleResult();
        session.close();
        JsonObject obj = new JsonParser().parse(jsonString).getAsJsonObject();
        return obj.get("taskType").getAsString();

    }

    @Override
    public String getTaskDetails(int number) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<String> criteria = builder.createQuery(String.class);
        Root<Task> taskRoot = criteria.from(Task.class);
        criteria.select(taskRoot.get("taskDetails").as(String.class));
        criteria.where(builder.equal(taskRoot.get("id"), number));
        String details = session.createQuery(criteria).getSingleResult();
        session.close();
        return details;
    }

    @Override
    public void update(int number) {
        String newStatus = "complete";
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaUpdate<Task> update = builder.createCriteriaUpdate(Task.class);
        Root<Task> taskRoot = update.from(Task.class);
        update.set(taskRoot.get("status"), newStatus);
        update.set(taskRoot.get("updateDate"), new Date());
        update.where(builder.equal(taskRoot.get("id"), number));
        session.createQuery(update).executeUpdate();
        tx.commit();
        session.close();

    }

    @Override
    public int getNumberOfTasks() {


        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Integer> criteria = builder.createQuery(Integer.class);
        Root<Task> taskRoot = criteria.from(Task.class);
        criteria.select(taskRoot.get("id").as(int.class));
        List numbers = session.createQuery(criteria).getResultList();
        int n = numbers.size();
        session.close();
        return n;

    }

    @Override
    public void add(Task task) {

        {
            sessionFactory.getCurrentSession().save(task);
        }

    }
}
