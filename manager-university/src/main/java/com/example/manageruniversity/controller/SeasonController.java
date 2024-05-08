package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.SeasonDTO;
import com.example.manageruniversity.service.ISeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class SeasonController {
    private final ISeasonService seasonService;

    @Autowired
    public SeasonController(ISeasonService seasonService) {
        this.seasonService = seasonService;
    }
    @PostMapping("/seasons")
    public SeasonDTO createSeason(@RequestBody SeasonDTO seasonDTO) {
        return seasonService.saveOrUpdate(seasonDTO);
    }

    @PutMapping("/seasons/{seasonId}")
    public SeasonDTO updateSeason(@PathVariable("seasonId") Long seasonId,
                                  @RequestBody SeasonDTO seasonDTO) {
        seasonDTO.setId(seasonId);
        return seasonService.saveOrUpdate(seasonDTO);
    }
    @DeleteMapping("/seasons/{seasonId}")
    public void deleteSeason(@PathVariable("seasonId") Long seasonId) {
        seasonService.delete(seasonId);
    }
    @GetMapping("/seasons")
    public List<SeasonDTO> seasonList() {
        return seasonService.records();
    }
    @GetMapping("/seasons/courses/{coursesId}")
    public List<SeasonDTO> getListSeasonByCoursesId(@PathVariable("coursesId") Long coursesId) {
        return seasonService.getListSeasonByCoursesId(coursesId);
    }
    @GetMapping("/seasons/search")
    public List<SeasonDTO> getListByDisabled(@RequestParam("disabled") boolean disabled) {
        return seasonService.getListSeasonByDisabled(disabled);
    }
    @GetMapping("/seasons/{seasonId}")
    public SeasonDTO getSeasonById(@PathVariable("seasonId") Long seasonId) {
        return seasonService.findById(seasonId);
    }
}
