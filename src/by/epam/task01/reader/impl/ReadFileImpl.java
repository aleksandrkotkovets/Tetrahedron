package by.epam.task01.reader.impl;

import by.epam.task01.exception.ReadDataException;
import by.epam.task01.reader.ReadFile;
import by.epam.task01.validator.FileAndDataValidator;
import by.epam.task01.validator.impl.FileAndDataValidatorImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFileImpl implements ReadFile {

    private static final Logger LOGGER = LogManager.getLogger(ReadFile.class);
    private static final ReadFileImpl INSTANCE = new ReadFileImpl();

    private ReadFileImpl() {
    }

    public static ReadFileImpl getInstance() {
        return INSTANCE;
    }

    public List<String> readDataTxt(String path) throws ReadDataException {
        LOGGER.info("Read File");

        File file = new File(path);
        Path ResPath = Paths.get(path);
        FileAndDataValidator fileFileAndDataValidator = FileAndDataValidatorImpl.getInstance();
        boolean resultValidator = fileFileAndDataValidator.checkFile(file);
        if (!resultValidator) {
            LOGGER.warn("File:" + path + "  is not exist or empty");
            throw new ReadDataException("File is not exist or empty - " + path);
        }
        try (Stream<String> lineStream = Files.newBufferedReader(ResPath).lines()) {
            List<String> lines = lineStream.collect(Collectors.toList());
            LOGGER.info("File:" + file + " was successfully read");
            return lines;
        } catch (IOException e) {
            LOGGER.warn("File:" + path + ". Exception with readAllLines method");
            throw new ReadDataException(e);
        }
    }
}
