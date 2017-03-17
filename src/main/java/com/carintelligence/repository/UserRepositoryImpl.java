package com.carintelligence.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.carintelligence.model.User;

/**
 * Project: carintelligence
 * Created by Leonardo Simoza on 09/3/17.
 **/
@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository
{

    @PersistenceContext
    private EntityManager em;


    public User find(Long userId)
    {
        // Returns the User for given userId.
        return em.find(User.class, userId);
    }


    public User save(User user)
    {
        // Saves the given user object and returns the same.
        em.persist(user);
        em.flush();
        return user;
    }


    @Override
    public List<User> findAll()
    {
        // Returns all the users in our system.
//        TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<User> q = cb.createQuery(User.class);
        Root<User> c = q.from(User.class);
        q.select(c);
        TypedQuery<User> query = em.createQuery(q);
        return query.getResultList();
    }


    @Override
    public List<User> paginate(int offset, int limit)
    {
        // Returns the list of paginated users.
//        TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<User> q = cb.createQuery(User.class);
        Root<User> c = q.from(User.class);
        q.select(c);
        TypedQuery<User> query = em.createQuery(q);
        return query.setFirstResult(offset).setMaxResults(limit).getResultList();
    }


    @Override
    public User update(User user, Long userId)
    {
        // Updates the given user with new data.
        user.setId(userId);
        User updatedUser = em.merge(user);
        em.flush();
        return updatedUser;
    }


    @Override
    public User delete(Long userId)
    {
        // Deletes the user with the given userId.
        User userToBeDeleted = em.find(User.class, userId);
        em.remove(userToBeDeleted);
        return userToBeDeleted;
    }

}
