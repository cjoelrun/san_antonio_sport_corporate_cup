package com.sas.service.impl;

import com.sas.common.Event;
import com.sas.db.repository.EventRepository;
import com.sas.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: pete
 * Date: 4/13/14
 * Time: 6:51 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class EventServiceImpl implements EventService {
    @Autowired
    EventRepository repo;

    @Override
    public <S extends Event> S create(@NotNull S obj) {
        return repo.save(obj);
    }

    @Override
    public Event retrieve(@NotNull Long aLong) {
        return repo.findOne(aLong);
    }

    @Override
    public Iterable<Event> retrieveAll() {
        return repo.findAll();
    }

    @Override
    public <S extends Event> S update(@NotNull S obj) {
        return repo.save(obj);
    }

    @Override
    public void delete(@NotNull Long aLong) {
        repo.delete(aLong);
    }

    @Override
    public void delete(@NotNull Event obj) {
        repo.delete(obj);
    }

    @Override
    public Long count() {
        return repo.count();
    }
}
