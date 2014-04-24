package com.sas.db.repository;

import com.sas.common.Event;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * User: pete
 * Date: 4/13/14
 * Time: 4:46 PM
 * To change this template use File | Settings | File Templates.
 */
public interface EventRepository extends JpaRepository<Event, Long> {
}
