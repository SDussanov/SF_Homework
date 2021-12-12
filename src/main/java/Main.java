import general.*;
import interfacecomparator.StudentComparator;
import interfacecomparator.UniversityComparator;
import reader.Reader;

import java.io.IOException;
import java.util.List;

//Когда скачиваю проект с GIT пытаюсь запустить, программа как будто не видит путь к файлу src/main/resources/universityInfo.xlsx,
//Надо файл заново сохранить в новую папку тогда путь программа увидит файл.
//Почему такая ошибка выходит? C первого раза не видит путь к файлу? Это у всех так?

public class Main {

    public static void main(String[] args) throws IOException {
        Student student1 = new Student("dussanov", "1", 4, 4.5f);
        University university1 = new University("1", "New general.University", "NU", 2021, StudyProfile.IT);

        System.out.println(student1);
        System.out.println(university1);

        List<University> universities = Reader.readUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator = MyComparator.getUniversityComparator(UniversityComparatorType.YEAR);
        universities.stream().sorted(universityComparator).forEach(System.out::println);

        List<Student> students = Reader.readStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator = MyComparator.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE);
        students.stream().sorted(studentComparator).forEach(System.out::println);
    }
}
