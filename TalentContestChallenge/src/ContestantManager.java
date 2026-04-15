import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class ContestantManager {
    private ArrayList<Contestant> listOfContestants;

    public ContestantManager() {
        this.listOfContestants = new ArrayList<>();
    }

    public ArrayList<Contestant> getListOfContestants() {
        return listOfContestants;
    }

    public void setListOfContestants(ArrayList<Contestant> listOfContestants) {
        this.listOfContestants = listOfContestants;
    }

    public void addContestant(Contestant contestant) {
        if (listOfContestants.size() >= 500) {
            System.out.println("Максималният брой участници вече е достигнат. Участникът " +
                    contestant.getFullName() + " не e добавен.");
        } else {
            listOfContestants.add(contestant);
            System.out.println("Участникът " + contestant.getFullName() + " e добавен успешно.");
        }
    }

    public void sortByName() {
        listOfContestants.sort(Comparator.comparing(contestant -> contestant.getFullName()));
    }

    public ArrayList<Contestant> filterList(String areaChoice, int yearChoice) {
        ArrayList<Contestant> listFilteredByOneArea = new ArrayList<Contestant>();
        for (Contestant contestant : listOfContestants) {
            if (areaChoice.equals(contestant.getArea()) && (contestant.getYearOfBirth() > yearChoice || contestant.getYearOfBirth() < 25)) {
                listFilteredByOneArea.add(contestant);
            }
        }

        return listFilteredByOneArea;
    }

    public ArrayList<Contestant> filterList(String areaChoice) {
        ArrayList<Contestant> listFilteredByOneArea = new ArrayList<Contestant>();
        for (Contestant contestant : listOfContestants) {
            if (areaChoice.equals(contestant.getArea())) {
                listFilteredByOneArea.add(contestant);
            }
        }

        return listFilteredByOneArea;
    }

    public ArrayList<Contestant> sortByTalentAndPoints(ArrayList<Contestant> filteredList) {
        filteredList.sort(Comparator.comparing(Contestant::getTypeOfTalent)
                .thenComparing(Comparator.comparing(Contestant::getPoints).reversed()));
        return filteredList;
    }

    public void printContestants(ArrayList<Contestant> list) {
        for (Contestant contestant : list) {
            System.out.println(contestant.contestantFormattedInfo());
        }
    }

    public Contestant findTopContestant(ArrayList<Contestant> filteredList) {
        Contestant topContestant = filteredList.get(0);
        for (Contestant contestant : filteredList) {
            if (contestant.getPoints() > topContestant.getPoints()) {
                topContestant = contestant;
            }
        }
        return topContestant;
    }

    public double findAverageAge(ArrayList<Contestant> filteredList) {
        int currentYear = LocalDate.now().getYear();
        int fullYearOfBirth;
        int age;
        int totalAge = 0;
        double averageAge;
        for (Contestant contestant : filteredList) {
            if (contestant.getYearOfBirth() <= 25) {
                fullYearOfBirth = 2000 + contestant.getYearOfBirth();
            } else {
                fullYearOfBirth = 1900 + contestant.getYearOfBirth();
            }
            age = currentYear - fullYearOfBirth;
            totalAge += age;
        }
        averageAge = ( ) totalAge / filteredList.size();
        return averageAge;
    }
}