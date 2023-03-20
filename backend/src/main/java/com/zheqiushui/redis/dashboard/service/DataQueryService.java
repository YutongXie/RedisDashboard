package com.zheqiushui.redis.dashboard.service;

import org.springframework.stereotype.Controller;
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

    @GetMapping(path = "/getkeyprefix")
    public List<String> getKeyPrefix(String dbname) {
        List<String> prefixList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            prefixList.add("prefix-" + i);
        }
        return prefixList;
    }
}
