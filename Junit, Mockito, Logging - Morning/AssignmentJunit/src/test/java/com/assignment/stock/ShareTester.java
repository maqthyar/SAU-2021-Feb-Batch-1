package com.assignment.stock;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ShareTester
{
    StockService service = mock(StockService.class);
    Shares share;

    int value = 147900;

    @Before
    public void setUp()
    {
        share = new Shares(service);
    }

    @Test
    public void testMarketValue()
    {
        when(service.getPrice("Google")).thenReturn(295);
        assertEquals(value,share.getMarketValue("Google"));
    }

}
