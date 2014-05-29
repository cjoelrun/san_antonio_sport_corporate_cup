package com.sas.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: pete
 * Date: 5/27/14
 * Time: 10:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class DivisionScore {
    private List<TeamTotal> teamScore = new ArrayList<TeamTotal>();

    public List<TeamTotal> getTeamScore() {
        return teamScore;
    }

    public void setTeamScore(List<TeamTotal> teamScore) {
        this.teamScore = teamScore;
    }
}
