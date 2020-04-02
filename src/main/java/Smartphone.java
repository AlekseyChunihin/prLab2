public class Smartphone {

    int id;
    String model;
    String name;
    double diagonal;
    double price;

    public int getId() {
        return id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setVersionOS(String versionOS) {
        this.versionOS = versionOS;
    }

    int memory;

    public String getModel() {
        return model;
    }

    public String getName() {
        return name;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public double getPrice() {
        return price;
    }

    public int getMemory() {
        return memory;
    }

    public String getProcessor() {
        return processor;
    }

    public String getVersionOS() {
        return versionOS;
    }

    String processor;
    String versionOS;
    public Smartphone(int id, String model, String name, double diagonal, double price, int memory, String processor, String versionOS) {
        this.id=id;
        this.model = model;
        this.name = name;
        this.diagonal = diagonal;
        this.price = price;
        this.memory = memory;
        this.processor = processor;
        this.versionOS = versionOS;
    }


}
