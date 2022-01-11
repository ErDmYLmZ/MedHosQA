package utilities;

import pojos.Appointment;
import pojos.Patient;
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
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter writer  = new BufferedWriter( fileWriter);
            for (int i=0; i<actualData.size(); i++) {
                writer.append(actualData.get(i)  +",\n");
            }
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void saveAppointmentData(String fileName, Appointment [] appointments){
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter writer  = new BufferedWriter( fileWriter);
            for (int i=0; i<appointments.length; i++ ){
                //Eger patient null ise bu sekilde fail etmez
                if(appointments[i].getPatient() != null) {
                    writer.append(appointments[i].getPatient().getFirstName() +"," +   appointments[i].getPatient().getLastName()
                            +",");
                    if (appointments[i].getPatient().getUser() != null){
                        writer.append(appointments[i].getPatient().getUser().getSsn()+",\n");
                    }else
                    {
                        writer.append("\n");
                    }
                }
            }
            writer.close();
            Registrant registrant1 = new Registrant();
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public static void savePatientsApiData(String fileName, Patient[] patientsPojo) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (int i =0; i<patientsPojo.length; i++){
                if(patientsPojo[i] != null) {
                writer.append(patientsPojo[i]+",\n");
                    System.out.println(patientsPojo[i]);
                    if (patientsPojo[i].getUser() != null){
                        writer.append(patientsPojo[i].getUser().getSsn()+",\n");
                        System.out.println(patientsPojo[i].getUser().getSsn());
                    }else
                    {
                        writer.append("\n");
                    }
            }
            }

            writer.close();
            Patient patients = new Patient();
        }catch (Exception e){
              e.printStackTrace();
    }
        }



}
