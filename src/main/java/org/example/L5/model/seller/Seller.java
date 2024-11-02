package org.example.L5.model.seller;

import org.example.L5.model.Specialize;
import org.example.L5.model.buyer.Buyer;
import lombok.extern.slf4j.Slf4j;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Slf4j
@Getter
@NoArgsConstructor
public abstract class Seller {

    public abstract Specialize getSpecializeType();
    public abstract void addBuyerToSeller(Buyer buyer);
    public abstract void deleteBuyerToSeller(Buyer buyer);
    public abstract List<Buyer> getBuyers();
    public abstract void clearSeller();

}
