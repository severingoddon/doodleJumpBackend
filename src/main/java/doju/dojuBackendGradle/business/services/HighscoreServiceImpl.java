package doju.dojuBackendGradle.business.services;

import doju.dojuBackendGradle.business.interfaces.HighscoreService;
import doju.dojuBackendGradle.business.models.Highscore;
import doju.dojuBackendGradle.business.repositories.HighscoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HighscoreServiceImpl implements HighscoreService {

    private final HighscoreRepository highscoreRepository;

    public List<Highscore> getHighscore(){
        return highscoreRepository.findAll();
    }

    public void deleteHighscore(Integer id){
        highscoreRepository.deleteById(id);
    }

    public void addHighscore(Highscore highscore) {
        Optional<Highscore> highscoreOptional = highscoreRepository.findById(highscore.getId());
        if(highscoreOptional.isPresent()){
            highscoreRepository.deleteAll(); //currently we only want one highscore to be stored in the database. Could be changed later
            highscoreRepository.save(highscore);
        }else{
            highscoreRepository.save(highscore);
        }
    }
}
