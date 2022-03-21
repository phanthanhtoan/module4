package com.codegym.repository.impl;

import com.codegym.model.Music;
import com.codegym.repository.MusicRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class MusicRepositoryImpl implements MusicRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Music> findAll() {
        TypedQuery<Music> query = em.createQuery("select c from Music c", Music.class);
        return query.getResultList();
    }

    @Override
    public Music findById(Long id) {
        TypedQuery<Music> query = em.createQuery("select c from Music c where  c.id=:id", Music.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void save(Music model) {
        if(model.getId() != null){
            em.merge(model);
        } else {
            em.persist(model);
        }
    }

    @Override
    public void remove(Long id) {
        Music customer = findById(id);
        if(customer != null){
            em.remove(customer);
        }
    }
}
