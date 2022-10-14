package hu.nye.progtech.foxandhounds;

import hu.nye.progtech.foxandhounds.model.MapVo;
import hu.nye.progtech.foxandhounds.service.map.parser.MapParser;
import hu.nye.progtech.foxandhounds.service.map.reader.MapReader;
import hu.nye.progtech.foxandhounds.service.map.reader.impl.BufferedReaderMapReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {


        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("map/staticmap.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        MapReader mapReader = new BufferedReaderMapReader(reader);
        List<String> rawMap = mapReader.read();

        MapParser mapParser = new MapParser(8,8);
        MapVo mapVo = mapParser.parse(rawMap);

        System.out.println(mapVo);
    }
    }
