package com.demo.bpp.aop2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author junhong
 */

@Component("work")
public class WorkerImpl implements Worker {

    private List<String> nameList = new ArrayList<String>();

    @Override
    public void add(String name) {
        nameList.add(name);
    }

    @Override
    public void print() {
        String s = get();
        System.out.println(s);
    }

    @Override
    public String get() {
        StringBuffer sb = new StringBuffer();
        for(String name : nameList){
            sb.append(name).append(";");
        }
        return sb.toString();
    }

    @Override
    public String getWithRuntimeExecption() {
        throw new IllegalArgumentException("getWithRuntimeExecption");
    }

    @Override
    public String getWithCustomException(){
        throw new CustomExecption("getWithExecption");
    }

}
