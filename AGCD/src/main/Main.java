package main;

import view.ViewAGCD;
import model.ModelAGCD;
import controller.ControllerAGCD;

public class Main {
    private static ViewAGCD viewAGCD;
    private static ModelAGCD modelAGCD;
    private static ControllerAGCD controllerAGCD;
    
    public static void main(String[] args)
    {
        viewAGCD = new ViewAGCD();
        modelAGCD = new ModelAGCD();
        controllerAGCD = new ControllerAGCD(viewAGCD, modelAGCD);
    }
}
