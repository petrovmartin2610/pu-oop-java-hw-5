
public class MainClass {

    public static void main(String[] args) {

        //инстанции на телефонни екрани
        Telephone telephoneScreen = new Telephone();
        telephoneScreen.telephoneScreen();
        telephoneScreen.appendPhoneToCategory();

        Telephone telephoneScreen2 = new Telephone();
        telephoneScreen.appendPhoneToCategory();
        telephoneScreen2.appendPhoneToCategory();

        Telephone telephoneScreen3 = new Telephone();
        telephoneScreen3.telephoneScreen();
        telephoneScreen3.appendPhoneToCategory();

        Telephone telephoneScreen4 = new Telephone();
        telephoneScreen4.telephoneScreen();
        telephoneScreen4.appendPhoneToCategory();

        Telephone telephoneScreen5 = new Telephone();
        telephoneScreen5.telephoneScreen();
        telephoneScreen5.appendPhoneToCategory();


        //масив обекти Telephone, съхраняващ всички генерирани обекти от този тип
        Telephone[] collectionOfPhones = new Telephone[5];
        collectionOfPhones[0] = telephoneScreen;
        collectionOfPhones[1] = telephoneScreen2;
        collectionOfPhones[2] = telephoneScreen3;
        collectionOfPhones[3] = telephoneScreen4;
        collectionOfPhones[4] = telephoneScreen5;

        //определяне категорията на телефонните екрани от масива обекти Telephone
        for (int i = 0; i < 5; i++) {
            collectionOfPhones[i].appendPhoneToCategory();
        }

    }
}
