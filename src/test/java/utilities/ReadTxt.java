package utilities;

import io.cucumber.java.en.Given;
import pojos.Patient;
import pojos.Registrant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ReadTxt {
    public static List<Registrant> returnAllUserData(String filename){
        List<Registrant> all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line  = br.readLine();
            while (line != null){
                Registrant registrant = new Registrant();
                // String ssn = line.split(",")[0]; sadece ssn veriyor
                if(line.split(",")[0] != null)
                    registrant.setSsn(line.split(",")[0]);
                registrant.setFirstName(line.split(",")[1]);
                registrant.setLastName(line.split(",")[2]);
                registrant.setUsername(line.split(",")[3]);
                registrant.setEmail(line.split(",")[4]);
                if(line.split(",")[5] != null)
                    registrant.setActivated(Boolean.parseBoolean(line.split(",")[5]));
                if(line.split(",")[6] != null)
                    registrant.setCreatedDate(line.split(",")[6]);
                line = br.readLine();
                all.add(registrant);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }


    public static List<Patient> returnAllPatientData(String filename){
        List<Patient> all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line  = br.readLine();
            int i = 0;
            while (line != null){
                Patient patient = new Patient();
                // String ssn = line.split(",")[0]; sadece ssn veriyor
                if(line.split(",")[0] != null)
                    patient.setFirstName(line.split(",")[1]);
//                patient.setCreatedBy(line.split(",")[0].trim());
//                patient.setCreatedDate(line.split(",")[1].trim());
//                patient.setFirstName(line.split(",")[2].trim());
                patient.setLastName(line.split(",")[2].trim());
                patient.setEmail(line.split(",")[16].trim());
                patient.setBirthDate(line.split(",")[3].trim());
                patient.setPhone(line.split(",")[4].trim());
                patient.setGender(line.split(",")[5].trim());
                patient.setAdress(line.split(",")[7].trim());

//                patient.setAdress(line.split(",")[7].trim());

//                if(line.split(",")[8] != null)
//                    //registrant.setActivated(Boolean.parseBoolean(line.split(",")[5]));
//                if(line.split(",")[9] != null)
//                    //registrant.setCreatedDate(line.split(",")[6]);
                line = br.readLine();
                all.add(patient);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }






    public static List<String> returnUserSSNs(String filename){
        List<String> ssnList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line  = br.readLine();
            while (line != null){
                // String ssn = line.split(",")[0]; sadece ssn veriyor
                ssnList.add(line.split(",")[0]);
                line = br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ssnList;
    }

    public static List<String> returnPatientIdDbData(String filename){
        List<String> idList = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line  = br.readLine();
            while (line != null){

                idList.add(line.replace("[","").split(",")[0].trim());

                line = br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return idList;
    }
    public static List<String> returnAppointmentData(String filename){
        List<String> ssnList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line  = br.readLine();
            while (line != null){
                // String ssn = line.split(",")[0]; sadece ssn veriyor
                ssnList.add(line.split(",")[4]);

                line=br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ssnList;

    }
    public static List<String> returnAppointmentId(String filename){
        List<String> idList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line  = br.readLine();
            while (line != null){
                // String ssn = line.split(",")[0]; sadece ssn veriyor
                idList.add(line.split(",")[0]);
                line=br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return idList;
    }
    public static List<String> returnUserUserName(String fileName02){
        List<String> userName = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName02))) {
            String line  = br.readLine();
            while (line != null){
                // String userName = line.split(",")[4]; sadece username veriyor
                userName.add(line.split(",")[0]);
                line = br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return userName;
    }
    public static List<String> returnUserEmail(String fileName02){
        List<String> email = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName02))) {
            String line  = br.readLine();
            while (line != null){
                // String email = line.split(",")[5]; sadece email veriyor
                email.add(line.split(",")[1]);
                line = br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return email;
    }
    public static List<String> returnUserSsn (String fileName){
        List<String> email = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line  = br.readLine();
            while (line != null){
                // String email = line.split(",")[5]; sadece email veriyor
                email.add(line.split(",")[0]);
                line = br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return email;
    }
}