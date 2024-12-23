package com.jsp.foodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.foodapp.entities.Admin;
import com.jsp.foodapp.entities.FoodOrders;
import com.jsp.foodapp.entities.User;

@Repository
public class FoodOrdersDao {
	@Autowired
	EntityManagerFactory emf;
public void saveFoodOrders(FoodOrders foodorder) {
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	et.begin();
	em.persist(foodorder);
	et.commit();
}
public List<FoodOrders> viewAllfoodorder(){
	EntityManager em=emf.createEntityManager();
	Query query=em.createQuery("select f from FoodOrders f");
	return query.getResultList();
}
public FoodOrders viewfoodorderById(int id) {
	EntityManager em=emf.createEntityManager();
	FoodOrders foodorder=em.find(FoodOrders.class, id);
	return foodorder;
}
public void updatefoodorder(FoodOrders foodorder) {
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	et.begin();
	em.merge(foodorder);
	et.commit();
}
public void deletefoodorderById(int id) {
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	FoodOrders foodorder=em.find(FoodOrders.class, id);
	et.begin();
	em.remove(foodorder);
	et.commit();
}
}
