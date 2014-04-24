package com.sas.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pete
 * Date: 4/13/14
 * Time: 4:06 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Division")
public class Division {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="NAME")
    String name;

    @OneToMany(mappedBy = "division")
    private List<Team> teams = new ArrayList<Team>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
