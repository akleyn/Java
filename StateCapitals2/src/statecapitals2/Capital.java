/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statecapitals2;

/**
 *
 * @author softwareguild
 */
public class Capital {
    private String key;
    private String capital;
    private int population;
    private double miles;
    
        public Capital(String key, String capital, int population, double miles){
            this.key = key;
            this.capital = capital;
            this.population = population;
            this.miles = miles;
        }

        public String getKey(){
            return key;
        }
        
        public String getCapital(){
            return capital;
        }
        
        public int getPopulation(){
            return population;
        }
        
        public double getMiles(){
            return miles;
        }
}   
