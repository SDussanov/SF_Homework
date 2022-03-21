import general.*;
import interfacecomparator.StudentComparator;
import interfacecomparator.UniversityComparator;
import reader.Reader;
import util.StatisticsUtil;
import writer.Writer;
import writer.WriterJSON;
import writer.WriterXML;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {

        try {
            LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Не смог подгрузить логгер: " + e);
        }

        logger.log(INFO, "Начинаю отработку процессаа");


        //Add single student
        /*

        Student student1 = new Student("dussanov", "1", 4, 4.5f);
        University university1 = new University("1", "New general.University", "NU", 2021, StudyProfile.IT);
        System.out.println(student1);
        System.out.println(university1);*/

        List<University> universities = Reader.readUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator = MyComparator.getUniversityComparator(UniversityComparatorType.YEAR);
        //universities.stream().sorted(universityComparator).forEach(System.out::println);
        universities.sort(universityComparator);

        //List universities from list to Json
        /*
        String universitiesJson = JsonUtil.universityListToJson(universities);
        System.out.println(universitiesJson);


        //check counts list = json
        List<University> universitiesFromJson = JsonUtil.jsonToUniversityList(universitiesJson);
        System.out.println(universitiesFromJson);

        System.out.println("Списки университетов равны: " + (universities.size() == universitiesFromJson.size()));

        universities.forEach(university -> {

            String universityJson = JsonUtil.universityToJson(university);
            System.out.println(universityJson);

            University universityFromJson = JsonUtil.jsonToUniversity(universityJson);
            System.out.println(universityFromJson);

        });*/

        List<Student> students = Reader.readStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator = MyComparator.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE);
        //students.stream().sorted(studentComparator).forEach(System.out::println);
        students.sort(studentComparator);

        //List students from list to Json
        /*
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

        });*/

        List<Statistics> statisticsList = StatisticsUtil.createStatistics(students, universities);
        Writer.writeStatistics(statisticsList, "statistics.xlsx");

        FullInfo fullInfo = new FullInfo()
                .setStudentList(students)
                .setUniversityList(universities)
                .setStatisticsList(statisticsList)
                .setProcessDate(new Date());

        WriterXML.generateXmlReq(fullInfo);
        WriterJSON.writeJsonReq(fullInfo);



        logger.log(INFO, "Закончил обработку процесса");
    }
}
