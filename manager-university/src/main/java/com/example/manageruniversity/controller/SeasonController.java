package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.SeasonDTO;
import com.example.manageruniversity.service.ISeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SeasonController {
    private final ISeasonService seasonService;

    @Autowired
    public SeasonController(ISeasonService seasonService) {
        this.seasonService = seasonService;
    }
    @PostMapping("/api/seasons")
    public SeasonDTO createSeason(@RequestBody SeasonDTO seasonDTO) {
        return seasonService.saveOrUpdate(seasonDTO);
    }

    @PutMapping("/api/seasons/{seasonId}")
    public SeasonDTO updateSeason(@PathVariable("seasonId") Long seasonId,
                                  @RequestBody SeasonDTO seasonDTO) {
        seasonDTO.setId(seasonId);
        return seasonService.saveOrUpdate(seasonDTO);
    }
    @DeleteMapping("/api/seasons/{seasonId}")
    public void deleteSeason(@PathVariable("seasonId") Long seasonId) {
        seasonService.delete(seasonId);
    }
    @GetMapping("/api/seasons")
    public List<SeasonDTO> seasonList() {
        return seasonService.records();
    }
}
