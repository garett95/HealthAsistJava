public class Converter {

    double oneStepLengthInMeters;
    double oneStepCals;

    Converter(double length, double cals) {
         oneStepLengthInMeters = length;
         oneStepCals = cals;
    }

    void convert(int steps) {
        System.out.println("Пройденная дистанция: " + steps * oneStepLengthInMeters / 1000 + " км");
        System.out.println("Количество сожжёных калорий: " + steps * oneStepCals / 1000 + " ккал");
    }
}