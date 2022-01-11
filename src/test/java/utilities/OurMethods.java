package utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class OurMethods {
    // girilen row ve column a gore ilgili elemani verir:
    public static WebElement getWebElementWithRowAndColumn(int row, int column) {
        String xpath = "//tr["+row+"]/td["+column+"]";
        System.out.println("xpath of edited start date : " + xpath);
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    // girilen row ve column a gore ilgili elemanin text'ini verir:
    public static String getElementTextByRowAndColumn(int row, int column) {
        String xpathEditedRow = "//tr["+row+"]/td["+column+"]";
        System.out.println("xpath of edited date : " + xpathEditedRow);
        return Driver.getDriver().findElement(By.xpath(xpathEditedRow)).getText();
    }
    public static WebElement getElementByRowAndColumn(int row, int column) {
        String xpathEditedRow = "//tr["+row+"]/td["+column+"]";
        System.out.println("xpath of edited date for the element : " + xpathEditedRow);

        return Driver.getDriver().findElement(By.xpath(xpathEditedRow));
    }

public static String formatDateToSendKeys(Date anyDate) {

    //startDate = faker.date().past(20, TimeUnit.DAYS);
   // System.out.println(startDate);

    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm");
    String formattedAnyDate = format.format(anyDate);
    // System.out.println(formattedStartDate);
return  formattedAnyDate;
}
public static String getBirthdayWithFaker_AM_PM () {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyyy-MM-dd,hh:mmaa");
    Faker faker = new Faker();
    String birthdayWith_AM_PM = sdf.format(faker.date().birthday(5, 85));
    return birthdayWith_AM_PM;
}


    // web sayfasinda giris icin aldigi tarih noktali 30.12.2022 12:21 seklinde
    // Fakat kaydedilen ve getText ile alinan tarih formati 30/12/22 12:51 seklinde.
    // Asagidaki metod ile degisiklikleri yaptim.
//    public static String changeDateToWebPageFormat (String dateTimeWithDots) {
//        String reformattedDate = dateTimeWithDots.replace(".", "/")
//                .replace("2022", "22");
//        return reformattedDate;
//    }
    // Yukaridaki metodu reformatForTestCase() metodu ile guncelledim.

    public static String reformatForTestCase(Date startDate) {
        SimpleDateFormat reformat = new SimpleDateFormat("dd/MM/yy hh:mm");
        String reformattedStartDate = reformat.format(startDate);
        System.out.println(reformattedStartDate);
        return  reformattedStartDate;
    }
    public static void main(String[] args) {

//        String reformattedDate = changeDateToWebPageFormat("30.12.2022 12:21");
//        System.out.println(reformattedDate);

        Faker faker = new Faker();
        Date startDate = faker.date().past(20, TimeUnit.DAYS);
        System.out.println(startDate);  //Tue Dec 28 23:17:52 EET 2021
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyyyyhh:mm");
        String formattedStartDate = format.format(startDate);
        System.out.println(formattedStartDate);//28.12.2021 11:17

        //yukaridaki islemi formatDateToSendKeys(Date anyDate) metodu ile yapalim
        System.out.println("with the method formatDateToSendKeys:  " + formatDateToSendKeys(startDate));

        //asagisi tekrar reformat icin
        // yani validation yapilacaksa tarihi tekrar 28/12/21 11:17 formatina donusturmek icin
        SimpleDateFormat reformat = new SimpleDateFormat("dd/MM/yy hh:mm");
        String reformattedStartDate = reformat.format(startDate);
        System.out.println(reformattedStartDate);//28/12/21 11:17
        // bu kismin metodu ise reformatForTestCase(Date startDate) seklinde idi.
        //Onu da kullanarak asagida execute edelim:

        //startDate = Tue Dec 28 23:17:52 EET 2021
        System.out.println(reformatForTestCase(startDate));//28/12/21 11:17

    }
}
