package day7.model;

public class Program {

    private int weight;
    private String name;
    private String[] childs;

    private String root = "";

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public Program(int weight, String name, String[] childs) {
        this.weight = weight;
        this.name = name;
        this.childs = childs;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getChilds() {
        return childs;
    }

    public void setChilds(String[] childs) {
        this.childs = childs;
    }

}
