package tables;

import java.time.LocalDate;

/**
 *
 * @author Alain
 */
public class Employe {

    private int numEmp;
    private String nomEmp;
    private String jobEmp;
    private LocalDate dateEmp;
    private int deptEmp;

    public Employe() {
    }

    public Employe(int numEmp, String nomEmp, String jobEmp, LocalDate dateEmp, int deptEmp) {
        this.numEmp = numEmp;
        this.nomEmp = nomEmp;
        this.jobEmp = jobEmp;
        this.dateEmp = dateEmp;
        this.deptEmp = deptEmp;
    }

    public int getNumEmp() {
        return numEmp;
    }

    public String getNomEmp() {
        return nomEmp;
    }

    public String getJobEmp() {
        return jobEmp;
    }

    public LocalDate getDateEmp() {
        return dateEmp;
    }

    public int getDeptEmp() {
        return deptEmp;
    }

    public void setNumEmp(int numEmp) {
        this.numEmp = numEmp;
    }

    public void setNomEmp(String nomEmp) {
        this.nomEmp = nomEmp;
    }

    public void setJobEmp(String jobEmp) {
        this.jobEmp = jobEmp;
    }

    public void setDateEmp(LocalDate dateEmp) {
        this.dateEmp = dateEmp;
    }

    public void setDeptEmp(int deptEmp) {
        this.deptEmp = deptEmp;
    }

    
    
}
