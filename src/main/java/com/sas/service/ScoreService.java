package com.sas.service;

import com.sas.common.Event;
import com.sas.common.Score;
import com.sas.common.Team;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pete
 * Date: 4/13/14
 * Time: 4:35 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ScoreService extends AbstractService<Score, Long> {
    public Iterable<Score> findByTeam(Team team);

    public Iterable<Score> findByEvent(Event event);

    public List<Score> findByTeams(Iterable<Team> teams);

    public Score findByTeamAndEvent(Team team, Event event);
}
