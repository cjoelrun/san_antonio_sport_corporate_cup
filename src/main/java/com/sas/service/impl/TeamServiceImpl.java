package com.sas.service.impl;

import com.sas.common.Division;
import com.sas.common.Team;
import com.sas.db.repository.TeamRepository;
import com.sas.service.TeamService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pete
 * Date: 4/13/14
 * Time: 6:55 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class TeamServiceImpl implements TeamService {
    @Autowired
    TeamRepository repo;

    @Override
    public <S extends Team> S create(@NotNull S obj) {
        return repo.save(obj);
    }

    @Override
    public Team retrieve(@NotNull Long aLong) {
        return repo.findOne(aLong);
    }

    @Override
    public Iterable<Team> retrieveAll() {
        return repo.findAll();
    }

    @Override
    public <S extends Team> S update(@NotNull S obj) {
        return repo.save(obj);
    }

    @Override
    public void delete(@NotNull Long aLong) {
        repo.delete(aLong);
    }

    @Override
    public void delete(@NotNull Team obj) {
        repo.delete(obj);
    }

    @Override
    public Long count() {
        return repo.count();
    }

    @Override
    public Iterable<Team> findTeamByDivision(Division division) {
        return repo.findByDivision(division);
    }
}
