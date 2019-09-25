package by.epam.task01.model.validator;

import java.io.File;

public interface FileAndDataValidator {
    boolean checkData(String string);

    boolean checkFile(File file);
    boolean checkCountOfGoodData();
}
