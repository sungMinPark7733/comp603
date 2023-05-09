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

    public MemoManager() {
        bTreeDate = new BinaryTree();
        bTreeTitle = new BinaryTree();
    }

    public Date stringToDate(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return formatter.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(MemoManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void addMemo(String date, String title, String message) {
        Memo memo = new Memo(stringToDate(date), title, message);
        addToTree(memo, (E) memo.getDate());
        addToTree(memo, (E) memo.getTitle());
    }

    public void addToTree(Memo memo, E key) {
        if (key instanceof Date) {
            bTreeDate.addElement(memo, (Date) key);
        } else if (key instanceof String) {
            bTreeTitle.addElement(memo, (String) key);
        }
    }

    public Memo findMemo(E key) {
        if (key instanceof Date) {
            return (Memo) bTreeDate.searchElement((Date) key);
        } else if (key instanceof String) {
            return (Memo) bTreeTitle.searchElement((String) key);
        }
        return null;
    }

    public Memo[] getSortedMemoList(E key) {
        return null;
    }

    public void reverseOrder() {
        bTreeDate.reverseOrder();
        bTreeTitle.reverseOrder();
    }

}
