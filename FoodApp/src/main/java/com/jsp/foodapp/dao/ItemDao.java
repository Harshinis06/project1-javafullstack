package com.jsp.foodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.foodapp.entities.FoodOrders;
import com.jsp.foodapp.entities.Item;
import com.jsp.foodapp.entities.User;

@Repository
public class ItemDao {
	@Autowired
	EntityManagerFactory emf;
public void saveItem(Item item) {
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	et.begin();
	em.persist(item);
	et.commit();
}
public List<Item> viewAllitem(){
	EntityManager em=emf.createEntityManager();
	Query query=em.createQuery("select i from Item i");
	return query.getResultList();
}
public Item viewitemById(int id) {
	EntityManager em=emf.createEntityManager();
	Item item=em.find(Item.class, id);
	return item;
}
public void updateitem(Item item) {
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	et.begin();
	em.merge(item);
	et.commit();
}
public void deleteitemorderById(int id) {
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	Item item=em.find(Item.class, id);
	et.begin();
	em.remove(item);
	et.commit();
}
}
