public class room {
    private  int Id ;
    private int floor ;
    private int capacity;
    private String  type;

    public room(int id, int floor, int capacity, String type) {
        Id = id;
        this.floor = floor;
        this.capacity = capacity;
        this.type = type;
    }

    public room() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
