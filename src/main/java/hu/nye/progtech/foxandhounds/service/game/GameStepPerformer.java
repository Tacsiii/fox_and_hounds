package hu.nye.progtech.foxandhounds.service.game;

import hu.nye.progtech.foxandhounds.service.command.InputHandler;
import hu.nye.progtech.foxandhounds.service.input.UserInputReader;

/**
 * Performs game step with the help of the input reader and handler.
 */

public class GameStepPerformer {

    private UserInputReader userInputReader;

    public GameStepPerformer(UserInputReader userInputReader, InputHandler inputHandler) {
        this.userInputReader = userInputReader;
        this.inputHandler = inputHandler;
    }

    private InputHandler inputHandler;

    public void performGameStep() {
        String input = userInputReader.readInput();
        inputHandler.handleInput(input);
    }


}
