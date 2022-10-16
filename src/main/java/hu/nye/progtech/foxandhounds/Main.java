package hu.nye.progtech.foxandhounds;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import hu.nye.progtech.foxandhounds.model.GameState;
import hu.nye.progtech.foxandhounds.model.MapVo;
import hu.nye.progtech.foxandhounds.service.command.Command;
import hu.nye.progtech.foxandhounds.service.command.InputHandler;
import hu.nye.progtech.foxandhounds.service.command.impl.ExitCommand;
import hu.nye.progtech.foxandhounds.service.command.impl.PrintCommand;
import hu.nye.progtech.foxandhounds.service.game.GameController;
import hu.nye.progtech.foxandhounds.service.game.GameStepPerformer;
import hu.nye.progtech.foxandhounds.service.input.UserInputReader;
import hu.nye.progtech.foxandhounds.service.map.MapReaderFacade;
import hu.nye.progtech.foxandhounds.service.map.parser.MapParser;
import hu.nye.progtech.foxandhounds.service.map.validation.reader.MapReader;
import hu.nye.progtech.foxandhounds.service.map.validation.reader.impl.BufferedReaderMapReader;
import hu.nye.progtech.foxandhounds.service.util.MapUtil;
import hu.nye.progtech.foxandhounds.ui.MapPrinter;
import hu.nye.progtech.foxandhounds.ui.PrintWrapper;

/**
 * Entrypoint of Fox and hounds game.
 */

public class Main {

    /**
     * Entrypoint of the game.
     *
     */
    public static void main(String[] args) {

        // game components

        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("map/staticmap.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        MapReader mapReader = new BufferedReaderMapReader(reader);

        // uncomment this to check logback
        //List<String> rawMap = mapReader.read();


        MapParser mapParser = new MapParser(8, 8);
        // MapVo mapVo = mapParser.parse(rawMap);
        MapUtil mapUtil = new MapUtil();

        MapReaderFacade mapReaderFacade = new MapReaderFacade(mapReader, mapParser);
        MapVo mapVo = mapReaderFacade.readMap();

        GameState gameState = new GameState(mapVo, false);

        /*List<MapValidator> mapValidatorList = List.of(
                new HoundCountValidator(),
                new HoundPositionValidatior(),
                new FoxCountValidator(),
                new FoxPositionValidator()
                );

        MapValidatorComposer mapValidatorComposer = new MapValidatorComposer(mapValidatorList);
*/
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        UserInputReader userInputReader = new UserInputReader(stdin);

        PrintWrapper printWrapper = new PrintWrapper();
        MapPrinter mapPrinter = new MapPrinter(8, 8, mapUtil, printWrapper);

        List<Command> commandList = Arrays.asList(
                new PrintCommand(mapPrinter, gameState),
                new ExitCommand(gameState)
        );

        InputHandler inputHandler = new InputHandler(commandList);

        GameStepPerformer gameStepPerformer = new GameStepPerformer(userInputReader, inputHandler);

        GameController gameController = new GameController(gameState, mapUtil, gameStepPerformer);
        gameController.gameLoop();
    }


}
