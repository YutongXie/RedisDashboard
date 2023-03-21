package com.zheqiushui.redis.dashboard.service;

import org.springframework.stereotype.Component;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Qiushui.Zhe
 * @date 2023/03/21 10:34
 */
@Component
public class KeyPrefixService {
    private final static String DB_NAME_PREFIX = "DB-";
    private static ConcurrentHashMap<String, List<String>> keyPrefixMap = new ConcurrentHashMap<>();

    static {
        for (int i = 0; i < 5; i++) {
            List<String> keyPrefixList = new ArrayList<>();
            for (int i1 = 0; i1 < 3; i1++) {
                keyPrefixList.add("prefix-" + i + "-" + i1);
            }
            keyPrefixMap.put(DB_NAME_PREFIX + i, keyPrefixList);
        }
    }
    public List<String> getKeyPrefix(String dbName) {
        if (keyPrefixMap.containsKey(dbName)) {
            return keyPrefixMap.get(dbName);
        } else {
            return new ArrayList<String>();
        }
    }

    public void updateKeyPrefix(String dbName, List<String> latestPrefixList) {
        keyPrefixMap.put(dbName, latestPrefixList);
    }
}
