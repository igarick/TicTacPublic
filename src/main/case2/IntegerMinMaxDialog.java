package main.case2;

public class IntegerMinMaxDialog extends AbstractDialog<Integer> {

    public IntegerMinMaxDialog(String title, String error, int min, int max) {
        super(title,
                error,
                Integer::parseInt,
                n -> n >= min && n <= max);

    }


}
