package by.epam.task01.validator;

import java.io.File;

public interface FileAndDataValidator {
    boolean checkData(String string);

    boolean checkFile(File file);
    boolean checkCountOfGoodData();
}
