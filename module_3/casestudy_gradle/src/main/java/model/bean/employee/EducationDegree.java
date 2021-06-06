package model.bean.employee;

public class EducationDegree {

    private int educationDegreeId;
    private String educationName;

    public EducationDegree() {
    }

    public EducationDegree(int educationDegreeId, String educationName) {
        this.educationDegreeId = educationDegreeId;
        this.educationName = educationName;
    }

    public int getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(int educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public String getEducationName() {
        return educationName;
    }

    public void setEducationName(String educationName) {
        this.educationName = educationName;
    }
}
