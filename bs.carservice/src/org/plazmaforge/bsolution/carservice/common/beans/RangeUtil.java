package org.plazmaforge.bsolution.carservice.common.beans;

public class RangeUtil {

    public static boolean isValueInRange(int value, int valueFrom, int valueTo) {
	return value >= valueFrom && value < valueTo;
    }
}
