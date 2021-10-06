/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objmodels;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author LE THUY
 */
public class InterviewStatus {
    private SimpleStringProperty status;
    private SimpleStringProperty comment;
    private SimpleStringProperty updBy;
    private SimpleStringProperty lable;
    private SimpleStringProperty updDate;

    public InterviewStatus(String status, String comment, String updBy, String lable, String updDate) {
        this.status = new SimpleStringProperty(status);
        this.comment = new SimpleStringProperty(comment);
        this.updBy = new SimpleStringProperty(updBy);
        this.lable = new SimpleStringProperty(lable);
        this.updDate = new SimpleStringProperty(updDate);
    }

    public String getStatus() {
        return status.get();
    }

    public void setStatus(String status) {
        this.status = new SimpleStringProperty(status);
    }

    public String getComment() {
        return comment.get();
    }

    public void setComment(String comment) {
        this.comment = new SimpleStringProperty(comment);
    }

    public String getUpdBy() {
        return updBy.get();
    }

    public void setUpdBy(String updBy) {
        this.updBy = new SimpleStringProperty(updBy);
    }

    public String getLable() {
        return lable.get();
    }

    public void setLable(String lable) {
        this.lable = new SimpleStringProperty(lable);
    }

    public String getUpdDate() {
        return updDate.get();
    }

    public void setUpdDate(String updDate) {
        this.updDate = new SimpleStringProperty(updDate);
    }
    
}
