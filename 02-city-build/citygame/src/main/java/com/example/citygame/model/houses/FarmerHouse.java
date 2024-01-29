package com.example.citygame.model.houses;

import com.example.citygame.model.resources.Fish;

public class FarmerHouse extends House {

    public FarmerHouse(Fish fish){
        super("Farmer House", 10, 0);

        /* 5 units of fish per minut for a farmer house */
        getResourceNeeds().put(fish, 5);

        /* Increase the consumption rate according the the needs */
        fish.increaseConsumptionRate(5);
    }

}
