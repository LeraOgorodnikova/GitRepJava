package com.github.drxaos.edu;


import java.io.Serializable;

public interface SavedList  <E extends Serializable>{
    void reload() throws FileOperationException;
    E get(int index);
    int size();

    //E set(int index, E element);
    //E remove(int index);
    //void add(int index, E element);

}
