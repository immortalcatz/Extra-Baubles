package com.minecraftitems.ExtraBaubles.money;

import java.util.HashMap;

public class MoneyManager
{
   public static HashMap<String, Double> bal = new HashMap<String, Double>(); // {PlayerName, Balance}

    public static void setBalance(String player, double amount)
    {
        bal.put(player, amount);
    }

    public static Double getBalance(String player)
    {
        return bal.get(player);
    }

    public static Boolean hasAccount(String player)
    {
        return bal.containsKey(player);
    }

}
