package spark.webapi.entity;

public class Score extends ScoreKey {
    private Integer score;
    private Integer majorNo;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

	public Integer getMajorNo() {
		return majorNo;
	}

	public void setMajorNo(Integer majorNo) {
		this.majorNo = majorNo;
	}
}