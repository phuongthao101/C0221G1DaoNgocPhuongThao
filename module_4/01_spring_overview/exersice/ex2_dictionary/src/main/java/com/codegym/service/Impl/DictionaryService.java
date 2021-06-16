package com.codegym.service.Impl;

import com.codegym.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class DictionaryService implements IDictionaryService {

    Map<String, String> map;
    {
        map = new HashMap<>();
        map.put("hello","xin chào");
        map.put("book","sách");
        map.put("computer","máy tính");
        map.put("bye","tạm biệt");
    }

    public  String find(String word){
        String result = this.map.get(word);
        if(result== null){
            result = "Không tìm thấy từ này";
        }
        return result;
    }

}
