package com.minecraftitems.ExtraBaubles.money;

import com.google.common.collect.ArrayListMultimap;
import com.minecraftitems.ExtraBaubles.utility.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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

    public static final ArrayListMultimap<String, BankUsers> BANK_USERS_ARRAY_LIST_MULTIMAP = ArrayListMultimap.create();
    public static final Map<String, BankUsers> BANK_USERS_MAP = new HashMap<String, BankUsers>();
    static {
        HashMap<String, BankUsers> map = new HashMap<String, BankUsers>();
        BankUsers b = new BankUsers("51401262-c403-4374-bb43-2cf2519eb6e9", "liamjarvisman");
        map.put("51401262-c403-4374-bb43-2cf2519eb6e9", b);


    }

    public static void getBankUser() {
        for (String key : BANK_USERS_MAP.keySet()){
            if (!key.isEmpty() && !BANK_USERS_MAP.get(key).Name.isEmpty()) {
                 BankUsers test = BANK_USERS_MAP.get(key);
                Log.info(test);
            }
        }
    }

    public static class BankUsers {

        public final String uuid;
        public final String Name;

        public BankUsers(String uuid, String Name) {
            this.uuid = uuid;
            this.Name = Name;
        }

    }


    }
