package org.example.L5.service;

import org.example.L5.exception.SellerIsBusyException;
import org.example.L5.exception.WrongSellerTypeException;
import org.example.L5.model.Specialize;
import org.example.L5.model.buyer.Buyer;
import org.example.L5.model.seller.Seller;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class SellerManager {

    private final Map<Specialize, Seller> sellers;

    public SellerManager() {
        this.sellers = new HashMap<>();
    }

    public void addBuyerToSeller(Seller seller, Buyer buyer) throws WrongSellerTypeException, SellerIsBusyException {
        try {
            isRightSpecialize(seller.getSpecializeType(), buyer.getPreferences());
            sellers.putIfAbsent(seller.getSpecializeType(), seller); //если продавца ещё нет в списке, то добавить
            seller.addBuyerToSeller(buyer);
        } catch (WrongSellerTypeException e) {
            log.info(e.getMessage());
        } finally {
            if (sellers.containsKey(buyer.getPreferences())) {
                if (!sellers.get(buyer.getPreferences()).getBuyers().contains(buyer)) {
                    Seller correct = sellers.get(buyer.getPreferences());
                    correct.addBuyerToSeller(buyer);
                    log.info("Покупатель направлен к нужному консультанту");
                }
            } else {
                throw new SellerIsBusyException("сейчас к нужного консультанта нет");
            }
        }
    }

    private void isRightSpecialize(Specialize sellerType, Specialize buyerType) throws WrongSellerTypeException {
        if (sellerType != buyerType) {
            throw new WrongSellerTypeException("Покупателю нужен консультант другого отдела!");
        }
    }
}
