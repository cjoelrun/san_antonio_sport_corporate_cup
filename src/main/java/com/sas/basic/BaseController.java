package com.sas.basic;

import com.sas.common.Division;
import com.sas.common.Event;
import com.sas.common.Score;
import com.sas.common.Team;
import com.sas.service.DivisionService;
import com.sas.service.EventService;
import com.sas.service.ScoreService;
import com.sas.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
@SessionAttributes({"eventIdSelected","divisionIdSelected","teamSelected"})
public class BaseController {

    Logger logger = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    DivisionService divisionService;

    @Autowired
    EventService eventService;

    @Autowired
    TeamService teamService;

    @Autowired
    ScoreService scoreService;

    @RequestMapping(value="/welcome", method = RequestMethod.GET)
    public String welcome(ModelMap model) {
        model.addAttribute("message", "Maven Web Project + Spring 3 MVC - welcome()");
        //Spring uses InternalResourceViewResolver and return back index.jsp
        return "index";
    }

    @RequestMapping(value="/welcome/{name}", method = RequestMethod.GET)
    public String welcomeName(@PathVariable String name, ModelMap model) {
        model.addAttribute("message", "Maven Web Project + Spring 3 MVC - " + name);
        return "index";
    }

    @RequestMapping(value="/getAllTeams", method = RequestMethod.GET)
    public String showTeams(ModelMap model){
        Iterable<Division> allDivision = divisionService.retrieveAll();
        StringBuilder sb = new StringBuilder();
        for(Division division : allDivision){
            sb.append(division.getName()).append("<br>");
        }
        model.addAttribute("message", sb.toString());
        return "index";
    }

    @RequestMapping(value="/selectEvent", method = RequestMethod.GET)
    public String showEvents(ModelMap model){
        Iterable<Event> allEvents = eventService.retrieveAll();
        model.remove("eventIdSelected");
        model.remove("divisionIdSelected");
        model.remove("teamSelected");
        model.addAttribute("events", allEvents);
        return "selectEvent";
    }

    @RequestMapping(value="/setEvent/{eventId}")
    public String showDivision(@PathVariable("eventId") String eventId, ModelMap model){
        model.addAttribute("eventIdSelected", Long.valueOf(eventId));
        Iterable<Division> allDivision = divisionService.retrieveAll();
        model.addAttribute("divisions", allDivision);
        return "selectDivision";
    }

    @RequestMapping(value="/setDivision/{divisionId}", method = RequestMethod.GET)
    public String showTeams(@PathVariable("divisionId") String divisionId, ModelMap model){
        Long divisionIdSelected = Long.valueOf(divisionId);
        Division division = divisionService.retrieve(divisionIdSelected);
        Iterable<Team> allTeams = teamService.findTeamByDivision(division);
        Event event = eventService.retrieve((Long)model.get("eventIdSelected"));
        List<Team> selectableTeams = new ArrayList<Team>();
        for(Team team : allTeams){
            Score score = scoreService.findByTeamAndEvent(team, event);
            if(score == null){
                selectableTeams.add(team);
            }
        }
        model.addAttribute("divisionIdSelected", divisionIdSelected);
        model.addAttribute("teams", selectableTeams);
        return "selectTeam";
    }

    @RequestMapping(value="/setTeam/{teamId}", method = RequestMethod.GET)
    public String selectTeam(@PathVariable("teamId") String teamId, ModelMap model){
        Long teamIdSelected = Long.valueOf(teamId);
        model.addAttribute("teamSelected", teamService.retrieve(teamIdSelected));
        return "addScore";
    }

    @RequestMapping(value="/addScore/{score}", method = RequestMethod.GET)
    public String addScore(@PathVariable("score") String score_str, ModelMap model){
        Integer score = Integer.valueOf(score_str);
        Team selectedTeam = (Team)model.get("teamSelected");
        logger.debug("selected team : " + ((selectedTeam != null) ? selectedTeam.getName():"null team"));
        Long eventId = (Long)model.get("eventIdSelected");
        logger.debug("selected event " + eventId);
        Event event = eventService.retrieve(eventId);
        Score scoreDb = new Score();
        scoreDb.setEvent(event);
        scoreDb.setTeam(selectedTeam);
        scoreDb.setScore(score);
        scoreService.create(scoreDb);
        model.addAttribute("allScores", scoreService.retrieveAll());
        return "showAllScores";
    }

}