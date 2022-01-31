import java.util.HashMap;

public class StepTracker {

    Converter converter = new Converter(0.75, 50);
    int stepsDayGoal = 10000;
    HashMap<Integer, MonthData> monthToData = new HashMap<>();

    public StepTracker() {
        for (int i = 0; i < 12; i++) {
            monthToData.put(i, new MonthData());
        }
    }

    public void saveInputSteps(int month, int day, int steps) {
        monthToData.get(month).daysOfMonth[day - 1] = steps;
        System.out.println("Количество пройденных шагов добавлено");
    }

    public int changeStepsDayGoal(int newGoal) {
        stepsDayGoal = newGoal;
        return stepsDayGoal;
    }

    public void showMonthStats(int month) {
        showStepsMonthStats(month);
        System.out.println();
        System.out.println("Общее количество шагов за " + month +
                "-й месяц: " + getSumMonthSteps(month));
        showMonthMaxSteps(month);
        getAverageMonthSteps(month);
        converter.convert(getSumMonthSteps(month));
        getBestSeries(month);
    }

    public void showStepsMonthStats(int month) {
        MonthData months = monthToData.get(month);
        System.out.println("Ежедневая статистика по количеству шагов за " +
                month + "-й месяц:");
        for (int i = 0; i < (months.daysOfMonth.length - 1); i++) {
            System.out.print((i + 1) + " день: " + months.daysOfMonth[i] + ", ");
        }
        System.out.print("30 день: " + months.daysOfMonth[29]);
    }

    public int getSumMonthSteps(int month) {
        MonthData months = monthToData.get(month);
        int sumMonthSteps = 0;
        for (int i = 0; i < months.daysOfMonth.length; i++) {
            sumMonthSteps += months.daysOfMonth[i];
        }
        return sumMonthSteps;
    }

    public void showMonthMaxSteps(int month) {
        MonthData months = monthToData.get(month);
        int monthMaxSteps = 0;
        for (int i = 0; i < months.daysOfMonth.length; i++) {
            if (months.daysOfMonth[i] > monthMaxSteps) {
                monthMaxSteps = months.daysOfMonth[i];
            }
        }
        System.out.println("Максимальное пройденное количество шагов в день: " + monthMaxSteps);
    }

    public void getAverageMonthSteps(int month) {
        int averageMonthSteps = getSumMonthSteps(month) / 30;
        System.out.println("Среднее количество шагов: " + averageMonthSteps);
    }

    public void getBestSeries(int month) {
        MonthData months = monthToData.get(month);
        int currentSeries = 0;
        int maxSeries = 0;
        for (int i = 0; i < months.daysOfMonth.length; i++) {
            if (months.daysOfMonth[i] >= stepsDayGoal) {
                currentSeries = 1;
                for (int j = i + 1; j < (months.daysOfMonth.length - 1); j++) {
                    if (months.daysOfMonth[j] >= stepsDayGoal) {
                        currentSeries += 1;
                    } else {
                        break;
                    }
                }
            }
            if (currentSeries > maxSeries) {
                maxSeries = currentSeries;
            }
        }
        System.out.println("Лучшая серия достижений цели по количеству шагов в день: " + maxSeries);
    }
}





