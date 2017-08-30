package org.plazmaforge.bsolution.base;


/*
 * Test Bean
 * Created on 20.09.2005
 *
 */

/**
 * @author Oleh Hapon
 * 
 */
public class MyBean {

    private String name;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String toString() {
	return getClass() + "[name = " + getName() + "]";
    }

    /*
    public static void main(String[] s) {
	PathAssociationCreator c = new PathAssociationCreator();
	AssociationManager.setAssociationCreator(c);
	Association a = AssociationManager.getAssociation(CountryList.class);
	System.out.print(a);
    }
    */

}
