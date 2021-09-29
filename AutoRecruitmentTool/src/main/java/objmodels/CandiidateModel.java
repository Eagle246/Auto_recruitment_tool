package objmodels;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CandiidateModel {

    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty job;
    private SimpleIntegerProperty experience;
    private SimpleStringProperty cv_link;
    private SimpleStringProperty skills;
    private SimpleStringProperty status;
    private SimpleStringProperty comment;
    private SimpleStringProperty user;
    private SimpleStringProperty label;
    private SimpleStringProperty cv_date;
    private SimpleStringProperty can_location;
    private SimpleStringProperty referral;
    private SimpleIntegerProperty phone;

    public CandiidateModel(Integer id, String name, String job, Integer experience, String cv_link, String skills, String status, String comment, String user, String label, String cv_date, String location, String referral, Integer phone) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.job = new SimpleStringProperty(job);
        this.experience = new SimpleIntegerProperty(experience);
        this.cv_link = new SimpleStringProperty(cv_link);
        this.skills = new SimpleStringProperty(skills);
        this.status = new SimpleStringProperty(status);
        this.comment = new SimpleStringProperty(comment);
        this.user = new SimpleStringProperty(user);
        this.label = new SimpleStringProperty(label);
        this.cv_date = new SimpleStringProperty(cv_date);
        this.can_location = new SimpleStringProperty(location);
        this.referral = new SimpleStringProperty(referral);
        this.phone = new SimpleIntegerProperty(phone);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public String getJob() {
        return job.get();
    }

    public void setJob(String job) {
        this.job = new SimpleStringProperty(job);
    }

    public int getExperience() {
        return experience.get();
    }

    public void setExperience(int experience) {
        this.experience = new SimpleIntegerProperty(experience);
    }

    public String getCv_link() {
        return cv_link.get();
    }

    public void setCv_link(String cv_link) {
        this.cv_link.set(cv_link);
    }

    public String getSkills() {
        return skills.get();
    }

    public void setSkills(String skills) {
        this.skills = new SimpleStringProperty(skills);
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

    public String getUser() {
        return user.get();
    }

    public void setUser(String user) {
        this.user = new SimpleStringProperty(user);
    }

    public String getLabel() {
        return label.get();
    }

    public void setLabel(String label) {
        this.label = new SimpleStringProperty(label);
    }

    public String getCv_date() {
        return cv_date.get();
    }

    public void setCv_date(String cv_date) {
        this.cv_date = new SimpleStringProperty(cv_date);
    }

    public String getCan_location() {
        return can_location.get();
    }

    public void setLocation(String location) {
        this.can_location = new SimpleStringProperty(location);
    }

    public String getReferral() {
        return referral.get();
    }

    public void setReferral(String referral) {
        this.referral = new SimpleStringProperty(referral);
    }

    public int getPhone() {
        return phone.get();
    }

    public void setPhone(int phone) {
        this.phone = new SimpleIntegerProperty(phone);
    }

    @Override
    public String toString() {
        return "CandiidateModel{" + "id=" + id + ", name=" + name + ", job=" + job + ", experience=" + experience + ", cv_link=" + cv_link + ", skills=" + skills + ", status=" + status + ", comment=" + comment + ", user=" + user + ", label=" + label + ", cv_date=" + cv_date + ", can_location=" + can_location + ", referral=" + referral + ", phone=" + phone + '}';
    }
    
}
