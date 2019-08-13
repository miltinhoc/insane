package org.academiadecodigo.codezillas.insane.persistence.daos.jpa;

import org.academiadecodigo.codezillas.insane.persistence.daos.Dao;
import org.academiadecodigo.codezillas.insane.persistence.model.AbstractUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDao<T extends AbstractUser> implements Dao {

    private Class<T> accountType;

    @PersistenceContext
    protected EntityManager em;

    public void setEm(EntityManager em) {
        this.em = em;
    }



    public T findById(Integer id) {
        return em.find(accountType, id);
    }


    public List<T> findAll() {

            CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(accountType);
            Root<T> root = criteriaQuery.from(accountType);
            return em.createQuery(criteriaQuery).getResultList();
    }

    public Object saveOrUpdate(Object accountModel) {
        return em.merge(accountModel);
    }


    public void delete(Integer id) {
        em.remove(em.find(accountType,id));
    }


    public Class<T> getAccountType() {
        return accountType;
    }

    public void setAccountType(Class<T> accountType) {
        this.accountType = accountType;
    }
}
