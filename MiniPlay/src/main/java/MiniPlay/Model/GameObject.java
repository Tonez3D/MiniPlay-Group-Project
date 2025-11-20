package MiniPlay.Model;

import java.util.ArrayList;

public class GameObject<T> {
    ArrayList<T> data;

    public GameObject(ArrayList<T> data) {
        this.data = data;
    }

    public ArrayList<T> getData() {
        return data;
    }
    public void setData(ArrayList<T> data) {
        this.data = data;
    }
}
