package hu.nye.progtech.foxandhounds.service.map.parser;

import hu.nye.progtech.foxandhounds.model.MapVo;

import java.util.Arrays;
import java.util.List;

public class MapParser {

    private final int numberOfRows;
    private final int numberOfColumns;

    public MapParser(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
    }

    public MapVo parse(List<String> rawMap){
       int[][] values = getValues(rawMap);


        return new MapVo(numberOfRows, numberOfColumns, values);
    }
    private int[][] getValues(List<String> rawMap){
        int[][] result = new int[numberOfRows][];

        for (int i = 0 ; i < numberOfRows; i++) {
            result[i] = new int[numberOfColumns];

            String row = rawMap.get(i);
            String[] numbersAsString = row.split("");

            for (int j = 0; j < numberOfColumns; j++){
                int n = Integer.parseInt(numbersAsString[j]);
                result[i][j] = n;
            }
        }

        return result;
    }
}
