public class ItemsTask {
    public int id;
    public String title;
    public String description;
    public Status status;

    public ItemsTask( String title, String description) {

        this.title = title;
        this.description = description;
        this.status = Status.NEW;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }
}
