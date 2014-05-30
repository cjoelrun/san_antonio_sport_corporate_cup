package com.sas.basic;

import com.sas.common.Division;
import com.sas.common.DivisionScore;
import com.sas.common.Event;
import com.sas.common.Score;
import com.sas.common.Team;
import com.sas.common.TeamTotal;
import com.sas.service.DivisionService;
import com.sas.service.EventService;
import com.sas.service.ScoreService;
import com.sas.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: pete
 * Date: 4/27/14
 * Time: 9:01 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/standings")
@SessionAttributes({"division", "eventIdSelected","divisionIdSelected","teamSelected"})
public class StandingsController {
    Logger logger = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    DivisionService divisionService;

    @Autowired
    EventService eventService;

    @Autowired
    TeamService teamService;

    @Autowired
    ScoreService scoreService;

    @RequestMapping(value="/team/{team_id}", method= RequestMethod.GET)
    public String getTeamStandings(@PathVariable("team_id") String teamId, ModelMap model){
        Team team = teamService.retrieve(Long.valueOf(teamId));
        Iterable<Score> teamScores = scoreService.findByTeam(team);
        model.addAttribute("team", team);
        model.addAttribute("teamScore", teamScores);
        return "teamStandings";
    }

    @RequestMapping(value="/event/{event_id}", method = RequestMethod.GET)
    public String getEventStandings(@PathVariable("event_id") String eventId, ModelMap model){
        Event event = eventService.retrieve(Long.valueOf(eventId));
        Iterable<Score> eventScores = scoreService.findByEvent(event);
        List<Score> divisionScores = new ArrayList<Score>();
        Division currDevision = (Division)model.get("division");
        for(Score score : eventScores){
            if(score.getTeam().getDivision().getId().equals(currDevision.getId())){
                divisionScores.add(score);
            }
        }
        Collections.sort(divisionScores,new Comparator <Score>(){

            @Override
            public int compare(Score o1, Score o2) {
                return o1.getScore().compareTo(o2.getScore()) *-1;
            }
        });
        model.addAttribute("event", event);
        model.addAttribute("eventScores", divisionScores);
        return "eventStandings";
    }

    @RequestMapping(value="/division/{division_id}/event/{event_id}", method = RequestMethod.GET)
    public String getEventResutsByDivision(@PathVariable("division_id") String divisionId,
                                           @PathVariable("event_id") String eventId,
                                           ModelMap model){
        Event event = eventService.retrieve(Long.valueOf(eventId));
        Iterable<Score> eventScores = scoreService.findByEvent(event);
        List<Score> divisionScores = new ArrayList<Score>();
        Division currDevision = divisionService.retrieve(Long.valueOf(divisionId));
        for(Score score : eventScores){
            if(score.getTeam().getDivision().getId().equals(currDevision.getId())){
                divisionScores.add(score);
            }
        }
        Collections.sort(divisionScores,new Comparator <Score>(){

            @Override
            public int compare(Score o1, Score o2) {
                return o1.getScore().compareTo(o2.getScore()) *-1;
            }
        });
        model.addAttribute("event", event);
        model.addAttribute("eventScores", divisionScores);
        model.addAttribute("division", currDevision);
        return "eventStandings";
    }

    @RequestMapping(value="/division/{division_id}", method = RequestMethod.GET)
    public String getDivisionStandings(@PathVariable("division_id") String divisionId, ModelMap model){
        Division division = divisionService.retrieve(Long.valueOf(divisionId));
        Iterable<Team> teamsInDivision = teamService.findTeamByDivision(division);
        Iterable<Score> scores = scoreService.findByTeams(teamsInDivision);
        DivisionScore divisionScore = new DivisionScore();
        for(Team team : teamsInDivision){
            TeamTotal teamTotal = new TeamTotal();
            teamTotal.setTeam(team);
            teamTotal.setTotalScore(Integer.valueOf(0));
            divisionScore.getTeamScore().add(teamTotal);
        }

        for(Score score : scores){
            for(TeamTotal team : divisionScore.getTeamScore()){
                if(score.getTeam().getId().equals(team.getTeam().getId())){
                    team.setTotalScore(team.getTotalScore()+score.getScore());
                }
            }
        }
        Collections.sort(divisionScore.getTeamScore(),new Comparator <TeamTotal>(){

            @Override
            public int compare(TeamTotal o1, TeamTotal o2) {
                return o1.getTotalScore().compareTo(o2.getTotalScore()) *-1;
            }
        });
        model.addAttribute("division", division);
        model.addAttribute("divisionScores", divisionScore.getTeamScore());
        return "divisionScores";
    }

    @RequestMapping(value="/standings/getAllEvents", method = RequestMethod.GET)
    public String getAllEvents(ModelMap model){
        model.addAttribute("allEvents", eventService.retrieveAll());
        return "standingEvent";
    }
}
