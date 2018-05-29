package spark.webapi.entity;

public class Major {
    private Integer majorNo;

    private String majorName;

    public Integer getMajorNo() {
        return majorNo;
    }

    public void setMajorNo(Integer majorNo) {
        this.majorNo = majorNo;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName == null ? null : majorName.trim();
    }
}