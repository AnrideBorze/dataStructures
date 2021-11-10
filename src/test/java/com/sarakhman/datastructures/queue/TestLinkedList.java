package com.sarakhman.datastructures.queue;

import com.sarakhman.datastructures.list.LinkedList;
import com.sarakhman.datastructures.list.List;



public class TestLinkedList extends TestList{

    @Override
    protected List getList() {
        return new LinkedList();
    }


}
