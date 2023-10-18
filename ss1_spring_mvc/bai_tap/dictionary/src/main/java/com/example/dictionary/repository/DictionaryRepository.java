package com.example.dictionary.repository;

import com.example.dictionary.service.IDictionaryService;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private static final Map<String,String> map ;
    static {
        map= new HashMap<>();
        map.put("Cow","Con bò");
        map.put("Chicken","Con gà");
        map.put("Dog","Con chó");
        map.put("Cat","Con mèo");
        map.put("Tiger","Con hổ");
        map.put("Pig","Con lợn");
        map.put("Bird","Con chim");
        map.put("Monkey","Con khỉ");
        map.put("Elephant","Con voi");
    }
    @Override
    public String showResult(String keyWord) {
        return map.getOrDefault(keyWord,"Not find");
    }
}
