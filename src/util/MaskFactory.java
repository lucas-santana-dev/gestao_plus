package util;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class MaskFactory {

    public static MaskFormatter createRgMask() {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter("##.###.###-##");
            formatter.setPlaceholderCharacter('_');
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return formatter;
    }
}
