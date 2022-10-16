package hu.nye.progtech.foxandhounds.service.map.validation.impl;

import hu.nye.progtech.foxandhounds.model.MapVo;
import hu.nye.progtech.foxandhounds.service.exception.MapValidationException;
import hu.nye.progtech.foxandhounds.service.map.validation.MapValidator;

/**
 * Checks the starting position of the fox.
 */

public class FoxPositionValidator implements MapValidator {

    @Override
    public void validate(MapVo mapVo) {
        int numberOfRows = mapVo.getNumberOfRows();
        int foxMapValue = mapVo.getFoxMapValue();
        int[][] values = mapVo.getValues();

        if (values[numberOfRows - 1][0] != foxMapValue) {
            throw new MapValidationException("Fox is not at the starting position! It should be at row:" + numberOfRows + "Column: 1");
        }

    }
}
