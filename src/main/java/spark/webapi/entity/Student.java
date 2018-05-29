package spark.webapi.entity;

public class Student {
    private Integer stuNo;

    private String stuName;

    private Integer majorNo;

    private String role;

    public Integer getStuNo() {
        return stuNo;
    }

    public void setStuNo(Integer stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public Integer getMajorNo() {
        return majorNo;
    }

    public void setMajorNo(Integer majorNo) {
        this.majorNo = majorNo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }
}