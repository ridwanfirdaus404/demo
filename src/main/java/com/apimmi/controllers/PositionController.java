package com.apimmi.controllers;

import com.apimmi.dto.SearchKey;
import com.apimmi.models.entities.Position;
import com.apimmi.services.PositionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.apimmi.dto.ListPositionDto;

@RestController
@RequestMapping("api/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @PostMapping("/get/name")
    public Position getDao(@RequestBody SearchKey searchKey) {
        return positionService.getDao(searchKey.getSearchKey());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<ListPositionDto> findAll() {
        return positionService.findAll();
    }

}
