package doju.dojuBackendGradle.business.repositories;


import doju.dojuBackendGradle.business.models.Highscore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HighscoreRepository extends JpaRepository<Highscore, Integer> {

}
