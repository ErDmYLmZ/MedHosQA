package utilities;
import pojos.Country;
import pojos.Registrant;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class WriteToTxt {
    public static void saveRegistrantData(String fileName, Registrant registrant){
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter writer  = new BufferedWriter( fileWriter);
            writer.append(registrant.getSsn()+ ","+registrant.getFirstName()+","+registrant.getLastName()
                    +","+registrant.getUsername()+","+registrant.getEmail()+","+registrant.getPassword()+",\n");
            writer.close();
            Registrant registrant1 = new Registrant();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void saveRegistrantApiData(String fileName, Registrant []registrants){
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter writer  = new BufferedWriter( fileWriter);
            for (int i=0; i<registrants.length; i++) {
                writer.append(registrants[i].getSsn() + "," + registrants[i].getFirstName() + "," +registrants[i].getLastName()
                        + "," + registrants[i].getLogin() + "," +registrants[i].getEmail() +"," + registrants[i].isActivated()+","
                        + registrants[i].getCreatedDate() +",\n");
            }
            writer.close();
            Registrant registrant1 = new Registrant();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void saveDBUserData(String fileName, List<Object> actualData){
        try {
            FileWriter fileWriter = new FileWriter(fileName, false);
            BufferedWriter writer  = new BufferedWriter( fileWriter);
            for (int i=0; i<actualData.size(); i++) {
                writer.append(actualData.get(i)  +",\n");
            }
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
