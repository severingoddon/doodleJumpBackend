package doju.dojuBackendGradle.business.interfaces;

import doju.dojuBackendGradle.business.models.Highscore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface HighscoreService {
    public List<Highscore> getHighscore();
    public void deleteHighscore(Integer id);
    public void addHighscore(Highscore highscore);
}
