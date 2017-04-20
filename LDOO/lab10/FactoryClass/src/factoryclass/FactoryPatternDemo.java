/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoryclass;

/**
 *
 * @author Valeria
 */

public class FactoryPatternDemo {
    public static void main(String[] args){
        
        ShapeFactory sf = new ShapeFactory();
        
        Shape s1 = sf.getShape("CIRCLE");
            s1.drawing();                   
        
        Shape s2 = sf.getShape("RECTANGLE");
            s2.drawing();
        
        Shape s3 = sf.getShape("SQUARE");
            s3.drawing();
    }
}
