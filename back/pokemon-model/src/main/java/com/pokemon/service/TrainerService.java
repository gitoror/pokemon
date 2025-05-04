package com.pokemon.service;

import com.pokemon.model.Trainer;
import com.pokemon.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    public Trainer getTrainerById(Long id) {
        return trainerRepository.findById(id).orElseThrow(() -> new RuntimeException("Trainer not found"));
    }

    public Trainer createTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    public Trainer updateTrainer(Long id, Trainer trainer) {
        Optional<Trainer> existingTrainer = trainerRepository.findById(id);
        if (existingTrainer.isPresent()) {
            Trainer updatedTrainer = existingTrainer.get();
            updatedTrainer.setName(trainer.getName());
            updatedTrainer.setAge(trainer.getAge());
            return trainerRepository.save(updatedTrainer);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Trainer not found with id " + id
            );
        }
    }

    public void deleteTrainer(Long id) {
        trainerRepository.deleteById(id);
    }

    public List<Trainer> searchTrainer(String name) {
        return trainerRepository.findByName(name);
    }
}
