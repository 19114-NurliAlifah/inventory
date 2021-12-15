package uas_pbo;
public class Session {
    private static int id;
    public static void setId(int id) {
        Session.id = id;
    }
    
    public static int getId() {
        return id;
    }
}
