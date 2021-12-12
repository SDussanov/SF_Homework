package general;

public enum StudyProfile {
    FINANCE("Финансы"),
    IT("Информационные Технологии"),
    JURISPRUDENCE("Юриспруденция"),
    MEDICINE("Медицина");

    private final String profileName;

    private StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return this.profileName;
    }
}