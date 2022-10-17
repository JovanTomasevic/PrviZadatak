package constants;

public class ApiEndpoints {

    public static final String CROCODILES = "my/crocodiles/";

    public static String SINGLE_CROCODILE(Integer crocId) {
        return CROCODILES + crocId + "/";
    }
}
