package utilities;
import pojos.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import pojos.Appointment;
import pojos.Patient;
import pojos.Registrant;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;


public class WriteToTxt {


    public static void saveRegistrantData(String fileName, Registrant registrant) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.append(registrant.getSsn() + "," + registrant.getFirstName() + "," + registrant.getLastName()
                    + "," + registrant.getUsername() + "," + registrant.getEmail() + "," + registrant.getPassword() + ",\n");
            writer.close();
            Registrant registrant1 = new Registrant();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveRegistrantApiData(String fileName, Registrant[] registrants) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (int i = 0; i < registrants.length; i++) {
                writer.append(registrants[i].getSsn() + "," + registrants[i].getFirstName() + "," + registrants[i].getLastName()
                        + "," + registrants[i].getLogin() + "," + registrants[i].getEmail() + "," + registrants[i].isActivated() + ","
                        + registrants[i].getCreatedDate() + ",\n");
            }
            writer.close();
            Registrant registrant1 = new Registrant();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void savePatientsApiData(String fileName, Patient[] patientsPojo) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            for (int i = 0; i < patientsPojo.length; i++) {
                if (patientsPojo[i].getFirstName() != null) {

                    writer.append(patientsPojo[i].getCreatedBy() + "," + patientsPojo[i].getCreatedDate() + "," + patientsPojo[i].getId() + "," +
                            patientsPojo[i].getFirstName() + "," + patientsPojo[i].getLastName() + "," + patientsPojo[i].getBirthDate() + "," + patientsPojo[i].getPhone() + "," +
                            patientsPojo[i].getGender() + "," + patientsPojo[i].getAdress() + "," + patientsPojo[i].getEmail() + "," + patientsPojo[i].getUser() + ",\n");

                } else {
                    writer.append("\n");
                }
            }
            writer.close();
            Patient patients = new Patient();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void saveDBUserData(String fileName, List<Object> actualData) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (int i = 0; i < actualData.size(); i++) {
                writer.append(actualData.get(i) + ",\n");
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveDBPatientData(String fileName, List<List<Object>> actualPatientData){
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter writer  = new BufferedWriter( fileWriter);
            for (int i=0; i<actualPatientData.size(); i++) {
                writer.append(actualPatientData.get(i) +",\n");
            }
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void saveAppointmentData(String fileName, Appointment[] appointments) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (int i = 0; i < appointments.length; i++) {
                //Eger patient null ise bu sekilde fail etmez
                if (appointments[i].getPatient() != null) {
                    writer.append(appointments[i].getPatient().getFirstName() + "," + appointments[i].getPatient().getLastName()
                            + ",");
                    if (appointments[i].getPatient().getUser() != null) {
                        writer.append(appointments[i].getPatient().getUser().getSsn() + ",\n");
                    } else {
                        writer.append("\n");
                    }
                }
            }
            writer.close();
            Registrant registrant1 = new Registrant();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void saveDBUsernameAndEmailDBData(String fileName, List<Object> emails,List<Object> logins){
        try {
            FileWriter fileWriter = new FileWriter(fileName, false);
            BufferedWriter writer  = new BufferedWriter( fileWriter);
            int loginSize = logins.size();
            //System.out.println(loginSize);
            int emailsSize = emails.size();
            //System.out.println(emailsSize);

            if(loginSize >= emailsSize){
                for (int i=0; i<loginSize; i++) {
                    writer.append(logins.get(i)+"," );

                    if(emailsSize <= loginSize+1){
                        writer.append(emails.get(i)+",\n");
                    }

                }
            }else{

                for (int i=0; i<emailsSize; i++) {
                    writer.append(emails.get(i)+"," );

                    if(loginSize <= emailsSize+1){
                        writer.append(logins.get(i)+",\n");
                    }
                }
            }

            writer.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void saveUserApiData(String fileName, US02_UserName_Email[] us02UserNameEmails){
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter writer  = new BufferedWriter( fileWriter);
            for (int i=0; i<us02UserNameEmails.length; i++) {
                writer.append(us02UserNameEmails[i].getSsn() + ","
                        + us02UserNameEmails[i].getFirstName() + "," +us02UserNameEmails[i].getLastName()
                        + "," + us02UserNameEmails[i].getLogin() + "," +us02UserNameEmails[i].getEmail()
                        +"," + us02UserNameEmails[i].isActivated()+","
                        + us02UserNameEmails[i].getCreatedDate() +",\n");
            }
            writer.close();
            Registrant registrant1 = new Registrant();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

//}
//
//    public static void savePatientsApiData(String fileName, Patient[] patientsPojo) {
//        try {
//            FileWriter fileWriter = new FileWriter(fileName, true);
//            BufferedWriter writer = new BufferedWriter(fileWriter);
//            for (int i =0; i<patientsPojo.length; i++){
//                if(patientsPojo[i] != null) {
//                writer.append(patientsPojo[i]+",\n");
//                    System.out.println(patientsPojo[i]);
//                    if (patientsPojo[i].getUser() != null){
//                        writer.append(patientsPojo[i].getUser().getSsn()+",\n");
//                        System.out.println(patientsPojo[i].getUser().getSsn());
//                    }else
//                    {
//                        writer.append("\n");
//                    }
//            }
//            }
//
//            writer.close();
//            Patient patients = new Patient();
//        }catch (Exception e){
//              e.printStackTrace();
//    }
//        }




}
