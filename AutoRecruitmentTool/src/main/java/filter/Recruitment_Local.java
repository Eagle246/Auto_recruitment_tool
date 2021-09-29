/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import objmodels.Recruiter;

/**
 *
 * @author Eagle
 */
public class Recruitment_Local extends Recruitment_Online {

   public Recruitment_Local(Recruiter oRecruiter, String JobTitle, String Experience, String Expectation, String Location,String Refeeral) {
       super(oRecruiter, JobTitle, Experience, Expectation, Location, Refeeral);  
    }
}
