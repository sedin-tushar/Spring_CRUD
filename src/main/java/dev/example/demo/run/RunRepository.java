package dev.example.demo.run;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class RunRepository {
  private static final Logger log = LoggerFactory.getLogger(RunRepository.class);
  private List<Run> runs=new ArrayList<>();

  List<Run> findAll(){
    return runs;
  }

  Optional<Run> findById(Integer id){
    return runs.stream()
                   .filter(run -> Objects.equals(run.id(), id))
                   .findFirst() ;
  }

  void create(Run run){
    runs.add(run);
  }

  void update(Run newRun, Integer id) {
        Optional<Run> existingRun = findById(id);
        if(existingRun.isPresent()) {
            var r = existingRun.get();
            log.info("Updating Existing Run: " + existingRun.get());
            runs.set(runs.indexOf(r),newRun);
        }
    }

    void delete(Integer id) {
        runs.removeIf(run -> Objects.equals(run.id(), id));
    }

  @PostConstruct
  private void init() {
    runs.add(new Run(1, "Monday Ru", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 3, Location.OUTDOOR));
    runs.add(new Run(2, "Wednesday Run", LocalDateTime.now(), LocalDateTime.now().plus(4, ChronoUnit.HOURS), 5, Location.OUTDOOR));
  }
}
