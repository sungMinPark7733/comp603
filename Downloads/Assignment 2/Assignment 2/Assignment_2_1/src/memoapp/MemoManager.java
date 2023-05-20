package memoapp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MemoManager<E extends Comparable> {

    BinaryTree bTreeDate;
    BinaryTree bTreeTitle;
    Date date;

    public static void main(String[] args) {
        MemoManager<String> memoManager = new MemoManager<>();

        // Adding memos
        memoManager.addMemo("2023/05/20", "Important Meeting", "Remember to prepare for the meeting.");
        memoManager.addMemo("2023/05/19", "Buy Groceries", "Make a list of items to buy.");

        // Testing findMemo method
        System.out.println("Find Memo:");
        Memo foundMemo = memoManager.findMemo("Important Meeting");
        if (foundMemo != null) {
            System.out.println("Memo Found:");
            System.out.println("Date: " + foundMemo.getDate());
            System.out.println("Title: " + foundMemo.getTitle());
            System.out.println("Message: " + foundMemo.getMessage());
        } else {
            System.out.println("Memo Not Found!");
        }
        System.out.println();

        // Testing getSortedMemoList method
        System.out.println("Sorted Memo List:");
        Memo[] sortedMemos = memoManager.getSortedMemoList("meeting");
        if (sortedMemos != null) {
            for (Memo memo : sortedMemos) {
                System.out.println("Date: " + memo.getDate());
                System.out.println("Title: " + memo.getTitle());
                System.out.println("Message: " + memo.getMessage());
                System.out.println();
            }
        } else {
            System.out.println("No Memos Found!");
        }
        System.out.println();

        // Testing reverseOrder method
        System.out.println("Reversed Order:");
        memoManager.reverseOrder();

        // Testing getSortedMemoList method after reversing order
        System.out.println("Sorted Memo List after Reversed Order:");
        sortedMemos = memoManager.getSortedMemoList("meeting");
        if (sortedMemos != null) {
            for (Memo memo : sortedMemos) {
                System.out.println("Date: " + memo.getDate());
                System.out.println("Title: " + memo.getTitle());
                System.out.println("Message: " + memo.getMessage());
                System.out.println();
            }
        } else {
            System.out.println("No Memos Found!");
        }
    }

    Date stringToDate(String dateString) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException ex) {
            Logger.getLogger(MemoManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }

    public void addMemo(String date, String title, String message) {
        Memo memo = new Memo(stringToDate(date), title, message);
        addToTree(memo, (E) stringToDate(date));
        addToTree(memo, (E) title);
    }

    public void addToTree(Memo memo, E key) {
        if (key instanceof Date) {
            if (bTreeDate == null) {
                bTreeDate = new BinaryTree();
            }
            bTreeDate.addElement(memo, key);
        } else if (key instanceof String) {
            if (bTreeTitle == null) {
                bTreeTitle = new BinaryTree();
            }
            bTreeTitle.addElement(memo, key);
        }
    }

    public Memo findMemo(E key) {
        E targetMemoKey = key;
        Memo targetMemo;
        if (targetMemoKey instanceof Date) {
            targetMemo = (Memo) bTreeDate.searchElement(targetMemoKey);
            return targetMemo;
        } else if (targetMemoKey instanceof String) {
            targetMemo = (Memo) bTreeTitle.searchElement(targetMemoKey);
            return targetMemo;
        }
        return null;
    }

    public Memo[] getSortedMemoList(E key) {
        E searchingKey = key;
        Node[] sortedNodes;

        if (searchingKey instanceof Date) {
            BinaryTree bTree = bTreeDate;
            sortedNodes = bTree.toSortedList();
        } else if (searchingKey instanceof String) {
            BinaryTree bTree = bTreeTitle;
            sortedNodes = bTree.toSortedList();
        } else {
            return null;
        }
        Memo[] sortedMemos = new Memo[sortedNodes.length];
        for (int i = 0; i < sortedNodes.length; i++) {
            sortedMemos[i] = (Memo) sortedNodes[i].getElement();
        }
        return sortedMemos;
    }

    public void reverseOrder() {
        if (bTreeDate != null) {
            bTreeDate.reverseOrder();
        } else {
            System.out.println("No memos in the date tree.");
        }
        if (bTreeTitle != null) {
            bTreeTitle.reverseOrder();
        } else {
            System.out.println("No memos in the title tree.");
        }
    }

}
