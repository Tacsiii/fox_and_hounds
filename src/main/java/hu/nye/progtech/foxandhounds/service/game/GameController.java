package hu.nye.progtech.foxandhounds.service.game;

import hu.nye.progtech.foxandhounds.model.GameState;
import hu.nye.progtech.foxandhounds.service.util.MapUtil;

/**
 * Controls game cycles.
 */
public class GameController {


    private GameState gameState;
    private MapUtil mapUtil;

    private GameStepPerformer gameStepPerformer;

    public GameController(GameState gameState, MapUtil mapUtil, GameStepPerformer gameStepPerformer) {
        this.gameState = gameState;
        this.mapUtil = mapUtil;
        this.gameStepPerformer = gameStepPerformer;
    }

    /**
     * Commences a game loop.
     */

    public void gameLoop() {

        while (isGameInProgress()) {
            gameStepPerformer.performGameStep();
        }
    }

    private boolean isGameInProgress() {
        return !mapUtil.isMapCompleted(gameState.getMapVo()) && !gameState.isUserWantsToExit();

    }
}
