package com.codegym.service.Impl;

import com.codegym.service.IConvertService;

public class ConvertService implements IConvertService {
    @Override
    public int convert(int a, int b) {
        return a*b;
    }
}
