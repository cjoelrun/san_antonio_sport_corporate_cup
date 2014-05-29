package com.sas.db.repository;

import com.sas.common.Event;
import com.sas.common.Score;
import com.sas.common.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pete
 * Date: 4/13/14
 * Time: 4:47 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ScoreRepository extends JpaRepository<Score, Long> {
    public Iterable<Score> findByTeam(Team team);

    public Iterable<Score> findByEvent(Event event);

    public Score findByTeamAndEvent(Team team, Event event);
}
