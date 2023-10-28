public class SubTask extends ItemsTask {
    int epicid;

    public SubTask(String title, String description, int epicid) {
        super( title, description);
        this.epicid = epicid;
    }
}
