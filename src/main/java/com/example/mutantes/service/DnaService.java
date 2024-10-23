package com.example.mutantes.service;

import com.example.mutantes.model.Dna;
import com.example.mutantes.repository.DnaRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Service
public class DnaService {
    private final DnaRepository dnaRepository;
    private static final String VALID_CHARACTERS = "ACTG";
    private static final int SEQUENCE_LENGTH = 4;
    private static final int REQUIRED_MUTANT_SEQUENCES = 2;

    public DnaService(DnaRepository dnaRepository) {
        this.dnaRepository = dnaRepository;
    }

    public boolean analyzeDna(String[] dna){
        boolean isValid = validateDna(dna);
        if (isValid){
            return checkDna(dna);
        }
        return false;
    }
    public static boolean validateDna(String[] dna){
        int n = dna.length;
        if (n == 0)return false;
        if(dna == null)return false;
        for (String sequence: dna){
            if (n != sequence.length() || sequence == null)return false;
            sequence.toCharArray();
            for (char c : sequence.toCharArray()){
                if (VALID_CHARACTERS.indexOf(c) == -1) return false;
            }
        }
        return true;

    }
    public boolean checkDna(String[] dnaArray){
        String dnaSequence = String.join(",",dnaArray);
        Optional<Dna> optionalDna = dnaRepository.findByDna(dnaSequence);
        Dna dna;
        if(optionalDna.isPresent()){
            dna = optionalDna.get();
            return dna.isMutant();
        }

        boolean isMutant = isMutant(dnaArray);

        dna = Dna.builder()
                .dna(dnaSequence)
                .isMutant(isMutant)
                .build();
        dnaRepository.save(dna);
        return dna.isMutant();
    }
    public static boolean isMutant (String[] dna) {

        int sequenceCounter = 0;
        int n = dna.length;

        char[][] dnaMatrix = new char[n][];


        for (int i = 0; i < n; i++) {
            dnaMatrix[i] = dna[i].toCharArray();
        }

        for (int i = 0;  i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                //checkRows
                if (j + 3 < n &&
                        dnaMatrix[i][j] == dnaMatrix[i][j + 1] &&
                        dnaMatrix[i][j] == dnaMatrix[i][j + 2] &&
                        dnaMatrix[i][j] == dnaMatrix[i][j + 3]) {
                    sequenceCounter++;
                }
                //checkColumn
                if (i + 3 < n &&
                        dnaMatrix[i][j] == dnaMatrix[i + 1][j] &&
                        dnaMatrix[i][j] == dnaMatrix[i + 2][j] &&
                        dnaMatrix[i][j] == dnaMatrix[i + 3][j]) {
                    sequenceCounter++;
                }
                //checkDiagonal left to right
                if (i + 3 < n && j +3 < n &&
                        dnaMatrix[i][j] == dnaMatrix[i + 1][j + 1] &&
                        dnaMatrix[i][j] == dnaMatrix[i + 2][j + 2] &&
                        dnaMatrix[i][j] == dnaMatrix[i + 3][j + 3]) {
                    sequenceCounter++;
                }
                //checkDiagonal right to left
                if ((j-3)>=0 && (i + 3)< n &&
                        dnaMatrix[i][j] == dnaMatrix[i + 1][j - 1] &&
                        dnaMatrix[i][j] == dnaMatrix[i + 2][j - 2] &&
                        dnaMatrix[i][j] == dnaMatrix[i + 3][j - 3]) {
                    sequenceCounter++;
                }
                if (sequenceCounter >= REQUIRED_MUTANT_SEQUENCES){
                    return true;
                }
            }
        }
        return false;
    }
}


