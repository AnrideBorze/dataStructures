package com.sarakhman.datastructures.queue;



public class TestArrayQueue extends TestQueue{


    @Override
    protected Queue getQueue() {
        return new ArrayQueue();
    }

}
