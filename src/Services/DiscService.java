package Services;
import java.util.*;
public class DiscService {
    public static int rollingOfDisc(){
        return new Random().nextInt(6) + 1;
    }
}
