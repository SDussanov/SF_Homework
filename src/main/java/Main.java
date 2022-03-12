import general.*;
import interfacecomparator.StudentComparator;
import interfacecomparator.UniversityComparator;
import reader.Reader;
import util.JsonUtil;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        /*Student student1 = new Student("dussanov", "1", 4, 4.5f);
        University university1 = new University("1", "New general.University", "NU", 2021, StudyProfile.IT);
        System.out.println(student1);
        System.out.println(university1);*/

        List<University> universities = Reader.readUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator = MyComparator.getUniversityComparator(UniversityComparatorType.YEAR);
        //universities.stream().sorted(universityComparator).forEach(System.out::println);

        universities.sort(universityComparator);
        String universitiesJson = JsonUtil.universityListToJson(universities);
        //System.out.println(universitiesJson);

        List<University> universitiesFromJson = JsonUtil.jsonToUniversityList(universitiesJson);
        //System.out.println(universitiesFromJson);

        System.out.println("Списки университетов равны: " + (universities.size() == universitiesFromJson.size()));

        universities.forEach(university -> {

            String universityJson = JsonUtil.universityToJson(university);
            System.out.println(universityJson);

            University universityFromJson = JsonUtil.jsonToUniversity(universityJson);
            System.out.println(universityFromJson);

        });


        List<Student> students = Reader.readStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator = MyComparator.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE);
        //students.stream().sorted(studentComparator).forEach(System.out::println);
        students.sort(studentComparator);

        String studentsJson = JsonUtil.studentListToJson(students);
        //System.out.println(studentsJson);

        List<Student> studentsFromJson = JsonUtil.jsonToStudentList(studentsJson);
        //System.out.println(studentsFromJson);

        System.out.println("Списки студентов равны: " + (students.size() == studentsFromJson.size()));

        students.forEach(student -> {

            String studentJson = JsonUtil.studentToJson(student);
            System.out.println(studentJson);

            Student studentFromJson = JsonUtil.jsonToStudent(studentJson);
            System.out.println(studentFromJson);

        });

    }
}
