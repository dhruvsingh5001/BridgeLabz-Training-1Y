@FunctionalInterface
interface LightBehavior {
    void activate();
}

public class SmartHomeLighting {

    public static void executeLight(LightBehavior behavior) {
        behavior.activate();
    }

    public static void main(String[] args) {

        LightBehavior motionTrigger = () -> System.out.println("Motion detected: Lights ON (Bright Mode)");
        LightBehavior nightMode = () -> System.out.println("Night mode: Lights ON (Dim Mode)");
        LightBehavior voiceCommand = () -> System.out.println("Voice command: Lights ON (Custom Color)");

        motionTrigger.activate();
        nightMode.activate();
        voiceCommand.activate();

        executeLight(() -> System.out.println("Motion detected: Bright Light ON"));
        executeLight(() -> System.out.println("Evening: Warm Light ON"));
        executeLight(() -> System.out.println("Voice: Blue Ambient Light ON"));
    }
}