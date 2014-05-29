package com.sas.service;

import com.sas.common.Division;
import com.sas.common.Team;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pete
 * Date: 4/13/14
 * Time: 4:35 PM
 * To change this template use File | Settings | File Templates.
 */
public interface TeamService extends AbstractService<Team, Long> {
    public Iterable<Team> findTeamByDivision(Division division);
}
