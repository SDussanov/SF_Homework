package reader;

import general.StudyProfile;
import general.Student;
import general.University;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Reader {

    private static final Logger logger = Logger.getLogger(Reader.class.getName());

    private Reader() {
    }


    public static List<University> readUniversities(String filePath) throws IOException {

        List<University> universities = new ArrayList<>();
        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("Университеты");

            Iterator<Row> rows = sheet.iterator();
            rows.next();

            while (rows.hasNext()) {
                Row currentRow = rows.next();
                University university = new University();
                universities.add(university);
                university.setId(currentRow.getCell(0).getStringCellValue());
                university.setFullName(currentRow.getCell(1).getStringCellValue());
                university.setShortName(currentRow.getCell(2).getStringCellValue());
                university.setYearOfFoundation((int) currentRow.getCell(3).getNumericCellValue());
                university.setMainProfile(StudyProfile.valueOf(
                        StudyProfile.class, currentRow.getCell(4).getStringCellValue()));
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Не смог прочитать файл с университетами", e);
            return universities;
        }
        logger.log(Level.INFO, "Прочитал файл с университетами");
        return universities;
    }

    public static List<Student> readStudents(String filePath) throws IOException {

        List<Student> students = new ArrayList<>();

        try {

            FileInputStream inputStream = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("Студенты");

            Iterator<Row> rows = sheet.iterator();
            rows.next();

            while (rows.hasNext()) {
                Row currentRow = rows.next();
                Student student = new Student();
                students.add(student);
                student.setUniversityId(currentRow.getCell(0).getStringCellValue());
                student.setFullName(currentRow.getCell(1).getStringCellValue());
                student.setCurrentCourseNumber((int) currentRow.getCell(2).getNumericCellValue());
                student.setAvgExamScore((float) currentRow.getCell(3).getNumericCellValue());
            }

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Не смог прочитать файл со студентами", e);
            return students;
        }

        logger.log(Level.INFO, "Прочитал файл со студентами");
        return students;

    }


}
