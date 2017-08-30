package org.plazmaforge.framework.client.forms;

public class FormEnvironment {

    private static boolean pagination = true;

    public static boolean isPagination() {
        return pagination;
    }

    public static void setPagination(boolean pagination) {
        FormEnvironment.pagination = pagination;
    }
    
}
