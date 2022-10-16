package hu.nye.progtech.foxandhounds.service.map.validation.impl;

import hu.nye.progtech.foxandhounds.model.MapVo;
import hu.nye.progtech.foxandhounds.service.exception.MapValidationException;
import hu.nye.progtech.foxandhounds.service.map.validation.MapValidator;
import hu.nye.progtech.foxandhounds.service.util.MapUtil;

/**
 * Checks the starting number of foxes on the map.
 */

public class FoxCountValidator implements MapValidator {


    @Override
    public void validate(MapVo mapVo) throws MapValidationException {
        int foxCounter = 0;
        int foxMapValue = mapVo.getFoxMapValue();
        int numberOfRows = mapVo.getNumberOfRows();
        int numberOfColumns = mapVo.getNumberOfColumns();
        int[][] values = mapVo.getValues();

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                if (values[i][j] == foxMapValue) {
                    foxCounter++;
                }
            }
            if (foxCounter != 1) {
                throw new MapValidationException("One and only one fox should be present, now its:" + foxCounter);

            }
        }
    }
}
