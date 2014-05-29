package com.sas.db.repository;

import com.sas.common.Division;
import com.sas.common.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pete
 * Date: 4/13/14
 * Time: 4:48 PM
 * To change this template use File | Settings | File Templates.
 */
public interface TeamRepository extends JpaRepository<Team, Long> {
    public Iterable<Team> findByDivision(Division division);
}
