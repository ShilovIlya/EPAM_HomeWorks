package javase02.t06;

import javase02.t07.LowFunctional;

@LowFunctional(function = "navigate")
public class NuclearSubmarine {
    private Engine nuclearEngine;

    class Engine{
        int power;
        Engine(int power){
            this.power = power;
        }
    }

    public NuclearSubmarine(int power){
        nuclearEngine = new Engine(power);
    }

    public void navigate(){
        for (int i = 0; i < nuclearEngine.power; i++){
            for (int j = 0; j < i; j++){
                System.out.print("~~");
            }
            System.out.print("<=^^===>");
            for (int j = i; j < nuclearEngine.power; j++){
                System.out.print("~~");
            }
            System.out.println();
        }
    }
}
