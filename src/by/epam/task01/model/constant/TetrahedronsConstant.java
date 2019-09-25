package by.epam.task01.model.constant;

/**
 * The class describes constants.
 *
 * @author Kotkovets Aleksandr Sergeevich
 * @version 1.0 11.09.2019
 * @since JDK1.0
 */

public class TetrahedronsConstant {

    public static final double SQUARE_ROOT_OF_THREE = 1.73205080757;
    public static final double SQUARE_ROOT_OF_TWO = 1.41421356237;
    public static final double TWO_ON_THREE  = 0.666666666667;

    public static final int SECOND_DEGREE = 2;
    public static final int THIRD_DEGREE = 3;
    public static final int TWELVE = 12;
    public static final int MIN_COUNT_OF_GOOD_DATA = 4;
    public static final int NUMBERS_OF_SIDES = 6;

//   public static final String FIND_ONLY_NUMBERS = "^-?\\d\\s-?\\d\\s-?\\d$";
   public static final String FIND_ONLY_NUMBERS = "^((-?\\d+(.\\d+)?\\s)){2}((-?\\d+(.\\d+)?))$";


}
