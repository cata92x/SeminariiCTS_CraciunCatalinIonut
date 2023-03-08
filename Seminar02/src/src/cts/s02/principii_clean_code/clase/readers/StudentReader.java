package src.cts.s02.principii_clean_code.clase.readers;

import src.cts.s02.principii_clean_code.clase.Aplicant;
import src.cts.s02.principii_clean_code.clase.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentReader extends AplicantReader {
    @Override
    public List<Aplicant> readAplicants(String fileName) throws FileNotFoundException {
        Scanner input = new Scanner(new File(fileName));
        input.useDelimiter(",|\n");
        List<Aplicant> aplicants = new ArrayList<Aplicant>();

        while (input.hasNext()) {
            Student student = new Student();

            super.readAplicant(input, student);

            int an_studii = input.nextInt();
            String facultate = (input.next()).toString();

            student.setAn_studii(an_studii);
            student.setFacultate(facultate);

            aplicants.add(student);
        }
        input.close();
        return aplicants;
    }
}
