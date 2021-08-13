package com.apimmi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.apimmi.models.entities.Position;
import com.apimmi.dto.ListPositionDto;
import com.apimmi.models.repos.PositionRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PositionService {

    @Autowired
    private PositionRepo positionRepo;

    public Iterable<Position> listPosition() {
        return positionRepo.findAll();
    }

    public List<ListPositionDto> findAll() {
        List<Position> emp = (List<Position>) positionRepo.findAll();

        List<ListPositionDto> list = new ArrayList<>();

        for (int i = 0; i < emp.size(); i++) {
            ListPositionDto le = new ListPositionDto();
            le.setId(emp.get(i).getId());
            le.setName(emp.get(i).getName());

            list.add(le);
        }

        return list;
    }

    public Position getDao(String name) {
        return positionRepo.getDao(name);
    }

    public Position findById(Long id) {
        Optional<Position> pos = positionRepo.findById(id);
        return pos.get();
    }

}
