package com.apimmi.models.repos;

import java.util.List;

import javax.websocket.server.PathParam;

import com.apimmi.models.entities.Position;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepo extends CrudRepository<Position, Long> {

    @Query("SELECT p.id,p.name FROM Position p")
    public List<Position> listPosition();

    @Query("SELECT p FROM Position p WHERE p.name = :name")
    public Position getDao(@PathParam("name") String name);

}
