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
        memoManager.addMemo("2023/05/20", "Meeting", "Important meeting at 10 AM");
        memoManager.addMemo("2023/05/21", "Shopping", "Buy groceries and household items");

        // Finding memos
        Memo memo1 = memoManager.findMemo("Meeting");
        if (memo1 != null) {
            System.out.println("Found memo: " + memo1.getTitle());
            System.out.println("Message: " + memo1.getMessage());
            System.out.println("Date: " + memo1.getDate());
        } else {
            System.out.println("Memo not found.");
        }

        Memo memo2 = memoManager.findMemo("2023/05/21");
        if (memo2 != null) {
            System.out.println("Found memo: " + memo2.getTitle());
            System.out.println("Message: " + memo2.getMessage());
            System.out.println("Date: " + memo2.getDate());
        } else {
            System.out.println("Memo not found.");
        }

        // Getting sorted memo list
        Memo[] sortedMemos = memoManager.getSortedMemoList("2023/05/20");
        if (sortedMemos != null) {
            System.out.println("Sorted memos:");
            for (Memo memo : sortedMemos) {
                System.out.println("Title: " + memo.getTitle());
                System.out.println("Message: " + memo.getMessage());
                System.out.println("Date: " + memo.getDate());
                System.out.println("-------------------------");
            }
        } else {
            System.out.println("No memos found.");
        }

        // Reversing the order
        memoManager.reverseOrder();
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
        int nodeCount = sortedNodes.length;
        Memo[] sortedMemos = new Memo[nodeCount];

        for (int i = 0; i < nodeCount; i++) {
            Node node = sortedNodes[i];
            sortedMemos[i] = (Memo) node.getElement();
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
