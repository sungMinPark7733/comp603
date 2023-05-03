package memoapp;

import java.util.Date;

public class Memo {

    private Date date;
    private String title;
    private String message;

    public Memo(Date date, String title, String message) {
        this.date = date;
        this.title = title;
        this.message = message;
    }

    public String toString() {
        return this.getDate() + "\n" + this.getTitle() + "\n" + this.getMessage();
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
