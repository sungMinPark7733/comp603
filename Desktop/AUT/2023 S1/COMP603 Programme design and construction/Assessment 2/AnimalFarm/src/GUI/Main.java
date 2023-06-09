package GUI;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
    }

    public Main() {
        Model model = new Model();
        View view = new View();
        view.setVisible(true);
        model.addObserver(view);
        Controller controller = new Controller(model, view);
    }
}
