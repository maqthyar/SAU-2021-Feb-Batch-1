package com.assignment.stock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Shares
{
    private static Logger logger = LogManager.getLogger(Shares.class);
    StockService s ;

    public Shares(StockService s)
    {
        this.s = s;
    }

    private static int getOldPrice(String s)
    {
        logger.info("Getting the old price of " + s);

        return 400;
    }


    int getMarketValue(String share)
    {

        logger.info("Getting market value for " + s);


        int val = s.getPrice(share);

        return val*500 + getOldPrice(share) ;

    }
}
