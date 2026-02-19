interface BackupSerializable {
}

class UserData implements BackupSerializable {
    String name;
    int age;

    UserData(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class LogFile {
    String data;

    LogFile(String data) {
        this.data = data;
    }
}

class BackupProcessor {
    static void backup(Object obj) {
        if (obj instanceof BackupSerializable)
            System.out.println("Backing up object: " + obj.getClass().getSimpleName());
        else
            System.out.println("Object not eligible for backup.");
    }
}

public class BackupSystem {
    public static void main(String[] args) {

        UserData user = new UserData("Dhruv", 21);
        LogFile log = new LogFile("System logs...");

        BackupProcessor.backup(user);
        BackupProcessor.backup(log);
    }
}
