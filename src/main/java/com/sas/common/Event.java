package com.sas.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: pete
 * Date: 4/13/14
 * Time: 4:06 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Event")
public class Event {

    @Id
    @GeneratedValue
    Long id;

    @Column(name="NAME")
    String name;

    @ManyToOne
    @JoinColumn(name = "EVENT_TYPE_ID", referencedColumnName = "ID")
    EventType eventType;

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

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
}
