package com.sas.service.impl;

import com.sas.common.Division;
import com.sas.db.repository.DivisionRepository;
import com.sas.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: pete
 * Date: 4/13/14
 * Time: 6:03 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class DivisionServiceImpl implements DivisionService {

    @Autowired
    DivisionRepository repo;

    @Override
    public <S extends Division> S create(@NotNull S obj) {
        throw new RuntimeException("Don't use");
    }

    @Override
    public Division retrieve(@NotNull Long id) {
        return repo.findOne(id);
    }

    @Override
    public Iterable<Division> retrieveAll() {
        return repo.findAll();
    }

    @Override
    public <S extends Division> S update(@NotNull S obj) {
        return repo.save(obj);
    }

    @Override
    public void delete(@NotNull Long id) {
        repo.delete(id);
    }

    @Override
    public void delete(@NotNull Division obj) {
        repo.delete(obj);
    }

    @Override
    public Long count() {
        return repo.count();
    }
}
