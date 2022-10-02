package classes_and_objects.task13;

import classes_and_objects.task12.Book;

import java.util.Objects;

public class ProgrammerBook extends Book {
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ProgrammerBook) {
            boolean isLanguagesEquals = Objects.equals(this.language, ((ProgrammerBook) obj).language);
            boolean isLevelsEquals = this.level == ((ProgrammerBook)obj).level;
            return isLanguagesEquals && isLevelsEquals;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.language.hashCode() + this.level;
    }

    @Override
    public String toString() {
        return "Language: " + this.language + " Level: " + this.level;
    }

    private String language;
    private int level;
}
