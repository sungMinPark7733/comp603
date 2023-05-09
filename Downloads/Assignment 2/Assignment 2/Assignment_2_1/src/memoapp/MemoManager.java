package memoapp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MemoManager<E, F extends Comparable> {

    BinaryTree bTreeDate;
    BinaryTree bTreeTitle;

    public void addMemo(String date, String title, String message) {
        Memo memo = new Memo(date, title, message);
        addToTree(memo, (E) memo.getDate()); // add to bTreeDate using date as key
        addToTree(memo, (E) memo.getTitle()); // add to bTreeTitle using title as key
    }

    @SuppressWarnings("unchecked")
    public void addToTree(Memo memo, E key) {
        if (key instanceof Date) {
            if (bTreeDate == null) {
                bTreeDate = new BinaryTree<Date, Memo>();
            }
            bTreeDate.insert((Date) key, memo);
        } else if (key instanceof String) {
            if (bTreeTitle == null) {
                bTreeTitle = new BinaryTree<String, Memo>();
            }
            bTreeTitle.insert((String) key, memo);
        } else {
            throw new IllegalArgumentException("Invalid key type: " + key.getClass());
        }
    }

    public Memo findMemo(E key) {

    }

    public Memo[] getSortedMemoList(E key) {

    }

    public void reverseOrder() {

    }

}
