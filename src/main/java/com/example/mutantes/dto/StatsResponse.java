package com.example.mutantes.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatsResponse {
    private int count_mutant_dna;
    private int count_human_dna;
    private float ratio;
}
