package com.github.drxaos.edu;

import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.util.Iterator;

public class SavedListTest {

    @Test
    public void test1() throws Exception {

        //File file = new File("./list1.dat");
        File file = new File("list1.sqlite");
        if (file.exists()) {
            file.delete();
        }

        //FileSavedList<String> list = new FileSavedList<String>(file);
        SqliteSavedList<String> list = new SqliteSavedList<String>(file);
        list.add("One");
        list.add("Two");
        list.add("Three");
        for (int i = 0; i < 100; i++) {
            list.add(1, "Hello " + i);
        }
        list.remove("Two");

        // check contents
        Assert.assertTrue(list.contains("Hello 50"));
        Assert.assertEquals(102, list.size());
        Assert.assertEquals("One", list.get(0));
        Assert.assertEquals("Hello 99", list.get(1));
        Assert.assertEquals("Hello 0", list.get(100));

        // create another list
        //File file2 = new File("./list1a.dat");
        File file2 = new File("list1a.sqlite");
        if (file2.exists()) {
            file2.delete();
        }
        //FileSavedList<String> list2 = new FileSavedList<String>(file);
        SqliteSavedList<String> list2 = new SqliteSavedList<String>(file);
        list2.add("One");
        list2.add("Two");
        list2.add("Three");


        list.retainAll(list2);
        Assert.assertEquals(2, list.size());
    }

    @Test
    public void test2() throws Exception {
        //File file = new File("./list2.dat");
        File file = new File("list2.sqlite");
        if (file.exists()) {
            file.delete();
        }

        //FileSavedList<String> list = new FileSavedList<String>(file);
        FileSavedList<String> list = new FileSavedList<String>(file);
        list.add("One");
        list.add("Two");
        list.add("Three");
        for (int i = 0; i < 100; i++) {
            list.add(1, "Hello " + i);
        }
        list.remove("Two");
        list = null;

        //FileSavedList<String> loadedList = new FileSavedList<String>(file);
        SqliteSavedList<String> loadedList = new SqliteSavedList<String>(file);

        Assert.assertTrue(file.exists());
        Assert.assertTrue(loadedList.contains("Hello 50"));
        Assert.assertEquals(102, loadedList.size());
        Assert.assertEquals("One", loadedList.get(0));
        Assert.assertEquals("Hello 99", loadedList.get(1));
        Assert.assertEquals("Hello 0", loadedList.get(100));
    }

    @Test
    public void test3() throws Exception {
        //File file = new File("./list3.dat");
        File file = new File("list3.sqlite");
        if (file.exists()) {
            file.delete();
        }

        // create list
        SqliteSavedList<String> list = new SqliteSavedList<String>(file);
        //FileSavedList<String> list = new FileSavedList<String>(file);
        list.add("One");
        list.add("Two");
        list.add("Three");
        for (int i = 0; i < 100; i++) {
            list.add(1, "Hello " + i);
        }
        list.remove("Two");

        // load list and remove elements
        //FileSavedList<String> loadedList = new FileSavedList<String>(file);
        SqliteSavedList<String> loadedList = new SqliteSavedList<String>(file);
        for (Iterator<String> iterator = loadedList.iterator(); iterator.hasNext(); ) {
            String next = iterator.next();
            if (next.contains("8")) {
                iterator.remove();
            }
        }
        Assert.assertEquals(83, loadedList.size());

        // reload
        list.reload();
        Assert.assertFalse(list.isEmpty());
        Assert.assertEquals(83, list.size());

        // remove file
        file.delete();

        // reload
        list.reload();
        Assert.assertTrue(list.isEmpty());
        Assert.assertEquals(0, list.size());
    }


    @Test
    public void test4() throws Exception {
        //File file = new File("./list4.dat");
        File file = new File("list4.sqlite");
        if (file.exists()) {
            file.delete();
        }

        // create list
        //FileSavedList<Integer> list = new FileSavedList<Integer>(file);
        SqliteSavedList<Integer> list = new SqliteSavedList<Integer>(file);
        list.add(1);
        list.add(2);
        list.add(3);
        list.set(0, 999);
        list = null;

        // load list
        //FileSavedList<Integer> loadedList = new FileSavedList<Integer>(file);
        SqliteSavedList<Integer> loadedList = new SqliteSavedList<Integer>(file);

        Assert.assertTrue(file.exists());
        Assert.assertEquals(Integer.valueOf(999), loadedList.get(0));
        Assert.assertEquals(Integer.valueOf(2), loadedList.get(1));
        Assert.assertEquals(Integer.valueOf(3), loadedList.get(2));
        Assert.assertEquals(3, loadedList.size());
    }
}
