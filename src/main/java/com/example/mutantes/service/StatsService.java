package com.example.mutantes.service;

import com.example.mutantes.dto.StatsResponse;
import com.example.mutantes.repository.DnaRepository;
import org.springframework.stereotype.Service;

@Service
public class StatsService {
    private final DnaRepository dnaRepository;

    public StatsService(DnaRepository dnaRepository) {
        this.dnaRepository = dnaRepository;
    }

    public StatsResponse getStats (){
        int mutant = dnaRepository.countByIsMutant(true);
        int human = dnaRepository.countByIsMutant(false);
        float ratio = (float) mutant / human;
        return StatsResponse.builder()
                .count_mutant_dna(mutant)
                .count_human_dna(human)
                .ratio(ratio)
                .build();
    }
}
