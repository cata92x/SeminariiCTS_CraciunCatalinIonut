package src.cts.s02.principii_clean_code.clase.readers;

import src.cts.s02.principii_clean_code.clase.Aplicant;
import src.cts.s02.principii_clean_code.clase.Elev;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElevReader implements AplicantReader {

    @Override
    public List<Aplicant> readAplicants(String fileName) throws FileNotFoundException {
        Scanner input2 = new Scanner(new File(fileName));
        input2.useDelimiter(",|\n");
        List<Aplicant> aplicants = new ArrayList<>();

        while (input2.hasNext()) {
            String nume = input2.next();
            String prenume = input2.next();
            int varsta = input2.nextInt();
            int punctaj = input2.nextInt();
            int nr = input2.nextInt();
            String[] vect = new String[5];
            for (int i = 0; i < nr; i++)
                vect[i] = input2.next();
            int clasa = input2.nextInt();
            String tutore = input2.next();
            Elev e = new Elev(nume, prenume, varsta, punctaj, nr, vect, clasa, tutore);
            aplicants.add(e);
        }

        input2.close();
        return aplicants;
    }
}
