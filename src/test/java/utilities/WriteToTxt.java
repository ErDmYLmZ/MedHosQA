package utilities;

import pojos.Registrant;

import java.io.BufferedWriter;
import java.io.FileWriter;


public class WriteToTxt {
    public static void saveRegistrantData(String fileName, Registrant registrant){
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter writer  = new BufferedWriter( fileWriter);
            writer.append(registrant.getSsn()+ ","+registrant.getFirstname()+","+registrant.getLastname()
                    +","+registrant.getUsername()+","+registrant.getEmail()+","+registrant.getPassword()+",\n");
            writer.close();
            Registrant registrant1 = new Registrant();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}