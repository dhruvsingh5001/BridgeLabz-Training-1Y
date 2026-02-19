interface SensitiveData {
}

class CreditCard implements SensitiveData {
    String number;

    CreditCard(String number) {
        this.number = number;
    }
}

class PublicInfo {
    String info;

    PublicInfo(String info) {
        this.info = info;
    }
}

class SecurityProcessor {
    static void process(Object obj) {
        if (obj instanceof SensitiveData)
            System.out.println("Encrypting sensitive data: " + obj.getClass().getSimpleName());
        else
            System.out.println("No encryption needed: " + obj.getClass().getSimpleName());
    }
}

public class DataSecurity {
    public static void main(String[] args) {

        CreditCard card = new CreditCard("1234-5678-9876-5432");
        PublicInfo info = new PublicInfo("Welcome Message");

        SecurityProcessor.process(card);
        SecurityProcessor.process(info);
    }
}
