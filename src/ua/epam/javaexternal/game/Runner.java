package ua.epam.javaexternal.game;

public class Runner
{
    public static void main(String[] args)
    {
        Model model = new Model();
        View view = new View();

        Controller baseApp = new Controller(view, model);
        baseApp.start();
    }
}
