package com.name.OX;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ola Podorska
 */
class AutomatCreatorDiagonally implements AutomatCreator {
    @Override
    public void createFile(int size, int winningSigns) {
        String name = "/home/ola/Desktop/" + size + "_" + winningSigns + "_d.txt";
        File file = new File(name);
        try (FileWriter fr = new FileWriter(file)) {
            fr.write("en");
            fr.write(System.getProperty("line.separator"));
            fr.write("player1");
            fr.write(System.getProperty("line.separator"));
            fr.write("player2");
            fr.write(System.getProperty("line.separator"));
            fr.write(String.valueOf(size));
            fr.write(System.getProperty("line.separator"));
            fr.write(String.valueOf(winningSigns));
            fr.write(System.getProperty("line.separator"));

            List<List<Integer>> winningSequences = winningSequences(winningSigns, size);
            for (List<Integer> winning : winningSequences
            ) {
                List<Integer> availableFields = availableFields(size);
                List<Integer> notAvailableFields = notAvailableFields(availableFields, winning);
                for (int i = 0; i < winningSigns; i++){
                    fr.write(String.valueOf(winning.get(0)));
                    winning.remove(0);
                    fr.write(System.getProperty("line.separator"));
                    if (i < winningSigns - 1){
                        fr.write(String.valueOf(notAvailableFields.get(0)));
                        notAvailableFields.remove(0);
                        fr.write(System.getProperty("line.separator"));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        private List<Integer> availableFields(int size) {
        List<Integer> availableFields = new ArrayList<>();
        for (int i = 1; i <= size * size; i++) {
            availableFields.add(i);
        }
        return availableFields;
    }

    private List<Integer> notAvailableFields(List<Integer> availableFields, List<Integer> winningFields) {
        for (Integer notEmptyField: winningFields
             ) {
            availableFields.remove(notEmptyField);
        }
        return availableFields;
    }

    private List<List<Integer>> winningSequences(int winningSigns, int size) {
        List<List<Integer>> allWinningSequences = new ArrayList<>();
        List<Integer> winningSequences;
        for (int j = 1; j < (size * size); j++) {
            winningSequences = new ArrayList<>();
            int index = j, counter = 0;
            while (counter < winningSigns) {
                if (index % size == 0) {
                    j += winningSigns - 1;
                }
                winningSequences.add(index);
                if (index == size * size){
                    j = size * size;
                    break;
                }
                index += (size + 1);
                counter++;
            }
            allWinningSequences.add(winningSequences);
        }

        return allWinningSequences;
    }

    public static void main(String[] args) {
        AutomatCreator automatCreator = new AutomatCreatorDiagonally();
        automatCreator.createFile(11, 7);
    }
}
