package registries;

import GW.*;
import Models.Person;

public class GWRegistry {
    private GW<Person> personGW = new PersonGW();

    private static GWRegistry instance = new GWRegistry();

    private GWRegistry(){};

    public static GWRegistry getInstance(){
        return instance;
    }

    public GW<Person> getPersonGW(){
        return personGW;
    }
}
