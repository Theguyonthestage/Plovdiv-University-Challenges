public class Contestant {
    private String fullName;
    private String contestantCode;
    private String typeOfTalent;
    private String area;
    private int points;
    private int sequentialNumber;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;

    public Contestant(String fullName, String contestantCode, String typeOfTalent,
                      int points) {
        if (fullName.length() > 45 || fullName.split(" ").length != 3) {
            throw new IllegalArgumentException("Името трябва да е до 45 знака и да съдържа три имена.");
        }
        if (typeOfTalent.length() > 20) {
            throw new IllegalArgumentException("Видът талант трябва да е не по-дълъг от 20 знака.");
        }
        if (points < 0) {
            throw new IllegalArgumentException("Трябва да въведете положителна стойност за точки.");
        }
        if (!contestantCode.matches("\\d{10}")) {
            throw new IllegalArgumentException("Кодът трябва да е точно 10 цифри.");
        }
        this.fullName = fullName;
        this.typeOfTalent = typeOfTalent;
        this.contestantCode = contestantCode;
        this.points = points;
        this.sequentialNumber = Integer.parseInt(contestantCode.substring(0, 3));
        this.dayOfBirth = Integer.parseInt(contestantCode.substring(4, 6));
        this.monthOfBirth = Integer.parseInt(contestantCode.substring(6, 8));
        this.yearOfBirth = Integer.parseInt(contestantCode.substring(8, 10));
        this.area = parseArea(contestantCode);

    }

    public String getFullName() {
        return fullName;
    }

    public String getTypeOfTalent() {
        return typeOfTalent;
    }

    public String getArea() {
        return area;
    }

    public int getPoints() {
        return points;
    }

    public int getSequentialNumber() {
        return sequentialNumber;
    }

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String contestantFormattedInfo() {
        String[] names = fullName.split(" ");
        String formattedNames = names[0] + " " + names[1].charAt(0) + ". " + names[2];
        String formattedBirthDAte = String.format("%02d.%02d.%02d", dayOfBirth,
                monthOfBirth, (yearOfBirth % 100));
        return formattedNames + ", " + sequentialNumber + ", " + area + ", " + typeOfTalent + ", " + points + ", " + formattedBirthDAte + ".";
    }

    private String parseArea(String contestantCode) {
        int areaNum = Integer.parseInt(contestantCode.substring(3, 4));
        switch (areaNum) {
            case 1:
                return "София";
            case 2:
                return "Пловдив";

            case 3:
                return "Варна";

            case 4:
                return "Бургас";

            case 5:
                return "Русе";
            case 6:
                return "Благоевград";

            default:
                return "Грешка - несъществуващ код на областта";


        }


    }

}