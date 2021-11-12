package com.sarakhman.datastructures.queue;

import com.sarakhman.datastructures.list.ArrayList;
import com.sarakhman.datastructures.list.List;


public class TestArrayList extends TestList {
    @Override
    protected List getList() {
        return new ArrayList();
    }

}
