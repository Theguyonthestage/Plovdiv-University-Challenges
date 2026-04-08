import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ContestantManager list = new ContestantManager();

        list.addContestant(new Contestant("Богдана Василева Петрова", "1232030692", "пеене", 30000));
        list.addContestant(new Contestant("Алексей Иванов Димитров", "0561150595", "танцуване", 25000));
        list.addContestant(new Contestant("Виктория Петрова Стоянова", "0891120188", "пеене", 18000));
        list.addContestant(new Contestant("Георги Андреев Николов", "2004250300", "танцуване", 42000));

        System.out.println("======2.");
        System.out.println("Извеждане на списък на всички участници, подредени по име в азбучен ред.");
        list.sortByName();
        list.printContestants(list.getListOfContestants());

        System.out.println("======3.");
        ArrayList<Contestant> sofiaAfter1990 = list.filterList("София", 90);
        list.sortByTalentAndPoints(sofiaAfter1990);
        list.printContestants(sofiaAfter1990);

        System.out.println("======4.");

        ContestantManager listForThreeRegions = new ContestantManager();

        listForThreeRegions.addContestant(new Contestant("Иван Петров Георгиев", "0011150595", "пеене", 25000));
        listForThreeRegions.addContestant(new Contestant("Мария Иванова Стоянова", "0021120100", "танци", 32000));
        listForThreeRegions.addContestant(new Contestant("Петър Георгиев Димитров", "0031010385", "акробатика", 18000));
        listForThreeRegions.addContestant(new Contestant("Анна Димитрова Колева", "0041250203", "пеене", 41000));

        listForThreeRegions.addContestant(new Contestant("Богдана Василева Петрова", "1232030692", "пеене", 30000));
        listForThreeRegions.addContestant(new Contestant("Георги Андреев Николов", "1242150998", "танци", 42000));
        listForThreeRegions.addContestant(new Contestant("Десислава Маркова Тодорова", "1252080191", "акробатика", 22000));

        listForThreeRegions.addContestant(new Contestant("Виктория Петрова Стоянова", "0893120188", "пеене", 18000));
        listForThreeRegions.addContestant(new Contestant("Алексей Иванов Димитров", "0903150502", "танци", 35000));
        listForThreeRegions.addContestant(new Contestant("Николай Стоянов Василев", "0913201095", "жонглиране", 27000));

        String[] areas = {"София", "Пловдив", "Варна"};

        for (String area : areas) {
            System.out.println("\n====== Област: " + area + " ======");

            System.out.println("\n--- Списък по азбучен ред ---");
            ContestantManager areaManager = new ContestantManager();
            areaManager.setListOfContestants(listForThreeRegions.filterList(area));
            areaManager.sortByName();
            areaManager.printContestants(areaManager.getListOfContestants());

            System.out.println("\n--- Участници родени след 1990 ---");
            ArrayList<Contestant> filteredByYear = areaManager.filterList(area, 90);
            areaManager.sortByTalentAndPoints(filteredByYear);
            areaManager.printContestants(filteredByYear);

            Contestant top = areaManager.findTopContestant(areaManager.getListOfContestants());
            System.out.println("Участникът с най- голям брой точки е: " + top.getFullName() + ", " + top.getPoints() + " точки");

            double averageAge = areaManager.findAverageAge(areaManager.getListOfContestants());
            System.out.printf("\n Средна възраст: %.2f", averageAge);
        }
    }
}
