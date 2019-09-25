package by.epam.task01.model.validator.impl;

import by.epam.task01.model.constant.TetrahedronsConstant;
import by.epam.task01.model.validator.FileAndDataValidator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;

import static by.epam.task01.model.constant.TetrahedronsConstant.FIND_ONLY_NUMBERS;

public class FileAndDataValidatorImpl implements FileAndDataValidator {

    private static final FileAndDataValidatorImpl INSTANCE = new FileAndDataValidatorImpl();
    private static final Logger LOGGER = LogManager.getLogger(FileAndDataValidatorImpl.class);

    private FileAndDataValidatorImpl() {
    }

    public static FileAndDataValidatorImpl getInstance() {
        return INSTANCE;
    }

    public boolean checkData(String string) {
        return string.matches(FIND_ONLY_NUMBERS);
    }


    public boolean checkFile(File file) {
        if (file == null || !file.exists() || file.isDirectory() || file.length() == 0) {
            return false;
        }
        return true;
    }

    public  boolean checkCountOfGoodData() {

        LOGGER.info("Method: checkCountOfGoodData");

        if (TetrahedronValidatorImpl.countOfGoodData >= TetrahedronsConstant.MIN_COUNT_OF_GOOD_DATA) {
            LOGGER.info("Count of Good reader>=4");
        } else {
            LOGGER.info("Count of Good reader<=4");
        }
        return TetrahedronValidatorImpl.countOfGoodData >= TetrahedronsConstant.MIN_COUNT_OF_GOOD_DATA;
    }
}
