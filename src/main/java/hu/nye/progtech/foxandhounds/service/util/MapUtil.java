package hu.nye.progtech.foxandhounds.service.util;

import java.util.ArrayList;
import java.util.List;

import hu.nye.progtech.foxandhounds.model.MapVo;

/**
 * Class that gives certain informations about map.
 */
public class MapUtil {

    /**
     * Gets the number of rows of a map.
     */
    public List<Integer> getRowOfMap(MapVo mapVo, int rowIndex) {
        List<Integer> result = new ArrayList<>();

        int[][] map = mapVo.getValues();
        for (int i = 0; i < mapVo.getNumberOfColumns(); i++) {
            result.add(map[rowIndex][i]);
        }

        return result;
    }

    /**
     * Gets the number of columns of a map.
     */

    public List<Integer> getColumnOfMap(MapVo mapVo, int columnIndex) {
        List<Integer> result = new ArrayList<>();

        int[][] map = mapVo.getValues();
        for (int i = 0; i < mapVo.getNumberOfRows(); i++) {
            result.add(map[i][columnIndex]);
        }

        return result;
    }

    /**
     * Checks if the fox is at the top row.
     */
    public boolean isMapCompleted(MapVo mapVo) {
        boolean result = true;

        int[][] map = mapVo.getValues();
        for (int i = 0; i < mapVo.getNumberOfColumns(); i++) {
            if (map[0][i] != mapVo.getFoxMapValue()) {
                result = false;
                break;
            }
        }

        return result;
    }
}
