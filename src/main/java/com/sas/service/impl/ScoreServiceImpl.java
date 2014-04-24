package com.sas.service.impl;

import com.sas.common.Score;
import com.sas.db.repository.ScoreRepository;
import com.sas.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: pete
 * Date: 4/13/14
 * Time: 6:53 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    ScoreRepository repo;
    @Override
    public <S extends Score> S create(@NotNull S obj) {
        return repo.save(obj);
    }

    @Override
    public Score retrieve(@NotNull Long aLong) {
        return repo.findOne(aLong);
    }

    @Override
    public Iterable<Score> retrieveAll() {
        return repo.findAll();
    }

    @Override
    public <S extends Score> S update(@NotNull S obj) {
        return repo.save(obj);
    }

    @Override
    public void delete(@NotNull Long aLong) {
        repo.delete(aLong);
    }

    @Override
    public void delete(@NotNull Score obj) {
        repo.delete(obj);
    }

    @Override
    public Long count() {
        return repo.count();
    }
}
