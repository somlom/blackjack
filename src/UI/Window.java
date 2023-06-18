package UI;

public class Window {
    private String height;
    private String width;

    public Window(String[] data) {
        try {
            if(data.length != 0){
                this.width = data[0];
                this.height = data[1];
            }
        } catch (Exception e) {
            throw new Error("Sizing error: "+e, null);
        }
    }
}
