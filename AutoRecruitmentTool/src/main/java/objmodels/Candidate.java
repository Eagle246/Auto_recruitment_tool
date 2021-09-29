/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objmodels;

/**
 *
 * @author Eagle
 */
public class Candidate {
    public String name;
    public String job_title;
    public String latest_cpmpany;
    public String exp_year;
    public String salary;
    public String location;
    public String src_link;
    public String gender;
    public String phone;
    public String referral;
    public String latest_upd;
    public String label;
    public String status;
    public String skill;
    public String comment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getLatest_cpmpany() {
        return latest_cpmpany;
    }

    public void setLatest_cpmpany(String latest_cpmpany) {
        this.latest_cpmpany = latest_cpmpany;
    }

    public String getExp_year() {
        return exp_year;
    }

    public void setExp_year(String exp_year) {
        this.exp_year = exp_year;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSrc_link() {
        return src_link;
    }

    public void setSrc_link(String src_link) {
        this.src_link = src_link;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReferral() {
        return referral;
    }

    public void setReferral(String referral) {
        this.referral = referral;
    }

    public String getLatest_upd() {
        return latest_upd;
    }

    public void setLatest_upd(String latest_upd) {
        this.latest_upd = latest_upd;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Candidate() {
    }

    public Candidate(String name, String job_title, String latest_cpmpany, String exp_year, String salary, String location, String src_link, String gender, String phone, String referral, String latest_upd, String label, String status, String skill, String comment) {  
        this.name = name;
        this.job_title = job_title;
        this.latest_cpmpany = latest_cpmpany;
        this.exp_year = exp_year;
        this.salary = salary;
        this.location = location;
        this.src_link = src_link;
        this.gender = gender;
        this.phone = phone;
        this.referral = referral;
        this.latest_upd = latest_upd;
        this.label = label;
        this.status = status;
        this.skill = skill;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Candidate{" + "name=" + name + ", job_title=" + job_title + ", latest_cpmpany=" + latest_cpmpany + ", exp_year=" + exp_year + ", salary=" + salary + ", location=" + location + ", src_link=" + src_link + ", gender=" + gender + ", phone=" + phone + ", referral=" + referral + ", latest_upd=" + latest_upd + ", label=" + label + ", status=" + status + ", skill=" + skill + ", comment=" + comment + '}';
    }
    
}
