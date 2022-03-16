package general;

public class Statistics {

    private StudyProfile studyProfile;
    private float avgScore;
    private int studentCount;
    private int universityCount;
    private String universityName;

    public Statistics(StudyProfile studyProfile, float avgScore, int studentCount, int universityCount, String universityName) {
        this.studyProfile = studyProfile;
        this.avgScore = avgScore;
        this.studentCount = studentCount;
        this.universityCount = universityCount;
        this.universityName = universityName;
    }

    public Statistics() {

    }

    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public void setStudyProfile(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
    }

    public float getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(float avgScore) {
        this.avgScore = avgScore;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public int getUniversityCount() {
        return universityCount;
    }

    public void setUniversityCount(int universityCount) {
        this.universityCount = universityCount;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}
