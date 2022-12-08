package day7Fail;

public class FileData implements Data{
    private String name;

    public FileData(String name){
        this.name = name;
    }
    public int fileSize() {
        String[]parts = name.split(" ");
        return Integer.parseInt(parts[0]);
    }
    
    public String getName() {
        return name;
    }
    


    
}
