package com.zheqiushui.redis.dashboard.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qiushui.Zhe
 * @date 2023/03/20 20:08
 */
@RestController()
@RequestMapping("/data")
public class DataQueryService {
    @Autowired
    private KeyPrefixService keyPrefixService;
    @GetMapping(path = "/getkeyprefix")
    public List<String> getKeyPrefix(String dbname) {
        if(StringUtils.isBlank(dbname)) {
            return new ArrayList<>();
        } else {
            return keyPrefixService.getKeyPrefix(dbname);
        }
    }

    @GetMapping(path = "/getData")
    public String getData(String keyPrefix, String keyInfo) {
        if(StringUtils.isBlank(keyPrefix)  || StringUtils.isBlank(keyInfo)) {
            return "invalid input";
        } else {
            return keyPrefix + ":" + keyInfo;
        }
    }
}
