
package memoapp;

import java.util.Date;

public class Memo {
    Date date;
    String title;
    String message;
    
    public String toString()
    {
        return this.date + this.title + this.message;
    }
}
