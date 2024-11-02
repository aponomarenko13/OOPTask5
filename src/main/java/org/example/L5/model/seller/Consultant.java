package org.example.L5.model.seller;

import org.example.L5.model.Specialize;
import org.example.L5.model.buyer.Buyer;

import java.util.ArrayList;
import java.util.List;


public class Consultant extends Seller {

    Specialize specializeType;
    List<Buyer> buyers;

    public Consultant(Specialize specializeType) {
        this.specializeType = specializeType;
        this.buyers = new ArrayList<>();
    }

    @Override
    public Specialize getSpecializeType() {
        return specializeType;
    }

    @Override
    public List<Buyer> getBuyers() {
        return buyers;
    }

    @Override
    public void clearSeller() {
        buyers = new ArrayList<>();
    }

    @Override
    public void deleteBuyerToSeller(Buyer buyer) {
        for (Buyer buyer1 : buyers) {
            if (buyer.equals(buyer1)) {
                buyers.remove(buyer);
            }
        }
    }

    @Override
    public void addBuyerToSeller(Buyer buyer) {
        buyers.add(buyer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consultant consultant = (Consultant) o;
        return specializeType == consultant.specializeType;
    }

}