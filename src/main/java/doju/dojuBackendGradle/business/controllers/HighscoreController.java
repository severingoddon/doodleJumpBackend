package doju.dojuBackendGradle.business.controllers;

import doju.dojuBackendGradle.business.models.Highscore;
import doju.dojuBackendGradle.business.services.HighscoreServiceImpl;
import doju.dojuBackendGradle.business.utils.HighscoreDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor  //makes a constructor and instantiation (lombok)
@RequestMapping(path = "doju/v1/highscore")
public class HighscoreController {

    private final HighscoreServiceImpl highscoreService; //instantiated by lombok

    @CrossOrigin
    @GetMapping
    public List<Highscore> getHighscore(){
        return highscoreService.getHighscore();
    }

    @CrossOrigin
    @DeleteMapping("/delete")
    public void deleteHighscore(@RequestParam int id){
        highscoreService.deleteHighscore(id);
    }

    @CrossOrigin
    @PostMapping
    public void addHighscore(@RequestBody HighscoreDto highscore) {
        if (highscore.getValue() > highscoreService.getHighscore().get(0).getValue()) {
            Highscore newHighscore = new Highscore(highscore.getValue());
            newHighscore.setId(1); //because we only want one highscore currently so id is always the same. Will be overwritten everytime
            highscoreService.addHighscore(newHighscore);
        }
    }
}
