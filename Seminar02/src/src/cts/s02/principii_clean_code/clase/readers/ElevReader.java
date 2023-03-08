package src.cts.s02.principii_clean_code.clase.readers;

import src.cts.s02.principii_clean_code.clase.Aplicant;
import src.cts.s02.principii_clean_code.clase.Elev;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElevReader extends AplicantReader {

    @Override
    public List<Aplicant> readAplicants(String fileName) throws FileNotFoundException {
        Scanner input2 = new Scanner(new File(fileName));
        input2.useDelimiter(",|\n");
        List<Aplicant> aplicants = new ArrayList<>();

        while (input2.hasNext()) {
            Elev elev = new Elev();
            super.readAplicant(input2, elev);

            int clasa = input2.nextInt();
            String tutore = input2.next();

            elev.setClasa(clasa);
            elev.setTutore(tutore);

            aplicants.add(elev);
        }

        input2.close();
        return aplicants;
    }
}
