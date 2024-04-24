import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Clément Vogt
 * @version Version 1.0
 */
public class Pilote extends Navigant
{
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private LocalDate dateValidationBrevet;

    public Pilote(String nom, boolean genre, String canton, int nbHeuresVol, LocalDate dateBrevet)
    {
        super(nom, genre, canton, nbHeuresVol);
        this.dateValidationBrevet = dateBrevet;
    }

    public LocalDate getDateValidationBrevet() {
        return dateValidationBrevet;
    }

    @Override
    public String toString() {
        return super.toString() + ", brevet en date du " + DATE_FORMATTER.format(dateValidationBrevet);
    }
}
