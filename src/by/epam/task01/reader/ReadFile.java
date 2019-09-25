package by.epam.task01.reader;

import by.epam.task01.exception.ReadDataException;

import java.util.List;

/**
 * The class describes methods for working with reader files.
 *
 * @author Kotkovets Aleksandr Sergeevich
 * @version 1.0 11.09.2019
 * @since JDK1.0
 */

public interface ReadFile {
        public List<String> readDataTxt(String path) throws ReadDataException;

}
